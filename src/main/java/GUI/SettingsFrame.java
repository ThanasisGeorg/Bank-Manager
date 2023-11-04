package GUI;

import Database.DBMethods;
import Database.Database;
import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import kdesp73.databridge.connections.*;
import kdesp73.databridge.helpers.QueryBuilder;

import main.Customer;

/**
 *
 * @author tgeorg
 */
public class SettingsFrame extends javax.swing.JFrame {
   
    ServicesFrame sf;
    ChangePasswordFrame cpf;
    ArrayList<Customer> customerList;
    ResourceBundle rb;

    Color pc = new Color(162, 119, 255);
    Color bg = new Color(21, 20, 27);

    private static final String FILEPATH = System.getProperty("user.dir").replaceAll(Pattern.quote("\\"), "/");
    private int indexOfCustomerLoggedIn;

    public SettingsFrame() {
        DatabaseConnection db = Database.connection();

        initComponents();
        this.setTitle("Settings");

        // Center frame
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        // Color, focus and visibility setup of components
        settingsPanel.setBackground(bg);
        changePwBtn.setForeground(pc);

        languageComboBox.setFocusable(false);
        themesComboBox.setFocusable(false);
        changePwBtn.setFocusable(false);

        this.setIconImage(new ImageIcon(FILEPATH + "/data/Icons/gear-solid.svg").getImage());

        db.close();
    }

    public SettingsFrame(ServicesFrame sf, ArrayList<Customer> customerList, int indexOfCustomerLoggedIn) {
        DatabaseConnection db = Database.connection();

        initComponents();
        this.setTitle("Settings");

        // Center frame
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        // Setup of components
        this.sf = sf;
        this.customerList = customerList;
        this.indexOfCustomerLoggedIn = indexOfCustomerLoggedIn;

        // Color, focus and visibility setup of components
        settingsPanel.setBackground(bg);
        changePwBtn.setForeground(pc);

        languageComboBox.setFocusable(false);
        themesComboBox.setFocusable(false);
        changePwBtn.setFocusable(false);

        this.setIconImage(new ImageIcon(FILEPATH + "/data/icons/gear-solid.svg").getImage());
        
        configureFrameLanguage();

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

        settingsPanel = new javax.swing.JPanel();
        generalLabel = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        languageLabel = new javax.swing.JLabel();
        languageComboBox = new javax.swing.JComboBox<Locale>();
        appearanceLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        themesLabel = new javax.swing.JLabel();
        themesComboBox = new javax.swing.JComboBox<>();
        securityLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        changePwBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        generalLabel.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        generalLabel.setText("<html><p style=\"text-align:center\"><b>General</p> </html>");

        languageLabel.setText("<html><p style=\"text-align:center\"><b>Language:</p> </html>");

        languageComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                languageComboBoxActionPerformed(evt);
            }
        });

        appearanceLabel.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        appearanceLabel.setText("<html><p style=\"text-align:center\"><b>Appearance</p> </html>");

        themesLabel.setText("<html><p style=\"text-align:center\"><b>Theme:</p> </html>");

        themesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Light", "Dark" }));

        securityLabel.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        securityLabel.setText("<html><p style=\"text-align:center\"><b>Security</p> </html>");

        changePwBtn.setText("<html><p style=\"text-align:center\"><b>Change Password</p> </html>");
        changePwBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePwBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout settingsPanelLayout = new javax.swing.GroupLayout(settingsPanel);
        settingsPanel.setLayout(settingsPanelLayout);
        settingsPanelLayout.setHorizontalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addComponent(themesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(themesComboBox, 0, 300, Short.MAX_VALUE)
                        .addGap(87, 87, 87))
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(changePwBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(appearanceLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                            .addGroup(settingsPanelLayout.createSequentialGroup()
                                .addComponent(languageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(languageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(generalLabel, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(securityLabel, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        settingsPanelLayout.setVerticalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(generalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(languageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(languageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(appearanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(themesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(themesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(securityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changePwBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(250, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(settingsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(settingsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void configureFrameLanguage(){
        languageComboBox.addItem(Locale.US);
        languageComboBox.addItem(Locale.GERMANY);
        languageComboBox.addItemListener(itemEvent -> setTexts());
    }
    
    private void setTexts(){
        Locale locale = languageComboBox.getItemAt(languageComboBox.getSelectedIndex());
        System.out.println(locale);
        rb = ResourceBundle.getBundle("Bundle", locale);
        setTitle(rb.getString("application.title"));
        languageLabel.setText(rb.getString("language") + ":");
        languageComboBox.setToolTipText(rb.getString("language.tooltip"));
    }
    
    private void changePwBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePwBtnActionPerformed
        if (cpf != null) {
            cpf.dispose();
        }

        cpf = new ChangePasswordFrame(this, customerList, indexOfCustomerLoggedIn);
        cpf.setVisible(true);
    }//GEN-LAST:event_changePwBtnActionPerformed

    private void languageComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_languageComboBoxActionPerformed
        DatabaseConnection db = Database.connection();

        String s = languageComboBox.getSelectedItem().toString();
//        if (s.equalsIgnoreCase("English")) {
//            Locale.setDefault(new Locale("en","US"));
//        } else if (s.equalsIgnoreCase("Greek")) {
//            Locale.setDefault(new Locale("el","GR"));
//        }

        try {
            DBMethods.updateSettings(s);
        } catch (SQLException ex) {
            Logger.getLogger(SettingsFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        db.close();
    }//GEN-LAST:event_languageComboBoxActionPerformed

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws javax.swing.UnsupportedLookAndFeelException
     */
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        /* Set the Nimbus look and feel */
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SettingsFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel appearanceLabel;
    private javax.swing.JButton changePwBtn;
    private javax.swing.JLabel generalLabel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private JComboBox<Locale> languageComboBox;
    private javax.swing.JLabel languageLabel;
    private javax.swing.JLabel securityLabel;
    private javax.swing.JPanel settingsPanel;
    private javax.swing.JComboBox<String> themesComboBox;
    private javax.swing.JLabel themesLabel;
    // End of variables declaration//GEN-END:variables
}
