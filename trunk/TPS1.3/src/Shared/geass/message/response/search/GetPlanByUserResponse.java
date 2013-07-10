/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Shared.geass.message.response.search;

import Shared.geass.dataPOJO.Plan;
import Shared.geass.message.response.Response;
import java.util.ArrayList;



/**
 *
 * @author Administrator
 */
public class GetPlanByUserResponse extends Response{
   ArrayList<Plan> planlist =null;
    public GetPlanByUserResponse(ArrayList<Plan> planlist){
        this.planlist=planlist;
    }
    public ArrayList<Plan> GetPlanByUser(){
        return planlist ;
    }
}
