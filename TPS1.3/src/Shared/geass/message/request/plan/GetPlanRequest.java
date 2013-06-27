package Shared.geass.message.request.plan;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.dataPOJO.Plan;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.Response;
import Shared.geass.message.response.plan.GetPlanResponse;

public class GetPlanRequest extends Request {

	private static final long serialVersionUID = 1L;
	private int planid;
	
	public GetPlanRequest(int planid){
		this.planid = planid;
	}

	@Override
	public Response invoke() {
		Plan plan = DatabaseController.getInstance().getPlan(planid);
		return new GetPlanResponse(plan);
	}

}
