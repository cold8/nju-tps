package Shared.geass.message.response.plan;

import java.util.ArrayList;

import Shared.geass.dataPOJO.Plan;
import Shared.geass.message.response.Response;

public class GetPlanListResponse extends Response {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Plan> planList;

	public GetPlanListResponse(ArrayList<Plan> planList) {
		this.planList = planList;
	}

	public ArrayList<Plan> getPlanList() {
		return planList;
	}

}
