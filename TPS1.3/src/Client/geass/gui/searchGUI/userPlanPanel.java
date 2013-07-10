/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.geass.gui.searchGUI;



import Client.geass.gui.planGUI.DisplayPlanPanel;
import Client.geass.gui.planGUI.DisplaySearchedPlanPanel;
import Client.geass.gui.travellerGUI.TableModel;
import Server.geass.database.DBplan;
import Shared.geass.dataPOJO.Plan;
import Shared.geass.dataPOJO.User;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class userPlanPanel extends javax.swing.JPanel {

    /**
     * Creates new form userPlanPanel
     */
    public userPlanPanel() {
        initComponents();
       
        getPlanByuser(null);
      //  init();
        
        jSplitPane1.setRightComponent(new PlanSearchPanel(this)); 
       
        // System.out.println("初始位置"+j.getValue());
    }
 public userPlanPanel(User user){
     this.user=user ;
      initComponents();
            //  init();
      getPlanByuser(null);
       jSplitPane1.setRightComponent(new PlanSearchPanel(user,this)); 
 }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        PhaseButton1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setAutoscrolls(true);
        setOpaque(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(700, 600));

        jLabel1.setText("过去查看");

        jTable1.setModel(plantable);
        jTable1.setName("useplan");
        jScrollPane2.setViewportView(jTable1);

        PhaseButton1.setText("查看详细计划");
        PhaseButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhaseButton1ActionPerformed(evt);
            }
        });

        jButton1.setText("删除");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(142, 142, 142)
                .addComponent(PhaseButton1)
                .addGap(129, 129, 129))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PhaseButton1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        jScrollPane1.setViewportView(jSplitPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(153, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
//  弹出 查看详细 计划的窗口 的 按钮 ？！！！！！！出现了问题，不知道怎么做的，跳不出来了呢
    //===================================================================================
    private void PhaseButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhaseButton1ActionPerformed
        // TODO add your handling code here:
     
    }//GEN-LAST:event_PhaseButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int index =jTable1.getSelectedRow();
        if(index!=-1){
               planList.remove(index);
             if(planList==null){
                System.out.println("没有的行程"); 
                return ;}
            
                     
        } else JOptionPane.showMessageDialog(this, "请选中一行：）");
    this.plantable.setDataVector(TableModel.getInstance().planTableVector(planList), TableModel.PLAN_COLUMN_NAMES);
        
    }//GEN-LAST:event_jButton1ActionPerformed
// 利用 JScrollBar 做的 界面调转 到 目标 框 中
    public void display(){
       //  jSplitPane1.setDividerLocation(1.0);
        // jScrollPane1.scrollRectToVisible(null);
          JScrollBar j = jScrollPane1.getHorizontalScrollBar();
         j.setValue(0);
         jScrollPane1.setHorizontalScrollBar(j);
         
    }
    
    //  查询某一个用户的计划，刷新表格 可以添加 计划
public void getPlanByuser(Plan p){
    if(p!=null){
    planList.add(p);}
    if(planList==null){
        System.out.println("没有的行程"); 
        return ;
}
    this.plantable.setDataVector(TableModel.getInstance().planTableVector(planList), TableModel.PLAN_COLUMN_NAMES);
}
// 

    
    
  
    public void move( ){
    
         
  Toolkit kit = Toolkit.getDefaultToolkit();    
					Image img = kit.getImage("src//c.PNG"); 
					
					Cursor dynamiteCuror = kit.createCustomCursor(img, new Point(10,10),"dynamite stick") ;    
                                        setCursor(dynamiteCuror);
       
   
}
    public void enter(){
         Toolkit kit = Toolkit.getDefaultToolkit();    
					Image img = kit.getImage("src//7.jpg"); 
					
					Cursor dynamiteCuror = kit.createCustomCursor(img, new Point(10,10),"dynamite stick") ;    
                                        setCursor(dynamiteCuror);
       
    }
    public void release(){
         setCursor(null);
    }

DBplan dbplan = new DBplan();
    
private User  user ;
ArrayList<Plan>  planList = dbplan.getPlanByuser("g");
private DefaultTableModel plantable = new DefaultTableModel(null,TableModel.PLAN_COLUMN_NAMES);
private PlanSearchPanel  ps = new PlanSearchPanel(this);
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PhaseButton1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
