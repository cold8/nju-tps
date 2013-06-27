package Client.geass.clientController.searchInfoController;


import Shared.geass.dataPOJO.Phase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class findTripController {
	findTripService lo =new findTripImp();
    Vector<String> Collum =new Vector(Arrays.asList("地址","交通","食物","时间"));
   
     
   
   public  DefaultTableModel getModel(){
       MyTableModel table =new MyTableModel(null,Collum);
       
       return table  ;
   }

  
   class MyTableModel extends DefaultTableModel {

   public MyTableModel(Vector<Vector<String>> data, Vector<String> columnNames) {
       super(data, columnNames);

   }}
   public Vector<List> searchTableVector(String key) {
        list =lo.SearchbyCity(key);
        if(list!=null)
        return new Vector<List>(toCityTable(list));
        else return null ;
   }
     public Vector<List> searchTableVector2(String key) {
         list = lo.SearchbyDay(key);
      if(list!=null)
        return new Vector<List>(toCityTable(list));
      else return null ;
   }
    
   public Vector<Vector<String>> toCityTable(List list) {
   	try {
           Vector<Phase> seList = new Vector(list);
           Vector<Vector<String>> reList = new Vector<Vector<String>>();
           for(int i=0; i<seList.size(); i++){
              // System.out.println("heheheheh");
               reList.add((Vector<String>)toCityStringArray(seList.get(i)));
           }
           return reList;
           } catch (Exception e) {
               e.printStackTrace();
               return null;
           }
       }     

   public List toCityStringArray(Phase plan){
       Vector<String> list = new Vector<String>();
       //String show = plan.getFood()+plan.getTime()+plan.getSite()+plan.getTransport();
       list.add(plan.getSite());//id
       list.add(plan.getTransport());
              
      
       return list;
   } 
public boolean isValid(){
   return list == null;
}
public  Vector<String> getCollum(){
    return Collum ;
}   
ArrayList<Phase> list =null;

public Phase getResult(int index){
	//System.out.println(list.size());
	if((index!=-1)&&!isValid()){
		System.out.println("info here");
		return list.get(index);}
	else 
		return null ;
}
	
}
