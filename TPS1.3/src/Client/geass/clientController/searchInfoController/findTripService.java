package Client.geass.clientController.searchInfoController;


import java.util.ArrayList;
import java.util.Date;

import Shared.geass.dataPOJO.Phase;

public interface findTripService {

	ArrayList SearchbyCity(String key);
/**
 * 根据城市名搜索
 * @param key2 
 * @param key城市
 * @return
 */
	ArrayList SearchbyDate(Date key, Date key2);
	/**
	 * 根据行程天数搜索
	 * 
	 * @param days 天数
	 * @return
	 */
	ArrayList SearchbyCityDate(String str,Date days);          //未实现，by git
	/**
	 *  
	 * @param str  城市名
	 * @param days 天数
	 * @return
	 */
	ArrayList<Phase> SearchbyDay(String key);
}
