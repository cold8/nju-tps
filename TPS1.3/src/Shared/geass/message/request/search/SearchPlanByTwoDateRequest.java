package Shared.geass.message.request.search;

import java.util.ArrayList;
import java.util.Date;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.dataPOJO.Plan;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.Response;
import Shared.geass.message.response.search.GetPlanByTwoDateResponse;

public class SearchPlanByTwoDateRequest extends Request {

    Date beginDate;
    Date endDate;

    public SearchPlanByTwoDateRequest(Date beginDate, Date endDate) {
        // TODO Auto-generated constructor stub
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public Response invoke() {
        ArrayList<Plan> planlist;
        planlist = DatabaseController.getInstance().searchPlanByTwoDate(beginDate, endDate);
        return new GetPlanByTwoDateResponse(planlist);
    }
}
