package Client.geass.clientController.planController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.sourceforge.jtimepiece.JTimepiece;
import Shared.geass.dataPOJO.Phase;
import Shared.geass.dataPOJO.Plan;
import Client.geass.clientController.PlanClient;

public class GuiModifyPlanController {

    private static PlanClient client = PlanClient.getInstance();

    ;
	
	public GuiModifyPlanController() {
    }

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
                    }
                } else {
                    content = null;
                }
            }
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
     * 将一个Phase时间段的开始或结束时间转换成String字符串
     *
     * @param time
     * @return String类型的时间
     *//*
     private static String convertTimeToString(Date time){
		
     JTimepiece t = new JTimepiece();
     String str;
     int minute = t.getMinute(time);
		
     if(minute<10)
     str = t.getHourOfDay(time)+":0"+minute;
     else
     str = t.getHourOfDay(time)+":"+minute;

     return str;
     }*/

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
     * 修改计划标题
     *
     * @param planid
     * @param newPlantitle
     * @return 修改成功与否
     * @throws IOException
     */
    public static boolean setTitle(int planid, String newPlantitle) throws IOException {
        return client.setPlantitle(planid, newPlantitle);
    }

    /**
     * 获得一个由id指定的计划
     *
     * @param planid
     * @return 一个Plan类型对象
     * @throws IOException
     */
    public static Plan getPlan(int planid) throws IOException {
        return client.getPlan(planid);
    }

    /**
     * 将selector中的String类型日期转换成util.Date类型日期
     *
     * @param datestr
     * @return 一个util.Date类型日期
     */
    public static Date convertSelectorToDate(String datestr) {
        String[] str0 = datestr.split("年");//{"yyyy","M月d日"}
        String[] str1 = str0[1].split("月");//{"MM","d日"}
        String[] str2 = str1[1].split("日");//{"dd"}

        //DATE----------------------------------------------------------------------
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt(str0[0]), Integer.parseInt(str1[0]) - 1, Integer.parseInt(str2[0]), 0, 0, 0);
        Date d = cal.getTime();

        return d;
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
        JTimepiece t = new JTimepiece();

        ArrayList<Phase> phases = client.getDay(planid, date);
        Phase phase;
        DefaultTableModel model;
        String[][] content;
        int row;

        if (phases != null) {
            row = phases.size();

            content = new String[row][10];
            for (int i = 0; i < row; i++) {
                phase = phases.get(i);

                content[i][0] = t.convertDateToString(phase.getBegintime(), "HH':'mm");
                content[i][1] = t.convertDateToString(phase.getEndtime(), "HH':'mm");
                content[i][2] = phase.getCityname();
                content[i][3] = phase.getSite();
                content[i][4] = phase.getTransport();
                content[i][5] = phase.getBreakfast();
                content[i][6] = phase.getLunch();
                content[i][7] = phase.getDinner();
                content[i][8] = phase.getComment();
                content[i][9] = "点击选择";
            }

            model = new DefaultTableModel(
                    content,
                    new String[]{
                "开始时间", "结束时间", "城市", "景点", "交通", "早餐", "午餐", "晚餐", "备忘", "删除时间段"
            }) {
                private static final long serialVersionUID = 1L;

                @Override
                public boolean isCellEditable(int row, int column) {
                    return true;
                }
            };
        } else {
            content = null;
            model = new DefaultTableModel(
                    content,
                    new String[]{
                "开始时间", "结束时间", "城市", "景点", "交通", "早餐", "午餐", "晚餐", "备忘", "删除时间段"
            }) {
                private static final long serialVersionUID = 1L;

                @Override
                public boolean isCellEditable(int row, int column) {
                    return true;
                }
            };
        }

        return model;
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
        return client.getCityList(countryname);
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
        beginTime = t.setMinute(beginTime, Integer.parseInt(beginMinute));

        Date endTime = t.setHour(mydate, Integer.parseInt(endHour));
        endTime = t.setMinute(endTime, Integer.parseInt(endMinute));

        if (client.validPhase(planid, mydate, beginTime, endTime)) {
            client.insertPhase(planid, mydate, beginTime, endTime, cityname, site, transport, breakfast, lunch, dinner, comment);
            return true;
        } else {
            return false;
        }

    }

    /**
     * 用于在表格中修改一天的计划 如果表格模型参数内容中检查到冲突的时间段，则修改失败
     *
     * @param planid
     * @param datestr
     * @param tableModel
     * @return 修改结果
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static boolean modifyDayOfPlan(int planid, String datestr,
            TableModel tableModel) throws IOException, ClassNotFoundException {

        Date date = convertSelectorToDate(datestr);
        ArrayList<Phase> phases = client.getDay(planid, date);//为了获取原tableModel的phaseid
        boolean isSucceed = true;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            int phaseid = phases.get(i).getPhaseid();
            Date begintime = convertStringToTime(datestr, (String) tableModel.getValueAt(i, 0));
            Date endtime = convertStringToTime(datestr, (String) tableModel.getValueAt(i, 1));//endtime
            String cityname = (String) tableModel.getValueAt(i, 2);
            String site = (String) tableModel.getValueAt(i, 3);
            String transport = (String) tableModel.getValueAt(i, 4);
            String breakfast = (String) tableModel.getValueAt(i, 5);
            String lunch = (String) tableModel.getValueAt(i, 6);
            String dinner = (String) tableModel.getValueAt(i, 7);
            String comment = (String) tableModel.getValueAt(i, 8);
            boolean delete = false;
            if (tableModel.getValueAt(i, 9).getClass().equals(Class.forName("java.lang.String"))) {
                delete = false;
            } else {
                delete = (boolean) tableModel.getValueAt(i, 9);
            }


            if (delete) {
                if (client.deletePhase(phaseid) == false) {
                    isSucceed = false;
                }
                break;
            } //跳过检查重复步骤：可以覆盖原来的时间段
            else {
                if (client.insertPhase(planid, date, begintime, endtime, cityname, site, transport, breakfast, lunch, dinner, comment) == false) {
                    isSucceed = false;
                }
                break;
            }

        }

        return isSucceed;
    }

    /**
     * 用于读取表格内容 将一个HH:mm形式的字符串转换成util.Date类型的时间
     *
     * @param timestr
     * @param datestr
     * @return util.Date类型的时间
     */
    private static Date convertStringToTime(String datestr, String timestr) {

        Date date = convertSelectorToDate(datestr);
        String[] timeStr = new String[2];
        int hour = -1;
        int minute = -1;

        timeStr = timestr.split(":");
        hour = Integer.parseInt(timeStr[0]);
        if (timeStr[1].charAt(0) == '0') {
            minute = Character.getNumericValue(timeStr[1].charAt(1));
        } else {
            minute = Integer.parseInt(timeStr[1]);
        }

        JTimepiece t = new JTimepiece();
        date = t.setHourOfDay(date, hour);
        date = t.setMinute(date, minute);

        return date;
    }

    /**
     * 用于读取表格内容 将一个HH:mm形式的字符串转换成util.Date类型的时间
     *
     * @param timestr
     * @param date
     * @return util.Date类型的时间
     */
    private static Date convertStringToTime(Date date, String timestr) {

        //Date date = convertSelectorToDate(datestr);
        String[] timeStr = new String[2];
        int hour = -1;
        int minute = -1;

        timeStr = timestr.split(":");
        hour = Integer.parseInt(timeStr[0]);
        if (timeStr[1].charAt(0) == '0') {
            minute = Character.getNumericValue(timeStr[1].charAt(1));
        } else {
            minute = Integer.parseInt(timeStr[1]);
        }

        JTimepiece t = new JTimepiece();
        date = t.setHourOfDay(date, hour);
        date = t.setMinute(date, minute);

        return date;
    }

    /**
     * 用于在表格中修改一天的计划 检查表格模型参数中所有时间字段的内容是否输入正确
     *
     * @param tableModel
     * @return 检查结果
     */
    public static boolean validTableTime(TableModel tableModel) {
        String[] begintimeArray = new String[tableModel.getRowCount()];
        String[] endtimeArray = new String[tableModel.getRowCount()];;
        boolean valided = true;

        for (int i = 0; i < tableModel.getRowCount(); i++) {
            begintimeArray[i] = (String) tableModel.getValueAt(i, 0);
            endtimeArray[i] = (String) tableModel.getValueAt(i, 1);
        }

        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (validTableTime(begintimeArray[i], endtimeArray[i]) == false) {
                valided = false;
                break;
            }
        }

        return valided;


    }

    /**
     * 用于修改一天的表格 检查一个时间段开始时间和结束时间字符串是否符合格式
     *
     * @param begintime
     * @param endtime
     * @return 检查结果
     */
    public static boolean validTableTime(String begintime, String endtime) {
        String[] beginStr = new String[2];
        String[] endStr = new String[2];
        String beginhour = null;
        String beginminute = null;
        String endhour = null;
        String endminute = null;
        beginStr = begintime.split(":");
        endStr = endtime.split(":");

        if (beginStr.length != 2 || endStr.length != 2) {
            return false;
        } else {

            beginhour = beginStr[0];
            endhour = endStr[0];
            if (beginStr[1].charAt(0) == '0') {
                beginminute = Character.toString(beginStr[1].charAt(1));
            } else {
                beginminute = beginStr[1];
            }
            if (endStr[1].charAt(0) == '0') {
                endminute = Character.toString(endStr[1].charAt(1));
            } else {
                endminute = endStr[1];
            }

            if (validTime(beginhour, beginminute, endhour, endminute) == 1) {
                return true;
            } else {
                return false;
            }
        }

    }

    /**
     * 重新设置计划的开始日期
     *
     * @param planid
     * @param oldStartdate
     * @param newStartdate
     * @param isDeleteConfirmed true:确认要删除新日期之前的计划内容 false：尚未确认删除新日期之前的计划内容
     * @return 设置结果 返回2，表示没有更改 返回1，表示该新开始日期在原来开始日期之前；或已确认删除，成功修改
     * 返回0，表示该开始日期在原来开始日期之后，在原来结束日期之前，需要确认是否删除部分计划内容
     * 返回-1，表示该开始日期在原来结束日期之后或相等，不允许设置，要求先设置结束日期
     * @throws IOException
     */
    public static int setPlanStartdate(int planid, Date oldStartdate, Date oldEnddate, Date newStartdate, boolean isDeleteConfirmed) throws IOException {

        if (oldStartdate.toString().equals(newStartdate.toString())) {
            return 2;
        } else {
            if (newStartdate.before(oldStartdate)) {
                client.setPlanStartdate(planid, newStartdate);
                return 1;
            } else if (newStartdate.before(oldEnddate)) {
                if (isDeleteConfirmed) {
                    client.setPlanStartdate(planid, newStartdate);
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return -1;
            }

        }
    }

    /**
     * 重新设置计划的结束日期
     *
     * @param planid
     * @param oldEnddate
     * @param newEnddate
     * @param isDeleteConfirmed true:确认要删除新日期之后的计划内容 false：尚未确认删除新日期之后的计划内容
     * @return 设置结果 返回2，表示没有更改 返回1，表示该新结束日期在原来结束日期之后
     * 返回0，表示该结束日期在原来结束日期之前，在原来开始日期之后，需要确认是否删除部分计划内容
     * 返回-1，表示该开始日期在原来开始日期之前，不允许设置，要求先设置开始日期
     * @throws IOException
     */
    public static int setPlanEnddate(int planid, Date oldEnddate, Date oldStartdate, Date newEnddate, boolean isDeleteConfirmed) throws IOException {

        if (oldEnddate.toString().equals(newEnddate.toString())) {
            return 2;
        } else {
            if (newEnddate.after(oldEnddate)) {
                client.setPlanEnddate(planid, newEnddate);
                return 1;
            } else if (newEnddate.after(oldStartdate)) {
                if (isDeleteConfirmed) {
                    client.setPlanEnddate(planid, newEnddate);
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return -1;
            }

        }
    }

    /**
     * 返回一个由planid和phaseinfo解析的Phase
     *
     * @param planid
     * @param phaseInfo
     * @return
     * @throws IOException
     */
    public static Phase getPhase(int planid, Date date, String phaseInfo) throws IOException {

        //phaseInfo的格式：HH:mm-HH:mm+" 在 "+phase.getCityname()+"-"+phase.getSite()+"，交通方式："+phase.getTransport();

        String begintimeStr = phaseInfo.substring(0, 5);//endindex的字符不会被记录，需要将endindex记录到最后一个字符之后的那个字符上
        String endtimeStr = phaseInfo.substring(6, 11);
        Date begintime = convertStringToTime(date, begintimeStr);
        Date endtime = convertStringToTime(date, endtimeStr);

        return client.getPhase(planid, begintime, endtime);
    }

    /**
     * 删除一个由id指定的Phase
     *
     * @param phaseid
     * @return 删除结果
     * @throws IOException
     */
    public static boolean deletePhase(int phaseid) throws IOException {
        return client.deletePhase(phaseid);
    }

    /**
     * 清空一天的计划内容
     *
     * @param planid
     * @param datestr
     * @return 清空结果
     * @throws IOException
     */
    public static boolean clearDay(int planid, String datestr) throws IOException {
        Date date = convertSelectorToDate(datestr);
        return client.clearDay(planid, date);
    }
}
