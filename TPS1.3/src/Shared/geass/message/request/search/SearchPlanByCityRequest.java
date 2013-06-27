package Shared.geass.message.request.search;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.dataPOJO.Plan;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.Response;
import Shared.geass.message.response.search.GetPlanByCityResponse;
import java.util.ArrayList;

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
        ArrayList<Plan> planlist;
        planlist = DatabaseController.getInstance().searchPlanByCity(cityname);
        return new GetPlanByCityResponse(planlist);
    }
}
