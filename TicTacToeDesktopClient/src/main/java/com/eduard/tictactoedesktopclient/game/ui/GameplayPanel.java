/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduard.tictactoedesktopclient.game.ui;

import com.eduard.tictactoedesktopclient.game.GameController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Eduard
 */
public class GameplayPanel extends javax.swing.JPanel {

    /**
     * Creates new form GameplayPanel
     */
    public GameplayPanel() {
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

        userDataPanel = new javax.swing.JPanel();
        turnLabel = new javax.swing.JLabel();
        playersPanel = new javax.swing.JPanel();
        usernameLabel = new javax.swing.JLabel();
        versusLabel = new javax.swing.JLabel();
        tablePanel = new javax.swing.JPanel();
        square0 = new javax.swing.JButton();
        square1 = new javax.swing.JButton();
        square2 = new javax.swing.JButton();
        square3 = new javax.swing.JButton();
        square4 = new javax.swing.JButton();
        square5 = new javax.swing.JButton();
        square6 = new javax.swing.JButton();
        square7 = new javax.swing.JButton();
        sqare8 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout(0, 20));

        userDataPanel.setBackground(new java.awt.Color(245, 245, 245));
        userDataPanel.setLayout(new java.awt.GridLayout(1, 0));

        turnLabel.setBackground(new java.awt.Color(245, 245, 245));
        turnLabel.setFont(new java.awt.Font("Proxima Nova Alt Rg", 1, 18)); // NOI18N
        turnLabel.setForeground(new java.awt.Color(71, 71, 71));
        turnLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        turnLabel.setText("Turn: ");
        userDataPanel.add(turnLabel);
        turnLabel.getAccessibleContext().setAccessibleName("turnLabel");

        playersPanel.setBackground(new java.awt.Color(245, 245, 245));
        playersPanel.setLayout(new java.awt.GridLayout(2, 0));

        usernameLabel.setBackground(new java.awt.Color(255, 255, 255));
        usernameLabel.setFont(new java.awt.Font("Proxima Nova Alt Rg", 1, 18)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(71, 71, 71));
        usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameLabel.setText("Username:");
        playersPanel.add(usernameLabel);
        usernameLabel.getAccessibleContext().setAccessibleName("usernameLabel");

        versusLabel.setBackground(new java.awt.Color(255, 255, 255));
        versusLabel.setFont(new java.awt.Font("Proxima Nova Alt Rg", 1, 18)); // NOI18N
        versusLabel.setForeground(new java.awt.Color(71, 71, 71));
        versusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        versusLabel.setText("Versus:");
        playersPanel.add(versusLabel);
        versusLabel.getAccessibleContext().setAccessibleName("versusLabel");

        userDataPanel.add(playersPanel);

        add(userDataPanel, java.awt.BorderLayout.CENTER);

        tablePanel.setBackground(new java.awt.Color(255, 255, 255));
        tablePanel.setLayout(new java.awt.GridBagLayout());

        square0.setBackground(new java.awt.Color(255, 255, 255));
        square0.setMaximumSize(new java.awt.Dimension(80, 80));
        square0.setMinimumSize(new java.awt.Dimension(80, 80));
        square0.setPreferredSize(new java.awt.Dimension(100, 100));
        square0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square0ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        tablePanel.add(square0, gridBagConstraints);
        square0.getAccessibleContext().setAccessibleName("0");

        square1.setBackground(new java.awt.Color(255, 255, 255));
        square1.setPreferredSize(new java.awt.Dimension(100, 100));
        square1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square0ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        tablePanel.add(square1, gridBagConstraints);
        square1.getAccessibleContext().setAccessibleName("1");

        square2.setBackground(new java.awt.Color(255, 255, 255));
        square2.setPreferredSize(new java.awt.Dimension(100, 100));
        square2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square0ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        tablePanel.add(square2, gridBagConstraints);
        square2.getAccessibleContext().setAccessibleName("2");

        square3.setBackground(new java.awt.Color(255, 255, 255));
        square3.setPreferredSize(new java.awt.Dimension(100, 100));
        square3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square0ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        tablePanel.add(square3, gridBagConstraints);
        square3.getAccessibleContext().setAccessibleName("3");

        square4.setBackground(new java.awt.Color(255, 255, 255));
        square4.setPreferredSize(new java.awt.Dimension(100, 100));
        square4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square0ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        tablePanel.add(square4, gridBagConstraints);
        square4.getAccessibleContext().setAccessibleName("4");

        square5.setBackground(new java.awt.Color(255, 255, 255));
        square5.setPreferredSize(new java.awt.Dimension(100, 100));
        square5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square0ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        tablePanel.add(square5, gridBagConstraints);
        square5.getAccessibleContext().setAccessibleName("5");

        square6.setBackground(new java.awt.Color(255, 255, 255));
        square6.setPreferredSize(new java.awt.Dimension(100, 100));
        square6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square0ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        tablePanel.add(square6, gridBagConstraints);
        square6.getAccessibleContext().setAccessibleName("6");

        square7.setBackground(new java.awt.Color(255, 255, 255));
        square7.setPreferredSize(new java.awt.Dimension(100, 100));
        square7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square0ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        tablePanel.add(square7, gridBagConstraints);
        square7.getAccessibleContext().setAccessibleName("7");

        sqare8.setBackground(new java.awt.Color(255, 255, 255));
        sqare8.setPreferredSize(new java.awt.Dimension(100, 100));
        sqare8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square0ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        tablePanel.add(sqare8, gridBagConstraints);
        sqare8.getAccessibleContext().setAccessibleName("8");

        add(tablePanel, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void square0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square0ActionPerformed
        // TODO add your handling code here:
        JButton source = (JButton) evt.getSource();
        Integer squareNr = Integer.parseInt(source.getAccessibleContext().getAccessibleName());
        GameController gameInstance = GameController.getInstance();
        
        if(gameInstance.getButtonsMap()[squareNr / 3][squareNr % 3] == -1 && gameInstance.isPlayerTurn()) {
            source.setIcon(gameInstance.getMyIcon());
            try {
                gameInstance.sendMessageToServer("MOVE|" + gameInstance.getOpponentUsername()+ "|" + squareNr);
            } catch (IOException ex) {
                Logger.getLogger(GameplayPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            gameInstance.setPlayerTurn(false);
            gameInstance.update(squareNr, 1);
        }
    }//GEN-LAST:event_square0ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel playersPanel;
    private javax.swing.JButton sqare8;
    private javax.swing.JButton square0;
    private javax.swing.JButton square1;
    private javax.swing.JButton square2;
    private javax.swing.JButton square3;
    private javax.swing.JButton square4;
    private javax.swing.JButton square5;
    private javax.swing.JButton square6;
    private javax.swing.JButton square7;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JLabel turnLabel;
    private javax.swing.JPanel userDataPanel;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel versusLabel;
    // End of variables declaration//GEN-END:variables
}
