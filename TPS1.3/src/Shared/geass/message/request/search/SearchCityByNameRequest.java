package Shared.geass.message.request.search;

import java.util.ArrayList;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.dataPOJO.City;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.Response;
import Shared.geass.message.response.search.GetCityByNameResponse;

public class SearchCityByNameRequest extends Request {

    private static final long serialVersionUID = 1L;
    private String cityname;

    public SearchCityByNameRequest(String cityname) {
        this.cityname = cityname;
    }

    @Override
    public Response invoke() {
        ArrayList<City> citylist = DatabaseController.getInstance().searchCityByName(cityname);
        //  System.out.println(" "+ citylist.getCityname());
        return new GetCityByNameResponse(citylist);
    }
}
