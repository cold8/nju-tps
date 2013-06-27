package Shared.geass.message.request.plan;

import java.util.Date;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.ConfirmResponse;
import Shared.geass.message.response.Response;

public class SetPlanEnddateRequest extends Request {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int planid;
	private Date newEnddate;
	
	public SetPlanEnddateRequest(int planid, Date newEnddate) {
		this.planid = planid;
		this.newEnddate = newEnddate;
	}

	@Override
	public Response invoke() {
		boolean succeed = DatabaseController.getInstance().setPlanEnddate(planid,newEnddate);
		return new ConfirmResponse(succeed);
	}

}
