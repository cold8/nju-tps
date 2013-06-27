package Shared.geass.message.request.plan;

import java.util.Date;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.dataPOJO.Plan;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.Response;
import Shared.geass.message.response.plan.GetPlanResponse;

public class CreatePlanRequest extends Request {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private Date begindate;
	private Date enddate;
	private String username;
	
	public CreatePlanRequest(String u,String t, Date bd, Date ed){
		username = u;
		title = t;
		begindate = bd;
		enddate = ed;
	}

	@Override
	public Response invoke() {
		
		Plan plan = DatabaseController.getInstance().createPlan(username,title, begindate,enddate);
		return new GetPlanResponse(plan);
	}

}
