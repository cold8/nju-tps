package Shared.geass.message.request.plan;

import java.util.ArrayList;
import java.util.Date;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.dataPOJO.Phase;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.Response;
import Shared.geass.message.response.plan.GetPhaseOfDayResponse;

public class GetPhaseOfDayRequest extends Request {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int planid;
	private Date date;

	public GetPhaseOfDayRequest(int planid, Date date) {
		this.planid = planid;
		this.date = date;
	}

	@Override
	public Response invoke() {
		ArrayList<Phase> phaseArray = null;
		phaseArray = DatabaseController.getInstance().getPhaseOfDay(planid,date);
		/*
		 * 从数据层控制器获得的Phase[]是没有按照begintime和endtime排序的数组
		 * 需要返回一个已经排序的Response
		 */
		phaseArray = sortPhaseArray(phaseArray);
		
		return new GetPhaseOfDayResponse(phaseArray);
	}

	private ArrayList<Phase> sortPhaseArray(ArrayList<Phase> phaseArray) {

		ArrayList<Phase> array = phaseArray;//待排序的数组
		/*
		 * 插入排序算法
		 */
		int i=0;
		int j=0;
		Phase tempPhase = null;
		
		//先按begintime排序
		for (i=1; i<array.size(); i++){
			tempPhase = array.get(i);
			for (j=i-1; j>=0 && array.get(j).getBegintime().after(tempPhase.getBegintime()); j--)
				array.set(j+1, array.get(j));
			array.set(j+1, tempPhase);
		}
		
		//再按endtime排序
		i=0;
		j=0;
		
		for (i=1; i<array.size(); i++){
			tempPhase = array.get(i);
			for (j=i-1; j>=0 && array.get(j).getBegintime().after(tempPhase.getBegintime()); j--)
				array.set(j+1, array.get(j));
			array.set(j+1, tempPhase);
		}

		return array;
	}

}
