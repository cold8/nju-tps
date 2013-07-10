package Server.geass.database.Controller;

import Server.geass.database.DBcity;
import java.util.ArrayList;
import java.util.Date;

import Server.geass.database.DBplan;
import Server.geass.database.DBuser;
import Shared.geass.dataPOJO.City;
import Shared.geass.dataPOJO.Phase;
import Shared.geass.dataPOJO.Plan;
import Shared.geass.dataPOJO.User;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 13-4-29
 * Time: 上午10:52
 * To change this template use File | Settings | File Templates.
 */
public class DatabaseController implements DatabaseControllerInterface{

    private DBuser dBuser = null;
    private DBplan dBplan = null;
    private DBcity dBcity = null;
    static DatabaseController instance;

    public DatabaseController() {
        this.dBuser = new DBuser();
        this.dBplan = new DBplan();
        this.dBcity = new DBcity();
    }

    static public DatabaseController getInstance(){
        if(instance==null)
            instance=new DatabaseController();
        return instance;
    }

    @Override
    public String getLastError() {
        String errormessage = "Database Error!";
        return errormessage;
    }

    @Override
    public boolean submitUserInfo(User user) {
        return dBuser.addUser(user);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean deleteUser(User user) {
        return dBuser.deleteUser(user);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean modifyUserInfo(User user) {
        return dBuser.modifyUserInfo(user);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public User getUserInfo(String userName) {
        return dBuser.getUserByName(userName);  //To change body of implemented methods use File | Settings | File Templates.
    }
    
       @Override
   	public Plan getPlanInfo(String title) {
   		return dBplan.getPlanInfo(title);
   	}

   	@Override
   	public ArrayList<Phase> getDay(int planid, Date date) {
   		return dBplan.getDay(planid,date);
   	}

   	@Override
   	public boolean insertPhase(int planid, Date date, Date begintime,
   			Date endtime, String cityname, String site, String transport,
   			String breakfast, String lunch, String dinner, String comment) {
   		return dBplan.insertPhase(planid,date,begintime,endtime,cityname,site,transport,breakfast,lunch,dinner,comment);
   		
   	}
   	
   	public boolean insertPhase(Phase phase){
   		
   		return true;
   	}

   	@Override
   	public boolean validPhase(int planid, Date date, Date beginTime,
   			Date endTime) {
   		
   		return dBplan.validPhase(planid, date, beginTime,endTime);
   	}

   	public Plan getPlan(int planid) {
   		return dBplan.getPlan(planid);
   	}

   	public int getMaxCountOfPhases(int planid) {
   		return dBplan.getMaxCountOfPhases(planid);
   	}

   	public ArrayList<Phase> getPhaseOfDay(int planid, Date date) {
   		return dBplan.getPhaseOfDay(planid,date);
   	}

   	public String[] getCountryList() {
   		return dBplan.getCountryList();
   	}

   	public String[] getCityList(String countryname) {
   		System.out.println("dbcontroller "+ countryname);//dBplan.getCityList(countryname)[0]);
   		return dBplan.getCityList(countryname);
   	}

   	public boolean deletePlan(int planid) {
   		return dBplan.deletePlan(planid);
   	}

   	public boolean setPlantitle(int planid, String newPlantitle) {
   		return dBplan.setPlantitle(planid,newPlantitle);
   	}

   	public boolean setPlanStartdate(int planid, Date newStartdate) {
   		return dBplan.setPlanStartdate(planid,newStartdate);
   	}

   	public boolean setPlanEnddate(int planid, Date newEnddate) {
   		return dBplan.setPlanEnddate(planid,newEnddate);
   	}

   	public Phase getPhaseRequest(int planid, Date begintime, Date endtime) {
   		return dBplan.getPhase(planid,begintime,endtime);
   	}

   	public ArrayList<Plan> getPlanList() {
   		return dBplan.getPlanList();
   	}

   	public boolean deletePhase(int phaseid) {
   		return dBplan.deletePhase(phaseid);
   	}

	public Plan createPlan(String username, String title, Date begindate,
			Date enddate) {
		return dBplan.createPlan(username,title,begindate,enddate);
	}

	public boolean clearDay(int planid, Date date) {
		return dBplan.clearDay(planid,date);
	}

	public ArrayList searchPlanByCity(String cityname) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList searchCityBySeason(String cityname) {
		// TODO Auto-generated method stub
		return dBcity.searchCityBySeason(cityname);
	}

	public ArrayList searchCityByName(String cityname) {
		// TODO Auto-generated method stub
		return dBcity.searchCityByName(cityname);
	}

	public ArrayList searchPlanByTwoDate(Date beginDate, Date endDate) {
		// TODO Auto-generated method stub
		return dBcity.searchPlanByTwoDate(beginDate, endDate);
	}

	public ArrayList searchPlanByCityDate(String cityName, Date indate) {
		// TODO Auto-generated method stub
		//这里的indate 是 当天
		return dBcity.searchPlanByCityDate(cityName, indate);
	}
	
	public boolean checkPlanTitle(String plantitle){
		return dBplan.checkPlanTitle(plantitle);
	}

	public City getMapCity(String cityname) {
		// TODO Auto-generated method stub
		return null;
	}

       public ArrayList getPhase(int planid){
           return dBcity.getPhase(planid);
       }
       public City randomCity(){
           return dBcity.randomSearch();
       }


}
