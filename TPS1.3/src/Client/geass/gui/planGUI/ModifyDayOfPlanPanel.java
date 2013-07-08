package Client.geass.gui.planGUI;

import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import net.sourceforge.jtimepiece.JTimepiece;
import Client.geass.clientController.planController.GuiCreatePlanController;
import Client.geass.clientController.planController.GuiModifyPlanController;
import Client.geass.gui.travellerGUI.TravellerFrame;
import Shared.geass.dataPOJO.Plan;

/**
 *
 * @author Kaya Wai
 */
public class ModifyDayOfPlanPanel extends javax.swing.JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Plan plan;
    private int planid;
    private String datestr;
    private TravellerFrame parent;
    private String selectedCountryname;
    private TableColumn cityColumn;
    private boolean isTableChanged = false;
    private TableColumn checkColumn;
    //private MapFrame mf = new MapFrame();
    private JLabel mapPicture;

    public ModifyDayOfPlanPanel(TravellerFrame parent, int planid, String datestr) throws IOException {
        this.planid = planid;
        this.datestr = datestr;
        this.parent = parent;
        plan = GuiModifyPlanController.getPlan(planid);
        //mf.show("北京");
        initComponents();
    }

    public ModifyDayOfPlanPanel(TravellerFrame parent, Plan plan, String datestr) {
        this.plan = plan;
        this.datestr = datestr;
        this.planid = plan.getPlanid();
        this.parent = parent;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        titlePlan = new javax.swing.JPanel();
        titleLb = new javax.swing.JLabel();
        headerPanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        todayDate = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        mapPanel = new javax.swing.JPanel();
        mapPicture = new JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        addPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        addContentPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        starthourField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        startminuteField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        endhourField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        endminuteField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        siteField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        transportField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        breakfastField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        lunchField = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        dinnerField = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        commentScrollPane = new javax.swing.JScrollPane();
        commentField = new javax.swing.JTextArea();
        addButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        countrySelector = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        citySelector = new javax.swing.JComboBox();
        tablePanel = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jumpDate = new javax.swing.JComboBox();
        jumpButton = new javax.swing.JButton();
        tableScrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();

        setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        setPreferredSize(new java.awt.Dimension(850, 1000));

        titlePlan.setPreferredSize(new java.awt.Dimension(0, 40));

        titleLb.setFont(new java.awt.Font("长城特粗黑体", 0, 24)); // NOI18N
        titleLb.setText("修改当日计划");
        titlePlan.add(titleLb);

        headerPanel.setFont(new java.awt.Font("华文细黑", 0, 14)); // NOI18N
        headerPanel.setPreferredSize(new java.awt.Dimension(0, 40));
        headerPanel.setLayout(new java.awt.GridLayout(1, 0));

        jLabel10.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        jLabel10.setText("当日日期  ");
        jPanel5.add(jLabel10);

        todayDate.setText(datestr);
        jPanel5.add(todayDate);

        headerPanel.add(jPanel5);

        jPanel1.setPreferredSize(new java.awt.Dimension(260, 60));

        jLabel1.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        jLabel1.setText("计划标题  ");
        jPanel1.add(jLabel1);

        jLabel2.setText(plan.getPlantitle());
        jPanel1.add(jLabel2);

        headerPanel.add(jPanel1);

        jPanel2.setPreferredSize(new java.awt.Dimension(260, 60));

        jLabel3.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        jLabel3.setText("开始日期  ");
        jPanel2.add(jLabel3);

        JTimepiece t = new JTimepiece();
        jLabel4.setText(t.convertDateToString(plan.getStartdate(), "yyyy'年'MM'月'dd'日'"));
        jPanel2.add(jLabel4);

        headerPanel.add(jPanel2);

        jPanel3.setPreferredSize(new java.awt.Dimension(260, 60));

        jLabel5.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        jLabel5.setText("结束日期  ");
        jPanel3.add(jLabel5);

        jLabel6.setText(t.convertDateToString(plan.getEnddate(), "yyyy'年'MM'月'dd'日'"));
        jPanel3.add(jLabel6);

        headerPanel.add(jPanel3);

        mapPanel.setPreferredSize(new java.awt.Dimension(400, 400));
        mapPanel.setLayout(new javax.swing.BoxLayout(mapPanel, javax.swing.BoxLayout.Y_AXIS));

        jPanel9.setPreferredSize(new java.awt.Dimension(400, 30));
        jPanel9.setRequestFocusEnabled(false);

        jLabel11.setFont(new java.awt.Font("长城特粗黑体", 0, 18)); // NOI18N
        jLabel11.setText("查看地图");
        jPanel9.add(jLabel11);

        mapPanel.add(jPanel9);

        jPanel10.setPreferredSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 463, Short.MAX_VALUE));
        jPanel10Layout.setVerticalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 405, Short.MAX_VALUE));

        mapPanel.add(jPanel10);

        addPanel.setPreferredSize(new java.awt.Dimension(361, 381));
        addPanel.setLayout(new javax.swing.BoxLayout(addPanel, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel4.setPreferredSize(new java.awt.Dimension(300, 30));

        jLabel7.setFont(new java.awt.Font("长城特粗黑体", 0, 18)); // NOI18N
        jLabel7.setText("添加时间段");
        jPanel4.add(jLabel7);

        addPanel.add(jPanel4);

        addContentPanel.setRequestFocusEnabled(false);

        jLabel8.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        jLabel8.setText("时间");

        starthourField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        starthourField.setPreferredSize(new java.awt.Dimension(50, 30));

        jLabel9.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        jLabel9.setText("国家");

        jLabel12.setText(":");

        startminuteField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        startminuteField.setPreferredSize(new java.awt.Dimension(50, 30));

        jLabel13.setText("至");

        endhourField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        endhourField.setPreferredSize(new java.awt.Dimension(50, 30));

        jLabel14.setText(":");

        endminuteField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        endminuteField.setPreferredSize(new java.awt.Dimension(50, 30));

        jLabel15.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        jLabel15.setText("景点");

        siteField.setPreferredSize(new java.awt.Dimension(306, 30));
        siteField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siteFieldActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        jLabel16.setText("早餐");

        transportField.setPreferredSize(new java.awt.Dimension(306, 30));

        jLabel17.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        jLabel17.setText("交通");

        breakfastField.setPreferredSize(new java.awt.Dimension(70, 30));

        jLabel18.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        jLabel18.setText("午餐");

        lunchField.setPreferredSize(new java.awt.Dimension(70, 30));

        jLabel19.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        jLabel19.setText("晚餐");

        dinnerField.setPreferredSize(new java.awt.Dimension(70, 30));
        dinnerField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dinnerFieldActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        jLabel20.setText("备注");

        commentScrollPane.setAutoscrolls(true);

        commentField.setColumns(20);
        commentField.setFont(new java.awt.Font("宋体", 0, 12)); // NOI18N
        commentField.setLineWrap(true);
        commentField.setRows(5);
        commentScrollPane.setViewportView(commentField);
        tableScrollPane.setViewportView(commentField);
        tableScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        tableScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        addButton.setText("添加");
        addButton.setPreferredSize(new java.awt.Dimension(57, 28));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        resetButton.setText("清空");
        resetButton.setPreferredSize(new java.awt.Dimension(57, 28));
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        try {
            countrySelector.setModel(new javax.swing.DefaultComboBoxModel(GuiCreatePlanController.getCountryList()));
        } catch (Exception e) {
        }
        countrySelector.setPreferredSize(new java.awt.Dimension(160, 30));
        countrySelector.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                selectedCountryname = (String) e.getItem();
                try {
                    citySelector.setModel(new DefaultComboBoxModel(GuiCreatePlanController.getCityList(selectedCountryname)));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                citySelector.repaint();
            }
        });

        mapPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/geass/gui/picture/map.jpg")));
        mapPicture.setMaximumSize(new java.awt.Dimension(400, 400));
        mapPicture.setMinimumSize(new java.awt.Dimension(400, 400));
        mapPicture.setPreferredSize(new java.awt.Dimension(400, 400));

        mapPanel.add(mapPicture);

        jLabel23.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        jLabel23.setText("城市");

        try {
            citySelector.setModel(new javax.swing.DefaultComboBoxModel(GuiCreatePlanController.getCityList("中国")));
        } catch (Exception e) {
        }
        citySelector.setPreferredSize(new java.awt.Dimension(160, 30));

        javax.swing.GroupLayout addContentPanelLayout = new javax.swing.GroupLayout(addContentPanel);
        addContentPanel.setLayout(addContentPanelLayout);
        addContentPanelLayout.setHorizontalGroup(
                addContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(addContentPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
                .addGroup(addContentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addContentPanelLayout.createSequentialGroup()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(commentScrollPane))
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addContentPanelLayout.createSequentialGroup()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(breakfastField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lunchField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dinnerField, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addContentPanelLayout.createSequentialGroup()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(transportField, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addContentPanelLayout.createSequentialGroup()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(siteField, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addContentPanelLayout.createSequentialGroup()
                .addGroup(addContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(addContentPanelLayout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(countrySelector, 0, 1, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addContentPanelLayout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(starthourField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(startminuteField, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(addContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(addContentPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel13)
                .addGap(20, 20, 20)
                .addComponent(endhourField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(endminuteField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(addContentPanelLayout.createSequentialGroup()
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23)
                .addGap(12, 12, 12)
                .addComponent(citySelector, 0, 1, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        addContentPanelLayout.setVerticalGroup(
                addContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(addContentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(starthourField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(addContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(startminuteField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(endhourField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel13)
                .addComponent(endminuteField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel14)
                .addComponent(jLabel8)
                .addComponent(jLabel12)))
                .addGap(18, 18, 18)
                .addGroup(addContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel9)
                .addComponent(countrySelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel23)
                .addComponent(citySelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(siteField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(addContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(transportField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(addContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(breakfastField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lunchField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(dinnerField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel18)
                .addComponent(jLabel19)
                .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(addContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(addContentPanelLayout.createSequentialGroup()
                .addComponent(commentScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jLabel20))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        addPanel.add(addContentPanel);

        tablePanel.setLayout(new javax.swing.BoxLayout(tablePanel, javax.swing.BoxLayout.Y_AXIS));

        jPanel13.setMinimumSize(new java.awt.Dimension(134, 35));
        jPanel13.setPreferredSize(new java.awt.Dimension(823, 40));

        try {
            jumpDate.setModel(new DefaultComboBoxModel(GuiModifyPlanController.getDaySelector(plan.getStartdate(), plan.getEnddate())));
        } catch (Exception e) {
        }
        jumpDate.setName(""); // NOI18N
        jumpDate.setPreferredSize(new java.awt.Dimension(160, 30));
        jPanel13.add(jumpDate);

        jumpButton.setText("转到");
        jumpButton.setPreferredSize(new java.awt.Dimension(57, 28));
        jumpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumpButtonActionPerformed(evt);
            }
        });
        jPanel13.add(jumpButton);

        tablePanel.add(jPanel13);

        tableScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        tableScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        try {
            table.setModel(GuiModifyPlanController.getUpdatedDayModel(plan.getPlanid(), datestr));
        } catch (Exception e) {
            e.printStackTrace();
        }
        table.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                isTableChanged = true;
            }
        });
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cityColumn = table.getColumnModel().getColumn(2);
        cityColumn.setCellEditor(new DefaultCellEditor(citySelector));
        checkColumn = table.getColumnModel().getColumn(9);
        checkColumn.setCellEditor(new DefaultCellEditor(new JCheckBox()));
        tableScrollPane.setViewportView(table);

        tablePanel.add(tableScrollPane);

        jPanel11.setPreferredSize(new java.awt.Dimension(823, 50));
        java.awt.GridBagLayout jPanel11Layout = new java.awt.GridBagLayout();
        jPanel11Layout.columnWidths = new int[]{0, 30, 0, 30, 0};
        jPanel11Layout.rowHeights = new int[]{0};
        jPanel11.setLayout(jPanel11Layout);

        backButton.setText("返回计划");
        backButton.setPreferredSize(new java.awt.Dimension(80, 30));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    backButtonActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        jPanel11.add(backButton, gridBagConstraints);

        submitButton.setText("保存修改");
        submitButton.setPreferredSize(new java.awt.Dimension(80, 30));
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    submitButtonActionPerformed(evt);
                } catch (HeadlessException | IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel11.add(submitButton, gridBagConstraints);

        clearButton.setText("清空本日");
        clearButton.setPreferredSize(new java.awt.Dimension(80, 30));
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    clearButtonActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jPanel11.add(clearButton, gridBagConstraints);

        tablePanel.add(jPanel11);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
                .addComponent(headerPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titlePlan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                .addComponent(addPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mapPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)))
                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlePlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(mapPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                .addContainerGap()));
    }// </editor-fold>                        

    private void jumpButtonActionPerformed(java.awt.event.ActionEvent evt) {

        //REMEMBER TO RESET THE DATESTR!!
        datestr = (String) jumpDate.getSelectedItem();
        try {
            table.setModel(GuiModifyPlanController.getUpdatedDayModel(planid, datestr));
            table.repaint();
        } catch (Exception e) {
        }
        todayDate.setText(datestr);
        todayDate.repaint();
    }

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) throws HeadlessException, IOException, ClassNotFoundException {

        TableModel tableModel = table.getModel();

        if (table.isEditing()) {
            JOptionPane.showMessageDialog(this, "表格正在修改中，请确定表格修改已完成", "表格正在修改", JOptionPane.PLAIN_MESSAGE);
        } else {
            if (isTableChanged) {

                if (GuiModifyPlanController.validTableTime(tableModel)) {

                    if (GuiModifyPlanController.modifyDayOfPlan(planid, datestr, tableModel) == true) {

                        int opt = 0;//YES:0, NO:1
                        opt = JOptionPane.showOptionDialog(this, "计划修改成功！是否返回原界面？若否，则跳转至整体计划内容", "修改成功", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                        if (opt == 0) {
                        } else {
                            //-------------这段是界面跳转代码-----------
                            this.parent.modifyPlan(parent, plan.getPlanid());
                            //---------------------------------------
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "计划修改失败，请检查是否存在重复的时间段", "修改失败", JOptionPane.PLAIN_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "计划修改失败，请检查是否存在格式错误的开始或结束时间", "修改失败", JOptionPane.PLAIN_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "请先修改计划内容", "计划未修改", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        if (GuiModifyPlanController.clearDay(plan.getPlanid(), datestr)) {
            JOptionPane.showMessageDialog(this, "清空本日计划内容成功！", "清空成功", JOptionPane.PLAIN_MESSAGE);
            table.setModel(GuiModifyPlanController.getUpdatedDayModel(planid, datestr));
            table.repaint();
        } else {
            JOptionPane.showMessageDialog(this, "清空本日计划内容失败", "清空失败", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        //-------------这段是界面跳转代码-----------
        this.parent.modifyPlan(parent, planid);
        //---------------------------------------
    }

    private void siteFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void dinnerFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
        //String date = (String)dateSelector.getSelectedItem();
        String beginH = starthourField.getText();//NOT NULL
        String beginM = startminuteField.getText();//NOT NULL
        String endH = endhourField.getText();//NOT NULL
        String endM = endminuteField.getText();//NOT NULL
        String citi = (String) citySelector.getSelectedItem();//NOT NULL
        String spoty = siteField.getText();
        String trans = transportField.getText();
        String brkfst = breakfastField.getText();
        String lun = lunchField.getText();
        String dinn = dinnerField.getText();
        String comm = commentField.getText();

        if (beginH.isEmpty() || beginM.isEmpty() || endH.isEmpty() || endM.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请填写开始时间和结束时间", "请填写时间", JOptionPane.WARNING_MESSAGE);
        } else {
            if (GuiCreatePlanController.validTime(beginH, beginM, endH, endM) <= 0) {
                switch (GuiCreatePlanController.validTime(beginH, beginM, endH, endM)) {
                    case 0:
                        JOptionPane.showMessageDialog(this, "结束时间请不要小于开始时间", "时间错误", JOptionPane.WARNING_MESSAGE);
                        break;
                    case -1:
                        JOptionPane.showMessageDialog(this, "结束时间不符合格式", "时间错误", JOptionPane.WARNING_MESSAGE);
                        break;
                    case -2:
                        JOptionPane.showMessageDialog(this, "开始时间不符合格式", "时间错误", JOptionPane.WARNING_MESSAGE);
                        break;
                    case -3:
                        JOptionPane.showMessageDialog(this, "0<=小时<=23,0<=分钟<=59", "时间错误", JOptionPane.WARNING_MESSAGE);
                        break;
                    case -100:
                        JOptionPane.showMessageDialog(this, "时间请输入数字", "时间错误", JOptionPane.WARNING_MESSAGE);
                        break;
                    default:
                        break;
                }
            } else {
                try {
                    if (GuiCreatePlanController.insertPhase(plan.getPlanid(), datestr, beginH, beginM, endH, endM, citi, spoty, trans, brkfst, lun, dinn, comm)) {
                        JOptionPane.showMessageDialog(this, "成功设置" + datestr + " " + beginH + ":" + beginM + "至" + endH + ":" + endM + "的行程！", "行程设置成功", JOptionPane.PLAIN_MESSAGE);
                        DefaultTableModel model = GuiCreatePlanController.getUpdatedDayModel(plan.getPlanid(), datestr);
                        table.setModel(model);
                        table.repaint();

                        /*mf.repaint();
                         mf.show(citi);
                         */                    } else {
                        JOptionPane.showMessageDialog(this, "" + datestr + " " + beginH + ":" + beginM + "至" + endH + ":" + endM + "的行程已经存在", "行程设置失败", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(SetPlanPanel.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {
        //dateSelector.setSelectedIndex(0);
        //dateSelector.repaint();

        starthourField.setText(null);
        starthourField.repaint();

        startminuteField.setText(null);
        startminuteField.repaint();

        endhourField.setText(null);
        endhourField.repaint();

        endminuteField.setText(null);
        endminuteField.repaint();

        countrySelector.setSelectedItem("中国");
        countrySelector.repaint();
        try {
            citySelector.setModel(new javax.swing.DefaultComboBoxModel(GuiCreatePlanController.getCityList("中国")));
        } catch (IOException ex) {
            Logger.getLogger(SetPlanPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        citySelector.repaint();

        transportField.setText(null);
        transportField.repaint();

        siteField.setText(null);
        siteField.repaint();

        breakfastField.setText(null);
        breakfastField.repaint();

        lunchField.setText(null);
        lunchField.repaint();

        dinnerField.setText(null);
        dinnerField.repaint();

        commentField.setText(null);
        commentField.repaint();
    }
    // Variables declaration - do not modify                     
    private javax.swing.JButton addButton;
    private javax.swing.JPanel addContentPanel;
    private javax.swing.JPanel addPanel;
    private javax.swing.JPanel addPanel1;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField breakfastField;
    private javax.swing.JComboBox citySelector;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextArea commentField;
    private javax.swing.JScrollPane commentScrollPane;
    private javax.swing.JComboBox countrySelector;
    private javax.swing.JTextField dinnerField;
    private javax.swing.JTextField endhourField;
    private javax.swing.JTextField endminuteField;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton jumpButton;
    private javax.swing.JComboBox jumpDate;
    private javax.swing.JTextField lunchField;
    private javax.swing.JPanel mapPanel;
    private javax.swing.JButton resetButton;
    private javax.swing.JTextField siteField;
    private javax.swing.JTextField starthourField;
    private javax.swing.JTextField startminuteField;
    private javax.swing.JButton submitButton;
    private javax.swing.JTable table;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JScrollPane tableScrollPane;
    private javax.swing.JLabel titleLb;
    private javax.swing.JPanel titlePlan;
    private javax.swing.JLabel todayDate;
    private javax.swing.JTextField transportField;
    // End of variables declaration                   
}
