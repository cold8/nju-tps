package Shared.geass.message.response.plan;

import Shared.geass.message.response.Response;

public class GetCityListResponse extends Response {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] citylist;

	public GetCityListResponse(String[] citylist) {
		this.citylist = citylist;
	}

	public String[] getCityList() {
		return citylist;
	}

}
