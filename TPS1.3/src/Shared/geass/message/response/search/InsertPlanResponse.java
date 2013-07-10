/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Shared.geass.message.response.search;

import Shared.geass.message.response.Response;

/**
 *
 * @author Administrator
 */
public class InsertPlanResponse extends Response{
    boolean isInsert ;
    public InsertPlanResponse(boolean s){
        this.isInsert=s;
    }
    public boolean InsertPlan(){
        return isInsert;
    }
}
