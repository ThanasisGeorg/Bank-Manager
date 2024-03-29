package GUI;

import Database.DBMethods;
import Database.Database;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
public class DepositFrame extends javax.swing.JFrame {

    ServicesFrame sf;
    ArrayList<Customer> customerList;
    ResourceBundle rb;
    Theme theme;

    private int indexOfCustomerLoggedIn;

    Color pc = new Color(162, 119, 255);
    Color bg = new Color(21, 20, 27);
    Color sc = new Color(97, 255, 202);

    public DepositFrame() {
        FlatDarculaLaf.setup();
        // Frame setup
        initComponents();
        this.theme = GUIFunctions.setupFrame(this, "Deposit");

        // Center frame
        this.pack();
        this.setLocationRelativeTo(null);

        // Color, focus and visibility setup of components
        depositPanel.setBackground(bg);
        cancelBtn.setForeground(pc);
        applyBtn.setForeground(pc);

        cancelBtn.setFocusable(false);
        applyBtn.setFocusable(false);
    }

    public DepositFrame(ServicesFrame sf, ArrayList<Customer> customerList, int indexOfCustomerLoggedIn) {
        FlatDarculaLaf.setup();
        // Frame setup
        initComponents();
        this.theme = GUIFunctions.setupFrame(this, "Deposit");

        configureFrameProperties();

        // Focus and visibility setup of components
        cancelBtn.setFocusable(false);
        applyBtn.setFocusable(false);

        this.sf = sf;
        this.customerList = customerList;
        this.indexOfCustomerLoggedIn = indexOfCustomerLoggedIn;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        depositPanel = new javax.swing.JPanel();
        depositLabel = new javax.swing.JLabel();
        amountField = new javax.swing.JTextField();
        cancelBtn = new javax.swing.JButton();
        applyBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        depositPanel.setName("bg"); // NOI18N

        depositLabel.setFont(new java.awt.Font("Manjari", 0, 18)); // NOI18N
        depositLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        depositLabel.setText("<html><p style=\"text-align:center\"><b>Enter the amount you want to deposit</p> </html>");
        depositLabel.setName("textbox"); // NOI18N

        amountField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

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

        javax.swing.GroupLayout depositPanelLayout = new javax.swing.GroupLayout(depositPanel);
        depositPanel.setLayout(depositPanelLayout);
        depositPanelLayout.setHorizontalGroup(
            depositPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(depositPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(applyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, depositPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(depositLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, depositPanelLayout.createSequentialGroup()
                .addContainerGap(249, Short.MAX_VALUE)
                .addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(246, 246, 246))
        );
        depositPanelLayout.setVerticalGroup(
            depositPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(depositPanelLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(depositLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addGroup(depositPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(applyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(depositPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(depositPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void configureFrameProperties() {
        DatabaseConnection db = Database.connection();

        try {
            ResultSet rs = db.executeQuery(new QueryBuilder().select("Language").from("Settings").build());
            rs.next();
            String languageName = rs.getString(1);
            if (languageName.equals("English")) {
                GUIFunctions.setTexts(this, Locale.US);
            } else if (languageName.equals("Greek")) {
                GUIFunctions.setTexts(this, Locale.of("el", "GR"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SettingsFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        db.close();
    }

    private void applyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyBtnActionPerformed
        if (GUIUtils.checkChars(amountField.getText()) || amountField.getText().isBlank() || amountField.getText().isEmpty()
                || amountField.getText().contains(",") || amountField.getText().contains(".")) {
            JOptionPane.showMessageDialog(this, "Invalid amount");
            return;
        }

        double balance = Double.parseDouble(amountField.getText());

        customerList.get(indexOfCustomerLoggedIn).getAcc().setBalance(customerList.get(indexOfCustomerLoggedIn).getAcc().getBalance() + balance);
        try {
            DBMethods.updateCustomerAcc(customerList, indexOfCustomerLoggedIn);
        } catch (SQLException ex) {
            Logger.getLogger(DepositFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.setVisible(false);

        DatabaseConnection db = Database.connection();

        try {
            ResultSet rs = db.executeQuery(new QueryBuilder().select("Language").from("Settings").build());
            rs.next();
            String languageName = rs.getString(1);
            if (languageName.equals("English")) {
                JOptionPane.showMessageDialog(sf, "Successfull deposit.\nRefresh the information to see the result");
            } else if (languageName.equals("Greek")) {
                JOptionPane.showMessageDialog(sf, "Επιτυχής κατάθεση.\nΑνανεώστε τις πληροφορίες για να δείτε το αποτέλεσμα");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepositFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        db.close();
        
        this.dispose();
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
                new DepositFrame().setVisible(true);
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

    public JButton getCancelBtn() {
        return cancelBtn;
    }

    public JLabel getDepositLabel() {
        return depositLabel;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountField;
    private javax.swing.JButton applyBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel depositLabel;
    private javax.swing.JPanel depositPanel;
    // End of variables declaration//GEN-END:variables
}
