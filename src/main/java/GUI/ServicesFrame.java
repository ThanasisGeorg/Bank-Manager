package GUI;

import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import Database.DBMethods;
import Database.Database;
import Utils.Utils;
import com.formdev.flatlaf.*;
import java.awt.Component;
import java.sql.ResultSet;
import kdesp73.databridge.connections.DatabaseConnection;
import kdesp73.databridge.helpers.QueryBuilder;
import kdesp73.themeLib.Theme;
import kdesp73.themeLib.ThemeCollection;
import main.Customer;

/**
 *
 * @author tgeorg
 */
public class ServicesFrame extends javax.swing.JFrame {

    MainFrame mf;
    ForgotPasswordFrame fpf = new ForgotPasswordFrame();
    DepositFrame df = new DepositFrame();
    ChangePasswordFrame cpf = new ChangePasswordFrame();
    SettingsFrame sf = new SettingsFrame();
    ArrayList<Customer> customerList;
    Theme theme;

    Color pc = new Color(162, 119, 255);
    Color bg = new Color(21, 20, 27);
    Color sep = new Color(187, 187, 187);
    Color sc = new Color(97, 255, 202);

    private int indexOfCustomerLoggedIn;
    private boolean accInfoBtnPressed = false;
    private boolean depBtnPressed = false;
    private boolean uploadImgBtnPressed = false;

    public ServicesFrame() {   
        FlatDarculaLaf.setup();
        DatabaseConnection db = Database.connection();

        // Frame setup
        initComponents();
        this.theme = GUIFunctions.setupFrame(this, "~");

        // Center frame
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        // Color, focus and visibility setup of components
        servicesPanel.setBackground(bg);
        menuSeparator.setBackground(sep);
        accInfoBtn.setForeground(pc);
        accInfoSeparator.setBackground(sep);
        depBtn.setForeground(pc);
        depSeparator.setBackground(sep);
        delBtn.setForeground(pc);
        delSeparator.setBackground(sep);
        logoutBtn.setForeground(pc);
        logoutSeparator.setBackground(sep);
        refreshBtn.setForeground(pc);
        uploadImgBtn.setForeground(pc);
        settingsBtn.setForeground(pc);
        infoSeparator.setBackground(sep);
        avatarSeparator1.setBackground(sep);
        avatarSeparator2.setBackground(sep);

        accInfoBtn.setFocusable(false);
        depBtn.setFocusable(false);
        delBtn.setFocusable(false);
        logoutBtn.setFocusable(false);
        refreshBtn.setFocusable(false);
        uploadImgBtn.setFocusable(false);
        settingsBtn.setFocusable(false);

        try {
            ResultSet rs = db.executeQuery(new QueryBuilder().select("Font").from("Settings").build());
            rs.next();
            GUIUtils.changeGlobalFont(new Component[]{this}, 4, rs.getString(1));
        } catch (SQLException ex) {
            Logger.getLogger(this.getName()).log(Level.SEVERE, null, ex);
        }

        db.close();
    }

    public ServicesFrame(MainFrame mf, ArrayList<Customer> customerList, int indexOfCustomerLoggedIn) throws SQLException {
        FlatDarculaLaf.setup();
        DatabaseConnection db = Database.connection();

        // Frame setup
        initComponents();
        this.theme = GUIFunctions.setupFrame(this, customerList.get(indexOfCustomerLoggedIn).getAcc().getUsername() + ":~");

        // Color, focus and visibility setup of components
        servicesPanel.setBackground(bg);
        menuSeparator.setForeground(sep);
        accInfoBtn.setForeground(pc);
        accInfoSeparator.setForeground(sep);
        depBtn.setForeground(pc);
        depSeparator.setForeground(sep);
        delBtn.setForeground(pc);
        delSeparator.setForeground(sep);
        logoutBtn.setForeground(pc);
        logoutSeparator.setForeground(sep);
        refreshBtn.setForeground(pc);
        uploadImgBtn.setForeground(pc);
        settingsBtn.setForeground(pc);
        infoSeparator.setForeground(sep);
        avatarSeparator1.setForeground(sep);
        avatarSeparator2.setForeground(sep);
        
        accInfoBtn.setFocusable(false);
        depBtn.setFocusable(false);
        delBtn.setFocusable(false);
        logoutBtn.setFocusable(false);
        refreshBtn.setFocusable(false);
        uploadImgBtn.setFocusable(false);
        settingsBtn.setFocusable(false);

        this.mf = mf;
        this.customerList = customerList;
        this.indexOfCustomerLoggedIn = indexOfCustomerLoggedIn;

        loadImage(DBMethods.getImg(customerList, indexOfCustomerLoggedIn));
        setInfoPanel();

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

        imgChooser = new javax.swing.JFileChooser();
        servicesPanel = new javax.swing.JPanel();
        mainMenuLabel = new javax.swing.JLabel();
        menuSeparator = new javax.swing.JSeparator();
        accInfoBtn = new javax.swing.JButton();
        accInfoSeparator = new javax.swing.JSeparator();
        depBtn = new javax.swing.JButton();
        depSeparator = new javax.swing.JSeparator();
        delBtn = new javax.swing.JButton();
        delSeparator = new javax.swing.JSeparator();
        logoutBtn = new javax.swing.JButton();
        logoutSeparator = new javax.swing.JSeparator();
        mainSeparator = new javax.swing.JSeparator();
        infoPanel = new javax.swing.JPanel();
        avatarPanel = new javax.swing.JPanel();
        avatarLabel = new javax.swing.JLabel();
        customerInfoLabel = new javax.swing.JLabel();
        nameIndicator = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        surnameIndicator = new javax.swing.JLabel();
        surname = new javax.swing.JLabel();
        ageIndicator = new javax.swing.JLabel();
        age = new javax.swing.JLabel();
        accountInfoLabel = new javax.swing.JLabel();
        usernameIndicator = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        balanceIndicator = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        accIdIndicator = new javax.swing.JLabel();
        accountId = new javax.swing.JLabel();
        infoSeparator = new javax.swing.JSeparator();
        avatarSeparator1 = new javax.swing.JSeparator();
        avatarSeparator2 = new javax.swing.JSeparator();
        uploadImgBtn = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();
        settingsBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainMenuLabel.setFont(new java.awt.Font("Liberation Sans", 0, 26)); // NOI18N
        mainMenuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainMenuLabel.setText("<html><p style=\"text-align:center\"><b>Main Menu</p> </html>");

        menuSeparator.setBackground(new java.awt.Color(187, 187, 187));
        menuSeparator.setForeground(new java.awt.Color(187, 187, 187));

        accInfoBtn.setBackground(java.awt.Color.darkGray);
        accInfoBtn.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        accInfoBtn.setText("<html><p style=\"text-align:center\"><b>Account<br>Information</p> </html>");
        accInfoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accInfoBtnActionPerformed(evt);
            }
        });

        accInfoSeparator.setBackground(new java.awt.Color(187, 187, 187));
        accInfoSeparator.setForeground(new java.awt.Color(187, 187, 187));

        depBtn.setBackground(java.awt.Color.darkGray);
        depBtn.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        depBtn.setText("<html><p style=\"text-align:center\"><b>Deposit</p> </html>");
        depBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depBtnActionPerformed(evt);
            }
        });

        depSeparator.setBackground(new java.awt.Color(187, 187, 187));
        depSeparator.setForeground(new java.awt.Color(187, 187, 187));

        delBtn.setBackground(java.awt.Color.darkGray);
        delBtn.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        delBtn.setText("<html><p style=\"text-align:center\"><b>Delete<br>Account</p> </html>");
        delBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delBtnActionPerformed(evt);
            }
        });

        delSeparator.setBackground(new java.awt.Color(187, 187, 187));
        delSeparator.setForeground(new java.awt.Color(187, 187, 187));

        logoutBtn.setBackground(java.awt.Color.darkGray);
        logoutBtn.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        logoutBtn.setText("<html><p style=\"text-align:center\"><b>Logout</p> </html>");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        logoutSeparator.setBackground(new java.awt.Color(187, 187, 187));
        logoutSeparator.setForeground(new java.awt.Color(187, 187, 187));

        mainSeparator.setBackground(new java.awt.Color(187, 187, 187));
        mainSeparator.setForeground(new java.awt.Color(187, 187, 187));
        mainSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);

        avatarPanel.setBackground(new java.awt.Color(0, 0, 0));

        avatarLabel.setBackground(new java.awt.Color(0, 0, 0));
        avatarLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout avatarPanelLayout = new javax.swing.GroupLayout(avatarPanel);
        avatarPanel.setLayout(avatarPanelLayout);
        avatarPanelLayout.setHorizontalGroup(
            avatarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(avatarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
        );
        avatarPanelLayout.setVerticalGroup(
            avatarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(avatarLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
        );

        customerInfoLabel.setFont(new java.awt.Font("Liberation Sans", 0, 22)); // NOI18N
        customerInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        customerInfoLabel.setText("<html><p style=\"text-align:center\"><b>Customer Info</p> </html>");

        nameIndicator.setText("<html><p style=\"text-align:center\"><b>Name:</p> </html>");

        surnameIndicator.setText("<html><p style=\"text-align:center\"><b>Surname:</p> </html>");

        ageIndicator.setText("<html><p style=\"text-align:center\"><b>Age:</p> </html>");

        accountInfoLabel.setFont(new java.awt.Font("Liberation Sans", 0, 22)); // NOI18N
        accountInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        accountInfoLabel.setText("<html><p style=\"text-align:center\"><b>Account Info</p> </html>");

        usernameIndicator.setText("<html><p style=\"text-align:center\"><b>Username:</p> </html>");

        balanceIndicator.setText("<html><p style=\"text-align:center\"><b>Balance:</p> </html>");

        accIdIndicator.setText("<html><p style=\"text-align:center\"><b>Account ID:</p> </html>");

        infoSeparator.setBackground(new java.awt.Color(187, 187, 187));
        infoSeparator.setForeground(new java.awt.Color(187, 187, 187));

        avatarSeparator1.setBackground(new java.awt.Color(187, 187, 187));
        avatarSeparator1.setForeground(new java.awt.Color(187, 187, 187));
        avatarSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        avatarSeparator2.setBackground(new java.awt.Color(187, 187, 187));
        avatarSeparator2.setForeground(new java.awt.Color(187, 187, 187));

        uploadImgBtn.setBackground(java.awt.Color.darkGray);
        uploadImgBtn.setText("<html><p style=\"text-align:center\"><b>Upload Image</p> </html>");
        uploadImgBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        uploadImgBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadImgBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(accountInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                        .addComponent(uploadImgBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addContainerGap(51, Short.MAX_VALUE)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(infoPanelLayout.createSequentialGroup()
                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(balanceIndicator, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(accIdIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(balance, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(accountId, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(infoPanelLayout.createSequentialGroup()
                                .addComponent(usernameIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(infoPanelLayout.createSequentialGroup()
                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(infoPanelLayout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(surnameIndicator, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nameIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ageIndicator, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(36, 36, 36)
                                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(surname, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(infoSeparator, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(avatarSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(avatarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(avatarSeparator2))))))
                .addGap(17, 17, 17))
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(customerInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(avatarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(avatarSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(customerInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(surnameIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(surname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ageIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(infoSeparator)
                    .addComponent(avatarSeparator2))
                .addGap(8, 8, 8)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(uploadImgBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(accountInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(balanceIndicator, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(balance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(accountId, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accIdIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        refreshBtn.setBackground(java.awt.Color.darkGray);
        refreshBtn.setText("<html><p style=\"text-align:center\"><b>Refresh Information</p> </html>");
        refreshBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        settingsBtn.setBackground(java.awt.Color.darkGray);
        settingsBtn.setText("<html><p style=\"text-align:center\"><b>Settings</p> </html>");
        settingsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout servicesPanelLayout = new javax.swing.GroupLayout(servicesPanel);
        servicesPanel.setLayout(servicesPanelLayout);
        servicesPanelLayout.setHorizontalGroup(
            servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(servicesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logoutSeparator)
                    .addComponent(logoutBtn)
                    .addComponent(accInfoBtn)
                    .addComponent(depBtn)
                    .addComponent(depSeparator)
                    .addComponent(delSeparator)
                    .addComponent(delBtn)
                    .addComponent(accInfoSeparator)
                    .addComponent(mainMenuLabel)
                    .addComponent(menuSeparator))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                .addGroup(servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(settingsBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        servicesPanelLayout.setVerticalGroup(
            servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(servicesPanelLayout.createSequentialGroup()
                .addGroup(servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(servicesPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(settingsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(servicesPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mainSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                            .addGroup(servicesPanelLayout.createSequentialGroup()
                                .addComponent(mainMenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(menuSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(accInfoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(accInfoSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(depBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(depSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(delBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(delSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(logoutSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(servicesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(servicesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setInfoPanel() {
        name.setText(customerList.get(indexOfCustomerLoggedIn).getName());
        surname.setText(customerList.get(indexOfCustomerLoggedIn).getSurname());
        age.setText(customerList.get(indexOfCustomerLoggedIn).getAge());
        username.setText(customerList.get(indexOfCustomerLoggedIn).getAcc().getUsername());
        balance.setText(customerList.get(indexOfCustomerLoggedIn).getAcc().getBalance() + "");
        accountId.setText(customerList.get(indexOfCustomerLoggedIn).getAcc().getId());
    }

    private void loadImage(String dir) {
        ImageIcon imageIcon = new ImageIcon(dir);
        avatarLabel.setIcon(imageIcon);
    }

    public static void resizeImage(String imgDir) {
        String source = imgDir;
        System.out.println(source);

        BufferedImage originalImage = null;
        try {
            originalImage = ImageIO.read(new File(source));
        } catch (IOException ex) {
            Logger.getLogger(ServicesFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        BufferedImage outputImage = GUIUtils.resizeImage(originalImage, 184, 184);
        try {
            ImageIO.write(outputImage, "jpg", new File(imgDir));
        } catch (IOException ex) {
            Logger.getLogger(ServicesFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void accInfoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accInfoBtnActionPerformed
        accInfoBtnPressed = !accInfoBtnPressed;

        if (accInfoBtnPressed) {
            infoPanel.setVisible(false);
        } else {
            infoPanel.setVisible(true);
        }

    }//GEN-LAST:event_accInfoBtnActionPerformed

    private void depBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depBtnActionPerformed
        if (df != null) {
            df.dispose();
        }

        df = new DepositFrame(this, customerList, indexOfCustomerLoggedIn);
        df.setVisible(true);
    }//GEN-LAST:event_depBtnActionPerformed

    private void delBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBtnActionPerformed
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this account?", "Delete Account", JOptionPane.WARNING_MESSAGE);

        switch (choice) {
            case 0: { // confirm
                try {
                    DBMethods.deleteAccount(customerList, indexOfCustomerLoggedIn);
                    DBMethods.deleteCustomer(customerList, indexOfCustomerLoggedIn);
                    this.dispose();
                    mf = new MainFrame();
                    mf.setVisible(true);
                    JOptionPane.showMessageDialog(mf, "Successfull delete");
                } catch (SQLException ex) {
                    Logger.getLogger(ServicesFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }

            case 2: { // cancel
                break;
            }
        }
    }//GEN-LAST:event_delBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        try {
            this.dispose();
            mf = new MainFrame();
            mf.setVisible(true);
            JOptionPane.showMessageDialog(mf, "Successfull Logout");
        } catch (SQLException ex) {
            Logger.getLogger(ServicesFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        setInfoPanel();
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void uploadImgBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadImgBtnActionPerformed
        int UserChoice = imgChooser.showOpenDialog(this);

        String dir = "";
        if (UserChoice == JFileChooser.APPROVE_OPTION) {
            File SelectedFile = imgChooser.getSelectedFile();
            dir = SelectedFile.getPath();
            resizeImage(dir);
            try {
                DBMethods.updateImg(customerList, indexOfCustomerLoggedIn, dir);
            } catch (SQLException ex) {
                Logger.getLogger(ServicesFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            loadImage(dir);
        }

        if (UserChoice == JFileChooser.CANCEL_OPTION) {
//            mediaPlayerPath.setText("No File Selected");
        }
    }//GEN-LAST:event_uploadImgBtnActionPerformed

    private void settingsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsBtnActionPerformed
        if (sf != null) {
            sf.dispose();
        }

        try {
            sf = new SettingsFrame(mf, this, df, cpf, fpf, customerList, indexOfCustomerLoggedIn);
        } catch (SQLException ex) {
            Logger.getLogger(ServicesFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        sf.setVisible(true);
    }//GEN-LAST:event_settingsBtnActionPerformed

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
                new ServicesFrame().setVisible(true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accIdIndicator;
    private javax.swing.JButton accInfoBtn;
    private javax.swing.JSeparator accInfoSeparator;
    private javax.swing.JLabel accountId;
    private javax.swing.JLabel accountInfoLabel;
    private javax.swing.JLabel age;
    private javax.swing.JLabel ageIndicator;
    private javax.swing.JLabel avatarLabel;
    private javax.swing.JPanel avatarPanel;
    private javax.swing.JSeparator avatarSeparator1;
    private javax.swing.JSeparator avatarSeparator2;
    private javax.swing.JLabel balance;
    private javax.swing.JLabel balanceIndicator;
    private javax.swing.JLabel customerInfoLabel;
    private javax.swing.JButton delBtn;
    private javax.swing.JSeparator delSeparator;
    private javax.swing.JButton depBtn;
    private javax.swing.JSeparator depSeparator;
    private javax.swing.JFileChooser imgChooser;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JSeparator infoSeparator;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JSeparator logoutSeparator;
    private javax.swing.JLabel mainMenuLabel;
    private javax.swing.JSeparator mainSeparator;
    private javax.swing.JSeparator menuSeparator;
    private javax.swing.JLabel name;
    private javax.swing.JLabel nameIndicator;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JPanel servicesPanel;
    private javax.swing.JButton settingsBtn;
    private javax.swing.JLabel surname;
    private javax.swing.JLabel surnameIndicator;
    private javax.swing.JButton uploadImgBtn;
    private javax.swing.JLabel username;
    private javax.swing.JLabel usernameIndicator;
    // End of variables declaration//GEN-END:variables
}
