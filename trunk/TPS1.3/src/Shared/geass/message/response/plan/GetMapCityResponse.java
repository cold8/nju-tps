package Shared.geass.message.response.plan;

import Shared.geass.dataPOJO.City;
import Shared.geass.message.response.Response;

public class GetMapCityResponse extends Response{
	private static final long serialVersionUID = 1L;
	private City city;

	public GetMapCityResponse(City city) {
		this.city = city;
	}

	public City getCity() {
		return city;
	}


}
