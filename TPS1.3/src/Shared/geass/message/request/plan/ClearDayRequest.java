package Shared.geass.message.request.plan;

import java.util.Date;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.ConfirmResponse;
import Shared.geass.message.response.Response;

public class ClearDayRequest extends Request {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int planid;
	private Date date;

	public ClearDayRequest(int planid, Date date) {
		this.planid = planid;
		this.date = date;
	}

	@Override
	public Response invoke() {
		boolean succeed = DatabaseController.getInstance().clearDay(planid,date);
		return new ConfirmResponse(succeed);
	}

}
