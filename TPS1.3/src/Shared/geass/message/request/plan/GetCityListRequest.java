package Shared.geass.message.request.plan;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.Response;
import Shared.geass.message.response.plan.GetCityListResponse;

public class GetCityListRequest extends Request{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String countryname;

	public GetCityListRequest(String countryname) {
		System.out.println("new request getcity"+countryname);
		this.countryname = countryname;
	}

	@Override
	public Response invoke() {
		System.out.println("request getcity"+this.countryname);
		String[] citylist = DatabaseController.getInstance().getCityList(countryname);
		return new GetCityListResponse(citylist);
	}

}
