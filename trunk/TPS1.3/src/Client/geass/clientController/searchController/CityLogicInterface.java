package Client.geass.clientController.searchController;

import Shared.geass.dataPOJO.City;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;




public interface CityLogicInterface {
	
    public String getText(String cityid);
    public ArrayList SearchByName(String city);
    public ArrayList SearchBySeason(String season);
    public ArrayList searchPlanByTwoDate(Date beginDate, Date endDate);
    public ArrayList searchPlanByCityDate(String searchCondition ,Date date);
    public ArrayList getPhase(int planid);
    public City getRandomCity();
}
