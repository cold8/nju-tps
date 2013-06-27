package Shared.geass.message.response.search;

import java.util.ArrayList;

import Shared.geass.dataPOJO.City;
import Shared.geass.message.response.Response;

public class GetCityByNameResponse extends Response{
	private static final long serialVersionUID = 1L;
	ArrayList<City>  cityList;
	public GetCityByNameResponse(ArrayList list){
		this.cityList=list;
		
	}
    public ArrayList<City> getCityByName(){
    	return cityList ;
    }
}
 