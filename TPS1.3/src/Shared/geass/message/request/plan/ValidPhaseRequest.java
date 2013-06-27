package Shared.geass.message.request.plan;

import java.util.Date;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.ConfirmResponse;
import Shared.geass.message.response.Response;

public class ValidPhaseRequest extends Request {
	
	private static final long serialVersionUID = 1L;
	private int planid;
	private Date date, beginTime, endTime;
	
	public ValidPhaseRequest(int planid, Date date, Date beginTime, Date endTime){
		this.planid = planid;
		this.date = date;
		this.beginTime = beginTime;
		this.endTime = endTime;
	}

	@Override
	public Response invoke() {
		boolean confirmed = DatabaseController.getInstance().validPhase(planid,date,beginTime,endTime);
        return new ConfirmResponse(confirmed);
	}

}
