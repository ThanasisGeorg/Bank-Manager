package GUI;

import Database.*;
import java.awt.Color;
import static java.awt.Color.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import main.Customer;

import com.formdev.flatlaf.*;
import java.sql.ResultSet;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JLabel;
import kdesp73.databridge.connections.DatabaseConnection;
import kdesp73.databridge.helpers.QueryBuilder;
import kdesp73.themeLib.Theme;
import kdesp73.themeLib.ThemeCollection;

/**
 *
 * @author tgeorg
 */
public class ChangePasswordFrame extends javax.swing.JFrame {

    SettingsFrame sf;
    ArrayList<Customer> customerList;
    ResourceBundle rb;
    Theme theme = null;

    private int indexOfCustomerLoggedIn;

    Color pc = new Color(162, 119, 255);
    Color bg = new Color(21, 20, 27);
    Color def = new Color(187, 187, 187);

    public ChangePasswordFrame() {
        FlatDarculaLaf.setup();
        // Frame setup
        initComponents();
        this.theme = GUIFunctions.setupFrame(this, "Change your password");

        // Color, focus and visibility setup of components
        jPanel1.setBackground(bg);
        cancelBtn.setForeground(pc);
        applyBtn.setForeground(pc);
        oldPasswordField.setForeground(red);
        newPasswordField.setForeground(green);
        confirmNewPasswordField.setForeground(red);

        cancelBtn.setFocusable(false);
        applyBtn.setFocusable(false);
        this.setResizable(false);

        newPasswordField.setEnabled(false);
        confirmNewPasswordField.setEnabled(false);
    }

    public ChangePasswordFrame(SettingsFrame sf, ArrayList<Customer> customerList, int indexOfCustomerLoggedIn) {
        FlatDarculaLaf.setup();
        // Frame setup
        initComponents();
        this.theme = GUIFunctions.setupFrame(this, "Change your password");

        DatabaseConnection db = Database.connection();

        // Color, focus and visibility setup of components
        oldPasswordField.setForeground(red);
        newPasswordField.setForeground(green);
        confirmNewPasswordField.setForeground(red);

        cancelBtn.setFocusable(false);
        applyBtn.setFocusable(false);
        this.setResizable(false);

        newPasswordField.setEnabled(false);
        confirmNewPasswordField.setEnabled(false);

        this.sf = sf;
        this.customerList = customerList;
        this.indexOfCustomerLoggedIn = indexOfCustomerLoggedIn;

        db.close();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        oldPasswordIndicator = new javax.swing.JLabel();
        oldPasswordField = new javax.swing.JPasswordField();
        newPasswordIndicator = new javax.swing.JLabel();
        newPasswordField = new javax.swing.JPasswordField();
        confirmNewPasswordIndicator = new javax.swing.JLabel();
        confirmNewPasswordField = new javax.swing.JPasswordField();
        cancelBtn = new javax.swing.JButton();
        applyBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setName("bg"); // NOI18N

        oldPasswordIndicator.setText("<html><p style=\"text-align:center\"><b>Enter your old password:</p> </html>");
        oldPasswordIndicator.setName("textbox"); // NOI18N

        oldPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                oldPasswordFieldKeyReleased(evt);
            }
        });

        newPasswordIndicator.setText("<html><p style=\"text-align:center\"><b>Enter your new password:</p> </html>");
        newPasswordIndicator.setName("textbox"); // NOI18N

        newPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                newPasswordFieldKeyReleased(evt);
            }
        });

        confirmNewPasswordIndicator.setText("<html><p style=\"text-align:center\"><b>Confirm your new password:</p> </html>");
        confirmNewPasswordIndicator.setName("textbox"); // NOI18N

        confirmNewPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                confirmNewPasswordFieldKeyReleased(evt);
            }
        });

        cancelBtn.setBackground(java.awt.Color.darkGray);
        cancelBtn.setText("<html><p style=\"text-align:center\"><b>Cancel</p> </html>");
        cancelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelBtn.setName("btn"); // NOI18N
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        applyBtn.setBackground(java.awt.Color.darkGray);
        applyBtn.setText("<html><p style=\"text-align:center\"><b>Apply</p> </html>");
        applyBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        applyBtn.setName("btn"); // NOI18N
        applyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(applyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(oldPasswordIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newPasswordIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(confirmNewPasswordField)
                            .addComponent(newPasswordField)
                            .addComponent(oldPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(confirmNewPasswordIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oldPasswordIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oldPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newPasswordIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmNewPasswordIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmNewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(applyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void oldPasswordFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_oldPasswordFieldKeyReleased
        DatabaseConnection db = Database.connection();
        JPopupMenu errorMessage = new JPopupMenu();

        JMenuItem item;

        try {
            ResultSet rs = db.executeQuery(new QueryBuilder().select("Language").from("Settings").build());
            rs.next();
            String languageName = rs.getString(1);
            if (languageName.equals("English")) {
                if (!GUIUtils.charArrayToString(oldPasswordField.getPassword()).equals(customerList.get(indexOfCustomerLoggedIn).getAcc().getPassword())) {
                    item = new JMenuItem("This password does not match with the current account");
                    item.setForeground(red);
                    errorMessage.add(item);
                    errorMessage.show(this, 50, 220);
                    oldPasswordField.requestFocus();
                    oldPasswordField.setForeground(red);
                    return;
                }
            } else if (languageName.equals("Greek")) {
                if (!GUIUtils.charArrayToString(oldPasswordField.getPassword()).equals(customerList.get(indexOfCustomerLoggedIn).getAcc().getPassword())) {
                    item = new JMenuItem("Αυτός ο κωδικός δεν ταιριάζει με τον συγκεκριμένο λογαριασμό");
                    item.setForeground(red);
                    errorMessage.add(item);
                    errorMessage.show(this, 20, 220);
                    oldPasswordField.requestFocus();
                    oldPasswordField.setForeground(red);
                    return;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChangePasswordFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        oldPasswordField.setForeground(green);
        newPasswordField.setEnabled(true);

        errorMessage.show(this, 20, 220);
        errorMessage.setEnabled(false);
        oldPasswordField.requestFocus();

        db.close();
    }//GEN-LAST:event_oldPasswordFieldKeyReleased

    private void newPasswordFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newPasswordFieldKeyReleased
        DatabaseConnection db = Database.connection();
        JPopupMenu errorMessage = new JPopupMenu();
        errorMessage.setFocusable(false);

        try {
            ResultSet rs = db.executeQuery(new QueryBuilder().select("Language").from("Settings").build());
            rs.next();
            String languageName = rs.getString(1);
            if (languageName.equals("English")) {
                JMenuItem samePw = new JMenuItem("Your new password must not match with your old one");
                JMenuItem emptyBlankPw = new JMenuItem("Your new password must not be empty or blank");
                JMenuItem sizePw = new JMenuItem("Your new password must be at least 5 at size");
                JMenuItem numPw = new JMenuItem("Your new password must contain at least one number");
                JMenuItem charPw = new JMenuItem("Your new password must contain at least one character");

                samePw.setForeground(red);
                emptyBlankPw.setForeground(red);
                sizePw.setForeground(red);
                numPw.setForeground(red);
                charPw.setForeground(red);

                errorMessage.add(samePw);
                errorMessage.add(emptyBlankPw);
                errorMessage.add(sizePw);
                errorMessage.add(numPw);
                errorMessage.add(charPw);

                if (GUIUtils.charArrayToString(newPasswordField.getPassword()).isBlank() || GUIUtils.charArrayToString(newPasswordField.getPassword()).isEmpty()) {
                    errorMessage.remove(samePw);
                    errorMessage.remove(sizePw);
                    errorMessage.remove(numPw);
                    errorMessage.remove(charPw);
                    errorMessage.show(this, 50, 220);
                    newPasswordField.requestFocus();
                    newPasswordField.setForeground(red);
                    return;
                }

                if (GUIUtils.checkIfAllNums(GUIUtils.charArrayToString(newPasswordField.getPassword()))) {
                    if (newPasswordField.getPassword().length < 5) {
                        errorMessage.remove(samePw);
                        errorMessage.remove(emptyBlankPw);
                        errorMessage.remove(numPw);
                        errorMessage.show(this, 50, 220);
                        newPasswordField.requestFocus();
                        newPasswordField.setForeground(red);
                        return;
                    }
                    errorMessage.remove(samePw);
                    errorMessage.remove(emptyBlankPw);
                    errorMessage.remove(sizePw);
                    errorMessage.remove(numPw);
                    errorMessage.show(this, 50, 220);
                    newPasswordField.requestFocus();
                    newPasswordField.setForeground(red);
                    return;
                }

                if (!GUIUtils.checkNums(GUIUtils.charArrayToString(newPasswordField.getPassword()))) {
                    if (newPasswordField.getPassword().length < 5) {
                        errorMessage.remove(samePw);
                        errorMessage.remove(emptyBlankPw);
                        errorMessage.remove(charPw);
                        errorMessage.show(this, 50, 220);
                        newPasswordField.requestFocus();
                        newPasswordField.setForeground(red);
                        return;
                    }
                    errorMessage.remove(samePw);
                    errorMessage.remove(emptyBlankPw);
                    errorMessage.remove(sizePw);
                    errorMessage.remove(charPw);
                    errorMessage.show(this, 50, 220);
                    newPasswordField.requestFocus();
                    newPasswordField.setForeground(red);
                    return;
                }

                if (newPasswordField.getPassword().length < 5) {
                    errorMessage.remove(samePw);
                    errorMessage.remove(emptyBlankPw);
                    errorMessage.remove(numPw);
                    errorMessage.remove(charPw);
                    errorMessage.show(this, 50, 220);
                    newPasswordField.requestFocus();
                    newPasswordField.setForeground(red);
                    return;
                }

                if (GUIUtils.charArrayToString(newPasswordField.getPassword()).equals(customerList.get(indexOfCustomerLoggedIn).getAcc().getPassword())) {
                    errorMessage.remove(emptyBlankPw);
                    errorMessage.remove(sizePw);
                    errorMessage.remove(numPw);
                    errorMessage.remove(charPw);
                    errorMessage.show(this, 50, 220);
                    newPasswordField.requestFocus();
                    newPasswordField.setForeground(red);
                    return;
                }

                newPasswordField.setForeground(green);
                confirmNewPasswordField.setEnabled(true);

                errorMessage.remove(samePw);
                errorMessage.remove(emptyBlankPw);
                errorMessage.remove(sizePw);
                errorMessage.remove(numPw);
                errorMessage.remove(charPw);
                errorMessage.show(this, 50, 220);
                newPasswordField.requestFocus();
            } else if (languageName.equals("Greek")) {
                JMenuItem samePw = new JMenuItem("Ο κωδικός σας δεν πρέπει να ταιριάζει με τον παλιό σου");
                JMenuItem emptyBlankPw = new JMenuItem("Ο νέος σας κωδικός δεν πρέπει να είναι άδειος");
                JMenuItem sizePw = new JMenuItem("Ο νεός σας κωδικός πρέπει να είναι τουλάχιστον μεγέθους 5");
                JMenuItem numPw = new JMenuItem("Ο νέος σας κωδικός πρέπει να περιέχει τουλαχιστόν έναν αριθμό");
                JMenuItem charPw = new JMenuItem("Ο νέος σας κωδικός πρέπει να περιέχει τουλάχιστον έναν χαρακτήρα");

                samePw.setForeground(red);
                emptyBlankPw.setForeground(red);
                sizePw.setForeground(red);
                numPw.setForeground(red);
                charPw.setForeground(red);

                errorMessage.add(samePw);
                errorMessage.add(emptyBlankPw);
                errorMessage.add(sizePw);
                errorMessage.add(numPw);
                errorMessage.add(charPw);

                if (GUIUtils.charArrayToString(newPasswordField.getPassword()).isBlank() || GUIUtils.charArrayToString(newPasswordField.getPassword()).isEmpty()) {
                    errorMessage.remove(samePw);
                    errorMessage.remove(sizePw);
                    errorMessage.remove(numPw);
                    errorMessage.remove(charPw);
                    errorMessage.show(this, 1, 220);
                    newPasswordField.requestFocus();
                    newPasswordField.setForeground(red);
                    return;
                }

                if (GUIUtils.checkIfAllNums(GUIUtils.charArrayToString(newPasswordField.getPassword()))) {
                    if (newPasswordField.getPassword().length < 5) {
                        errorMessage.remove(samePw);
                        errorMessage.remove(emptyBlankPw);
                        errorMessage.remove(numPw);
                        errorMessage.show(this, 1, 220);
                        newPasswordField.requestFocus();
                        newPasswordField.setForeground(red);
                        return;
                    }
                    errorMessage.remove(samePw);
                    errorMessage.remove(emptyBlankPw);
                    errorMessage.remove(sizePw);
                    errorMessage.remove(numPw);
                    errorMessage.show(this, 1, 220);
                    newPasswordField.requestFocus();
                    newPasswordField.setForeground(red);
                    return;
                }

                if (!GUIUtils.checkNums(GUIUtils.charArrayToString(newPasswordField.getPassword()))) {
                    if (newPasswordField.getPassword().length < 5) {
                        errorMessage.remove(samePw);
                        errorMessage.remove(emptyBlankPw);
                        errorMessage.remove(charPw);
                        errorMessage.show(this, 1, 220);
                        newPasswordField.requestFocus();
                        newPasswordField.setForeground(red);
                        return;
                    }
                    errorMessage.remove(samePw);
                    errorMessage.remove(emptyBlankPw);
                    errorMessage.remove(sizePw);
                    errorMessage.remove(charPw);
                    errorMessage.show(this, 1, 220);
                    newPasswordField.requestFocus();
                    newPasswordField.setForeground(red);
                    return;
                }

                if (newPasswordField.getPassword().length < 5) {
                    errorMessage.remove(samePw);
                    errorMessage.remove(emptyBlankPw);
                    errorMessage.remove(numPw);
                    errorMessage.remove(charPw);
                    errorMessage.show(this, 1, 220);
                    newPasswordField.requestFocus();
                    newPasswordField.setForeground(red);
                    return;
                }

                if (GUIUtils.charArrayToString(newPasswordField.getPassword()).equals(customerList.get(indexOfCustomerLoggedIn).getAcc().getPassword())) {
                    errorMessage.remove(emptyBlankPw);
                    errorMessage.remove(sizePw);
                    errorMessage.remove(numPw);
                    errorMessage.remove(charPw);
                    errorMessage.show(this, 1, 220);
                    newPasswordField.requestFocus();
                    newPasswordField.setForeground(red);
                    return;
                }

                newPasswordField.setForeground(green);
                confirmNewPasswordField.setEnabled(true);

                errorMessage.remove(samePw);
                errorMessage.remove(emptyBlankPw);
                errorMessage.remove(sizePw);
                errorMessage.remove(numPw);
                errorMessage.remove(charPw);
                errorMessage.show(this, 1, 220);
                newPasswordField.requestFocus();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChangePasswordFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        db.close();
    }//GEN-LAST:event_newPasswordFieldKeyReleased

    private void confirmNewPasswordFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmNewPasswordFieldKeyReleased
        DatabaseConnection db = Database.connection();

        JPopupMenu errorMessage = new JPopupMenu();
        try {
            ResultSet rs = db.executeQuery(new QueryBuilder().select("Language").from("Settings").build());
            rs.next();
            String languageName = rs.getString(1);
            if (languageName.equals("English")) {
                JMenuItem samePw = new JMenuItem("This password does not match with your new one");
                errorMessage.add(samePw);

                samePw.setForeground(red);

                if (GUIUtils.charArrayToString(newPasswordField.getPassword()).equals(GUIUtils.charArrayToString(confirmNewPasswordField.getPassword()))) {
                    errorMessage.remove(samePw);
                    confirmNewPasswordField.setForeground(green);
                } else {
                    confirmNewPasswordField.setForeground(red);
                }

                errorMessage.show(this, 50, 220);
            } else if (languageName.equals("Greek")) {
                JMenuItem samePw = new JMenuItem("Αυτός ο κωδικός δεν ταιριάζει με τον καινούργιο");
                errorMessage.add(samePw);

                samePw.setForeground(red);

                if (GUIUtils.charArrayToString(newPasswordField.getPassword()).equals(GUIUtils.charArrayToString(confirmNewPasswordField.getPassword()))) {
                    errorMessage.remove(samePw);
                    confirmNewPasswordField.setForeground(green);
                } else {
                    confirmNewPasswordField.setForeground(red);
                }

                errorMessage.show(this, 50, 220);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChangePasswordFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        db.close();
    }//GEN-LAST:event_confirmNewPasswordFieldKeyReleased

    private void applyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyBtnActionPerformed
        DatabaseConnection db = Database.connection();

        try {
            ResultSet rs = db.executeQuery(new QueryBuilder().select("Language").from("Settings").build());
            rs.next();
            String languageName = rs.getString(1);
            if (languageName.equals("English")) {
                if (oldPasswordField.getForeground() == green && newPasswordField.getForeground() == green && confirmNewPasswordField.getForeground() == green) {
                    customerList.get(indexOfCustomerLoggedIn).getAcc().setPassword(GUIUtils.charArrayToString(newPasswordField.getPassword()));

                    try {
                        DBMethods.updateCustomerAcc(customerList, indexOfCustomerLoggedIn);
                    } catch (SQLException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.dispose();
                    JOptionPane.showMessageDialog(sf, "Successfull change of your password");
                } else {
                    JOptionPane.showMessageDialog(this, "Unsuccessfull change of your password", "Change Failed", JOptionPane.ERROR_MESSAGE);
                }
            } else if (languageName.equals("Greek")) {
                if (oldPasswordField.getForeground() == green && newPasswordField.getForeground() == green && confirmNewPasswordField.getForeground() == green) {
                    customerList.get(indexOfCustomerLoggedIn).getAcc().setPassword(GUIUtils.charArrayToString(newPasswordField.getPassword()));

                    try {
                        DBMethods.updateCustomerAcc(customerList, indexOfCustomerLoggedIn);
                    } catch (SQLException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.dispose();
                    JOptionPane.showMessageDialog(sf, "Επιτυχής αλλαγή κωδικού");
                } else {
                    JOptionPane.showMessageDialog(this, "Ανεπιτυχής αλλαγή κωδικού", "Η αλλαγή απέτυχε", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChangePasswordFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        db.close();
    }//GEN-LAST:event_applyBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws javax.swing.UnsupportedLookAndFeelException
     */
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        /* Set the Nimbus look and feel */

 /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangePasswordFrame().setVisible(true);
            }
        });
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
        ThemeCollection.applyTheme(this, theme);
    }

    public JButton getApplyBtn() {
        return applyBtn;
    }

    public void setApplyBtn(JButton applyBtn) {
        this.applyBtn = applyBtn;
    }

    public JButton getCancelBtn() {
        return cancelBtn;
    }

    public void setCancelBtn(JButton cancelBtn) {
        this.cancelBtn = cancelBtn;
    }

    public JLabel getConfirmNewPasswordIndicator() {
        return confirmNewPasswordIndicator;
    }

    public void setConfirmNewPasswordIndicator(JLabel confirmNewPasswordIndicator) {
        this.confirmNewPasswordIndicator = confirmNewPasswordIndicator;
    }

    public JLabel getNewPasswordIndicator() {
        return newPasswordIndicator;
    }

    public void setNewPasswordIndicator(JLabel newPasswordIndicator) {
        this.newPasswordIndicator = newPasswordIndicator;
    }

    public JLabel getOldPasswordIndicator() {
        return oldPasswordIndicator;
    }

    public void setOldPasswordIndicator(JLabel oldPasswordIndicator) {
        this.oldPasswordIndicator = oldPasswordIndicator;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JPasswordField confirmNewPasswordField;
    private javax.swing.JLabel confirmNewPasswordIndicator;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField newPasswordField;
    private javax.swing.JLabel newPasswordIndicator;
    private javax.swing.JPasswordField oldPasswordField;
    private javax.swing.JLabel oldPasswordIndicator;
    // End of variables declaration//GEN-END:variables
}
