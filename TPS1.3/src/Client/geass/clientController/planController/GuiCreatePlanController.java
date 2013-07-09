package Client.geass.clientController.planController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.sourceforge.jtimepiece.JTimepiece;

import Client.geass.clientController.PlanClient;
import Shared.geass.dataPOJO.Phase;
import Shared.geass.dataPOJO.Plan;

public class GuiCreatePlanController {

    private static PlanClient client = PlanClient.getInstance();

    ;
	
	public GuiCreatePlanController() {
    }

    /**
     * 输入标题、开始日期和结束日期建立计划
     *
     * @param title
     * @param begindate
     * @param enddate
     * @return
     * @throws IOException
     */
    public static Plan createPlan(String username, String title, Date begindate, Date enddate) throws IOException {
        if (checkTitle(title) == true) {
            return client.createPlan(username, title, begindate, enddate);
        } else {
            return null;
        }
    }

    /**
     * 用于初始化及更新表格
     *
     * @param planid
     * @param selectedDate
     * @return 一个由参数指定的计划中某一天的TableModel
     * @throws IOException
     */
    public static DefaultTableModel getUpdatedDayModel(int planid, String selectedDate) throws IOException {

        Date date = convertSelectorToDate(selectedDate);

        ArrayList<Phase> phases = client.getDay(planid, date);//如果没有存在内容，即返回null，表示空计划
        Phase phase;
        DefaultTableModel model;

        if (phases != null) {
            int row = phases.size();

            String[][] content = new String[row][8];
            for (int i = 0; i < row; i++) {
                phase = phases.get(i);

                content[i][0] = convertTimeToString(phase.getBegintime(), phase.getEndtime());
                content[i][1] = phase.getCityname();
                content[i][2] = phase.getSite();
                content[i][3] = phase.getTransport();
                content[i][4] = phase.getBreakfast();
                content[i][5] = phase.getLunch();
                content[i][6] = phase.getDinner();
                content[i][7] = phase.getComment();
            }

            model = new DefaultTableModel(
                    content,
                    new String[]{
                "时间", "城市", "景点", "交通", "早餐", "午餐", "晚餐", "备忘"
            }) {
                private static final long serialVersionUID = 1L;

                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
        } else {
            model = new DefaultTableModel(
                    null,
                    new String[]{
                "时间", "城市", "景点", "交通", "早餐", "午餐", "晚餐", "备忘"
            }) {
                private static final long serialVersionUID = 1L;

                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
        }

        return model;
    }

    /**
     * 向指定的计划和日期中插入一个新的时间段
     *
     * @param planid 计划序号
     * @param date 指定的日期
     * @param beginHour
     * @param beginMinute
     * @param endHour
     * @param endMinute
     * @param cityname
     * @param site
     * @param transport
     * @param breakfast
     * @param lunch
     * @param dinner
     * @param comment
     * @throws IOException
     * @return 如果已存在该时间段，则返回false；否则返回true
     */
    public static boolean insertPhase(int planid, String date, String beginHour,
            String beginMinute, String endHour, String endMinute, String cityname, String site,
            String transport, String breakfast, String lunch, String dinner, String comment) throws IOException {

        JTimepiece t = new JTimepiece();
        Date mydate = convertSelectorToDate(date);

        Date beginTime = t.setHour(mydate, Integer.parseInt(beginHour));
        if (beginMinute.length() == 2 && beginMinute.charAt(0) == '0') {
            beginMinute = Character.toString(beginMinute.charAt(1));
        }
        beginTime = t.setMinute(beginTime, Integer.parseInt(beginMinute));

        Date endTime = t.setHour(mydate, Integer.parseInt(endHour));
        if (endMinute.length() == 2 && endMinute.charAt(0) == '0') {
            endMinute = Character.toString(endMinute.charAt(1));
        }
        endTime = t.setMinute(endTime, Integer.parseInt(endMinute));

        if (client.validPhase(planid, mydate, beginTime, endTime)) {
            client.insertPhase(planid, mydate, beginTime, endTime, cityname, site, transport, breakfast, lunch, dinner, comment);
            return true;
        } else {
            return false;
        }

    }

    /**
     * 检查开始时间和结束时间是否格式
     *
     * @param beginHour
     * @param beginMinute
     * @param endHour
     * @param endMinute
     * @return
     */
    public static int validTime(String beginHour, String beginMinute, String endHour, String endMinute) {

        boolean cont = true;//默认格式无错误
        int flag = -3;//默认数字大小错误

        int myBeginhour = -1;
        int myBeginminute = -1;
        int myEndhour = -1;
        int myEndminute = -1;

        /**
         * 先做数字格式检查 通过后才做大小检查
         */
        try {
            myBeginhour = Integer.parseInt(beginHour);
            myBeginminute = Integer.parseInt(beginMinute);
            myEndhour = Integer.parseInt(endHour);
            myEndminute = Integer.parseInt(endMinute);
        } catch (NumberFormatException e) {
            cont = false;
            flag = -100;//非数字格式
        }

        /**
         * 数字大小检查
         */
        if (cont == true) {

            boolean isBegintimeValided;
            boolean isEndtimeValided;

            if ((myBeginhour >= 0 && myBeginhour < 24) && (myBeginminute >= 0 && myBeginminute < 60)) {
                isBegintimeValided = true;
            } else {
                isBegintimeValided = false;
            }

            if ((myEndhour >= 0 && myEndhour < 24) && (myEndminute >= 0 && myEndminute < 60)) {
                isEndtimeValided = true;
            } else {
                isEndtimeValided = false;
            }

            if (isBegintimeValided && isEndtimeValided) {
                //格式正确且大小正确
                if (myBeginhour <= myEndhour && myBeginminute <= myEndminute) {
                    flag = 1;
                } //格式正确但大小不正确
                else {
                    flag = 0;
                }
            } //开始时间格式正确但结束时间格式错误
            else if (isBegintimeValided == true && isEndtimeValided == false) {
                flag = -1;
            } //错误时间格式正确但开始时间格式错误
            else if (isBegintimeValided == false && isEndtimeValided == true) {
                flag = -2;
            } //开始结束时间格式都错误
            else {
                flag = -3;
            }
        }

        return flag;
    }

    /**
     * @param planid
     * @return id指定的计划
     * @throws IOException
     */
    public static Plan getPlan(int planid) throws IOException {
        Plan plan = null;
        plan = client.getPlan(planid);
        return plan;
    }

    /**
     * 检查计划标题是否存在
     *
     * @param title
     * @return
     * @throws IOException
     */
    private static boolean checkTitle(String title) throws IOException {
        return client.checkTitle(title);
    }

    /**
     * 将选单中的String日期对象转换成util.Date对象
     *
     * @param date
     * @return
     */
    private static Date convertSelectorToDate(String date) {

        String[] str0 = date.split("年");//{"yyyy","M月d日"}
        String[] str1 = str0[1].split("月");//{"MM","d日"}
        String[] str2 = str1[1].split("日");//{"dd"}

        //DATE----------------------------------------------------------------------
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt(str0[0]), Integer.parseInt(str1[0]) - 1, Integer.parseInt(str2[0]), 0, 0, 0);
        Date d = cal.getTime();

        return d;
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
     * 用于初始化计划展示表格
     *
     * @param planid
     * @return id指定的计划的TableModel
     * @throws IOException
     */
    public static TableModel initPlanTableModel(Plan plan) throws IOException {

        JTimepiece t = new JTimepiece();
        Date startDate = plan.getStartdate();
        Date endDate = plan.getEnddate();

        int col = calculateInterval(startDate, endDate, "D");//day size
        int row = getMaxCountOfPhases(plan.getPlanid());
        String[][] content;
        if (row == 0) {
            content = null;
        } else {
            content = new String[row][col];
        }

        //set header
        String[] header = getPlanTabelModelHeader(startDate, endDate);

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
                }
            } else {
                content = null;
            }
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

        JTimepiece t = new JTimepiece();
        String timestr = t.convertDateToString(phase.getBegintime(), "HH':'mm") + "-" + t.convertDateToString(phase.getEndtime(), "HH':'mm");
        String site = "";
        String transport = "";
        if (phase.getSite() != null) {
            site = "-" + phase.getSite();
        }
        if (phase.getTransport() != null) {
            transport = "，交通方式：" + phase.getTransport();
        }
        return timestr + " 在 " + phase.getCityname() + site + transport;
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
     * @return 获得系统支持的所有国家列表
     * @throws IOException
     */
    public static String[] getCountryList() throws IOException {
        return client.getCountryList();
    }

    /**
     * 获得系统支持的所有地区列表
     *
     * @param countryname 一个指定的国家，默认为中国
     * @return 系统支持的该国家的所有城市名称
     * @throws IOException
     */
    public static String[] getCityList(String countryname) throws IOException {
        System.out.println("guiplancontrol" + countryname);
        String[] cities = client.getCityList(countryname);
        if (cities == null) {
            System.out.println(countryname + " has no city");
            return new String[0];
        } else {
            return cities;
        }
    }

    /**
     * 获得一个计划的日期项菜单
     *
     * @param startdate
     * @param enddate
     * @return 字符串数组的日期项菜单
     */
    public static String[] getDaySelector(Date startdate, Date enddate) {

        String[] seq = null;
        int daycount = calculateInterval(startdate, enddate, "D");
        JTimepiece t = new JTimepiece();

        seq = new String[daycount];
        for (int i = 0; i < daycount; i++) {
            Date tempdate = t.addDay(startdate, i);
            seq[i] = t.convertDateToString(tempdate, "yyyy'年'MM'月'dd'日'");
        }

        return seq;
    }

    /**
     * 搜索计划
     *
     * @param cityname
     * @param date
     * @return 搜索到的所有计划，不成功则返回空值
     * @throws IOException
     */
    public static ArrayList<Plan> SearchPlanByCityDate(String cityname, Date date) throws IOException {

        if (date == null) {
            return client.searchPlanByCity(cityname);
        } else {
            return client.searchPlanByCityDate(date, cityname);
        }

    }

    /**
     * 取消计划创建时删除空计划
     *
     * @param planid
     * @throws IOException
     */
    public static boolean deletePlan(int planid) throws IOException {
        return client.deletePlan(planid);
    }

    /**
     * 根据日期和城市搜索计划
     *
     * @param city
     * @param date
     * @return 所有符合条件的计划列表
     * @throws IOException
     */
    public static ArrayList<Plan> searchPlanByCityDate(String city, Date date) throws IOException {
        return client.searchPlanByCityDate(date, city);
    }
}
