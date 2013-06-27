package Shared.geass.message.request.plan;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.ConfirmResponse;
import Shared.geass.message.response.Response;

public class SetPlantitleRequest extends Request {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int planid;
	private String newPlantitle;

	public SetPlantitleRequest(int planid, String newPlantitle) {
		this.planid = planid;
		this.newPlantitle = newPlantitle;
	}

	@Override
	public Response invoke() {
		boolean succeed = DatabaseController.getInstance().setPlantitle(planid,newPlantitle);
		return new ConfirmResponse(succeed);
	}

}
