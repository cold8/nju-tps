package Shared.geass.message.response.search;

import java.util.ArrayList;

import Shared.geass.dataPOJO.City;
import Shared.geass.message.response.Response;

public class GetCityBySeasonResponse extends Response{
	private static final long serialVersionUID = 1L;
	ArrayList<City>  cityList;
	public GetCityBySeasonResponse(ArrayList list){
		this.cityList=list;
		
	}
    public ArrayList<City> getCityBySeason(){
    	return cityList ;
    }
}
