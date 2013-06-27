package Client.geass.clientController.searchInfoController;


import Shared.geass.dataPOJO.City;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class iRecommendController {
    findCityService lo =new findCityImp();
    Vector<String> Collum =new Vector(Arrays.asList("查到的城市"));
  
     
   
   public  DefaultTableModel getModel(){
       MyTableModel table =new MyTableModel(null,Collum);
       
       return table  ;
   }

  
   class MyTableModel extends DefaultTableModel {

   public MyTableModel(Vector<Vector<String>> data, Vector<String> columnNames) {
       super(data, columnNames);

   }}
   public Vector<List> searchTableVector(String key) {
        list =lo.Searchbyname(key);
        if(list!=null)
        return new Vector<List>(toCityTable(list));
        else return null ;
   }
     public Vector<List> searchTableVector2(String key) {
         list = lo.Searchbyseason(key);
      if(list!=null)
        return new Vector<List>(toCityTable(list));
      else return null ;
   }
    
   public Vector<Vector<String>> toCityTable(List list) {
   	try {
           Vector<City> seList = new Vector(list);
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

   public List toCityStringArray(City city){
       Vector<String> list = new Vector<String>();
       String show = city.getCityname();
       list.add(show);//id
      
      
       return list;
   } 
public boolean isValid(){
   return list == null;
}
public  Vector<String> getCollum(){
    return Collum ;
}   
ArrayList<City> list =null;
public City getResult(int index){
	if((index!=-1)&&!isValid())
		
		return list.get(index);
	else 
		return null ;
}
}
