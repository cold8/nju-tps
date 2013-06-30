package Server.geass.database;

import Shared.geass.dataPOJO.City;
import Shared.geass.dataPOJO.Phase;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import Shared.geass.dataPOJO.Plan;
import Shared.geass.dataPOJO.User;
import Shared.geass.message.request.plan.GetCityListRequest;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA. User: Kite Date: 13-4-10 Time: 上午1:15 To change
 * this template use File | Settings | File Templates.
 */
public class test {

    public static void main(String args[]) {

//        User user = new User("d", "d", "d", "d", "d", "d");
//        DBuser dBuser = new DBuser();
//        user = dBuser.getUserByName("nju");
//        System.out.println(user.getPassword());
//
//        DBplan dbplan = new DBplan();
        //dbplan.createPlan("hi","d",new Date(),new Date());
//        Plan plan = dbplan.getPlanInfo("d");
//        Date a = plan.getStartdate();
//        DateFormat d1 = new SimpleDateFormat("yyyyy-MM-dd HH:mm:ss"); //默认语言（汉语）下的默认风格（MEDIUM风格，比如：2008-6-16 20:54:53）
//        String str1 = d1.format(a);
//        String str2 = d1.format(new Date());
//        System.out.println(str1 + " \n" + str2);
        //String cities[] = dbplan.getCityList("泰国");
        //System.out.println(cities[1]);

        //GetCityListRequest request = new GetCityListRequest("泰国");

        DBcity dbcity = new DBcity();
        ArrayList<City> cities;
//        cities = dbcity.searchCityBySeason("冬");
//        cities = dbcity.searchCityByName("南");
//        for(City c:cities){
//            System.out.println(c.getCityname());
//        }
//        Date dddd = new Date();
//        Date dd = new Date();
//        dddd.setDate(4); dd.setDate(19);
//        dddd.setYear(2013);dd.setYear(2013);
//        dddd.setMonth(6);  dd.setMonth(6);
//        //System.out.println(cities.get(0).getDescription());
//        ArrayList<Plan> plans = dbcity.searchPlanByTwoDate(dddd, dd);
//        System.out.println(plans.get(0).getPlanid());
//        
//        //System.out.println(plans==null);
//      //  ArrayList<Plan> planss = dbcity.searchPlanByTwoDate(plans.get(0).getStartdate(), plans.get(0).getEnddate());
//      //  System.out.println(planss==null);
//        ArrayList<Phase> phase = dbcity.getPhase(3);
//        System.out.println(phase.get(0).getCityname());
        City city ;
        city=dbcity.randomSearch();
        System.out.println(city.getCityname());

    }
}
