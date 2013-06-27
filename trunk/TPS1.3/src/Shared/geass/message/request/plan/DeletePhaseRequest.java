package Shared.geass.message.request.plan;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.ConfirmResponse;
import Shared.geass.message.response.Response;

public class DeletePhaseRequest extends Request {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int phaseid;

	public DeletePhaseRequest(int phaseid) {
		this.phaseid = phaseid;
	}

	@Override
	public Response invoke() {
		boolean succeed = DatabaseController.getInstance().deletePhase(phaseid);
		return new ConfirmResponse(succeed);
	}

}
