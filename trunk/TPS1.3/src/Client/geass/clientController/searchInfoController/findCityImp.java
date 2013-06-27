package Client.geass.clientController.searchInfoController;


import Shared.geass.dataPOJO.City;
import java.util.ArrayList;

public class findCityImp implements findCityService{
	  CityData db2 = new CityData();
	   boolean isValid = false;
	@Override
	public ArrayList Searchbyseason(String str) {
		// TODO Auto-generated method stub
		 ArrayList<City> citylist = new ArrayList<City>() ;
	     
	     String[]  list =searchByKey(str);
	     citylist = db2.Getbyname(list);
	    //  if(list!=null){
	      //     for(int i =0;i<list.length;i++)
	      //     citylist.add(db2.Getbyname(list[i]));
	     // }
	      return citylist;

	}

	@Override
	public ArrayList Searchbyname(String str) {
		// TODO Auto-generated method stub
		 String exact =cleanWord(str);
	     if(exact!=null)        
	     return db2.getbyseason(exact);
	     else
	         return null ;

	}
	private String cleanWord(String str){
	     String[] season = {"春","夏","秋","冬"};
	     
	     for(int i =0;i<4;i++){
	        // System.out.println("we come to cleanWord");
	         if(str.contains(season[i])){
	             isValid =true ;
	          return season[i];
	         }  
	     }
	      return null ;
	  }
	 public String[] searchByKey(String str){
	        String[] list ={"南京"};
	        isValid=true ;
	        return list;
	    }

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return isValid;
	}



}
