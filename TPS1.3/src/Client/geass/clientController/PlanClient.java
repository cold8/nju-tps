package Client.geass.clientController;

import Client.geass.clientController.searchInfoController.findTripImp;
import Client.geass.clientController.searchInfoController.findTripService;
import Client.geass.net.ClientMessageSender;
import Shared.geass.dataPOJO.City;
import Shared.geass.dataPOJO.Phase;
import Shared.geass.dataPOJO.Plan;
import Shared.geass.message.request.user.CheckNameRequest;
import Shared.geass.message.request.plan.CheckPlanTitleRequest;
import Shared.geass.message.request.plan.ClearDayRequest;
import Shared.geass.message.request.plan.CreatePlanRequest;
import Shared.geass.message.request.plan.DeletePhaseRequest;
import Shared.geass.message.request.plan.DeletePlanRequest;
import Shared.geass.message.request.plan.GetCityListRequest;
import Shared.geass.message.request.plan.GetCountryListRequest;
import Shared.geass.message.request.plan.GetDayRequest;
import Shared.geass.message.request.plan.GetMaxCountOfPhasesRequest;
import Shared.geass.message.request.plan.GetPhaseOfDayRequest;
import Shared.geass.message.request.plan.GetPhaseRequest;
import Shared.geass.message.request.plan.GetPlanListRequest;
import Shared.geass.message.request.plan.GetPlanRequest;
import Shared.geass.message.request.plan.InsertPhaseRequest;
import Shared.geass.message.request.plan.SetPlanEnddateRequest;
import Shared.geass.message.request.plan.SetPlanStartdateRequest;
import Shared.geass.message.request.plan.SetPlantitleRequest;
import Shared.geass.message.request.plan.ValidPhaseRequest;
import Shared.geass.message.response.ConfirmResponse;
import Shared.geass.message.response.plan.GetCityListResponse;
import Shared.geass.message.response.plan.GetCountryListResponse;
import Shared.geass.message.response.plan.GetDayResponse;
import Shared.geass.message.response.plan.GetMapCityResponse;
import Shared.geass.message.response.plan.GetMaxCountOfPhasesResponse;
import Shared.geass.message.response.plan.GetPhaseOfDayResponse;
import Shared.geass.message.response.plan.GetPhaseResponse;
import Shared.geass.message.response.plan.GetPlanListResponse;
import Shared.geass.message.response.plan.GetPlanResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class PlanClient {

    private static final String coutryname = null;
	private static PlanClient instance ;
    private ClientMessageSender infoSender;
   // private int i = 0;

    public PlanClient() 
    {

    }


    public static PlanClient getInstance(){
        if(instance == null){
            System.out.println("no planclient instance");
            instance = new PlanClient()  ;
        }
        return instance;
    }

    public void setInfoSender(ClientMessageSender infoSender){
        this.infoSender = infoSender;
    }
    
    public boolean sendUserName(String userName) throws IOException{
        Object object = infoSender.sendRequest(new CheckNameRequest(userName));
        ConfirmResponse confirmResponse = (ConfirmResponse)object;
        return confirmResponse.isConfirmed();
    }


	public Plan createPlan(String username,String title, Date begindate, Date enddate) throws IOException {
		Object obj = infoSender.sendRequest(new CreatePlanRequest(username,title,begindate,enddate));
		GetPlanResponse response = (GetPlanResponse)obj;
		return response.getPlan();
	}


	public boolean checkTitle(String title) throws IOException {
		Object obj = infoSender.sendRequest(new CheckPlanTitleRequest(title));
		ConfirmResponse response = (ConfirmResponse)obj;
		return response.isConfirmed();
	}


	public ArrayList<Phase> getDay(int planid, Date date) throws IOException {
		Object obj = infoSender.sendRequest(new GetDayRequest(planid,date));
		GetDayResponse response = (GetDayResponse)obj;
		return response.getDay();
		
	}


	public boolean insertPhase(int planid, Date mydate, Date beginTime,
			Date endTime, String cityname, String site, String transport,
			String breakfast, String lunch, String dinner, String comment) throws IOException {
		
		Object obj = infoSender.sendRequest(new InsertPhaseRequest(planid,mydate,beginTime,endTime,cityname,site,transport,breakfast,lunch,dinner,comment));
		ConfirmResponse response = (ConfirmResponse)obj;
		return response.isConfirmed();
	}


	public boolean validPhase(int planid, Date mydate, Date beginTime,
			Date endTime) throws IOException {
		Object obj = infoSender.sendRequest(new ValidPhaseRequest(planid,mydate,beginTime,endTime));
		ConfirmResponse response = (ConfirmResponse)obj;
		return response.isConfirmed();
	}


	public Plan getPlan(int planid) throws IOException {
		Object obj = infoSender.sendRequest(new GetPlanRequest(planid));
		GetPlanResponse response = (GetPlanResponse)obj;
		return response.getPlan();
	}


	public int getMaxCountOfPhases(int planid) throws IOException {
		Object obj = infoSender.sendRequest(new GetMaxCountOfPhasesRequest(planid));
		GetMaxCountOfPhasesResponse response = (GetMaxCountOfPhasesResponse)obj;
		return response.getMax();
	}

	public ArrayList<Phase> getPhaseOfDay(int planid, Date date) throws IOException {
		Object obj = infoSender.sendRequest(new GetPhaseOfDayRequest(planid,date));
		GetPhaseOfDayResponse response = (GetPhaseOfDayResponse)obj;
		return response.getPhaseArray();
	}


	public String[] getCountryList() throws IOException {
		Object obj = infoSender.sendRequest(new GetCountryListRequest());
		GetCountryListResponse response = (GetCountryListResponse)obj;
		return response.getCountryList();
	}


	public String[] getCityList(String countryname) throws IOException {
		//i++;
		//System.out.println("planclient "+i+"   "+countryname);
		
		GetCityListRequest request = new  GetCityListRequest(countryname);
		Object obj = infoSender.sendRequest(request);
		GetCityListResponse response = (GetCityListResponse)obj;

		return response.getCityList();
	}


	public ArrayList<Plan> getPlanList() throws IOException {
		Object obj = infoSender.sendRequest(new GetPlanListRequest());
		GetPlanListResponse response = (GetPlanListResponse)obj;
		return response.getPlanList();
	}


	public boolean deletePlan(int planid) throws IOException {
		Object obj = infoSender.sendRequest(new DeletePlanRequest(planid));
		ConfirmResponse response = (ConfirmResponse)obj;
		return response.isConfirmed();
	}


	public boolean setPlantitle(int planid, String newPlantitle) throws IOException {
		Object obj = infoSender.sendRequest(new SetPlantitleRequest(planid,newPlantitle));
		ConfirmResponse response = (ConfirmResponse)obj;
		return response.isConfirmed();
	}


	public boolean setPlanStartdate(int planid, Date newStartdate) throws IOException {
		Object obj = infoSender.sendRequest(new SetPlanStartdateRequest(planid,newStartdate));
		ConfirmResponse response = (ConfirmResponse)obj;
		return response.isConfirmed();
	}


	public boolean setPlanEnddate(int planid, Date newEnddate) throws IOException {
		Object obj = infoSender.sendRequest(new SetPlanEnddateRequest(planid,newEnddate));
		ConfirmResponse response = (ConfirmResponse)obj;
		return response.isConfirmed();
	}


	public Phase getPhase(int planid, Date begintime, Date endtime) throws IOException {
		Object obj = infoSender.sendRequest(new GetPhaseRequest(planid,begintime,endtime));
		GetPhaseResponse response = (GetPhaseResponse)obj;
		return response.getPhase();
	}


	public boolean deletePhase(int phaseid) throws IOException {
		Object obj = infoSender.sendRequest(new DeletePhaseRequest(phaseid));
		ConfirmResponse response = (ConfirmResponse)obj;
		return response.isConfirmed();
	}


	public ArrayList<Plan> searchPlanByCity(String cityname) throws IOException {
		findTripService service = new findTripImp();
		return service.SearchbyCity(cityname);
	}


	public ArrayList<Plan> searchPlanByDates(Date startdate, Date enddate) throws IOException {
		findTripService service = new findTripImp();
		return service.SearchbyDate(startdate, enddate);
	}


	public ArrayList<Plan> searchPlanByCityDate(Date date, String city) throws IOException {
		findTripService service = new findTripImp();
		return service.SearchbyCityDate(city, date);
	}


	public boolean clearDay(int planid, Date date) throws IOException {
		Object obj = infoSender.sendRequest(new ClearDayRequest(planid, date));
		ConfirmResponse response = (ConfirmResponse)obj;
		return response.isConfirmed();
	}
	


}
