/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.geass.gui.planGUI;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

import org.jdesktop.swingx.JXDatePicker;

import Client.geass.clientController.planController.GuiDisplayPlanController;
import Client.geass.gui.travellerGUI.TravellerFrame;
import Shared.geass.dataPOJO.Plan;

/**
 *
 * @author Kaya Wai
 */
public class DisplayPlanListPanel extends javax.swing.JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private ArrayList<Plan> planlist;
    private TravellerFrame parent;

    public DisplayPlanListPanel(TravellerFrame parent) throws IOException {
        planlist = GuiDisplayPlanController.getPlanList();
        this.parent = parent;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        titlePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        listPanel = new javax.swing.JPanel();
        listScrollPane = new javax.swing.JScrollPane();
        list = new javax.swing.JList();
        buttonPanel = new javax.swing.JPanel();
        displayButton = new javax.swing.JButton();
        searchPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        searchCity = new javax.swing.JTextField();
        searchDate = new JXDatePicker();
        searchCityDateButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        searchStartdate = new JXDatePicker();
        searchEnddate = new JXDatePicker();
        searchDateRangeButton = new javax.swing.JButton();
        subtitlePanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        titlePanel.setPreferredSize(new java.awt.Dimension(830, 40));

        jLabel1.setFont(new java.awt.Font("长城特粗黑体", 0, 24)); // NOI18N
        jLabel1.setText("查看计划列表");
        titlePanel.add(jLabel1);

        try {
            list.setModel(GuiDisplayPlanController.getPlanListModel());
        } catch (Exception e) {
        }
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listScrollPane.setViewportView(list);

        displayButton.setText("查看计划");
        displayButton.setPreferredSize(new java.awt.Dimension(80, 30));
        displayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(displayButton);

        javax.swing.GroupLayout listPanelLayout = new javax.swing.GroupLayout(listPanel);
        listPanel.setLayout(listPanelLayout);
        listPanelLayout.setHorizontalGroup(
                listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(listPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(listScrollPane)
                .addComponent(buttonPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap()));
        listPanelLayout.setVerticalGroup(
                listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(listPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap()));

        searchPanel.setLayout(new javax.swing.BoxLayout(searchPanel, javax.swing.BoxLayout.LINE_AXIS));

        jPanel4.setPreferredSize(new java.awt.Dimension(415, 50));
        java.awt.GridBagLayout jPanel4Layout = new java.awt.GridBagLayout();
        jPanel4Layout.columnWidths = new int[]{0, 10, 0, 10, 0, 10, 0};
        jPanel4Layout.rowHeights = new int[]{0};
        jPanel4.setLayout(jPanel4Layout);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/geass/gui/picture/plan/5.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setPreferredSize(new java.awt.Dimension(30, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel4.add(jLabel2, gridBagConstraints);

        searchCity.setForeground(new java.awt.Color(153, 153, 153));
        searchCity.setText("请输入城市名称");
        searchCity.setPreferredSize(new java.awt.Dimension(100, 30));
        searchCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCityActionPerformed(evt);
            }
        });
        searchCity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchCityFocusGained(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jPanel4.add(searchCity, gridBagConstraints);

        searchDate.setPreferredSize(new java.awt.Dimension(150, 30));
        searchDate.setFont(new java.awt.Font("宋体", 0, 14));
        searchDate.setFormats(new SimpleDateFormat("yyyy-MM-dd EE"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        jPanel4.add(searchDate, gridBagConstraints);

        searchCityDateButton.setText("搜索");
        searchCityDateButton.setPreferredSize(new java.awt.Dimension(60, 30));
        searchCityDateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    searchCityDateButtonActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        jPanel4.add(searchCityDateButton, gridBagConstraints);

        searchPanel.add(jPanel4);

        jPanel5.setPreferredSize(new java.awt.Dimension(415, 50));
        java.awt.GridBagLayout jPanel5Layout = new java.awt.GridBagLayout();
        jPanel5Layout.columnWidths = new int[]{0, 10, 0, 10, 0, 10, 0};
        jPanel5Layout.rowHeights = new int[]{0};
        jPanel5.setLayout(jPanel5Layout);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/geass/traveller/gui/picture/plan/5.png"))); // NOI18N
        jLabel3.setPreferredSize(new java.awt.Dimension(30, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel5.add(jLabel3, gridBagConstraints);

        searchStartdate.setFont(new java.awt.Font("宋体", 0, 14));
        searchStartdate.setFormats(new SimpleDateFormat("yyyy-MM-dd EE"));
        searchStartdate.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jPanel5.add(searchStartdate, gridBagConstraints);

        searchEnddate.setPreferredSize(new java.awt.Dimension(150, 30));
        searchEnddate.setFont(new java.awt.Font("宋体", 0, 14));
        searchEnddate.setFormats(new SimpleDateFormat("yyyy-MM-dd EE"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        jPanel5.add(searchEnddate, gridBagConstraints);

        searchDateRangeButton.setText("搜索");
        searchDateRangeButton.setPreferredSize(new java.awt.Dimension(60, 30));
        searchDateRangeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    searchDateRangeButtonActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        jPanel5.add(searchDateRangeButton, gridBagConstraints);

        searchPanel.add(jPanel5);

        jLabel4.setFont(new java.awt.Font("微软雅黑", 1, 16)); // NOI18N
        jLabel4.setText("所有计划列表");
        subtitlePanel.add(jLabel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(listPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(titlePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(subtitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(subtitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    }// </editor-fold>                        

    private void searchCityActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void displayButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int planindex = list.getSelectedIndex();

        if (planindex != -1) {
            Plan plan = planlist.get(planindex);
            //Plan plan = GuiDisplayPlanController.getPlan(String.valueOf(planindex));s

            //----------------------------这是界面跳转代码-------------------------//
            this.parent.displayPlan(parent, plan);
            //--------------------------------------------------------------//
        } else {
            JOptionPane.showMessageDialog(this, "请选择一项计划");
        }
    }

    private void searchCityDateButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        if (searchCity.getText().isEmpty() || searchCity.getText().equals("请输入城市名称")) {
            JOptionPane.showMessageDialog(this, "请输入指定日期和当日所在城市名称，或输入某个城市名称", "搜索失败", JOptionPane.PLAIN_MESSAGE);

        } else {
            ArrayList<Plan> resultList = GuiDisplayPlanController.searchPlanByCityDate(searchCity.getText(), searchDate.getDate());
            /* 
             * 刷新列表
             */
            if (resultList != null) {
                /*initSearchResultDialog(resultList);
                 searchResultDialog.setVisible(true);*/
                list.setModel(GuiDisplayPlanController.getPlanListModel(resultList));
                list.repaint();
            } else {
                JOptionPane.showMessageDialog(this, "无法找到符合条件的计划", "搜索失败", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    private void searchDateRangeButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        if (searchStartdate.getDate() == null || searchEnddate.getDate() == null) {
            JOptionPane.showMessageDialog(this, "请输入开始日期和结束日期", "搜索失败", JOptionPane.PLAIN_MESSAGE);

        } else {
            ArrayList<Plan> resultList = GuiDisplayPlanController.searchPlanByDateRange(searchStartdate.getDate(), searchEnddate.getDate());
            /* 
             * 刷新列表
             */
            if (resultList != null) {
                /*initSearchResultDialog(resultList);
                 searchResultDialog.setVisible(true);*/
                list.setModel(GuiDisplayPlanController.getPlanListModel(resultList));
                list.repaint();
            } else {
                JOptionPane.showMessageDialog(this, "无法找到符合条件的计划", "搜索失败", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    private void searchCityFocusGained(java.awt.event.FocusEvent evt) {
        if (searchCity.getText().equals("请输入城市名称")) {
            searchCity.setText("");
        }
    }
    // Variables declaration - do not modify                     
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton displayButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JList list;
    private javax.swing.JPanel listPanel;
    private javax.swing.JScrollPane listScrollPane;
    private javax.swing.JTextField searchCity;
    private javax.swing.JButton searchCityDateButton;
    private JXDatePicker searchDate;
    private javax.swing.JButton searchDateRangeButton;
    private JXDatePicker searchEnddate;
    private javax.swing.JPanel searchPanel;
    private JXDatePicker searchStartdate;
    private javax.swing.JPanel subtitlePanel;
    private javax.swing.JPanel titlePanel;
    // End of variables declaration                   
}
