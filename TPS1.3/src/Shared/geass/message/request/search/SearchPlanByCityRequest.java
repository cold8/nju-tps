package Shared.geass.message.request.search;

import java.util.ArrayList;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.dataPOJO.Plan;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.ConfirmResponse;
import Shared.geass.message.response.Response;
import Shared.geass.message.response.search.SearchPlanByCityResponse;

public class SearchPlanByCityRequest extends Request {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cityname;

	public SearchPlanByCityRequest(String cityname) {
		this.cityname = cityname;
	}

	@Override
	public Response invoke() {
		boolean confirmed = true;
		Plan[] planlist = DatabaseController.getInstance().searchPlanByCity(cityname);
        if(planlist==null)
            confirmed = false;
		
		
		return new ConfirmResponse(confirmed);
	}

}
