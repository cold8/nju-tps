package Shared.geass.message.request.plan;

import java.util.Date;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.ConfirmResponse;
import Shared.geass.message.response.Response;

public class InsertPhaseRequest extends Request {

	private static final long serialVersionUID = 1L;
    int planid;
    Date date;
    Date begintime;
    Date endtime;
    String cityname;
    String transport;
    String site;
    String breakfast;
    String lunch;
    String dinner;
    String comment;
	
	public InsertPhaseRequest(int planid, Date date, Date beginTime, Date endTime, String cityname, String site,
			String transport, String breakfast, String lunch, String dinner, String comment){
		this.planid = planid;
		this.date = date;
		this.begintime = beginTime;
		this.endtime = endTime;
		this.cityname = cityname;
		this.site = site;
		this.transport = transport;
		this.breakfast = breakfast;
		this.lunch = lunch;
		this.dinner = dinner;
		this.comment = comment;
		
	}

	@Override
	public Response invoke() {
		boolean success = DatabaseController.getInstance().insertPhase(planid,date,begintime,endtime,cityname,site,transport,breakfast,lunch,dinner,comment);
		Response response = new ConfirmResponse(success);
		return response;
	}

}
