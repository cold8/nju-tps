package Shared.geass.message.request.plan;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.ConfirmResponse;
import Shared.geass.message.response.Response;

public class DeletePlanRequest extends Request {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int planid;

	public DeletePlanRequest(int planid) {
		this.planid = planid;
	}

	@Override
	public Response invoke() {
		boolean succeed = DatabaseController.getInstance().deletePlan(planid);
		return new ConfirmResponse(succeed);
	}

}
