package Shared.geass.message.request.plan;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.Response;
import Shared.geass.message.response.plan.GetCountryListResponse;

public class GetCountryListRequest extends Request {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Response invoke() {
		String[] countrylist = DatabaseController.getInstance().getCountryList();
		return new GetCountryListResponse(countrylist);
	}

}
