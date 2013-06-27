package Client.geass.gui.planGUI;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import org.jdesktop.swingx.JXDatePicker;

import Client.geass.clientController.planController.GuiCreatePlanController;
import Client.geass.gui.travellerGUI.TravellerFrame;
import Shared.geass.dataPOJO.Plan;

/**
 *
 * @author Kaya Wai
 */
public class CreatePlanPanel extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;
	
	public CreatePlanPanel() {
        initComponents();
    }
	
	public CreatePlanPanel(TravellerFrame parent,String username){
		this.parent = parent;
		this.username = username;
		initComponents();
	}
	
	
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        titlefield = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        endtimePicker = new JXDatePicker();
        jLabel5 = new javax.swing.JLabel();
        createButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        beginTimePicker = new JXDatePicker();

        setPreferredSize(new java.awt.Dimension(850, 1000));

        jPanel2.setPreferredSize(new java.awt.Dimension(780, 170));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/geass/gui/picture/4.png"))); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(150, 150));
        jPanel2.add(jLabel2);

        jLabel4.setFont(new java.awt.Font("长城特粗黑体", 1, 30)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("从创建行程计划开始一段奇妙旅程吧！");
        jPanel2.add(jLabel4);

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 400));

        jLabel1.setFont(new java.awt.Font("微软雅黑", 1, 24)); // NOI18N
        jLabel1.setText("计划标题");

        titlefield.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        titlefield.setForeground(new java.awt.Color(153, 153, 153));
        titlefield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        titlefield.setText("请输入计划标题");
        titlefield.setPreferredSize(new java.awt.Dimension(200, 40));
        titlefield.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                titlefieldFocusGained(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("微软雅黑", 1, 24)); // NOI18N
        jLabel3.setText("结束日期");

        beginTimePicker.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        beginTimePicker.setForeground(new java.awt.Color(153, 153, 153));
        endtimePicker.setPreferredSize(new java.awt.Dimension(200, 40));
        endtimePicker.setFormats(new SimpleDateFormat("yyyy-MM-dd EE"));

        jLabel5.setFont(new java.awt.Font("微软雅黑", 1, 24)); // NOI18N
        jLabel5.setText("开始日期");

        createButton.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        createButton.setText("确认");
        createButton.setPreferredSize(new java.awt.Dimension(80, 30));
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					createButtonActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });

        cancelButton.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        cancelButton.setText("取消");
        cancelButton.setBorderPainted(false);
        cancelButton.setPreferredSize(new java.awt.Dimension(80, 30));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        beginTimePicker.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        beginTimePicker.setForeground(new java.awt.Color(153, 153, 153));
        //beginTimePicker.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        beginTimePicker.setPreferredSize(new java.awt.Dimension(200, 40));
        beginTimePicker.setFormats(new SimpleDateFormat("yyyy-MM-dd EE"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(beginTimePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(titlefield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(createButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(40, 40, 40)
                                .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(endtimePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titlefield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(beginTimePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endtimePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(359, Short.MAX_VALUE))
        );
    }                                                                

    private void titlefieldFocusGained(java.awt.event.FocusEvent evt) {                                       
        if(titlefield.getText().equals("请输入计划标题"))
            titlefield.setText(null);
    }                                      

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {                                             
       Plan plan = null;
    	
    	if(titlefield.getText().isEmpty()|beginTimePicker.getDate()==null|endtimePicker.getDate()==null)
    		JOptionPane.showMessageDialog(this, "请确认已经填写了所有内容","填写错误",JOptionPane.INFORMATION_MESSAGE);
    	else if(beginTimePicker.getDate().compareTo(endtimePicker.getDate())>0)
    		JOptionPane.showMessageDialog(this, "请确认正确选择了起始和结束日期","日期错误",JOptionPane.INFORMATION_MESSAGE);
    	else{
    		plan= GuiCreatePlanController.createPlan(username, titlefield.getText(), beginTimePicker.getDate(), endtimePicker.getDate());
    		if(plan==null) 
    			JOptionPane.showMessageDialog(this, "建立计划失败，已存在标题相同的计划","建立计划失败",JOptionPane.INFORMATION_MESSAGE);
    		else{
    			this.parent.setNewPanel(parent,plan);
    			
    		}
    	}
    }                                            
    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        	titlefield.setText("");
		titlefield.repaint();
		
		beginTimePicker.getEditor().setText("");
		beginTimePicker.setDate(null);
		beginTimePicker.repaint();
	
		endtimePicker.getEditor().setText("");
		endtimePicker.setDate(null);
		endtimePicker.repaint();
    }                                            

    // Variables declaration - do not modify                     
    private JXDatePicker beginTimePicker;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton createButton;
    private JXDatePicker endtimePicker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField titlefield;
    // End of variables declaration  
    private String username;
    private TravellerFrame parent;
}
