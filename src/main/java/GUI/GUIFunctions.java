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

        db.close();

        return theme;
    }
}
