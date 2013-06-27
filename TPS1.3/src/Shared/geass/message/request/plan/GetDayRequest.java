package Shared.geass.message.request.plan;

import java.util.ArrayList;
import java.util.Date;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.dataPOJO.Phase;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.Response;
import Shared.geass.message.response.plan.GetDayResponse;

public class GetDayRequest extends Request {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int planid;
	private Date date;
	
	public GetDayRequest(int planid, Date date){
		this.planid = planid;
		this.date = date;
	}

	@Override
	public Response invoke() {
		ArrayList<Phase> phases = DatabaseController.getInstance().getDay(planid, date);
		return new GetDayResponse(phases);
	}

}
