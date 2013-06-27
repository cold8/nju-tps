package Shared.geass.message.response.search;

import java.util.ArrayList;

import Shared.geass.dataPOJO.Plan;
import Shared.geass.message.response.Response;

public class GetPlanByCityDateResponse extends Response {
	private static final long serialVersionUID = 1L;
	ArrayList<Plan>  planList;
	public GetPlanByCityDateResponse(ArrayList<Plan> list){
		this.planList=list;
		
	}
    public ArrayList<Plan> GetPlanByCityDate(){
    	return planList ;
    }

}
