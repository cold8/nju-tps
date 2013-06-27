package Shared.geass.message.response.plan;

import java.util.ArrayList;

import Shared.geass.dataPOJO.Phase;
import Shared.geass.message.response.Response;

public class GetPhaseOfDayResponse extends Response {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Phase> phaseArray;

	public GetPhaseOfDayResponse(ArrayList<Phase> phaseArray) {
		this.phaseArray = phaseArray;
	}

	public ArrayList<Phase> getPhaseArray() {
		return phaseArray;
	}

}
