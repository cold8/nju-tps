/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.geass.gui.travellerGUI;

import Client.geass.gui.StatusGUI.StatusFrame;
import Client.geass.gui.guiController.ClientUserControllerInterface;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author tin
 */
public class WelcomePanel extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;
    /**
     * Creates new form WelcomePanel
     */
    public WelcomePanel() {
        initComponents();
    }

    public WelcomePanel(TravellerFrame parent, ClientUserControllerInterface clientUserController) {
        initComponents();
        this.parent = parent;
        this.clientUserController = clientUserController;
        initial();

    }

    private void initial() {
        this.username = clientUserController.getUserName();
        this.parent.setTitle("尊敬的 " + username + " ,欢迎您登录旅行者系统");
        this.nameLabel.setText(username);
        this.timeLabel.setText(new Date().toString());
        setUserInfo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        plnaButton = new javax.swing.JButton();
        newStatusButton = new javax.swing.JButton();
        lookPlanButton = new javax.swing.JButton();
        oldStatusButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        jSplitPane1.setDividerLocation(120);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setEnabled(false);

        jLabel1.setText("尊敬的 ：");

        jLabel2.setText("日期 ：");

        plnaButton.setText("新建一份旅行计划");
        plnaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plnaButtonActionPerformed(evt);
            }
        });

        newStatusButton.setText("发布新的旅行见闻");
        newStatusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newStatusButtonActionPerformed(evt);
            }
        });

        lookPlanButton.setText("查看您的过往计划");
        lookPlanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lookPlanButtonActionPerformed(evt);
            }
        });

        oldStatusButton.setText("发布过往计划的见闻");
        oldStatusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldStatusButtonActionPerformed(evt);
            }
        });

        exitButton.setText("退出旅行者系统");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        jButton5.setText("查看您和他人的旅行见闻");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(timeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                .addGap(96, 96, 96)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(newStatusButton)
                        .addGap(18, 18, 18)
                        .addComponent(oldStatusButton)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(plnaButton)
                        .addGap(18, 18, 18)
                        .addComponent(lookPlanButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(exitButton)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(timeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(plnaButton)
                        .addComponent(lookPlanButton)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 25, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(newStatusButton)
                            .addComponent(oldStatusButton)
                            .addComponent(jButton5))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(exitButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jSplitPane1.setTopComponent(jPanel1);

        jSplitPane2.setDividerLocation(300);
        jSplitPane2.setEnabled(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("您的近期见闻"));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 287, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );

        jSplitPane2.setLeftComponent(jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("系统推荐"));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );

        jSplitPane2.setRightComponent(jPanel3);

        jSplitPane1.setRightComponent(jSplitPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void plnaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plnaButtonActionPerformed
        // TODO add your handling code here:
        this.parent.CreateNewPlan();
    }//GEN-LAST:event_plnaButtonActionPerformed

    private void lookPlanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lookPlanButtonActionPerformed
        // TODO add your handling code here:
        try {
            this.parent.displayPlanList(parent);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }//GEN-LAST:event_lookPlanButtonActionPerformed

    private void newStatusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newStatusButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newStatusButtonActionPerformed

    private void oldStatusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldStatusButtonActionPerformed
        // TODO add your handling code here:
        new StatusFrame().setVisible(true);
    }//GEN-LAST:event_oldStatusButtonActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
        this.parent.dispose();
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    public void setUserInfo() {
        //.....setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/......")));
        //clientUserController.getUserInfo(username);
        nameLabel.setText(username + "  :)");

    }
    private ClientUserControllerInterface clientUserController;
    private TravellerFrame parent;
    private String username;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JButton lookPlanButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton newStatusButton;
    private javax.swing.JButton oldStatusButton;
    private javax.swing.JButton plnaButton;
    private javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables
}
