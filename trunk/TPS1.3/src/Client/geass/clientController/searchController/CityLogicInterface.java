package Client.geass.clientController.searchController;

import java.util.List;
import java.util.Vector;




public interface CityLogicInterface {
	
    public String getText(String cityid);
    public Vector<List> getListByName(String city);
    public Vector<List> getListBySeason(String season);
    public boolean isCity(String city);
	 public boolean isSeason(String season);
}
