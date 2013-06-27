package Client.geass.clientController.searchInfoController;

import java.util.ArrayList;

import Shared.geass.dataPOJO.Phase;

public class TripData {
	 
	  
	   public  ArrayList  GetbyCity(String[] str){
	       Phase trip = createPlan();
	       ArrayList<Phase> list = new ArrayList<Phase>() ;
	       if(list!=null){
	           for(int i =0;i<str.length;i++)
	       list.add(trip);
	           }
	      // System.out.println(trip.getFood());
	       return list ;
	   }
	   public Phase createPlan(){
		   Phase exm =new Phase();
		 
		   exm.setSite("南京");
		   exm.setTransport("火车");
		   return exm;
	   }
	public ArrayList getbyDay(int days){
	    ArrayList<Phase> triplist= new ArrayList<Phase>() ;
	    
	   // 搜索 季节得到 citylist 这里是桩啊！！！！！
	    triplist.add(createPlan());
	    return triplist ;
	}
	public ArrayList getByDayCity(String str,int days){
	     ArrayList<Phase> triplist= new ArrayList<Phase>() ;
	    
	   // 搜索 季节得到 citylist 这里是桩啊！！！！！
	    triplist.add(createPlan());
	    return triplist ;
	}
	public String getText(int id){
	    String str ="很美丽的地方";
	    String text =str;
	    return text;
	}
	public Object getPicture(String path){
	    Object picture="" ;
	    return picture ;
	}
	public boolean failConect(){
	    boolean isconnect=false;
	    return false ;
	}


}
