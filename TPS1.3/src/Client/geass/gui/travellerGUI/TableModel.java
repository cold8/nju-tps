package Client.geass.gui.travellerGUI;

import Shared.geass.dataPOJO.City;
import Shared.geass.dataPOJO.Phase;
import Shared.geass.dataPOJO.Plan;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class TableModel {

    public static TableModel instance;

    public static TableModel getInstance() {
        if (instance == null) {
            return new TableModel();
        }
        return instance;

    }
    /**
     * 城市表格模板
     */
    public static Vector<String> CITY_COLUMN_NAMES =
            new Vector<String>(Arrays.asList("城市名", "区域", "国家", "适宜旅游时间", "简介"));

    public Vector<List> cityTableVector(List list) {
        Vector<Vector<String>> resultList;
        try {
            Vector<City> cityList = new Vector(list);
            resultList = new Vector<Vector<String>>();
            for (City c : cityList) {
                resultList.add((Vector<String>) cityToStringArray(c));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return new Vector<List>(resultList);
    }

    public List cityToStringArray(City city) {
        Vector<String> list = new Vector<String>();
        list.add(city.getCityname());
        list.add(city.getProvince());
        list.add(city.getCountry());
        list.add(city.getBestseason());
        list.add(city.getDescription());
        return list;
    }
    /**
     * 个人计划表格模板
     */
    public static Vector<String> USER_PLAN_COLUMN_NAMES =
            new Vector<String>(Arrays.asList("计划名", "开始时间", "结束时间", "计划简介"));

    public Vector<List> userPlanTableVector(List list) {
        Vector<Vector<String>> resultList;
        try {
            Vector<Plan> planList = new Vector(list);
            resultList = new Vector<Vector<String>>();
            for (Plan p : planList) {
                resultList.add((Vector<String>) planToStringArray(p));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return new Vector<List>(resultList);
    }
    
    public List userPlanToStringArray(Plan plan) {
        Vector<String> list = new Vector<String>();
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");  //("yyyy-MM-dd HH:mm:ss");
        list.add(plan.getPlantitle());
        list.add(dateformat.format(plan.getStartdate()));
        list.add(dateformat.format(plan.getEnddate()));
        return list;
    }
    
    /**
     * 计划表格模板
     */
    public static Vector<String> PLAN_COLUMN_NAMES =
            new Vector<String>(Arrays.asList("计划名", "创建者", "开始时间", "结束时间", "计划简介"));

    public Vector<List> planTableVector(List list) {
        Vector<Vector<String>> resultList;
        try {
            Vector<Plan> planList = new Vector(list);
            resultList = new Vector<Vector<String>>();
            for (Plan p : planList) {
                resultList.add((Vector<String>) planToStringArray(p));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return new Vector<List>(resultList);
    }

    public List planToStringArray(Plan plan) {
        Vector<String> list = new Vector<String>();
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");  //("yyyy-MM-dd HH:mm:ss");
        list.add(plan.getPlantitle());
        list.add(plan.getUsername());
        list.add(dateformat.format(plan.getStartdate()));
        list.add(dateformat.format(plan.getEnddate()));
        return list;
    }
    /**
     * 计划片段模板
     */
    public static Vector<String> PHASE_COLUMN_NAMES =
            new Vector<String>(Arrays.asList("当天", "开始时间", "结束时间", "城市", "交通工具", "景点", "早餐", "中餐", "晚餐", "评论"));

    public Vector<List> phaseTableVector(List list) {
        Vector<Vector<String>> resultList;
        try {
            Vector<Phase> phaseList = new Vector(list);
            resultList = new Vector<Vector<String>>();
            for (Phase p : phaseList) {
                resultList.add((Vector<String>) phaseToStringArray(p));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return new Vector<List>(resultList);
    }

    public List phaseToStringArray(Phase phase) {
        Vector<String> list = new Vector<String>();
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");//("yyyy-MM-dd HH:mm:ss");
        DateFormat datef = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        list.add(dateformat.format(phase.getDate()));
        list.add(datef.format(phase.getBegintime()));
        list.add(datef.format(phase.getEndtime()));
        list.add(phase.getCityname());
        list.add(phase.getTransport());
        list.add(phase.getSite());
        list.add(phase.getBreakfast());
        list.add(phase.getLunch());
        list.add(phase.getDinner());
        list.add(phase.getComment());
        // list.add(phase.getBegintime());
        //list.add(dateformat.format(plan.getStartdate()));
        // list.add(dateformat.format(plan.getEnddate()));
        return list;
    }
}

class TravellerTableModel extends DefaultTableModel {

    public TravellerTableModel(Vector<Vector<String>> data, Vector<String> columnNames) {
        super(data, columnNames);

    }
}
