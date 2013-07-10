package Client.geass.clientController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import Shared.geass.dataPOJO.City;
import Shared.geass.dataPOJO.Plan;
import Shared.geass.message.request.plan.CheckPlanTitleRequest;
import Shared.geass.message.request.search.SearchCityByNameRequest;
import Shared.geass.message.request.search.SearchCityBySeasonRequest;
import Shared.geass.message.request.search.SearchPlanByCityDateRequest;
import Shared.geass.message.request.search.SearchPlanByTwoDateRequest;
import Shared.geass.message.response.ConfirmResponse;
import Shared.geass.message.response.search.GetCityByNameResponse;
import Shared.geass.message.response.search.GetCityBySeasonResponse;
import Shared.geass.message.response.search.GetPlanByCityDateResponse;
import Shared.geass.message.response.search.GetPlanByTwoDateResponse;

import Client.geass.net.ClientMessageSender;
import Shared.geass.dataPOJO.Phase;

import Shared.geass.message.request.search.GetPhaseRequest;
import Shared.geass.message.request.search.GetPlanByUserRequest;
import Shared.geass.message.request.search.GetRandomCityRequest;
import Shared.geass.message.request.search.InsertPhaseRequest;
import Shared.geass.message.request.search.InsertPlanRequest;
import Shared.geass.message.response.search.GetPhaseReponse;
import Shared.geass.message.response.search.GetPlanByUserResponse;
import Shared.geass.message.response.search.GetRandomCityResponse;
import Shared.geass.message.response.search.InsertPhaseResponse;
import Shared.geass.message.response.search.InsertPlanResponse;


public class CityClient {
	
	private static CityClient instance ;
        private static ClientMessageSender infoSender;

    public CityClient(){
    	
    	
    	
    }
    
    public static CityClient getInstance(){
        if(instance == null){
            System.out.println("no citylient instance");
            instance = new CityClient()  ;
        }
        return instance;
    }

    public void setInfoSender(ClientMessageSender infoSender){
        this.infoSender = infoSender;
       // System.out.println(""+ (infoSender==null));
    }
    
	public boolean checkTitle(String title) throws IOException {
		Object obj = infoSender.sendRequest(new CheckPlanTitleRequest(title));
		ConfirmResponse response = (ConfirmResponse)obj;
		return response.isConfirmed();
	}
	
	public ArrayList<City> searchCityByName(String cityname) throws IOException{ 
            System.out.println(""+ (infoSender==null));
		Object obj = infoSender.sendRequest(new SearchCityByNameRequest(cityname));
		GetCityByNameResponse response = (GetCityByNameResponse)obj;
		return response.getCityByName();
	}
	
	public ArrayList<City> searchCityBySeason(String season) throws IOException{
             System.out.println(""+ (infoSender==null));
		Object obj = infoSender.sendRequest(new SearchCityBySeasonRequest(season));
		GetCityBySeasonResponse response = (GetCityBySeasonResponse)obj;
		return response.getCityBySeason();
	}
	
	public ArrayList<Plan> searchPlanByTwoDate(Date beginDate, Date endDate)throws IOException{
		Object obj = infoSender.sendRequest(new SearchPlanByTwoDateRequest(beginDate, endDate));
		GetPlanByTwoDateResponse response = (GetPlanByTwoDateResponse)obj;
		return response.GetPlanList();
	}

	public ArrayList<Plan> searchPlanByCityDate(String cityName, Date indate) throws IOException{
		Object obj = infoSender.sendRequest(new SearchPlanByCityDateRequest(cityName, indate));
		GetPlanByCityDateResponse response = (GetPlanByCityDateResponse)obj;
		return response.GetPlanByCityDate();
	}
        public ArrayList<Phase> getPhase(int planid) throws IOException{
            Object obj = infoSender.sendRequest(new GetPhaseRequest(planid));
            GetPhaseReponse reponse =(GetPhaseReponse)obj;
            return reponse.getPhase();
        }
        public City randomSearch() throws IOException{
             Object obj = infoSender.sendRequest(new GetRandomCityRequest());
             GetRandomCityResponse reponse =(GetRandomCityResponse)obj;
             return reponse.getRandomCity();
        }
        public ArrayList<Plan> getPlanByUser(String userName) throws IOException{
            
             Object obj = infoSender.sendRequest(new GetPlanByUserRequest(userName));
             GetPlanByUserResponse reponse = (GetPlanByUserResponse)obj;
             return reponse.GetPlanByUser();
        }
          public boolean insertPhase(ArrayList<Phase> phase) throws IOException{
              Object obj = infoSender.sendRequest(new InsertPhaseRequest(phase.get(0)));
              InsertPhaseResponse reponse= (InsertPhaseResponse)obj;
              return reponse.InsertPhase();
          }
          public boolean insertPlan(Plan plan) throws IOException{
               Object obj = infoSender.sendRequest(new InsertPlanRequest(plan));
               InsertPlanResponse reponse =(InsertPlanResponse)obj;
               return reponse.InsertPlan();
          }
}