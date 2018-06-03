/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduard.tictactoedesktopclient.game.ui;

import com.eduard.tictactoedesktopclient.game.GameController;
import java.awt.CardLayout;
import java.awt.Component;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.websocket.DeploymentException;

/**
 *
 * @author Eduard
 */
public class MenuPanel extends javax.swing.JPanel {

    /**
     * Creates new form MenuPanel
     */
    public MenuPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        titlePanel = new javax.swing.JPanel();
        gameTitleLabel = new javax.swing.JLabel();
        contentMenuPanel = new javax.swing.JPanel();
        playButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        userDataPanel = new javax.swing.JPanel();
        messageLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));

        titlePanel.setBackground(new java.awt.Color(245, 245, 245));
        titlePanel.setLayout(new java.awt.GridLayout(1, 0));

        gameTitleLabel.setFont(new java.awt.Font("Proxima Nova Lt", 1, 36)); // NOI18N
        gameTitleLabel.setForeground(new java.awt.Color(71, 71, 71));
        gameTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gameTitleLabel.setText("Super TicTacToe");
        titlePanel.add(gameTitleLabel);

        add(titlePanel);

        contentMenuPanel.setBackground(new java.awt.Color(245, 245, 245));
        contentMenuPanel.setLayout(new java.awt.GridBagLayout());

        playButton.setBackground(new java.awt.Color(255, 255, 255));
        playButton.setFont(new java.awt.Font("Proxima Nova Alt Cn Lt", 1, 14)); // NOI18N
        playButton.setText("Play");
        playButton.setPreferredSize(new java.awt.Dimension(100, 30));
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(23, 0, 0, 0);
        contentMenuPanel.add(playButton, gridBagConstraints);

        loginButton.setBackground(new java.awt.Color(255, 255, 255));
        loginButton.setFont(new java.awt.Font("Proxima Nova Alt Cn Lt", 1, 14)); // NOI18N
        loginButton.setText("Login");
        loginButton.setPreferredSize(new java.awt.Dimension(100, 30));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(23, 0, 0, 0);
        contentMenuPanel.add(loginButton, gridBagConstraints);

        registerButton.setBackground(new java.awt.Color(255, 255, 255));
        registerButton.setFont(new java.awt.Font("Proxima Nova Alt Cn Lt", 1, 14)); // NOI18N
        registerButton.setText("Register");
        registerButton.setPreferredSize(new java.awt.Dimension(100, 30));
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(23, 0, 0, 0);
        contentMenuPanel.add(registerButton, gridBagConstraints);

        logoutButton.setBackground(new java.awt.Color(255, 255, 255));
        logoutButton.setFont(new java.awt.Font("Proxima Nova Alt Cn Lt", 1, 14)); // NOI18N
        logoutButton.setText("Logout");
        logoutButton.setPreferredSize(new java.awt.Dimension(100, 30));
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(23, 0, 0, 0);
        contentMenuPanel.add(logoutButton, gridBagConstraints);

        add(contentMenuPanel);
        contentMenuPanel.getAccessibleContext().setAccessibleName("contentMenuPanel");

        userDataPanel.setBackground(new java.awt.Color(245, 245, 245));
        userDataPanel.setLayout(new java.awt.GridLayout(2, 0));

        messageLabel.setFont(new java.awt.Font("Proxima Nova Alt Cn Lt", 1, 12)); // NOI18N
        messageLabel.setForeground(new java.awt.Color(255, 0, 0));
        messageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userDataPanel.add(messageLabel);
        messageLabel.getAccessibleContext().setAccessibleName("messageLabel");

        usernameLabel.setFont(new java.awt.Font("Proxima Nova Alt Cn Lt", 1, 12)); // NOI18N
        usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameLabel.setText("User: Not logged in");
        usernameLabel.setMinimumSize(new java.awt.Dimension(106, 50));
        usernameLabel.setPreferredSize(new java.awt.Dimension(106, 50));
        userDataPanel.add(usernameLabel);
        usernameLabel.getAccessibleContext().setAccessibleName("usernameLabel");

        add(userDataPanel);
        userDataPanel.getAccessibleContext().setAccessibleName("userDataPanel");
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        GameController game = GameController.getInstance();
        if(!game.userIsLogged()){
            game.switchToCard("loginCard");
        } else {
            GameController.setLabel("messageLabel", "You are already logged in", game.getRootContainer());
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        // TODO add your handling code here:
        GameController gameController = GameController.getInstance();
        if(gameController.userIsLogged()) {
            
            try {
                gameController.connectSocketToServer();
            } catch (URISyntaxException | DeploymentException | IOException ex) {
                Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            gameController.switchToCard("loadingCard");
        } else {
            GameController.setLabel("messageLabel", "You need to log in before you play", GameController.getInstance().getRootContainer());
        }
    }//GEN-LAST:event_playButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
        GameController gameInstance = GameController.getInstance();
        gameInstance.logUserOut();
        GameController.setLabel("usernameLabel", "Not logged in", this);
       
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        // TODO add your handling code here:
        JPanel parentPanel = (JPanel) this.getParent();
        CardLayout cl = (CardLayout) parentPanel.getLayout();
        cl.show(parentPanel, "registerCard");
    }//GEN-LAST:event_registerButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentMenuPanel;
    private javax.swing.JLabel gameTitleLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginButton;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JButton playButton;
    private javax.swing.JButton registerButton;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JPanel userDataPanel;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}