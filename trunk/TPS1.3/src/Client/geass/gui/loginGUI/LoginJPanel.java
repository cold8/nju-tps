package Client.geass.gui.loginGUI;

import Client.geass.gui.travellerGUI.TravellerFrame;
import Client.geass.gui.guiController.guiUserController.ClientUserControllerInterface;

import javax.swing.*;
import java.io.IOException;

/**
 *
 * @author Kite
 */
public class LoginJPanel extends javax.swing.JPanel {

    /**
     * Creates new form LoginJPanel
     */
    private LoginJFrame loginFrame = null;
    private Thread LoginThread;
    private ClientUserControllerInterface clientUserController;


    public LoginJPanel() {
        initComponents();
    }


    /**
     *
     * @param parent
     * @param clientUserController
     */
    public LoginJPanel(LoginJFrame parent, ClientUserControllerInterface clientUserController) {

        initComponents();
        loginFrame =  parent;
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
        passwordField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        loginButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        registerLabel = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("黑体", 1, 12)); // NOI18N
        jLabel1.setText("用户名：");

        jLabel2.setFont(new java.awt.Font("黑体", 1, 12)); // NOI18N
        jLabel2.setText("密码：");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                                        .addComponent(passwordField))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        loginButton.setFont(new java.awt.Font("黑体", 1, 12)); // NOI18N
        loginButton.setText("登录");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        registerLabel.setFont(new java.awt.Font("宋体", 2, 14)); // NOI18N
        registerLabel.setText("新用户注册请点击这里");
        registerLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(registerLabel))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(registerLabel)
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
    }// </editor-fold>

    private void registerLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerLabelMouseClicked
        // TODO add your handling code here:
        loginFrame.switchToRegister();       
    }//GEN-LAST:event_registerLabelMouseClicked

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
        startLogin();

    }//GEN-LAST:event_loginButtonActionPerformed

    private void startLogin() {
        LoginThread = new Thread(new Runnable() {
            @Override
            public void run() {
                login();
            }
        });

        if(!nameField.getText().equals("")&&!passwordField.getText().equals("")){
            loginFrame.switchToLoading();
            LoginThread.start();
        }
        else
        {
            if(nameField.getText().equals("")){
                JOptionPane.showMessageDialog(this,"请输入用户名");
            }else if(passwordField.getText().equals("")){
                JOptionPane.showMessageDialog(this,"请输入密码");
            }
        }
    }

    public void login() {
        try {
            int result  ;
            result = clientUserController.login(nameField.getText(), new String(passwordField.getText()));

            System.out.println(result);
            if(result == 2){
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new TravellerFrame(clientUserController).setVisible(true);
                    }
                });

                this.loginFrame.dispose();
            }else if(result == 1){
                loginFrame.switchToLogin();
                JOptionPane.showMessageDialog(this,"用户已登录");
                nameField.setText("");
                passwordField.setText("");
            }else if (result ==0){
                loginFrame.switchToLogin();
                JOptionPane.showMessageDialog(this,"密码错误");
                passwordField.setText("");
            }
        }catch (IOException e) {
            loginFrame.switchToLogin();
            JOptionPane.showMessageDialog(this,"网络错误");
            e.printStackTrace();
        }
    }






    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton loginButton;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField passwordField;
    private javax.swing.JLabel registerLabel;
    // End of variables declaration//GEN-END:variables
}
