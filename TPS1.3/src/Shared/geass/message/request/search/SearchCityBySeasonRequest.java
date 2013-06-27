package Shared.geass.message.request.search;

import java.util.ArrayList;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.dataPOJO.Plan;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.ConfirmResponse;
import Shared.geass.message.response.Response;
import Shared.geass.message.response.search.GetPlanByCityResponse;

public class SearchCityBySeasonRequest extends Request{
	private static final long serialVersionUID = 1L;
	private String season;

	public SearchCityBySeasonRequest(String season) {
		this.season = season;
	}

	@Override
	public Response invoke() {
		boolean confirmed = true;
		ArrayList citylist = DatabaseController.getInstance().searchCityBySeason(season);
		if(citylist==null)
            confirmed = false;
		return new ConfirmResponse(confirmed);
	}
}
