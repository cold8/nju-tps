/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.geass.gui.searchGUI;

import Client.geass.gui.planGUI.DisplayPlanListPanel;
import Client.geass.gui.planGUI.DisplayPlanPanel;

import Shared.geass.dataPOJO.Plan;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author Kite
 */
public class searchFrame extends javax.swing.JFrame {

    /**
     * Creates new form searchFrame
     */
    public searchFrame() throws IOException {
        initComponents();
        innit();
        
    }
    
    public void innit() throws IOException{Date dd = new Date(); dd.setDate(4);dd.setMonth(10);dd.setYear(2013);
      // citySearchPanel = new CitySearchPanel();
      // planSearchPanel = new PlanSearchPanel();
     //   recommendPanel = new recommendJPanel();
      
       //userPlanPanel = new userPlanPanel();
       //this.setContentPane(planSearchPanel);
     //  this.setContentPane(citySearchPanel);
       // this.setContentPane(splitPanel);
     //this.setContentPane(userPlanPanel);
       //this.setContentPane(recommendPanel);
        this.validate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 881, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 573, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel("org.jb2011.lnf.beautyeye.BeautyEyeLookAndFeelCross");
            UIManager.put("RootPane.setupButtonVisible", false);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(searchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(searchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(searchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(searchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new searchFrame().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(searchFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    private userPlanPanel userPlanPanel;
    private DisplayPlanListPanel dispListPlanPanel;
    private DisplayPlanPanel displayPlanPanel;
    private recommendJPanel recommendPanel;
    private CitySearchPanel citySearchPanel;
    private PlanSearchPanel planSearchPanel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
