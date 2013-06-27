package Client.geass.clientController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import Shared.geass.dataPOJO.City;
import Shared.geass.dataPOJO.Plan;
import Shared.geass.message.request.plan.CheckPlanTitleRequest;
import Shared.geass.message.request.search.SearchCityByNameRequest;
import Shared.geass.message.request.search.SearchCityBySeasonRequest;
import Shared.geass.message.request.search.SearchPlanByCityDate;
import Shared.geass.message.request.search.SearchPlanByTwoDate;
import Shared.geass.message.response.ConfirmResponse;
import Shared.geass.message.response.search.GetCityByNameResponse;
import Shared.geass.message.response.search.GetCityBySeasonResponse;
import Shared.geass.message.response.search.GetPlanByCityDateResponse;
import Shared.geass.message.response.search.GetPlanByTwoDateResponse;

import Client.geass.net.ClientMessageSender;

public class CityClient {
	
	private static CityClient instance ;
    private ClientMessageSender infoSender;

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
    }
    
	public boolean checkTitle(String title) throws IOException {
		Object obj = infoSender.sendRequest(new CheckPlanTitleRequest(title));
		ConfirmResponse response = (ConfirmResponse)obj;
		return response.isConfirmed();
	}
	
	public ArrayList<City> searchCityByName(String cityname) throws IOException{
		Object obj = infoSender.sendRequest(new SearchCityByNameRequest(cityname));
		GetCityByNameResponse response = (GetCityByNameResponse)obj;
		return response.getCityByName();
	}
	
	public ArrayList<City> searchCityBySeason(String season) throws IOException{
		Object obj = infoSender.sendRequest(new SearchCityBySeasonRequest(season));
		GetCityBySeasonResponse response = (GetCityBySeasonResponse)obj;
		return response.getCityBySeason();
	}
	
	public ArrayList<Plan> searchPlanByTwoDate(Date beginDate, Date endDate)throws IOException{
		Object obj = infoSender.sendRequest(new SearchPlanByTwoDate(beginDate, endDate));
		GetPlanByTwoDateResponse response = (GetPlanByTwoDateResponse)obj;
		return response.GetCityByTwoDate();
	}

	public ArrayList<Plan> searchPlanByCityDate(String cityName, Date indate) throws IOException{
		Object obj = infoSender.sendRequest(new SearchPlanByCityDate(cityName, indate));
		GetPlanByCityDateResponse response = (GetPlanByCityDateResponse)obj;
		return response.GetCityByCityDate();
	}

}