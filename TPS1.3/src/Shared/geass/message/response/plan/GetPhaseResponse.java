package Shared.geass.message.response.plan;

import Shared.geass.dataPOJO.Phase;
import Shared.geass.message.response.Response;

public class GetPhaseResponse extends Response {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Phase phase;
	

	public GetPhaseResponse(Phase phase) {
		this.phase = phase;
	}


	public Phase getPhase() {
		return phase;
	}

}
