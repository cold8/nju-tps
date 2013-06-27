package Shared.geass.message.response.search;

import java.util.ArrayList;

import Shared.geass.dataPOJO.Plan;
import Shared.geass.message.response.Response;

public class GetPlanByTwoDateResponse extends Response{
	private static final long serialVersionUID = 1L;
	ArrayList<Plan>  planList;
	public GetPlanByTwoDateResponse(ArrayList list){
		this.planList=list;
		
	}
    public ArrayList<Plan> GetPlanList(){
    	return planList ;
    }
	

}
