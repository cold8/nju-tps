/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.geass.gui.planGUI;

import java.awt.HeadlessException;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.TableModel;

import net.sourceforge.jtimepiece.JTimepiece;

import org.jdesktop.swingx.JXDatePicker;

import Client.geass.clientController.planController.GuiDeletePlanController;
import Client.geass.clientController.planController.GuiModifyPlanController;
import Client.geass.gui.travellerGUI.TravellerFrame;
import Shared.geass.dataPOJO.Phase;
import Shared.geass.dataPOJO.Plan;

/**
 *
 * @author Kaya Wai
 */
public class ModifyPlanPanel extends javax.swing.JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Plan plan;
    private int planid;
    private TravellerFrame parent;
    private Date newStartdate;
    private Date newEnddate;
    private Phase detailPhase;
    private Phase detailedPhase;
    //private MapFrame mf = new MapFrame();
    private JLabel mapPicture;

    public ModifyPlanPanel(TravellerFrame parent, Plan plan) throws IOException {
        this.plan = plan;
        this.planid = plan.getPlanid();
        this.parent = parent;
        //mf.show("北京");
        initComponents();
    }

    public ModifyPlanPanel(TravellerFrame parent, int planid) throws IOException {
        this.planid = planid;
        this.plan = GuiModifyPlanController.getPlan(planid);
        this.parent = parent;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() throws IOException {
        java.awt.GridBagConstraints gridBagConstraints;

        startdateDialog = new javax.swing.JDialog();
        jLabel15 = new javax.swing.JLabel();
        startdatePicker = new JXDatePicker();
        confirmModifyStartdateButton = new javax.swing.JButton();
        cancelModifyStartdateButton = new javax.swing.JButton();
        enddateDialog = new javax.swing.JDialog();
        enddateDialogLabel = new javax.swing.JLabel();
        enddatePicker = new JXDatePicker();
        cancelModifyEnddateButton = new javax.swing.JButton();
        confirmModifyEnddateButton = new javax.swing.JButton();
        detailDialog = new javax.swing.JDialog();
        titlePanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        timePanel = new javax.swing.JPanel();
        detailDate = new javax.swing.JLabel();
        detailStarttime = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        detailEndtime = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        detailCity = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        detailSite = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        detailTransport = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        detailBreakfast = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        detailLunch = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        detailDinner = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        detailCommentScrollPane = new javax.swing.JScrollPane();
        detailCommentArea = new javax.swing.JTextArea();
        buttonPanel = new javax.swing.JPanel();
        detailConfirmButton = new javax.swing.JButton();
        detailDeleteButton = new javax.swing.JButton();
        titlePlan = new javax.swing.JPanel();
        titleLb = new javax.swing.JLabel();
        headerPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        planTitle = new javax.swing.JLabel();
        modifyTitle = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        startdate = new javax.swing.JLabel();
        modifyStartdate = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        enddate = new javax.swing.JLabel();
        modifyEnddate = new javax.swing.JButton();
        mapPanel = new javax.swing.JPanel();
        mapPicture = new JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        addPanel = new javax.swing.JPanel();
        tablePanel = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jumpDateSelector = new javax.swing.JComboBox();
        jumpButton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel18 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        detailButton = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        deletePhaseButton = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        tableScrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        startdateDialog.setMinimumSize(new java.awt.Dimension(400, 270));
        startdateDialog.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                startdatePicker.getEditor().setText("");
                startdatePicker.setDate(null);
                startdatePicker.repaint();
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });
        java.awt.GridBagLayout modifyStartdateDialogLayout = new java.awt.GridBagLayout();
        modifyStartdateDialogLayout.columnWidths = new int[]{0, 30, 0, 30, 0, 30, 0};
        modifyStartdateDialogLayout.rowHeights = new int[]{0, 30, 0, 30, 0, 30, 0};
        startdateDialog.getContentPane().setLayout(modifyStartdateDialogLayout);

        jLabel15.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
        jLabel15.setText("请选择新的计划开始日期");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        startdateDialog.getContentPane().add(jLabel15, gridBagConstraints);

        startdatePicker.setPreferredSize(new java.awt.Dimension(160, 40));
        startdatePicker.setFormats(new SimpleDateFormat("yyyy-MM-dd EE"));
        startdatePicker.setFont(new java.awt.Font("宋体", 0, 14));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 3;
        startdateDialog.getContentPane().add(startdatePicker, gridBagConstraints);

        confirmModifyStartdateButton.setText("确认");
        confirmModifyStartdateButton.setPreferredSize(new java.awt.Dimension(60, 30));
        confirmModifyStartdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    confirmModifyStartdateButtonActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        startdateDialog.getContentPane().add(confirmModifyStartdateButton, gridBagConstraints);

        cancelModifyStartdateButton.setText("取消");
        cancelModifyStartdateButton.setPreferredSize(new java.awt.Dimension(60, 30));
        cancelModifyStartdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelModifyStartdateButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        startdateDialog.getContentPane().add(cancelModifyStartdateButton, gridBagConstraints);
        startdateDialog.setTitle("修改计划开始日期");

        enddateDialog.setMinimumSize(new java.awt.Dimension(400, 270));
        java.awt.GridBagLayout enddateDialogLayout = new java.awt.GridBagLayout();
        enddateDialogLayout.columnWidths = new int[]{0, 20, 0, 20, 0, 20, 0};
        enddateDialogLayout.rowHeights = new int[]{0, 30, 0, 30, 0};
        enddateDialog.getContentPane().setLayout(enddateDialogLayout);
        enddateDialog.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                enddatePicker.getEditor().setText("");
                enddatePicker.setDate(null);
                enddatePicker.repaint();
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });

        enddateDialogLabel.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
        enddateDialogLabel.setText("请选择新的计划结束日期");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        enddateDialog.getContentPane().add(enddateDialogLabel, gridBagConstraints);
        enddateDialog.setTitle("修改计划结束日期");

        enddatePicker.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        enddatePicker.setPreferredSize(new java.awt.Dimension(160, 40));
        enddatePicker.setFormats(new SimpleDateFormat("yyyy-MM-dd EE"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 7;
        enddateDialog.getContentPane().add(enddatePicker, gridBagConstraints);

        cancelModifyEnddateButton.setText("取消");
        cancelModifyEnddateButton.setPreferredSize(new java.awt.Dimension(60, 30));
        cancelModifyEnddateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelModifyEnddateButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        enddateDialog.getContentPane().add(cancelModifyEnddateButton, gridBagConstraints);

        confirmModifyEnddateButton.setText("确认");
        confirmModifyEnddateButton.setPreferredSize(new java.awt.Dimension(60, 30));
        confirmModifyEnddateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    confirmModifyEnddateButtonActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        enddateDialog.getContentPane().add(confirmModifyEnddateButton, gridBagConstraints);

        //detailDialog.setResizable(false);
        detailDialog.setTitle("时间段详细内容");
        detailDialog.setMinimumSize(new java.awt.Dimension(506, 414));

        titlePanel.setPreferredSize(new java.awt.Dimension(500, 30));

        jLabel7.setFont(new java.awt.Font("长城特粗黑体", 1, 20)); // NOI18N
        jLabel7.setText("时间段行程内容");
        titlePanel.add(jLabel7);

        timePanel.setPreferredSize(new java.awt.Dimension(500, 30));

        detailDate.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        detailDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detailDate.setText("2013年6月1日");
        detailDate.setMaximumSize(new java.awt.Dimension(150, 19));
        detailDate.setMinimumSize(new java.awt.Dimension(150, 19));
        detailDate.setPreferredSize(new java.awt.Dimension(150, 19));

        detailStarttime.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        detailStarttime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detailStarttime.setText("starttime");
        detailStarttime.setMinimumSize(new java.awt.Dimension(100, 19));
        detailStarttime.setPreferredSize(new java.awt.Dimension(100, 19));

        jLabel10.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        jLabel10.setText("至");

        detailEndtime.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        detailEndtime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detailEndtime.setText("endtime");
        detailEndtime.setMinimumSize(new java.awt.Dimension(100, 19));
        detailEndtime.setPreferredSize(new java.awt.Dimension(100, 19));

        javax.swing.GroupLayout timePanelLayout = new javax.swing.GroupLayout(timePanel);
        timePanel.setLayout(timePanelLayout);
        timePanelLayout.setHorizontalGroup(
                timePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(timePanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(detailDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(detailStarttime, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(detailEndtime, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        timePanelLayout.setVerticalGroup(
                timePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(timePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(detailStarttime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(detailEndtime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(detailDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)));

        jPanel5.setPreferredSize(new java.awt.Dimension(500, 300));

        jLabel25.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        jLabel25.setText("城市");

        detailCity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detailCity.setText("jLabel26");
        detailCity.setMaximumSize(new java.awt.Dimension(100, 30));
        detailCity.setPreferredSize(new java.awt.Dimension(100, 30));

        jLabel27.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        jLabel27.setText("景点");

        detailSite.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detailSite.setText("jLabel28");
        detailSite.setPreferredSize(new java.awt.Dimension(100, 30));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/geass/gui/picture/1.png"))); // NOI18N
        jLabel29.setMaximumSize(new java.awt.Dimension(30, 30));
        jLabel29.setMinimumSize(new java.awt.Dimension(30, 30));
        jLabel29.setPreferredSize(new java.awt.Dimension(30, 30));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/geass/gui/picture/2.png"))); // NOI18N
        jLabel30.setMaximumSize(new java.awt.Dimension(30, 30));
        jLabel30.setMinimumSize(new java.awt.Dimension(30, 30));
        jLabel30.setPreferredSize(new java.awt.Dimension(30, 30));

        jLabel32.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        jLabel32.setText("交通");

        detailTransport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detailTransport.setText("jLabel33");
        detailTransport.setPreferredSize(new java.awt.Dimension(100, 30));

        jLabel35.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        jLabel35.setText("早餐");
        jLabel35.setPreferredSize(new java.awt.Dimension(30, 19));

        detailBreakfast.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detailBreakfast.setText("jLabel36");
        detailBreakfast.setPreferredSize(new java.awt.Dimension(100, 30));

        jLabel38.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        jLabel38.setText("午餐");
        jLabel38.setPreferredSize(new java.awt.Dimension(30, 19));

        detailLunch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detailLunch.setText("jLabel39");
        detailLunch.setPreferredSize(new java.awt.Dimension(100, 30));

        jLabel41.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        jLabel41.setText("晚餐");

        detailDinner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detailDinner.setText("jLabel42");
        detailDinner.setPreferredSize(new java.awt.Dimension(100, 30));

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/geass/gui/picture/2.png"))); // NOI18N
        jLabel44.setMaximumSize(new java.awt.Dimension(30, 30));
        jLabel44.setMinimumSize(new java.awt.Dimension(30, 30));
        jLabel44.setPreferredSize(new java.awt.Dimension(30, 30));

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/geass/gui/picture/2.png"))); // NOI18N
        jLabel45.setMaximumSize(new java.awt.Dimension(30, 30));
        jLabel45.setMinimumSize(new java.awt.Dimension(30, 30));
        jLabel45.setPreferredSize(new java.awt.Dimension(30, 30));

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/geass/gui/picture/1.png"))); // NOI18N
        jLabel46.setMaximumSize(new java.awt.Dimension(30, 30));
        jLabel46.setMinimumSize(new java.awt.Dimension(30, 30));
        jLabel46.setPreferredSize(new java.awt.Dimension(30, 30));

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/geass/gui/picture/1.png"))); // NOI18N
        jLabel47.setMaximumSize(new java.awt.Dimension(30, 30));
        jLabel47.setMinimumSize(new java.awt.Dimension(30, 30));
        jLabel47.setPreferredSize(new java.awt.Dimension(30, 30));

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/geass/gui/picture/2.png"))); // NOI18N
        jLabel48.setMaximumSize(new java.awt.Dimension(30, 30));
        jLabel48.setMinimumSize(new java.awt.Dimension(30, 30));
        jLabel48.setPreferredSize(new java.awt.Dimension(30, 30));

        jLabel13.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        jLabel13.setText("备注");
        jLabel13.setPreferredSize(new java.awt.Dimension(30, 19));

        detailCommentArea.setEditable(false);
        detailCommentArea.setLineWrap(true);
        detailCommentArea.setColumns(20);
        detailCommentArea.setRows(5);
        detailCommentArea.setPreferredSize(new java.awt.Dimension(144, 200));
        detailCommentScrollPane.setViewportView(detailCommentArea);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(detailCommentScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(detailLunch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(detailTransport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(detailCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(detailSite, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(detailDinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(detailBreakfast, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(detailSite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(detailBreakfast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(detailTransport, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(detailDinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(detailCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(detailLunch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detailCommentScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE)));

        buttonPanel.setLayout(new java.awt.GridBagLayout());

        detailConfirmButton.setText("删除");
        detailConfirmButton.setPreferredSize(new java.awt.Dimension(60, 30));
        detailConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailConfirmButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 100, 10, 134);
        buttonPanel.add(detailConfirmButton, gridBagConstraints);

        detailDeleteButton.setText("确认");
        detailDeleteButton.setPreferredSize(new java.awt.Dimension(60, 30));
        detailDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    detailDeleteButtonActionPerformed(evt);
                } catch (HeadlessException | IOException e) {
                    e.printStackTrace();
                }
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 146, 10, 0);
        buttonPanel.add(detailDeleteButton, gridBagConstraints);

        javax.swing.GroupLayout detailDialogLayout = new javax.swing.GroupLayout(detailDialog.getContentPane());
        detailDialog.getContentPane().setLayout(detailDialogLayout);
        detailDialogLayout.setHorizontalGroup(
                detailDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(detailDialogLayout.createSequentialGroup()
                .addGroup(detailDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                .addComponent(timePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                .addComponent(titlePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)));
        detailDialogLayout.setVerticalGroup(
                detailDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(detailDialogLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(timePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)));

        setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        setPreferredSize(new java.awt.Dimension(850, 1000));

        titlePlan.setPreferredSize(new java.awt.Dimension(0, 40));

        titleLb.setFont(new java.awt.Font("长城特粗黑体", 0, 24)); // NOI18N
        titleLb.setText("修改计划");
        titlePlan.add(titleLb);

        headerPanel.setFont(new java.awt.Font("华文细黑", 0, 14)); // NOI18N
        headerPanel.setPreferredSize(new java.awt.Dimension(0, 40));
        headerPanel.setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setPreferredSize(new java.awt.Dimension(260, 60));

        jLabel1.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        jLabel1.setText("计划标题  ");
        jPanel1.add(jLabel1);

        planTitle.setText(plan.getPlantitle());
        jPanel1.add(planTitle);

        modifyTitle.setText("修改");
        modifyTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyTitleActionPerformed(evt);
            }
        });
        jPanel1.add(modifyTitle);

        headerPanel.add(jPanel1);

        jPanel2.setPreferredSize(new java.awt.Dimension(260, 60));

        jLabel3.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        jLabel3.setText("开始日期  ");
        jPanel2.add(jLabel3);

        JTimepiece t = new JTimepiece();
        startdate.setText(t.convertDateToString(plan.getStartdate(), "yyyy'年'MM'月'dd'日'"));
        jPanel2.add(startdate);

        modifyStartdate.setText("修改");
        modifyStartdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyStartdateActionPerformed(evt);
            }
        });
        jPanel2.add(modifyStartdate);

        headerPanel.add(jPanel2);

        jPanel3.setPreferredSize(new java.awt.Dimension(260, 60));

        jLabel5.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        jLabel5.setText("结束日期  ");
        jPanel3.add(jLabel5);

        enddate.setText(t.convertDateToString(plan.getEnddate(), "yyyy'年'MM'月'dd'日'"));
        jPanel3.add(enddate);

        modifyEnddate.setText("修改");
        modifyEnddate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyEnddateActionPerformed(evt);
            }
        });
        jPanel3.add(modifyEnddate);

        headerPanel.add(jPanel3);

        mapPanel.setPreferredSize(new java.awt.Dimension(843, 450));
        mapPanel.setLayout(new javax.swing.BoxLayout(mapPanel, javax.swing.BoxLayout.Y_AXIS));

        jPanel9.setPreferredSize(new java.awt.Dimension(843, 25));
        jPanel9.setRequestFocusEnabled(false);

        jLabel11.setFont(new java.awt.Font("长城特粗黑体", 0, 18)); // NOI18N
        jLabel11.setText("查看地图");
        jPanel9.add(jLabel11);

        mapPanel.add(jPanel9);

        jPanel10.setPreferredSize(new java.awt.Dimension(800, 400));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 830, Short.MAX_VALUE));
        jPanel10Layout.setVerticalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 412, Short.MAX_VALUE));

        mapPanel.add(jPanel10);
        mapPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/geass/gui/picture/map.jpg")));
        mapPicture.setMaximumSize(new java.awt.Dimension(400, 400));
        mapPicture.setMinimumSize(new java.awt.Dimension(400, 400));
        mapPicture.setPreferredSize(new java.awt.Dimension(400, 400));

        mapPanel.add(mapPicture);

        addPanel.setLayout(new javax.swing.BoxLayout(addPanel, javax.swing.BoxLayout.PAGE_AXIS));

        //tablePanel.setLayout(new javax.swing.BoxLayout(tablePanel, javax.swing.BoxLayout.Y_AXIS));

        jPanel13.setPreferredSize(new java.awt.Dimension(823, 40));

        jumpDateSelector.setModel(new DefaultComboBoxModel(GuiModifyPlanController.getDaySelector(plan.getStartdate(), plan.getEnddate())));
        jumpDateSelector.setName(""); // NOI18N
        jumpDateSelector.setPreferredSize(new java.awt.Dimension(160, 30));
        jPanel13.add(jumpDateSelector);

        jumpButton.setText("转到");
        jumpButton.setPreferredSize(new java.awt.Dimension(57, 28));
        jumpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jumpButtonActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        jPanel13.add(jumpButton);

        //tablePanel.add(jPanel13);

        jToolBar1.setBorder(null);
        jToolBar1.setRollover(true);
        jToolBar1.setBorderPainted(false);
        jToolBar1.setPreferredSize(new java.awt.Dimension(830, 35));

        jLabel18.setText("                                  ");
        jToolBar1.add(jLabel18);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/geass/gui/picture/6.png"))); // NOI18N
        jLabel14.setMaximumSize(new java.awt.Dimension(25, 25));
        jLabel14.setMinimumSize(new java.awt.Dimension(25, 25));
        jLabel14.setPreferredSize(new java.awt.Dimension(25, 25));
        jToolBar1.add(jLabel14);

        detailButton.setText("查看时段");
        detailButton.setFocusable(false);
        detailButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        detailButton.setMaximumSize(new java.awt.Dimension(80, 30));
        detailButton.setMinimumSize(new java.awt.Dimension(80, 30));
        detailButton.setPreferredSize(new java.awt.Dimension(80, 30));
        detailButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        detailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(detailButton);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/geass/gui/picture/6.png"))); // NOI18N
        jLabel16.setMaximumSize(new java.awt.Dimension(25, 25));
        jLabel16.setMinimumSize(new java.awt.Dimension(25, 25));
        jLabel16.setPreferredSize(new java.awt.Dimension(25, 25));
        jToolBar1.add(jLabel16);

        deletePhaseButton.setText("删除时段");
        deletePhaseButton.setFocusable(false);
        deletePhaseButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deletePhaseButton.setMaximumSize(new java.awt.Dimension(80, 30));
        deletePhaseButton.setMinimumSize(new java.awt.Dimension(80, 30));
        deletePhaseButton.setPreferredSize(new java.awt.Dimension(80, 30));
        deletePhaseButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        deletePhaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    deletePhaseButtonActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        jToolBar1.add(deletePhaseButton);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/geass/gui/picture/6.png"))); // NOI18N
        jLabel17.setMaximumSize(new java.awt.Dimension(25, 25));
        jLabel17.setMinimumSize(new java.awt.Dimension(25, 25));
        jLabel17.setPreferredSize(new java.awt.Dimension(25, 25));
        jToolBar1.add(jLabel17);

        backButton.setText("返回列表");
        backButton.setFocusable(false);
        backButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        backButton.setMaximumSize(new java.awt.Dimension(80, 30));
        backButton.setMinimumSize(new java.awt.Dimension(80, 30));
        backButton.setPreferredSize(new java.awt.Dimension(80, 30));
        backButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    backButtonActionPerformed(evt);
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
        });
        jToolBar1.add(backButton);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/geass/gui/picture/6.png"))); // NOI18N
        jLabel19.setMaximumSize(new java.awt.Dimension(25, 25));
        jLabel19.setMinimumSize(new java.awt.Dimension(25, 25));
        jLabel19.setPreferredSize(new java.awt.Dimension(25, 25));
        jToolBar1.add(jLabel19);

        deleteButton.setText("删除计划");
        deleteButton.setFocusable(false);
        deleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteButton.setMaximumSize(new java.awt.Dimension(80, 30));
        deleteButton.setMinimumSize(new java.awt.Dimension(80, 30));
        deleteButton.setPreferredSize(new java.awt.Dimension(80, 30));
        deleteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(deleteButton);

        jPanel6.add(jToolBar1);

        //tablePanel.add(jPanel6);

        try {
            TableModel model = GuiModifyPlanController.initPlanModel(plan);
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableScrollPane.setViewportView(table);
        tableScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        tableScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        //tablePanel.add(tableScrollPane);

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
                tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE));
        tablePanelLayout.setVerticalGroup(
                tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tablePanelLayout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(headerPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titlePlan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                .addComponent(addPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
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
                .addComponent(addPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap()));
    }// </editor-fold>                        

    private void jumpButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        String date = (String) jumpDateSelector.getSelectedItem();
        /*table.setModel(GuiModifyPlanController.getUpdatedDayModel(plan.getPlanid(), date));
         table.repaint();*/
        this.parent.modifyDayOfPlan(parent, plan, date);
    }

    private void confirmModifyStartdateButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        newStartdate = startdatePicker.getDate();
        JTimepiece t = new JTimepiece();
        if (newStartdate != null) {
            int result = GuiModifyPlanController.setPlanStartdate(planid, plan.getStartdate(), plan.getEnddate(), newStartdate, false);
            if (result == 1) {
                startdateDialog.dispose();
                startdatePicker.getEditor().setText("");
                startdatePicker.setDate(null);
                startdatePicker.repaint();
                JOptionPane.showMessageDialog(this, "计划开始日期修改成功！", "修改成功", JOptionPane.PLAIN_MESSAGE);
                //-------------------更新-----------------
                plan = GuiModifyPlanController.getPlan(planid);
                startdate.setText(t.convertDateToString(plan.getStartdate(), "yyyy'年'MM'月'dd'日'"));
                startdate.repaint();
                table.setModel(GuiModifyPlanController.initPlanModel(plan));
                table.repaint();
                //----------------------------------------------

            } else if (result == 2) {
                startdateDialog.dispose();
                startdatePicker.getEditor().setText("");
                startdatePicker.setDate(null);
                startdatePicker.repaint();
                JOptionPane.showMessageDialog(this, "未修改计划开始日期", "未做修改", JOptionPane.PLAIN_MESSAGE);
            } else if (result == -1) {
                startdateDialog.dispose();
                startdatePicker.getEditor().setText("");
                startdatePicker.setDate(null);
                startdatePicker.repaint();
                JOptionPane.showMessageDialog(this, "计划开始日期修改失败，新开始日期大于原结束日期，请先设置结束日期", "修改失败", JOptionPane.PLAIN_MESSAGE);
            } else {//result==0
                startdateDialog.dispose();
                startdatePicker.getEditor().setText("");
                startdatePicker.setDate(null);
                startdatePicker.repaint();
                if (JOptionPane.showOptionDialog(this, "新开始日期大于原来开始日期，将会删除新开始日期之前的计划内容，请问确认要删除吗？", "删除确认", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null) == 0) {
                    GuiModifyPlanController.setPlanStartdate(planid, plan.getStartdate(), plan.getEnddate(), newStartdate, true);
                    JOptionPane.showMessageDialog(this, "计划开始日期修改成功！", "修改成功", JOptionPane.PLAIN_MESSAGE);
                    //-------------------更新-----------------
                    plan = GuiModifyPlanController.getPlan(planid);
                    startdate.setText(t.convertDateToString(plan.getStartdate(), "yyyy'年'MM'月'dd'日'"));
                    startdate.repaint();
                    table.setModel(GuiModifyPlanController.initPlanModel(plan));
                    table.repaint();
                    jumpDateSelector.setModel(new DefaultComboBoxModel(GuiModifyPlanController.getDaySelector(plan.getStartdate(), plan.getEnddate())));
                    jumpDateSelector.repaint();
                    //----------------------------------------------
                } else {//CANCEL
                    JOptionPane.showMessageDialog(this, "取消设置新开始日期。将不会删除计划内容", "取消设置", JOptionPane.PLAIN_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "请选择开始日期", "修改失败", JOptionPane.PLAIN_MESSAGE);
        }

    }

    private void modifyTitleActionPerformed(java.awt.event.ActionEvent evt) {
        String newPlantitle = JOptionPane.showInputDialog(this, "请输入计划标题 ", "修改计划标题", JOptionPane.OK_CANCEL_OPTION);
        if (!newPlantitle.isEmpty()) {
            try {
                if (GuiModifyPlanController.setTitle(planid, newPlantitle) == false) {
                    JOptionPane.showMessageDialog(this, "该标题已经存在", "标题修改失败", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "标题成功修改为：" + newPlantitle + "!", "标题修改成功", JOptionPane.PLAIN_MESSAGE);
                    planTitle.setText(newPlantitle);
                    planTitle.repaint();
                }
            } catch (IOException ex) {
                Logger.getLogger(ModifyPlanPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "请输入计划标题", "标题修改失败", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private void modifyStartdateActionPerformed(java.awt.event.ActionEvent evt) {
        startdateDialog.setVisible(true);
    }

    private void modifyEnddateActionPerformed(java.awt.event.ActionEvent evt) {
        enddateDialog.setVisible(true);
    }

    private void cancelModifyStartdateButtonActionPerformed(java.awt.event.ActionEvent evt) {
        startdateDialog.dispose();
        startdatePicker.getEditor().setText("");
        startdatePicker.setDate(null);
        startdatePicker.repaint();
    }

    private void detailButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (table.getSelectedColumn() == -1 || table.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "请在表格中选择一个时间段", "请选择时间段", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JTimepiece t = new JTimepiece();
            int col = table.getSelectedColumn();//第几天，从0开始

            Date mydate = t.addDay(plan.getStartdate(), col);
            String phaseInfo = (String) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
            try {
                detailPhase = GuiModifyPlanController.getPhase(planid, mydate, phaseInfo);
            } catch (IOException ex) {
                Logger.getLogger(DisplayPlanPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

            detailDate.setText(t.convertDateToString(mydate, "yyyy'年'MM'月'dd'日'"));
            detailDate.repaint();

            detailStarttime.setText(t.convertDateToString(detailPhase.getBegintime(), "HH':'mm"));
            detailEndtime.setText(t.convertDateToString(detailPhase.getEndtime(), "HH':'mm"));
            detailStarttime.repaint();
            detailEndtime.repaint();

            detailCity.setText(detailPhase.getCityname());
            detailSite.setText(detailPhase.getSite());
            detailTransport.setText(detailPhase.getTransport());
            detailBreakfast.setText(detailPhase.getBreakfast());
            detailLunch.setText(detailPhase.getLunch());
            detailDinner.setText(detailPhase.getDinner());
            detailCommentArea.setText(detailPhase.getComment());
            detailCity.repaint();
            detailSite.repaint();
            detailTransport.repaint();
            detailBreakfast.repaint();
            detailLunch.repaint();
            detailDinner.repaint();
            detailCommentArea.repaint();

            detailDialog.setVisible(true);
        }

    }

    private void deletePhaseButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        detailDialog.dispose();
        if (GuiModifyPlanController.deletePhase(detailedPhase.getPhaseid())) {
            //---------更新部分--------
            plan = GuiModifyPlanController.getPlan(planid);
            table.setModel(GuiModifyPlanController.initPlanModel(plan));
            table.repaint();
            detailedPhase = null;
            //-------------------------
            JOptionPane.showMessageDialog(this, "计划时间段删除成功！", "删除成功", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "计划时间段删除失败", "删除失败", JOptionPane.PLAIN_MESSAGE);
        }
        /*//-------------这段是界面跳转代码-----------
         this.getParent().add(new ModifyPlanPanelNetbeans(plan), "ModifyPlanPanel");
         CardLayout cl = (CardLayout) this.getParent().getLayout();
         cl.show(this.getParent(),"ModifyPlanPanel");
         this.getParent().repaint();
         //---------------------------------------
         */    }

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String title = plan.getPlantitle();

        //OK:返回0，CANCEL：返回2
        int isConfirmed = 2;
        isConfirmed = JOptionPane.showConfirmDialog(this, "请问您确定要删除计划：" + title + "吗？", "删除确认", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (isConfirmed == 2) {
            JOptionPane.showMessageDialog(this, "已取消删除计划:" + title, "删除取消", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                if (GuiDeletePlanController.deletePlan(plan.getPlanid()) == true) {
                    JOptionPane.showMessageDialog(this, "已成功删除计划:" + title, "删除成功", JOptionPane.INFORMATION_MESSAGE);
                    //----------这段是界面跳转代码---------------
                    this.parent.displayPlanList(parent);
                    //---------------------------------
                } else {
                    JOptionPane.showMessageDialog(this, "计划:" + title + " 删除失败", "删除失败", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (IOException ex) {
                Logger.getLogger(DisplayPlanPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        this.parent.displayPlanList(parent);
    }

    private void detailConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {
        detailDialog.dispose();
    }

    private void detailDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) throws HeadlessException, IOException {
        detailDialog.dispose();
        if (GuiModifyPlanController.deletePhase(detailedPhase.getPhaseid())) {
            //---------更新部分--------
            plan = GuiModifyPlanController.getPlan(planid);
            table.setModel(GuiModifyPlanController.initPlanModel(plan));
            table.repaint();
            detailedPhase = null;
            //-------------------------
            JOptionPane.showMessageDialog(this, "计划时间段删除成功！", "删除成功", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "计划时间段删除失败", "删除失败", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private void confirmModifyEnddateButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        newEnddate = enddatePicker.getDate();
        JTimepiece t = new JTimepiece();
        if (newEnddate != null) {
            int result = GuiModifyPlanController.setPlanEnddate(planid, plan.getEnddate(), plan.getStartdate(), newEnddate, false);
            if (result == 1) {
                enddateDialog.dispose();
                enddatePicker.getEditor().setText("");
                enddatePicker.setDate(null);
                enddatePicker.repaint();
                JOptionPane.showMessageDialog(this, "计划结束日期修改成功！", "修改成功", JOptionPane.PLAIN_MESSAGE);
                //-------------------更新-----------------
                plan = GuiModifyPlanController.getPlan(planid);
                enddate.setText(t.convertDateToString(plan.getEnddate(), "yyyy'年'MM'月'dd'日'"));
                enddate.repaint();
                table.setModel(GuiModifyPlanController.initPlanModel(plan));
                table.repaint();
                jumpDateSelector.setModel(new DefaultComboBoxModel(GuiModifyPlanController.getDaySelector(plan.getStartdate(), plan.getEnddate())));
                jumpDateSelector.repaint();
                //----------------------------------------------

            } else if (result == 2) {
                enddateDialog.dispose();
                enddatePicker.getEditor().setText("");
                enddatePicker.setDate(null);
                enddatePicker.repaint();
                JOptionPane.showMessageDialog(this, "未修改计划结束日期", "未做修改", JOptionPane.PLAIN_MESSAGE);
            } else if (result == -1) {
                enddateDialog.dispose();
                enddatePicker.getEditor().setText("");
                enddatePicker.setDate(null);
                enddatePicker.repaint();
                JOptionPane.showMessageDialog(this, "计划结束日期修改失败，新结束日期小于原结束日期，请先设置开始日期", "修改失败", JOptionPane.PLAIN_MESSAGE);
            } else {//result==0
                enddateDialog.dispose();
                enddatePicker.getEditor().setText("");
                enddatePicker.setDate(null);
                enddatePicker.repaint();
                if (JOptionPane.showOptionDialog(this, "新结束日期小于原来结束日期，将会删除新结束日期之后的计划内容，请问确认要删除吗？", "删除确认", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null) == 0) {
                    GuiModifyPlanController.setPlanEnddate(planid, plan.getEnddate(), plan.getStartdate(), newEnddate, true);
                    JOptionPane.showMessageDialog(this, "计划结束日期修改成功！", "修改成功", JOptionPane.PLAIN_MESSAGE);
                    //-------------------更新-----------------
                    plan = GuiModifyPlanController.getPlan(planid);
                    enddate.setText(t.convertDateToString(plan.getEnddate(), "yyyy'年'MM'月'dd'日'"));
                    enddate.repaint();
                    table.setModel(GuiModifyPlanController.initPlanModel(plan));
                    table.repaint();
                    jumpDateSelector.setModel(new DefaultComboBoxModel(GuiModifyPlanController.getDaySelector(plan.getStartdate(), plan.getEnddate())));
                    jumpDateSelector.repaint();
                    //----------------------------------------------
                } else {//CANCEL
                    JOptionPane.showMessageDialog(this, "取消设置新结束日期。将不会删除计划内容", "取消设置", JOptionPane.PLAIN_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "请选择结束日期", "修改失败", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private void cancelModifyEnddateButtonActionPerformed(java.awt.event.ActionEvent evt) {
        enddateDialog.dispose();
        enddatePicker.getEditor().setText("");
        enddatePicker.setDate(null);
        enddatePicker.repaint();
    }
    // Variables declaration - do not modify                     
    private javax.swing.JPanel addPanel;
    private javax.swing.JButton backButton;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelModifyEnddateButton;
    private javax.swing.JButton cancelModifyStartdateButton;
    private javax.swing.JButton confirmModifyEnddateButton;
    private javax.swing.JButton confirmModifyStartdateButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel detailBreakfast;
    private javax.swing.JButton detailButton;
    private javax.swing.JLabel detailCity;
    private javax.swing.JTextArea detailCommentArea;
    private javax.swing.JScrollPane detailCommentScrollPane;
    private javax.swing.JButton detailConfirmButton;
    private javax.swing.JLabel detailDate;
    private javax.swing.JButton detailDeleteButton;
    private javax.swing.JDialog detailDialog;
    private javax.swing.JLabel detailDinner;
    private javax.swing.JLabel detailEndtime;
    private javax.swing.JLabel detailLunch;
    private javax.swing.JLabel detailSite;
    private javax.swing.JLabel detailStarttime;
    private javax.swing.JLabel detailTransport;
    private javax.swing.JLabel enddate;
    private javax.swing.JDialog enddateDialog;
    private javax.swing.JLabel enddateDialogLabel;
    private JXDatePicker enddatePicker;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton jumpButton;
    private javax.swing.JComboBox jumpDateSelector;
    private javax.swing.JPanel mapPanel;
    private javax.swing.JButton deletePhaseButton;
    private javax.swing.JButton modifyEnddate;
    private javax.swing.JButton modifyStartdate;
    private javax.swing.JButton modifyTitle;
    private javax.swing.JLabel planTitle;
    private javax.swing.JLabel startdate;
    private javax.swing.JDialog startdateDialog;
    private JXDatePicker startdatePicker;
    private javax.swing.JTable table;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JScrollPane tableScrollPane;
    private javax.swing.JPanel timePanel;
    private javax.swing.JLabel titleLb;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JPanel titlePlan;
    // End of variables declaration                   
}
