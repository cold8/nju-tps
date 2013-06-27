package Client.geass.gui.travellerGUI;

import Shared.geass.dataPOJO.City;
import Shared.geass.dataPOJO.Plan;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class TableModel {

    
    public static TableModel instance;
    
    public static TableModel getInstance(){
        if( instance == null )
            return new TableModel();
        return instance;
        
    }
    
    
    /**
     *
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
     *
     */
    public static Vector<String> PLAN_COLUMN_NAMES =
            new Vector<String>(Arrays.asList("计划名","创建者", "开始时间", "结束时间", "计划简介"));

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
        DateFormat dateformat = new SimpleDateFormat("yyyyy-MM-dd");  //("yyyyy-MM-dd HH:mm:ss");
        list.add(plan.getPlantitle());
        list.add(plan.getUsername());
        list.add(dateformat.format(plan.getStartdate()));
        list.add(dateformat.format(plan.getEnddate()));
        return list;
    }
}

class TravellerTableModel extends DefaultTableModel {

    public TravellerTableModel(Vector<Vector<String>> data, Vector<String> columnNames) {
        super(data, columnNames);

    }
}
