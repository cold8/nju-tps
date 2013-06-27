package Shared.geass.message.request.search;

import java.util.ArrayList;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.ConfirmResponse;
import Shared.geass.message.response.Response;

public class SearchCityByNameRequest extends Request {
	private static final long serialVersionUID = 1L;
	private String cityname;

	public SearchCityByNameRequest(String cityname) {
		this.cityname = cityname;
	}

	@Override
	public Response invoke() {
		boolean confirmed = true;
		ArrayList citylist = DatabaseController.getInstance().searchCityByName(cityname);
		if(citylist==null)
            confirmed = false;
		return new ConfirmResponse(confirmed);
	}

}
