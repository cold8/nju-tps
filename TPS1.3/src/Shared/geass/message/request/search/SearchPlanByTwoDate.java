package Shared.geass.message.request.search;

import java.util.ArrayList;
import java.util.Date;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.ConfirmResponse;
import Shared.geass.message.response.Response;

public class SearchPlanByTwoDate extends Request{
    Date beginDate;
    Date endDate;
	public SearchPlanByTwoDate(Date beginDate ,Date endDate) {
		// TODO Auto-generated constructor stub
		this.beginDate=beginDate;
		this.endDate=endDate;
	}
	public Response invoke() {
		boolean confirmed = true;
		ArrayList citylist = DatabaseController.getInstance().searchPlanByTwoDate(beginDate,endDate);
		if(citylist==null)
            confirmed = false;
		return new ConfirmResponse(confirmed);
	}

}
