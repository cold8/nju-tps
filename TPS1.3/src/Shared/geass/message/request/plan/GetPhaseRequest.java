package Shared.geass.message.request.plan;

import java.util.Date;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.dataPOJO.Phase;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.Response;
import Shared.geass.message.response.plan.GetPhaseResponse;

public class GetPhaseRequest extends Request {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int planid;
	private Date begintime;
	private Date endtime;

	public GetPhaseRequest(int planid, Date begintime, Date endtime) {
		this.planid = planid;
		this.begintime = begintime;
		this.endtime = endtime;
	}

	@Override
	public Response invoke() {
		Phase phase = DatabaseController.getInstance().getPhaseRequest(planid, begintime,endtime);
		return new GetPhaseResponse(phase);
	}

}
