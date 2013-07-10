/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Shared.geass.message.request.search;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.dataPOJO.City;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.Response;
import Shared.geass.message.response.search.GetRandomCityResponse;

/**
 *
 * @author Administrator
 */
public class GetRandomCityRequest extends Request {
 private static final long serialVersionUID = 1L;
    public GetRandomCityRequest(){
        
    }
    public Response invoke() {
      City  city =  DatabaseController.getInstance().randomCity();
      return new GetRandomCityResponse(city);
    }
    
}
