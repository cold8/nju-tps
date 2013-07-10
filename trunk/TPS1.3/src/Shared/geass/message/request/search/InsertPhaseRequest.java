/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Shared.geass.message.request.search;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.dataPOJO.Phase;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.Response;
import Shared.geass.message.response.search.InsertPhaseResponse;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class InsertPhaseRequest extends Request {
    private static final long serialVersionUID = 1L;
    Phase phase ;
    public InsertPhaseRequest( Phase phase){
        this.phase=phase;
    }
   
    public Response invoke() {
        boolean isInsert =DatabaseController.getInstance().InsertPhase(phase);
        return new InsertPhaseResponse(isInsert);
    }
    
}
