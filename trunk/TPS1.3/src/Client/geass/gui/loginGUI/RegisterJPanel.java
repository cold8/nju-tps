/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.geass.gui.loginGUI;

import Client.geass.gui.guiController.ClientUserControllerInterface;

import javax.swing.*;
import java.io.IOException;

/**
 *
 * @author Kite
 */
public class RegisterJPanel extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;
    private LoginJFrame loginFrame = null;

    public RegisterJPanel() {
        initComponents();
    }

    public RegisterJPanel(LoginJFrame parent) {
        initComponents();
        loginFrame = parent;
    }

    public RegisterJPanel(LoginJFrame parent, ClientUserControllerInterface clientUserController) {
        initComponents();
        this.loginFrame = parent;
        this.clientUserController = clientUserController;
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        confirmField = new javax.swing.JPasswordField();
        passwordField = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        registerButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        backLabel = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("黑体", 1, 12)); // NOI18N
        jLabel1.setText("用户名：");

        jLabel2.setFont(new java.awt.Font("黑体", 1, 12)); // NOI18N
        jLabel2.setText("密码：");

        nameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameFieldFocusLost(evt);
            }
            public void focusGained(java.awt.event.FocusEvent evt) {
                nameFieldFocusGained(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("黑体", 1, 12)); // NOI18N
        jLabel3.setText("确认密码：");

        confirmField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                confirmFieldFocusLost(evt);
            }
        });

        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFieldFocusGained(evt);
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
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nameField)
                    .addComponent(confirmField)
                    .addComponent(passwordField))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        registerButton.setFont(new java.awt.Font("黑体", 1, 12)); // NOI18N
        registerButton.setText("注册");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(registerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registerButton, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        backLabel.setFont(new java.awt.Font("宋体", 2, 14)); // NOI18N
        backLabel.setText("返回登录请点击这里");
        backLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 154, Short.MAX_VALUE)
                .addComponent(backLabel))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        // TODO add your handling code here:

        if (!passwordField.getText().equals(confirmField.getText())) {
            confirmField.setText("");
            JOptionPane.showMessageDialog(this, "请确认密码一致");
            return;
        }

        if ((!nameField.getText().equals("")) && (!passwordField.getText().equals("") && (!confirmField.getText().equals("")))) {




            try {
                clientUserController.submitUserInfo(nameField.getText(), passwordField.getText());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "注册失败，请检查网络后重试", "网络异常", JOptionPane.INFORMATION_MESSAGE);
                e.printStackTrace();
            }
            JOptionPane.showMessageDialog(this, "注册成功");
            this.loginFrame.switchToLogin();

        } else {
            JOptionPane.showMessageDialog(this, "注册失败,请输入完整信息", "", JOptionPane.INFORMATION_MESSAGE);
        }

        //TravellerFrame travellerFrame = new TravellerFrame();
    }//GEN-LAST:event_registerButtonActionPerformed

    private void backLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backLabelMouseClicked
        // TODO add your handling code here:
        loginFrame.switchToLogin();
    }//GEN-LAST:event_backLabelMouseClicked

    private void nameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameFieldFocusLost
        // TODO add your handling code here:
        if (!nameField.getText().equals("")) {
            if (!clientUserController.userNameValid(nameField.getText())) {
                JOptionPane.showMessageDialog(this, "用户名已存在");
                nameField.requestFocus();
                nameValid = false;
            }
        } else {
            nameValid = true;
        }
    }//GEN-LAST:event_nameFieldFocusLost

    private void nameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameFieldFocusGained
        // TODO add your handling code here:
        if (!nameValid) {
            nameField.setText("");
        }
    }//GEN-LAST:event_nameFieldFocusGained

    private void confirmFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_confirmFieldFocusLost
        // TODO add your handling code here:
        if (!passwordField.getText().equals("")) {
            if (!passwordField.getText().equals(confirmField.getText())) {

                passwordField.setForeground(new java.awt.Color(255, 255, 0));
                confirmField.setText("");
                passwordValid = false;
            } else {
                passwordValid = true;
            }

        }



    }//GEN-LAST:event_confirmFieldFocusLost

    private void passwordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusGained
        // TODO add your handling code here:
        if (passwordField.getForeground().equals(new java.awt.Color(255, 255, 0))) {
            passwordField.setText("");
            passwordField.getForeground().equals(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_passwordFieldFocusGained
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backLabel;
    private javax.swing.JPasswordField confirmField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField nameField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton registerButton;
    // End of variables declaration//GEN-END:variables
    private ClientUserControllerInterface clientUserController;
    private boolean nameValid, passwordValid;
}
