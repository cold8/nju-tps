package Shared.geass.message.request.search;

import java.util.ArrayList;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.dataPOJO.City;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.Response;
import Shared.geass.message.response.search.GetCityBySeasonResponse;

public class SearchCityBySeasonRequest extends Request {

    private static final long serialVersionUID = 1L;
    private String season;

    public SearchCityBySeasonRequest(String season) {
        this.season = season;
    }

    @Override
    public Response invoke() {
        ArrayList<City> citylist;
        citylist = DatabaseController.getInstance().searchCityBySeason(season);

        return new GetCityBySeasonResponse(citylist);
    }
}
