package GUI;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import Database.*;
import Utils.Utils;
import com.formdev.flatlaf.FlatDarculaLaf;
import java.io.File;
import java.sql.ResultSet;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import kdesp73.databridge.connections.DatabaseConnection;
import kdesp73.databridge.helpers.QueryBuilder;
import kdesp73.themeLib.*;
import main.Customer;

/**
 *
 * @author tgeorg
 */
public class GUIFunctions {

    // Functions for MainFrame
    public static int checkLoginInfo(MainFrame mf, ArrayList<Customer> customerList) {
        if ((mf.getUsernameField().getText().isEmpty() || mf.getUsernameField().getText().isBlank()) && mf.getPasswordField().getPassword().length == 0) {
            JOptionPane.showMessageDialog(mf, "Username and password can not be empty or blank", "Login Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }

        if (mf.getUsernameField().getText().isEmpty() || mf.getUsernameField().getText().isBlank()) {
            JOptionPane.showMessageDialog(mf, "Username can not be empty or blank", "Login Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }

        if (mf.getPasswordField().getPassword().length == 0) {
            JOptionPane.showMessageDialog(mf, "Password can not be empty or blank", "Login Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }

        for (int i = 0; i < customerList.size(); i++) {
            if (mf.getUsernameField().getText().equals(customerList.get(i).getAcc().getUsername())
                    && GUIUtils.checkLoginPassword(mf.getPasswordField().getPassword(), customerList, i) == 1) {
                return i;
            }
        }

        JOptionPane.showMessageDialog(mf, "Username or password are incorrect", "Login Error", JOptionPane.ERROR_MESSAGE);
        return -1;
    }

    public static int checkSignInInfo(MainFrame mf, ArrayList<Customer> customerList) {
        if ((mf.getNameField().getText().isEmpty() || mf.getNameField().getText().isBlank()) || (mf.getSurnameField().getText().isEmpty() || mf.getSurnameField().getText().isBlank())
                || mf.getAgeSpinner().getValue().equals(0) || (mf.getUsernameField2().getText().isEmpty() || mf.getUsernameField2().getText().isBlank())
                || mf.getPasswordField2().getPassword().length == 0) {
            JOptionPane.showMessageDialog(mf, "Complete all the fields first\nand make sure you pick a valid age", "Sign In Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }

        if (mf.getUsernameField2().getText().contains(" ") || GUIUtils.checkSpecialChars(mf.getUsernameField2().getText())) {
            JOptionPane.showMessageDialog(mf, "This username contains white spaces or these symbols:\n!,@,#,$,%,^,&,*,(,)", "Username Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }

        if (mf.getPasswordField2().getPassword().length < 5) {
            JOptionPane.showMessageDialog(mf, "Your password must be at least 5 at size", "Password Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }

        if (!GUIUtils.checkNums(GUIUtils.charArrayToString(mf.getPasswordField2().getPassword()))) {
            JOptionPane.showMessageDialog(mf, "Your password must contain at least 1 number", "Password Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }

        if ((Integer) mf.getAgeSpinner().getValue() < 18) {
            JOptionPane.showMessageDialog(mf, "You must be at least 18 years old\nto become a customer", "Age Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }

        boolean found = false;

        for (int i = 0; i < customerList.size(); i++) {
            if (mf.getUsernameField2().getText().equals(customerList.get(i).getAcc().getUsername())) {
                found = true;
                break;
            }
        }

        for (int i = 0; i < 10; i++) {
            if ((Integer) mf.getAgeSpinner().getValue() > 18 && GUIUtils.checkSignInPassword(mf.getPasswordField2().getPassword(), customerList, i) == 1) {
                if (!found) {
                    customerList.add(new Customer());
                    Utils.generateID(customerList, customerList.size() - 1);

                    // Add customer info
                    String[] customerInfo = new String[4];
                    customerInfo[0] = customerList.get(customerList.size() - 1).getAcc().getId();
                    customerInfo[1] = mf.getNameField().getText();
                    customerInfo[2] = mf.getSurnameField().getText();
                    Object age = (Object) mf.getAgeSpinner().getValue();
                    customerInfo[3] = age.toString();

                    // Add account info
                    customerList.get(customerList.size() - 1).getAcc().setUsername(mf.getUsernameField2().getText());
                    customerList.get(customerList.size() - 1).getAcc().setPassword(GUIUtils.charArrayToString(mf.getPasswordField2().getPassword()));
                    customerList.get(customerList.size() - 1).getAcc().setBalance(0.0);

                    customerList.get(customerList.size() - 1).addInfo(customerInfo);
                    try {
                        DBMethods.insertCustomer(customerList, customerList.size() - 1);
                        DBMethods.insertCustomerAcc(customerList, customerList.size() - 1);
                    } catch (SQLException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return 1;
                } else {
                    JOptionPane.showMessageDialog(mf, "This username has already been taken", "Sign In Error", JOptionPane.ERROR_MESSAGE);
                    return -1;
                }
            }
        }

        return -1;
    }

    public static void setLanguage(String language) {

    }

    public static ThemeCollection getThemes() {
        ThemeCollection themeCollection = new ThemeCollection();
        themeCollection.loadThemes(new File(System.getProperty("user.dir").replaceAll(Pattern.quote("\\"), "/") + "/themes/"));
//        System.out.println(System.getProperty("user.dir").replaceAll(Pattern.quote("\\"), "/") + "/themes/");

        return themeCollection;
    }

    public static Theme setupFrame(JFrame frame, String title) {
        DatabaseConnection db = Database.connection();
        Theme theme = null;

        frame.setTitle(title);

        // Center frame
        frame.pack();
        frame.setLocationRelativeTo(null);

        // Theme setup
        try {
            ResultSet rs = db.executeQuery(new QueryBuilder().select("Theme").from("Settings").build());
            rs.next();
            String themeName = rs.getString(1);
            ThemeCollection themes = getThemes();
            theme = themes.matchTheme(themeName);
            ThemeCollection.applyTheme(frame, theme);
        } catch (SQLException ex) {
            Logger.getLogger(SettingsFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (theme == null) {
            System.out.println("Theme is null");
            theme = new Theme(new YamlFile(System.getProperty("user.dir").replaceAll(Pattern.quote("\\"), "/") + "/themes/"));
            ThemeCollection.applyTheme(frame, theme);
        }

        // Language Setup
        try {
            ResultSet rs = db.executeQuery(new QueryBuilder().select("Language").from("Settings").build());
            rs.next();
            String languageName = rs.getString(1);
            if (languageName.equals("English")) {
                GUIFunctions.setTexts(frame, Locale.US);
            } else if (languageName.equals("Greek")) {
                GUIFunctions.setTexts(frame, Locale.of("el", "GR"));
            }
            ThemeCollection.applyTheme(frame, theme);
        } catch (SQLException ex) {
            Logger.getLogger(SettingsFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        db.close();

        return theme;
    }

    public static void setTexts(JFrame frame, Locale locale) {
        ResourceBundle rb = ResourceBundle.getBundle("i18n/Bundle", locale);
        if (frame instanceof SettingsFrame settingsFrame) {
            setSettingsFrameTexts(settingsFrame, rb);
        }
        if (frame instanceof ChangePasswordFrame cpf) {
            setChangePasswordFrameTexts(cpf, rb);
        }
        if (frame instanceof ServicesFrame servicesFrame) {
            setServicesFrameTexts(servicesFrame, rb);
        }
        if (frame instanceof DepositFrame df) {
            setDepositFrameTexts(df, rb);
        }
        if (frame instanceof MainFrame mf) {
//            setMainFrameTexts(mf, rb);
        }
        if (frame instanceof ForgotPasswordFrame fpf) {
            setForgotPasswordFrameTexts(fpf, rb);
        }
    }

    public static void setSettingsFrameTexts(SettingsFrame sf, ResourceBundle rb) {
        sf.getGeneralLabel().setText(rb.getString("general"));
        sf.getLanguageLabel().setText(rb.getString("language"));
        sf.getAppearanceLabel().setText(rb.getString("appearance"));
        sf.getThemesLabel().setText(rb.getString("themes"));
        sf.getSecurityLabel().setText(rb.getString("security"));
        sf.getChangePwBtn().setText(rb.getString("change_password"));
    }

    public static void setChangePasswordFrameTexts(ChangePasswordFrame cpf, ResourceBundle rb) {
        cpf.getOldPasswordIndicator().setText(rb.getString("old_password"));
        cpf.getNewPasswordIndicator().setText(rb.getString("new_password"));
        cpf.getConfirmNewPasswordIndicator().setText(rb.getString("confirm_password"));
        cpf.getApplyBtn().setText(rb.getString("apply"));
        cpf.getCancelBtn().setText(rb.getString("cancel"));
    }

    public static void setServicesFrameTexts(ServicesFrame sf, ResourceBundle rb){
        sf.getMainMenuLabel().setText(rb.getString("main_menu"));
        sf.getAccInfoBtn().setText(rb.getString("acc_information"));
        sf.getDepBtn().setText(rb.getString("deposit"));
        sf.getDelBtn().setText(rb.getString("delete"));
        sf.getLogoutBtn().setText(rb.getString("logout"));
        sf.getCustomerInfoLabel().setText(rb.getString("customer_info"));
        sf.getNameIndicator().setText(rb.getString("name"));
        sf.getSurnameIndicator().setText(rb.getString("surname"));
        sf.getAgeIndicator().setText(rb.getString("age"));
        sf.getAccountInfoLabel().setText(rb.getString("acc_info"));
        sf.getUsernameIndicator().setText(rb.getString("username"));
        sf.getBalanceIndicator().setText(rb.getString("balance"));
        sf.getUploadImgBtn().setText(rb.getString("upload_img"));
        sf.getRefreshBtn().setText(rb.getString("refresh"));
        sf.getSettingsBtn().setText(rb.getString("settings"));
    }
//    
    public static void setDepositFrameTexts(DepositFrame df, ResourceBundle rb){
        df.getDepositLabel().setText(rb.getString("deposit_indicator"));
        df.getApplyBtn().setText(rb.getString("apply"));
        df.getCancelBtn().setText(rb.getString("cancel"));
    }
//    
//    public static void setMainFrameTexts(MainFrame mf, ResourceBundle rb){
//        mf.getGeneralLabel().setText(rb.getString("general"));
//        mf.getLanguageLabel().setText(rb.getString("language"));
//        mf.getAppearanceLabel().setText(rb.getString("appearance"));
//        mf.getThemesLabel().setText(rb.getString("themes"));
//        mf.getSecurityLabel().setText(rb.getString("security"));
//        mf.getChangePwBtn().setText(rb.getString("change_password"));
//    }
//    
    public static void setForgotPasswordFrameTexts(ForgotPasswordFrame fpf, ResourceBundle rb){
        fpf.getUsernameIndicator().setText(rb.getString("username_indicator"));
        fpf.getNewPasswordIndicator().setText(rb.getString("new_password"));
        fpf.getConfirmNewPasswordIndicator().setText(rb.getString("confirm_password"));
        fpf.getApplyBtn().setText(rb.getString("apply"));
        fpf.getCancelBtn().setText(rb.getString("cancel"));
    }
}
