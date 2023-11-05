package GUI;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import Database.DBMethods;
import Database.Database;
import Utils.Utils;
import com.formdev.flatlaf.*;
import java.awt.Component;
import java.sql.ResultSet;
import kdesp73.databridge.connections.DatabaseConnection;
import kdesp73.databridge.helpers.QueryBuilder;
import main.*;

/**
 *
 * @author tgeorg
 */
public class MainFrame extends javax.swing.JFrame {

    ForgotPasswordFrame fpf;
    ServicesFrame sf;
    ArrayList<Customer> customerList = new ArrayList<>();

    Color pc = new Color(162, 119, 255);
    Color bg = new Color(21, 20, 27);
    Color sc = new Color(97, 255, 202);
    Color def = new Color(78, 80, 82);

    private boolean loginbtnPressed = false;
    private boolean signInbtnPressed = false;

    public MainFrame() throws SQLException {
        FlatDarculaLaf.setup();
        DatabaseConnection db = Database.connection();
        // Frame setup
        initComponents();
        this.setTitle("Bank Manager App");

        // Center frame
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        // Color, focus and visibility setup of components
        mainPanel.setBackground(bg);
        appNameLabel.setForeground(pc);
        
        loginBtn.setForeground(pc);
        usernameField.setBackground(bg);
        passwordField.setBackground(bg);
        okBtn1.setForeground(pc);
        
        signInBtn.setForeground(pc);
        nameField.setBackground(bg);
        surnameField.setBackground(bg);
        usernameField2.setBackground(bg);
        passwordField2.setBackground(bg);
        okBtn2.setForeground(pc);
        
        infoLabel.setBackground(pc);
        forgotPwLabel.setForeground(pc);

        loginBtn.setFocusable(false);
        signInBtn.setFocusable(false);
        okBtn1.setFocusable(false);
        okBtn2.setFocusable(false);

        loginPanel.setVisible(false);
        signInPanel.setVisible(false);

        // Load data from database
        Utils.load(customerList);

        db.close();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        appNameLabel = new javax.swing.JLabel();
        infoLabel = new javax.swing.JLabel();
        loginBtn = new javax.swing.JButton();
        signInBtn = new javax.swing.JButton();
        loginPanel = new javax.swing.JPanel();
        usernameLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        okBtn1 = new javax.swing.JButton();
        forgotPwBtn = new javax.swing.JPanel();
        forgotPwLabel = new javax.swing.JLabel();
        signInPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        surnameLabel = new javax.swing.JLabel();
        surnameField = new javax.swing.JTextField();
        usernameLabel2 = new javax.swing.JLabel();
        usernameField2 = new javax.swing.JTextField();
        passwordLabel2 = new javax.swing.JLabel();
        passwordField2 = new javax.swing.JPasswordField();
        okBtn2 = new javax.swing.JButton();
        ageLabel = new javax.swing.JLabel();
        ageSpinner = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        mainPanel.setName(""); // NOI18N

        appNameLabel.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        appNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appNameLabel.setText("Bank Manager Application");

        infoLabel.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        infoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoLabel.setText("<html><p style=\"text-align: center\">An easy and cool app to manage your bank accounts.<br><br>If you don't have already an existing account,<br><br>quickly become a customer and enjoy the services!</p></html>");
        infoLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(187, 187, 187)));

        loginBtn.setBackground(java.awt.Color.darkGray);
        loginBtn.setText("<html><p style=\"text-align:center\"><b>Login</p> </html>");
        loginBtn.setAlignmentX(0.5F);
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        signInBtn.setBackground(java.awt.Color.darkGray);
        signInBtn.setText("<html><p style=\"text-align:center\"><b>Sign In</p> </html>");
        signInBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInBtnActionPerformed(evt);
            }
        });

        loginPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        usernameLabel.setText("Username");

        passwordLabel.setText("Password");

        okBtn1.setBackground(java.awt.Color.darkGray);
        okBtn1.setText("<html><p style=\"text-align:center\"><b>OK</p> </html>");
        okBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        okBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtn1ActionPerformed(evt);
            }
        });

        forgotPwLabel.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        forgotPwLabel.setText("<html><p style=\"text-align:center\"><b>Forgot my password</p></html>");
        forgotPwLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        forgotPwLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgotPwLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                forgotPwLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                forgotPwLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout forgotPwBtnLayout = new javax.swing.GroupLayout(forgotPwBtn);
        forgotPwBtn.setLayout(forgotPwBtnLayout);
        forgotPwBtnLayout.setHorizontalGroup(
            forgotPwBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(forgotPwLabel)
        );
        forgotPwBtnLayout.setVerticalGroup(
            forgotPwBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(forgotPwBtnLayout.createSequentialGroup()
                .addComponent(forgotPwLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameField)
                            .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usernameLabel)
                                    .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(passwordField)))
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(okBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 36, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(forgotPwBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(usernameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(forgotPwBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(okBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        signInPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        nameLabel.setText("Name");

        surnameLabel.setText("Surname");

        usernameLabel2.setText("Username");

        passwordLabel2.setText("Password");

        okBtn2.setBackground(java.awt.Color.darkGray);
        okBtn2.setText("<html><p style=\"text-align:center\"><b>OK</p> </html>");
        okBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        okBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtn2ActionPerformed(evt);
            }
        });

        ageLabel.setText("Age");

        ageSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        javax.swing.GroupLayout signInPanelLayout = new javax.swing.GroupLayout(signInPanel);
        signInPanel.setLayout(signInPanelLayout);
        signInPanelLayout.setHorizontalGroup(
            signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signInPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ageLabel)
                    .addGroup(signInPanelLayout.createSequentialGroup()
                        .addGroup(signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(surnameField, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                .addComponent(nameLabel)
                                .addComponent(surnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nameField))
                            .addComponent(ageSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(signInPanelLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(okBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(passwordField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                .addComponent(passwordLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(usernameLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(usernameField2, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        signInPanelLayout.setVerticalGroup(
            signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signInPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(usernameLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(surnameLabel)
                    .addComponent(passwordLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ageSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(signInPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(0, 208, Short.MAX_VALUE)
                .addComponent(appNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(208, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(235, 235, 235)
                        .addComponent(signInBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(infoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(appNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(infoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(signInBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(signInPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signInBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInBtnActionPerformed
        signInbtnPressed = !signInbtnPressed;

        if (signInbtnPressed)
            signInPanel.setVisible(true);
        else
            signInPanel.setVisible(false);
    }//GEN-LAST:event_signInBtnActionPerformed

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        loginbtnPressed = !loginbtnPressed;

        if (loginbtnPressed)
            loginPanel.setVisible(true);
        else
            loginPanel.setVisible(false);
    }//GEN-LAST:event_loginBtnActionPerformed

    private void okBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtn1ActionPerformed
        int isLoginInfoValid = GUIFunctions.checkLoginInfo(this, customerList);
        if (isLoginInfoValid >= 0) {
            // Erase data from both login and login fields
            usernameField.setText("");
            passwordField.setText("");
            nameField.setText("");
            surnameField.setText("");
            ageSpinner.setValue((Integer) 0);
            usernameField2.setText("");
            passwordField2.setText("");

            try {
                sf = new ServicesFrame(this, customerList, isLoginInfoValid);
            } catch (SQLException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            sf.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_okBtn1ActionPerformed

    private void okBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtn2ActionPerformed
        int isSignInInfoValid = GUIFunctions.checkSignInInfo(this, customerList);
        if (isSignInInfoValid == 1) {
            // Erase data from both login and sign in fields
            usernameField.setText("");
            passwordField.setText("");
            nameField.setText("");
            surnameField.setText("");
            ageSpinner.setValue((Integer) 0);
            usernameField2.setText("");
            passwordField2.setText("");

            JOptionPane.showMessageDialog(this, "Successfull sign in");
        }
    }//GEN-LAST:event_okBtn2ActionPerformed

    private void forgotPwLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPwLabelMouseClicked
        if (fpf != null) {
            fpf.dispose();
        }

        fpf = new ForgotPasswordFrame(this, customerList);
        fpf.setVisible(true);
    }//GEN-LAST:event_forgotPwLabelMouseClicked

    private void forgotPwLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPwLabelMouseEntered
//        forgotPwLabel.setForeground(def);
    }//GEN-LAST:event_forgotPwLabelMouseEntered

    private void forgotPwLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPwLabelMouseExited
//        forgotPwLabel.setForeground(pc);
    }//GEN-LAST:event_forgotPwLabelMouseExited

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws javax.swing.UnsupportedLookAndFeelException
     */
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        /* Set the Nimbus look and feel */
//        UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarculaLaf");

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainFrame().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public JSpinner getAgeSpinner() {
        return ageSpinner;
    }

    public void setAgeSpinner(JSpinner ageSpinner) {
        this.ageSpinner = ageSpinner;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public JPasswordField getPasswordField2() {
        return passwordField2;
    }

    public void setPasswordField2(JPasswordField passwordField2) {
        this.passwordField2 = passwordField2;
    }

    public JTextField getSurnameField() {
        return surnameField;
    }

    public void setSurnameField(JTextField surnameField) {
        this.surnameField = surnameField;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public void setUsernameField(JTextField usernameField) {
        this.usernameField = usernameField;
    }

    public JTextField getUsernameField2() {
        return usernameField2;
    }

    public void setUsernameField2(JTextField usernameField2) {
        this.usernameField2 = usernameField2;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ageLabel;
    private javax.swing.JSpinner ageSpinner;
    private javax.swing.JLabel appNameLabel;
    private javax.swing.JPanel forgotPwBtn;
    private javax.swing.JLabel forgotPwLabel;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton okBtn1;
    private javax.swing.JButton okBtn2;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JPasswordField passwordField2;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel passwordLabel2;
    private javax.swing.JButton signInBtn;
    private javax.swing.JPanel signInPanel;
    private javax.swing.JTextField surnameField;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JTextField usernameField;
    private javax.swing.JTextField usernameField2;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel usernameLabel2;
    // End of variables declaration//GEN-END:variables
}
