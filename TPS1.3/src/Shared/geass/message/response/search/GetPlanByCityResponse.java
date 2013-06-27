package Shared.geass.message.response.search;

import Shared.geass.dataPOJO.Plan;
import Shared.geass.message.response.Response;
import java.util.ArrayList;

public class GetPlanByCityResponse extends Response {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private ArrayList<Plan> planlist;

    public GetPlanByCityResponse(ArrayList<Plan> planlist) {
        this.planlist = planlist;
    }

    public ArrayList<Plan> getPlanList() {
        return planlist;
    }
}
