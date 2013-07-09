package Client.geass.clientController.planController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.AbstractListModel;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.sourceforge.jtimepiece.JTimepiece;

import Client.geass.clientController.PlanClient;
import Shared.geass.dataPOJO.Phase;
import Shared.geass.dataPOJO.Plan;

public class GuiDisplayPlanController {

    private static PlanClient client = PlanClient.getInstance();

    ;
	
	public GuiDisplayPlanController() {
    }

    /**
     * 获得所有计划
     *
     * @return 所有计划的Plan类型数组
     * @throws IOException
     */
    public static ArrayList<Plan> getPlanList() throws IOException {
        ArrayList<Plan> planlist = null;
        planlist = client.getPlanList();
        return planlist;
    }

    /**
     * 用于初始化列表
     *
     * @return 所有计划的列表模型
     * @throws IOException
     */
    public static AbstractListModel<String> getPlanListModel() throws IOException {




        AbstractListModel<String> model = new AbstractListModel<String>() {
            /**
             *
             */
            private static final long serialVersionUID = 1L;
            private ArrayList<Plan> planlist = getPlanList();
            private String[] list;
            private JTimepiece t = new JTimepiece();

            private String[] initList() {
                if (planlist != null) {
                    list = new String[planlist.size()];
                    //初始化Plan[]数组，按planid大小获得
                    for (int i = 0; i < planlist.size(); i++) {
                        Plan tempplan = planlist.get(i);

                        Date startdate = tempplan.getStartdate();
                        Date enddate = tempplan.getEnddate();
                        String str1 = t.convertDateToString(startdate, "yyyy'年'MM'月'dd'日'");
                        String str2 = t.convertDateToString(enddate, "yyyy'年'MM'月'dd'日'");

                        list[i] = tempplan.getPlantitle() + " " + str1 + "-" + str2;
                    }
                } else {
                    list = null;
                }
                return list;
            }

            @Override
            public int getSize() {
                if (initList() != null) {
                    return initList().length;
                } else {
                    return 0;
                }
            }

            @Override
            public String getElementAt(int index) {
                String[] templist = initList();
                if (templist != null) {
                    return templist[index];
                } else {
                    return null;
                }
            }
        };

        return model;
    }


    /*	*/
    /**
     * @param planid
     * @return 获得由index指定序号的计划
     * @throws IOException
     *//*
     public static Plan getPlan(String planid) throws IOException {
     return client.getPlan(planid);
     }*/

    public static TableModel initPlanModel(Plan plan) throws IOException {
        JTimepiece t = new JTimepiece();
        Date startDate = plan.getStartdate();
        Date endDate = plan.getEnddate();

        int col = calculateInterval(startDate, endDate, "D");//day size
        int row = getMaxCountOfPhases(plan.getPlanid());
        String[][] content;


        //set header
        String[] header = getPlanTabelModelHeader(startDate, endDate);

        if (row != 0) {
            content = new String[row][col];

            //set content

            for (int i = 0; i < col; i++) {

                Date thisDay = t.addDay(startDate, i);
                ArrayList<Phase> phaseArray = getPhaseOfDay(plan.getPlanid(), thisDay);

                if (phaseArray != null) {
                    for (int j = 0; j < row; j++) {
                        if (j < phaseArray.size()) {
                            content[j][i] = getPhaseInfo(phaseArray.get(j));
                        } else {
                            content[j][i] = null;
                        }
                    }//写入一天的内容
                }//如果当天有计划内容
                else {
                    for (int j = 0; j < row; j++) {
                        content[j][i] = null;
                    }
                }
            }//如果当天没有计划内容

        }//如果计划不为空
        else {
            content = null;
        }

        return new DefaultTableModel(content, header) {
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
    }

    /**
     * 将Phase类型的参数转化成在计划表格中显示的简要内容字符串
     *
     * @param phase
     * @return Phase的简要内容字符串
     */
    private static String getPhaseInfo(Phase phase) {

        String timestr = convertTimeToString(phase.getBegintime(), phase.getEndtime());
        return timestr + " 在 " + phase.getCityname() + "-" + phase.getSite() + "，交通方式：" + phase.getTransport();
    }

    /**
     * 将一个Phase时间段的开始和结束时间转换成String字符串
     *
     * @param time1
     * @param time2
     * @return
     */
    private static String convertTimeToString(Date time1, Date time2) {

        JTimepiece t = new JTimepiece();
        String str1, str2;
        int minute1 = t.getMinute(time1);
        int minute2 = t.getMinute(time2);

        if (minute1 < 10) {
            str1 = t.getHourOfDay(time1) + ":0" + minute1;
        } else {
            str1 = t.getHourOfDay(time1) + ":" + minute1;
        }

        if (minute2 < 10) {
            str2 = t.getHourOfDay(time2) + ":0" + minute2;
        } else {
            str2 = t.getHourOfDay(time2) + ":" + minute2;
        }

        return str1 + " - " + str2;
    }

    /**
     * 获得由参数指定的计划中的某一天的所有Phase
     *
     * @param planid
     * @param date
     * @return Phase类型的数组
     * @throws IOException
     */
    private static ArrayList<Phase> getPhaseOfDay(int planid, Date date) throws IOException {
        /*
         * 系统已将一天中的Phase按开始时间和结束结束排序
         * 不是按照Phaseid排序
         */
        ArrayList<Phase> array = null;
        array = client.getPhaseOfDay(planid, date);
        return array;
    }

    /**
     * 用于表格模型的初始化 根据计划的开始日期和结束日期，获得表格的表头
     *
     * @param startDate
     * @param endDate
     * @return 字符串数组格式的从开始日期到结束日期的表头
     */
    private static String[] getPlanTabelModelHeader(Date startDate, Date endDate) {

        String[] header = null;
        int interval = calculateInterval(startDate, endDate, "D");
        JTimepiece t = new JTimepiece();

        if (interval == 0) {
            return header;
        } else {
            header = new String[interval];
            for (int i = 0; i < interval; i++) {
                Date tempDate = t.addDay(startDate, i);
                header[i] = t.convertDateToString(tempDate, "yyyy'年'MM'月'dd'日'");
            }
        }

        return header;
    }

    /**
     * @param planid
     * @return 由id指定的计划中，所有"行程日"所拥有的最大时间段的个数
     * @throws IOException
     */
    private static int getMaxCountOfPhases(int planid) throws IOException {
        int max = 0;
        max = client.getMaxCountOfPhases(planid);
        return max;
    }

    /**
     * 计算两个日期的时间间隔
     *
     * @param startDate开始时间
     * @param endDate结束时间
     * @param type间隔类型("Y/y"--年 "M/m"--月 "D/d"--日)
     * @return interval时间间隔
	 *
     */
    private static int calculateInterval(Date startDate, Date endDate, String type) {

        //只需要“日”的间隔
        type = "D";

        //时间间隔，初始为0
        int interval = 0;

        /*比较两个日期的大小，如果开始日期更大，则交换两个日期*/
        //标志两个日期是否交换过
        boolean reversed = false;
        if (endDate.compareTo(startDate) > 0) {
            Date tempdate = startDate;
            startDate = endDate;
            endDate = tempdate;
            //修改交换标志
            reversed = true;
        }

        /*将两个日期赋给日历实例，并获取年、月、日相关字段值*/
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startDate);
        int startYears = startCalendar.get(Calendar.YEAR);
        int startMonths = startCalendar.get(Calendar.MONTH);
        int startDays = startCalendar.get(Calendar.DAY_OF_YEAR);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);
        int endYears = endCalendar.get(Calendar.YEAR);
        int endMonths = endCalendar.get(Calendar.MONTH);
        int endDays = endCalendar.get(Calendar.DAY_OF_YEAR);

        //年
        if (cTrim(type).equals("Y") || cTrim(type).equals("y")) {
            interval = endYears - startYears;
            if (endMonths < startMonths) {
                --interval;
            }
        } //月
        else if (cTrim(type).equals("M") || cTrim(type).equals("m")) {
            interval = 12 * (endYears - startYears);
            interval += (endMonths - startMonths);
        } //日
        else if (cTrim(type).equals("D") || cTrim(type).equals("d")) {
            interval = 365 * (endYears - startYears);
            interval += (endDays - startDays);
            //除去闰年天数
            while (startYears < endYears) {
                if (isLeapYear(startYears)) {
                    --interval;
                }
                ++startYears;
            }
        }
        //如果开始日期更大，则返回负值
        if (reversed) {
            interval = -interval;
        }
        //返回计算结果
        return interval + 1;
    }

    /**
     * 字符串去除两头空格，如果为空，则返回""，如果不空，则返回该字符串去掉前后空格
     *
     * @param tStr输入字符串
     * @return 如果为空，则返回""，如果不空，则返回该字符串去掉前后空格
     */
    private static String cTrim(String tStr) {
        String ttStr = "";
        if (tStr == null) {
        } else {
            ttStr = tStr.trim();
        }
        return ttStr;
    }

    /**
     * 判定某个年份是否是闰年
     *
     * @param year待判定的年份
     * @return 判定结果
	  *
     */
    private static boolean isLeapYear(int year) {
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    }

    /**
     * 按城市名称搜索经过该城市的所有计划
     *
     * @param cityname
     * @return 满足条件的所有计划列表
     * @throws IOException
     */
    public static ArrayList<Plan> searchPlanByCity(String cityname) throws IOException {
        return client.searchPlanByCity(cityname);
    }

    /**
     * 按开始日期和结束日期搜索计划
     *
     * @param startdate
     * @param enddate
     * @return 满足条件的所有计划列表
     * @throws IOException
     */
    public static ArrayList<Plan> searchPlanByDates(Date startdate, Date enddate) throws IOException {
        return client.searchPlanByDates(startdate, enddate);
    }

    /**
     * 按在某个日期经过某个城市搜索计划
     *
     * @param city
     * @param date
     * @return 满足条件的所有计划
     * @throws IOException
     */
    public static ArrayList<Plan> searchPlanByCityDate(String city, Date date) throws IOException {
        if (date == null) {
            return client.searchPlanByCity(city);
        } else {
            return client.searchPlanByCityDate(date, city);
        }
    }

    /**
     * 用于更新列表模型
     *
     * @param cityname
     * @return 一个包含了按城市名称搜索的所有计划结果的列表模型
     * @throws IOException
     */
    @SuppressWarnings("rawtypes")
    public static ListModel getSearchedPlanListModel(String cityname) throws IOException {

        final String city = cityname;

        AbstractListModel<String> model = new AbstractListModel<String>() {
            private static final long serialVersionUID = 1L;
            private ArrayList<Plan> searchedPlanlist = GuiDisplayPlanController.searchPlanByCity(city);
            private String[] list;
            private JTimepiece t = new JTimepiece();

            private String[] initList() {
                if (searchedPlanlist != null) {
                    list = new String[searchedPlanlist.size()];
                    for (int i = 0; i < searchedPlanlist.size(); i++) {
                        Plan tempplan = searchedPlanlist.get(i);

                        Date startdate = tempplan.getStartdate();
                        Date enddate = tempplan.getEnddate();
                        String str1 = t.convertDateToString(startdate, "yyyy'年'MM'月'dd'日'");
                        String str2 = t.convertDateToString(enddate, "yyyy'年'MM'月'dd'日'");

                        list[i] = tempplan.getPlantitle() + " " + str1 + "-" + str2;
                    }
                } else {
                    list = null;
                }
                return list;
            }

            @Override
            public int getSize() {
                if (searchedPlanlist != null) {
                    return searchedPlanlist.size();
                } else {
                    return 0;
                }
            }

            @Override
            public String getElementAt(int index) {
                String[] templist = initList();
                if (templist != null) {
                    return templist[index];
                } else {
                    return null;
                }
            }
        };

        return model;
    }

    /**
     * 用于搜索计划列表模型的获取
     *
     * @param planlist
     * @return 列表模型
     * @throws IOException
     */
    public static AbstractListModel<String> getPlanListModel(ArrayList<Plan> planlist) throws IOException {

        final ArrayList<Plan> resultList = planlist;

        AbstractListModel<String> model = new AbstractListModel<String>() {
            /**
             *
             */
            private static final long serialVersionUID = 1L;
            private ArrayList<Plan> planlist = resultList;
            private String[] list;
            private JTimepiece t = new JTimepiece();

            private String[] initList() {
                if (planlist != null) {
                    list = new String[planlist.size()];
                    //初始化Plan[]数组，按planid大小获得
                    for (int i = 0; i < planlist.size(); i++) {
                        Plan tempplan = planlist.get(i);

                        Date startdate = tempplan.getStartdate();
                        Date enddate = tempplan.getEnddate();
                        String str1 = t.convertDateToString(startdate, "yyyy'年'MM'月'dd'日'");
                        String str2 = t.convertDateToString(enddate, "yyyy'年'MM'月'dd'日'");

                        list[i] = tempplan.getPlantitle() + " " + str1 + "-" + str2;
                    }
                } else {
                    list = null;
                }
                return list;
            }

            @Override
            public int getSize() {
                if (initList() != null) {
                    return initList().length;
                } else {
                    return 0;
                }
            }

            @Override
            public String getElementAt(int index) {
                String[] templist = initList();
                if (templist != null) {
                    return templist[index];
                } else {
                    return null;
                }
            }
        };

        return model;
    }

    /**
     * 根据日期范围搜索计划
     *
     * @param startdate
     * @param enddate
     * @return 返回所有符合条件的计划，若无则返回空
     * @throws IOException
     */
    public static ArrayList<Plan> searchPlanByDateRange(Date startdate, Date enddate) throws IOException {
        return client.searchPlanByDates(startdate, enddate);
    }
}
