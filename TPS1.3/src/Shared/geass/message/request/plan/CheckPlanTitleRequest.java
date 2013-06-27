package Shared.geass.message.request.plan;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.dataPOJO.Plan;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.ConfirmResponse;
import Shared.geass.message.response.Response;

public class CheckPlanTitleRequest extends Request {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	
	public CheckPlanTitleRequest(String t){
		title = t;
	}

	@Override
	public Response invoke() {
		boolean confirmed = true;
        confirmed = DatabaseController.getInstance().checkPlanTitle(title);
        return new ConfirmResponse(confirmed);
	}
	
	

}
