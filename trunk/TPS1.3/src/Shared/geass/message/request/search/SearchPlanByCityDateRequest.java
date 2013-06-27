package Shared.geass.message.request.search;

import java.util.ArrayList;
import java.util.Date;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.dataPOJO.Plan;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.Response;
import Shared.geass.message.response.search.GetPlanByCityDateResponse;

public class SearchPlanByCityDateRequest extends Request {

    String cityName;
    Date indate;

    public SearchPlanByCityDateRequest(String cityName, Date indate) {
        // TODO Auto-generated constructor stub
        this.cityName = cityName;
        this.indate = indate;
    }

    @Override
    public Response invoke() {
        // TODO Auto-generated method stub
        ArrayList<Plan> planlist ;
        planlist = DatabaseController.getInstance().searchPlanByCityDate(cityName, indate);

        return new GetPlanByCityDateResponse(planlist);
    }
}
