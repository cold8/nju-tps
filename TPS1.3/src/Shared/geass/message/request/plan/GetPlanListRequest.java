package Shared.geass.message.request.plan;

import java.util.ArrayList;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.dataPOJO.Plan;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.Response;
import Shared.geass.message.response.plan.GetPlanListResponse;

public class GetPlanListRequest extends Request {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Response invoke() {
		ArrayList<Plan> planList = DatabaseController.getInstance().getPlanList();
		return new GetPlanListResponse(planList);
	}

}
