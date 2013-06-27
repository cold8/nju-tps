package Shared.geass.message.request.plan;

import java.util.Date;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.ConfirmResponse;
import Shared.geass.message.response.Response;

public class SetPlanStartdateRequest extends Request {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int planid;
	private Date newStartdate;

	public SetPlanStartdateRequest(int planid, Date newStartdate) {
		this.planid = planid;
		this.newStartdate = newStartdate;
	}

	@Override
	public Response invoke() {
		boolean succeed = DatabaseController.getInstance().setPlanStartdate(planid,newStartdate);
		return new ConfirmResponse(succeed);
	}

}
