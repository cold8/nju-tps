package Client.geass.clientController.searchInfoController;

import Shared.geass.dataPOJO.Phase;
import java.util.ArrayList;
import java.util.Date;

public class findTripImp implements findTripService {
	 TripData db2 = new TripData();
	   boolean isValid = false;
	 public  ArrayList SearchbyCity(String str){
	      ArrayList<Phase> citylist = new ArrayList<Phase>() ;
	     
	     String[]  list =searchByKey(str);
	     
	      
	           citylist=db2.GetbyCity(list);
	      
	      return citylist;
	 }
	public boolean isValid(){
	    return isValid ;
	}
	public  ArrayList SearchbyDay(String day){
	     
	    int days = Integer.parseInt(day);
	     if(days>0)  {
	         isValid=true;
	         return db2.getbyDay(days);
	     }
	     else
	         return null ;
	}
	 public  ArrayList SearchbyCityDay(String str,int days){
	     // ArrayList<PlanSpecific> citylist = new ArrayList<PlanSpecific>() ;
	     
	     String[]  list =searchByKey(str);
	     
	      if(list!=null){
	           for(int i =0;i<list.length;i++)
	         return  db2.getByDayCity(list[i],days);
	      }
	      return null;
	 }
	 public String[] searchByKey(String str){
	        String[] list ={"南京"};
	        isValid=true;
	        return list;
	    }
	/*private String cleanWord(String str){
	     String[] season = {"春","夏","秋","冬"};
	     
	     for(int i =0;i<4;i++){
	        // System.out.println("we come to cleanWord");
	         if(str.contains(season[i])){
	             isValid =true ;
	          return season[i];
	         }  
	     }
	      return null ;
	  }*/
	@Override
	public ArrayList SearchbyDate(Date key, Date key2) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList SearchbyCityDate(String str, Date days) {
		// TODO Auto-generated method stub
		return null;
	}
	
	  



}
