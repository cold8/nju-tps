/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Shared.geass.message.response.search;

import Shared.geass.dataPOJO.Phase;
import Shared.geass.message.response.Response;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class GetPhaseReponse extends Response{
    private static final long serialVersionUID = 1L;
    ArrayList<Phase> phaseList ;
    public GetPhaseReponse(ArrayList<Phase> phaseList){
        this.phaseList=phaseList;
    }
    public ArrayList<Phase> getPhase(){
        return phaseList;
    }
}
