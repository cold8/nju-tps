package Shared.geass.message.response.plan;

import Shared.geass.message.response.Response;

public class GetMaxCountOfPhasesResponse extends Response {

	private static final long serialVersionUID = 1L;
	private int max;
	
	public GetMaxCountOfPhasesResponse(int max){
		this.max = max;
	}
	
	public int getMax(){
		return max;
	}
}
