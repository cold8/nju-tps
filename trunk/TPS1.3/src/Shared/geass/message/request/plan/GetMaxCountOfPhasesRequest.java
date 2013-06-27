package Shared.geass.message.request.plan;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.Response;
import Shared.geass.message.response.plan.GetMaxCountOfPhasesResponse;

public class GetMaxCountOfPhasesRequest extends Request {

	private static final long serialVersionUID = 1L;
	private int planid;
	
	public GetMaxCountOfPhasesRequest(int planid){
		this.planid = planid;
	}

	@Override
	public Response invoke() {
		int max;
		max = DatabaseController.getInstance().getMaxCountOfPhases(planid);
		return new GetMaxCountOfPhasesResponse(max);
	}

}
