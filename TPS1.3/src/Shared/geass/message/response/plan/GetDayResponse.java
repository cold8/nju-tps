package Shared.geass.message.response.plan;

import java.util.ArrayList;

import Shared.geass.dataPOJO.Phase;
import Shared.geass.message.response.Response;

public class GetDayResponse extends Response {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Phase> phases;

	public GetDayResponse(ArrayList<Phase> phases) {
		this.phases = phases;
	}

	public ArrayList<Phase> getDay() {
		return phases;
	}

}
