package Server.geass.database;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import Shared.geass.dataPOJO.Plan;
import Shared.geass.dataPOJO.User;
import Shared.geass.message.request.plan.GetCityListRequest;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 13-4-10
 * Time: 上午1:15
 * To change this template use File | Settings | File Templates.
 */
public class test {
    public static void main(String args[]){

        User user = new User("d","d","d","d","d","d");
        UserDAO dBuser = new UserDAO();
        user = dBuser.getUserByName("nju");
        System.out.println(user.getPassword());
        
        PlanDAO dbplan = new PlanDAO();
        //dbplan.createPlan("hi","d",new Date(),new Date());
        Plan plan = dbplan.getPlanInfo("d");
        Date a = plan.getStartdate();
        DateFormat d1 = new SimpleDateFormat("yyyyy-MM-dd HH:mm:ss"); //默认语言（汉语）下的默认风格（MEDIUM风格，比如：2008-6-16 20:54:53）
        String str1 = d1.format(a);
        String str2 = d1.format(new Date());
        System.out.println(str1+" \n"+str2);
        String cities[] = dbplan.getCityList("泰国");
        System.out.println(cities[1]);
        
		GetCityListRequest request = new  GetCityListRequest("泰国");

        



    }
}
