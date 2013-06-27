package Shared.geass.message.response.plan;

import Shared.geass.message.response.Response;

public class GetCountryListResponse extends Response {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] countrylist;

	public GetCountryListResponse(String[] countrylist) {
		this.countrylist = countrylist;
	}

	public String[] getCountryList() {
		return countrylist;
	}

}
