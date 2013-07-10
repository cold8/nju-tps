/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Shared.geass.message.response.search;

import Shared.geass.dataPOJO.City;
import Shared.geass.message.response.Response;

/**
 *
 * @author Administrator
 */
public class GetRandomCityResponse extends Response{
    private static final long serialVersionUID = 1L;
    City city ;
    public GetRandomCityResponse(City city){
        this.city=city;
    }
    public City getRandomCity(){
        return city ;
    }
}
