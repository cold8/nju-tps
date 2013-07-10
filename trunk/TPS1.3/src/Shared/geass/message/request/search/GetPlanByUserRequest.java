/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Shared.geass.message.request.search;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.dataPOJO.Plan;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.Response;
import Shared.geass.message.response.search.GetPlanByUserResponse;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class GetPlanByUserRequest extends Request {
       private static final long serialVersionUID = 1L;
       String username ;
       public GetPlanByUserRequest(String userName){
           this.username =userName;
       }
    @Override
    public Response invoke() {
        
        ArrayList<Plan> planlist = DatabaseController.getInstance().getPlanByuser(username);
        return new GetPlanByUserResponse(planlist);
    }
    
}
