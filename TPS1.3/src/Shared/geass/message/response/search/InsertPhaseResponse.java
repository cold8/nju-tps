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
public class InsertPhaseResponse extends Response {
    boolean isInsert ;
    public InsertPhaseResponse(boolean isInsert){
        this.isInsert=isInsert;
    }
    public boolean InsertPhase(){
        return  isInsert;
    }
}
