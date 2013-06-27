package Shared.geass.message.response.search;

import Shared.geass.dataPOJO.Plan;
import Shared.geass.message.response.Response;

public class GetPlanByCityResponse extends Response {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Plan[] planlist;

	public GetPlanByCityResponse(Plan[] planlist) {
		this.planlist = planlist;
	}

	public Plan[] getPlanList() {
		return planlist;
	}

}
