package Client.geass.clientController.searchController;

import Client.geass.clientController.CityClient;
import Shared.geass.dataPOJO.City;
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

  

    //====================================================================================
    //数据 获取 
    //====================================================================================
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
       return citylist==null ;
    }

    @Override
    public ArrayList searchPlanByTwoDate(Date beginDate, Date endDate) {
        try {        
            return cityClient.searchPlanByTwoDate(beginDate, endDate);
        } catch (IOException ex) {
            
            Logger.getLogger(CityLogic.class.getName()).log(Level.SEVERE, null, ex);return null ;
        }
        
    }

    @Override
    public ArrayList searchPlanByCityDate(String searchCondition, Date date) {
        try {
            return cityClient.searchPlanByCityDate(searchCondition, date);
        } catch (IOException ex) {
            Logger.getLogger(CityLogic.class.getName()).log(Level.SEVERE, null, ex);
            return null ;
        }
    }

    @Override
    public ArrayList getPhase(int planid) {
        try {
            return cityClient.getPhase(planid);
        } catch (IOException ex) {
            Logger.getLogger(CityLogic.class.getName()).log(Level.SEVERE, null, ex);
            return null ;
        }
    }

   
  
    
 


  
   
   
}
