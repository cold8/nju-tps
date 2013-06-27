package Shared.geass.message.request.search;

import java.util.ArrayList;
import java.util.Date;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.ConfirmResponse;
import Shared.geass.message.response.Response;

public class SearchPlanByCityDate extends Request {
String cityName ;
Date indate;
	public SearchPlanByCityDate(String cityName, Date indate) {
		// TODO Auto-generated constructor stub
		this.cityName=cityName;
		this.indate=indate;
	}

	@Override
	public Response invoke() {
		// TODO Auto-generated method stub
		boolean confirmed = true;
		ArrayList citylist = DatabaseController.getInstance().searchPlanByCityDate(cityName,indate);
		if(citylist==null)
            confirmed = false;
		return new ConfirmResponse(confirmed);
	}

}
