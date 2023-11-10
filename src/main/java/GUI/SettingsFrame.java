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
import kdesp73.themeLib.*;

import com.formdev.flatlaf.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import main.Customer;

/**
 *
 * @author tgeorg
 */
public class SettingsFrame extends javax.swing.JFrame {

    ServicesFrame sf;
    ChangePasswordFrame cpf;
    AboutFrame af;
    ArrayList<Customer> customerList;
    ResourceBundle rb;
    Theme theme;

    Color pc = new Color(162, 119, 255);
    Color bg = new Color(21, 20, 27);
    Color sep = new Color(187, 187, 187);

    private static final String FILEPATH = System.getProperty("user.dir").replaceAll(Pattern.quote("\\"), "/");
    private int indexOfCustomerLoggedIn;
    private int count1 = 0;
    private int count2 = 0;

    public SettingsFrame() {
        DatabaseConnection db = Database.connection();

        initComponents();
        this.theme = GUIFunctions.setupFrame(this, "Settings");

        // Color, focus and visibility setup of components
        settingsPanel.setBackground(bg);
        changePwBtn.setForeground(pc);

        languageComboBox.setFocusable(false);
        themesComboBox.setFocusable(false);
        changePwBtn.setFocusable(false);

//        this.setIconImage(new ImageIcon(FILEPATH + "/data/Icons/gear-solid.svg").getImage());
        db.close();
    }

    public SettingsFrame(ServicesFrame sf, ArrayList<Customer> customerList, int indexOfCustomerLoggedIn) throws SQLException {
        DatabaseConnection db = Database.connection();

        // Frame setup
        initComponents();
        this.theme = GUIFunctions.setupFrame(this, "Settings");

        configureFrameProperties();

        refreshThemeCombo();
        themesComboBox.setSelectedItem(theme.getName());

        // Color, focus and visibility setup of components
//        settingsPanel.setBackground(bg);
//        generalSeparator.setBackground(sep);
//        appearanceSeparator.setBackground(sep);
//        securitySeparator.setBackground(sep);
//        changePwBtn.setForeground(pc);
        languageComboBox.setFocusable(false);
        themesComboBox.setFocusable(false);
        changePwBtn.setFocusable(false);
        aboutBtn.setFocusable(false);
        helpBtn.setFocusable(false);

        this.sf = sf;
        this.customerList = customerList;
        this.indexOfCustomerLoggedIn = indexOfCustomerLoggedIn;

//        this.setIconImage(new ImageIcon(FILEPATH + "/data/icons/gear-solid.svg").getImage());
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
        generalSeparator = new javax.swing.JSeparator();
        languageLabel = new javax.swing.JLabel();
        languageComboBox = new javax.swing.JComboBox();
        appearanceLabel = new javax.swing.JLabel();
        appearanceSeparator = new javax.swing.JSeparator();
        themesLabel = new javax.swing.JLabel();
        themesComboBox = new javax.swing.JComboBox<>();
        securityLabel = new javax.swing.JLabel();
        securitySeparator = new javax.swing.JSeparator();
        changePwBtn = new javax.swing.JButton();
        helpBtn = new javax.swing.JButton();
        aboutBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        settingsPanel.setName("bg"); // NOI18N

        generalLabel.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        generalLabel.setText("<html><p style=\"text-align:center\"><b>General</p> </html>");
        generalLabel.setName("textbox"); // NOI18N

        generalSeparator.setBackground(new java.awt.Color(187, 187, 187));
        generalSeparator.setForeground(new java.awt.Color(187, 187, 187));
        generalSeparator.setName("fg_2"); // NOI18N

        languageLabel.setText("<html><p style=\"text-align:center\"><b>Language:</p> </html>");
        languageLabel.setName("textbox"); // NOI18N

        languageComboBox.setBackground(java.awt.Color.darkGray);
        languageComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                languageComboBoxActionPerformed(evt);
            }
        });

        appearanceLabel.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        appearanceLabel.setText("<html><p style=\"text-align:center\"><b>Appearance</p> </html>");
        appearanceLabel.setName("textbox"); // NOI18N

        appearanceSeparator.setBackground(new java.awt.Color(187, 187, 187));
        appearanceSeparator.setForeground(new java.awt.Color(187, 187, 187));
        appearanceSeparator.setName("fg_2"); // NOI18N

        themesLabel.setText("<html><p style=\"text-align:center\"><b>Theme:</p> </html>");
        themesLabel.setName("textbox"); // NOI18N

        themesComboBox.setBackground(java.awt.Color.darkGray);
        themesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Light", "Dark" }));
        themesComboBox.setFocusable(false);
        themesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themesComboBoxActionPerformed(evt);
            }
        });

        securityLabel.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        securityLabel.setText("<html><p style=\"text-align:center\"><b>Security</p> </html>");
        securityLabel.setName("textbox"); // NOI18N

        securitySeparator.setBackground(new java.awt.Color(187, 187, 187));
        securitySeparator.setForeground(new java.awt.Color(187, 187, 187));
        securitySeparator.setName("fg_2"); // NOI18N

        changePwBtn.setBackground(java.awt.Color.darkGray);
        changePwBtn.setText("<html><p style=\"text-align:center\"><b>Change Password</p> </html>");
        changePwBtn.setFocusable(false);
        changePwBtn.setName("btn"); // NOI18N
        changePwBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changePwBtnMouseClicked(evt);
            }
        });

        helpBtn.setBackground(java.awt.Color.darkGray);
        helpBtn.setText("<html><p style=\"text-align:center\"><b>Help</p> </html>");
        helpBtn.setName("btn"); // NOI18N

        aboutBtn.setBackground(java.awt.Color.darkGray);
        aboutBtn.setText("<html><p style=\"text-align:center\"><b>About</p> </html>");
        aboutBtn.setName("btn"); // NOI18N
        aboutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aboutBtnMouseClicked(evt);
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
                                .addComponent(appearanceSeparator, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(appearanceLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                            .addGroup(settingsPanelLayout.createSequentialGroup()
                                .addComponent(languageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(languageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(generalSeparator, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(generalLabel, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(securitySeparator, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(securityLabel, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, settingsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(aboutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(helpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        settingsPanelLayout.setVerticalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(generalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(generalSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(languageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(languageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(appearanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(appearanceSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(themesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(themesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(securityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(securitySeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changePwBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(helpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aboutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

    private void configureFrameProperties() {
        DatabaseConnection db = Database.connection();

        try {
            ResultSet rs = db.executeQuery(new QueryBuilder().select("Language").from("Settings").build());
            rs.next();
            String languageName = rs.getString(1);
            if (languageName.equals("English")) {
                languageComboBox.removeAllItems();
                languageComboBox.addItem("English");
                languageComboBox.addItem("Greek");
                GUIFunctions.setTexts(this, Locale.US);
                GUIFunctions.setTexts(this.sf, Locale.US);
                languageComboBox.addItemListener(itemEvent -> GUIFunctions.setTexts(this, Locale.US));
            } else if (languageName.equals("Greek")) {
                languageComboBox.removeAllItems();
                languageComboBox.addItem("Ελληνικά");
                languageComboBox.addItem("Αγγλικά");
                GUIFunctions.setTexts(this, Locale.of("el", "GR"));
                GUIFunctions.setTexts(this.sf, Locale.of("el", "GR"));
                languageComboBox.addItemListener(itemEvent -> GUIFunctions.setTexts(this, Locale.of("el", "GR")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SettingsFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        db.close();
    }

    public void refreshThemeCombo() {
        ArrayList<String> themeNames = new ArrayList<>();

        ThemeCollection themes = new ThemeCollection();
        themes.loadThemes(new File(FILEPATH + "/themes/"));

        for (Theme theme : themes.getThemes()) {
            themeNames.add(theme.getName());
        }

        // themeNames.add(0, "Default");
        themesComboBox.setModel(new DefaultComboBoxModel(themeNames.toArray()));
    }

    private void changePwBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePwBtnMouseClicked
        if (evt.getButton() != MouseEvent.BUTTON1) {
            return;
        }

        if (cpf != null) {
            cpf.dispose();
        }

        cpf = new ChangePasswordFrame(this, customerList, indexOfCustomerLoggedIn);
        cpf.setVisible(true);
    }//GEN-LAST:event_changePwBtnMouseClicked

    private void themesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themesComboBoxActionPerformed
        if (count2 == 0) {
            count2 = 1;
            return;
        }

        String themeName = themesComboBox.getSelectedItem().toString();
        ThemeCollection themes = new ThemeCollection();
        themes.loadThemes(new File(FILEPATH + "/themes/"));
        Theme selectedTheme = themes.matchTheme(themeName);

        try {
            DBMethods.updateTheme(themeName);
        } catch (SQLException ex) {
            Logger.getLogger(SettingsFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        sf.setTheme(selectedTheme);
        this.theme = selectedTheme;

        ThemeCollection.applyTheme(sf, selectedTheme);
        ThemeCollection.applyTheme(this, selectedTheme);
    }//GEN-LAST:event_themesComboBoxActionPerformed

    private void aboutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutBtnMouseClicked
        if (evt.getButton() != MouseEvent.BUTTON1) {
            return;
        }

        if (af != null) {
            af.dispose();
        }

        af = new AboutFrame(this);
        af.setVisible(true);
    }//GEN-LAST:event_aboutBtnMouseClicked

    private void languageComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_languageComboBoxActionPerformed
        if (count1 == 0) {
            count1 = 1;
            return;
        }

        DatabaseConnection db = Database.connection();
        String languageName = languageComboBox.getSelectedItem().toString();
        try {
            switch (languageName) {
                case "Ελληνικά":
                    DBMethods.updateLanguage("Greek");
                    configureFrameProperties();
                    break;
                case "Αγγλικά":
                    DBMethods.updateLanguage("English");
                    configureFrameProperties();
                    break;
                default:
                    DBMethods.updateLanguage(languageName);
                    configureFrameProperties();
                    break;
            }
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

 /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SettingsFrame().setVisible(true);
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

    public ChangePasswordFrame getCpf() {
        return cpf;
    }

    public void setCpf(ChangePasswordFrame cpf) {
        this.cpf = cpf;
    }

    public AboutFrame getAf() {
        return af;
    }

    public void setAf(AboutFrame af) {
        this.af = af;
    }

    public JButton getAboutBtn() {
        return aboutBtn;
    }

    public void setAboutBtn(JButton aboutBtn) {
        this.aboutBtn = aboutBtn;
    }

    public JLabel getAppearanceLabel() {
        return appearanceLabel;
    }

    public void setAppearanceLabel(JLabel appearanceLabel) {
        this.appearanceLabel = appearanceLabel;
    }

    public JButton getChangePwBtn() {
        return changePwBtn;
    }

    public void setChangePwBtn(JButton changePwBtn) {
        this.changePwBtn = changePwBtn;
    }

    public JLabel getGeneralLabel() {
        return generalLabel;
    }

    public void setGeneralLabel(JLabel generalLabel) {
        this.generalLabel = generalLabel;
    }

    public JSeparator getGeneralSeparator() {
        return generalSeparator;
    }

    public void setGeneralSeparator(JSeparator generalSeparator) {
        this.generalSeparator = generalSeparator;
    }

    public JButton getHelpBtn() {
        return helpBtn;
    }

    public void setHelpBtn(JButton helpBtn) {
        this.helpBtn = helpBtn;
    }

    public JLabel getLanguageLabel() {
        return languageLabel;
    }

    public void setLanguageLabel(JLabel languageLabel) {
        this.languageLabel = languageLabel;
    }

    public JLabel getSecurityLabel() {
        return securityLabel;
    }

    public void setSecurityLabel(JLabel securityLabel) {
        this.securityLabel = securityLabel;
    }

    public JPanel getSettingsPanel() {
        return settingsPanel;
    }

    public void setSettingsPanel(JPanel settingsPanel) {
        this.settingsPanel = settingsPanel;
    }

    public JComboBox<String> getThemesComboBox() {
        return themesComboBox;
    }

    public void setThemesComboBox(JComboBox<String> themesComboBox) {
        this.themesComboBox = themesComboBox;
    }

    public JLabel getThemesLabel() {
        return themesLabel;
    }

    public void setThemesLabel(JLabel themesLabel) {
        this.themesLabel = themesLabel;
    }

    public JComboBox getLanguageComboBox() {
        return languageComboBox;
    }

    public void setLanguageComboBox(JComboBox languageComboBox) {
        this.languageComboBox = languageComboBox;
    }

    public ResourceBundle getRb() {
        return rb;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aboutBtn;
    private javax.swing.JLabel appearanceLabel;
    private javax.swing.JSeparator appearanceSeparator;
    private javax.swing.JButton changePwBtn;
    private javax.swing.JLabel generalLabel;
    private javax.swing.JSeparator generalSeparator;
    private javax.swing.JButton helpBtn;
    private javax.swing.JComboBox languageComboBox;
    private javax.swing.JLabel languageLabel;
    private javax.swing.JLabel securityLabel;
    private javax.swing.JSeparator securitySeparator;
    private javax.swing.JPanel settingsPanel;
    private javax.swing.JComboBox<String> themesComboBox;
    private javax.swing.JLabel themesLabel;
    // End of variables declaration//GEN-END:variables
}
