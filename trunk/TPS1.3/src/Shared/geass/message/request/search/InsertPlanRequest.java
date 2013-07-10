/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Shared.geass.message.request.search;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.dataPOJO.Plan;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.Response;
import Shared.geass.message.response.search.InsertPlanResponse;

/**
 *
 * @author Administrator
 */
public class InsertPlanRequest extends Request{
    private static final long serialVersionUID = 1L;
    Plan plan ;
    public InsertPlanRequest(Plan plan){
        this.plan=plan;
    }
    @Override
    public Response invoke() {
     boolean isInsert = DatabaseController.getInstance().InsertPlan(plan);
     return new InsertPlanResponse(isInsert);
    }
}
