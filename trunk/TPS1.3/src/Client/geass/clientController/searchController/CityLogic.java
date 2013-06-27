package Client.geass.clientController.searchController;

import Client.geass.clientController.CityClient;
import Shared.geass.dataPOJO.City;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CityLogic implements CityLogicInterface {

    private CityClient cityClient;
    private static City cityR;
    private ArrayList<City> list;

    public CityLogic() {
        // TODO Auto-generated constructor stub
        cityClient = CityClient.getInstance();
        cityR = new City();
    }

    public CityLogic(CityClient cc) {
        this.cityClient = cc;
        cityR = new City();
    }

    @Override
    public String getText(String cityid) {
        // TODO Auto-generated method stub
        int index = Integer.parseInt(cityid);
        cityR = list.get(index);
        return cityR.getDescription();
    }

    @Override
    public Vector<List> getListByName(String city) {
        // TODO Auto-generated method stub
        list = SearchByName(city);
        if (list == null) {
            return null;
        } else {
            Vector<Vector<String>> nameList = new Vector<Vector<String>>();
            for (int i = 0; i < list.size(); i++) {
                nameList.add((Vector<String>) getString(list.get(i)));
            }
            return new Vector<List>(nameList);
        }
    }

    @Override
    public Vector<List> getListBySeason(String season) {
        // TODO Auto-generated method stub
        list = SearchBySeason(season);
        if (list == null) {
            return null;
        } else {
            //System.out.println(" "+ list.get(0).getCityname());
            Vector<Vector<String>> nameList = new Vector<Vector<String>>();
            for (int i = 0; i < list.size(); i++) {
                nameList.add((Vector<String>) getString(list.get(i)));
            }

            return new Vector<List>(nameList);
        }
    }

    //====================================================================================
    //
    //====================================================================================
    public ArrayList<City> SearchByName(String city) {
        ArrayList<String> clist = CleverName(city);
        ArrayList<City> rlist = new ArrayList<City>();
        if (clist.size() == 0) {
            return null;
        } else {
            System.out.println(" here1");
            try {
                for (int i = 0; i < clist.size(); i++) {
                    System.out.println(" here2");
                    rlist = cityClient.searchCityByName(clist.get(0));
                }
                iscity = false;
                return rlist;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                System.out.println("获取城市 失败");
                return null;
            }
        }
    }
    City c = new City("1", "南京", "中国", "江苏", "南京很美", "春天", " ", "1", "1");

    public ArrayList<City> SearchBySeason(String season) {
        String s = CleverSeason(season);
        ArrayList<City> list = new ArrayList<City>();
        if (s == null) {
            return null;
        } else {
            isSeason = false;
            try {
                System.out.println("a");
                list = cityClient.searchCityBySeason(s);
                System.out.println("b");
                //System.out.println("list 的大小是多少呢 "+ list.size());

                //list.remove(0);
                //System.out.println("删掉之后的"+ list.size());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                System.out.println(" 获取信息失败            ");
            }
            return list;

        }

    }
    String[] citylist = {"南京", "济南"};

    public ArrayList CleverName(String city) {
        ArrayList<String> namelist = new ArrayList<String>();
        //System.out.println(citylist.length+"   "+ citylist[0]);
        for (int i = 0; i < citylist.length; i++) {
            boolean b = citylist[i].contains(city);
            if (b) {
                System.out.println("1" + citylist[i]);
                iscity = true;
                namelist.add(citylist[i]);
            }
        }
        return namelist;
    }
    boolean iscity = false;
    boolean isSeason = false;

    public String CleverSeason(String season) {
        String[] summer = {"春", "夏", "秋", "冬"};
        for (int i = 0; i < 4; i++) {
            if (season.contains(summer[i])) {
                System.out.println(season);
                isSeason = true;
                return summer[i] + "天";
            }
        }
        return null;
    }

    public List getString(City city) {
        Vector<String> list = new Vector<String>();
        System.out.println(city == null);
        list.add(city.getCountry());
        list.add(city.getCityname());
        list.add(city.getBestseason());
        return list;

    }

    @Override
    public boolean isCity(String city) {
        // TODO Auto-generated method stub
        CleverName(city);
        return iscity;
    }

    @Override
    public boolean isSeason(String season) {
        // TODO Auto-generated method stub
        CleverSeason(season);
        return isSeason;
    }
}
