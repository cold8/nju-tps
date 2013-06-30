/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Shared.geass.message.request.search;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.dataPOJO.Phase;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.Response;
import Shared.geass.message.response.search.GetPhaseReponse;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class GetPhaseRequest  extends Request{
      private static final long serialVersionUID = 1L;
      private int planid ;
      public GetPhaseRequest(int planid){
          this.planid=planid;
      }

    @Override
    public Response invoke() {
       ArrayList<Phase> phaseList = DatabaseController.getInstance().getPhase(planid);
       return new GetPhaseReponse(phaseList);
    }
    
}
