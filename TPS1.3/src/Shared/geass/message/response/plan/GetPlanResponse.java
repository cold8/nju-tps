package Shared.geass.message.response.plan;

import Shared.geass.dataPOJO.Plan;
import Shared.geass.message.response.Response;

public class GetPlanResponse extends Response{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Plan plan;
	
	public GetPlanResponse(Plan p){
		plan = p;
	}

	public Plan getPlan(){
		return plan;
	}

}
