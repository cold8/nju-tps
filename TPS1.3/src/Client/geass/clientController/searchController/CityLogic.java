package Client.geass.clientController.searchController;

import Client.geass.clientController.CityClient;
import Shared.geass.dataPOJO.City;
import Shared.geass.dataPOJO.Phase;
import Shared.geass.dataPOJO.Plan;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CityLogic implements CityLogicInterface {

    private CityClient cityClient;
    private static City cityR;
    private ArrayList<City> citylist;

    public CityLogic() {
        // TODO Auto-generated constructor stub
        cityClient = CityClient.getInstance();

        //   cityClient = new CityClient();
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
        cityR = citylist.get(index);
        return cityR.getDescription();
    }

    /**
     *获取数据
     * @param city
     * @return
     */
    public ArrayList<City> SearchByName(String city) {

        try {
            citylist = cityClient.searchCityByName(city);
            return citylist;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("获取城市 失败");
            return null;
        }

    }

    public ArrayList<City> SearchBySeason(String season) {
        try {
            citylist = cityClient.searchCityBySeason(season);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println(" 获取信息失败            ");
        }
        return citylist;

    }

    public boolean isCity() {
        return citylist == null;
    }

    @Override
    public ArrayList searchPlanByTwoDate(Date beginDate, Date endDate) {
        try {
            return cityClient.searchPlanByTwoDate(beginDate, endDate);
        } catch (IOException ex) {

            Logger.getLogger(CityLogic.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public ArrayList searchPlanByCityDate(String searchCondition, Date date) {
        try {
            return cityClient.searchPlanByCityDate(searchCondition, date);
        } catch (IOException ex) {
            Logger.getLogger(CityLogic.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList getPhase(int planid) {
        try {
            return cityClient.getPhase(planid);
        } catch (IOException ex) {
            Logger.getLogger(CityLogic.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public City getRandomCity() {
        try {
            return cityClient.randomSearch();
        } catch (IOException ex) {
            Logger.getLogger(CityLogic.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList getPlanByUser(String username) {
        try {
            
            return cityClient.getPlanByUser(username);
        } catch (IOException ex) {
            Logger.getLogger(CityLogic.class.getName()).log(Level.SEVERE, null, ex);
            return null ;
        }
    }

    @Override
    public boolean insertPhase(ArrayList<Phase> phase) {
        try {
            return cityClient.insertPhase(phase);
        } catch (IOException ex) {
            Logger.getLogger(CityLogic.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean insertPlan(Plan plan) {
        try {
            return cityClient.insertPlan(plan);
        } catch (IOException ex) {
            Logger.getLogger(CityLogic.class.getName()).log(Level.SEVERE, null, ex);
            return false ;
        }
    }

   
  
    
 


  
   
   
}
