package Client.geass.clientController.searchController;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;



public class CityController implements CityControllerInterface {
	
	
 CityLogicInterface cl = new CityLogic() ;
 Vector<String> Collum =new Vector(Arrays.asList("查到的城市","所属地方","最佳季节"));
 
 
 
 
 
 
 
 
 @Override
    
    public Vector<List> TableVectorByName(String city) {
		// TODO Auto-generated method stub
		return  cl.getListByName(city);
	}

	
	@Override
	public Vector<List> TableVectorBySeason(String season) {
		// TODO Auto-generated method stub
		return cl.getListBySeason(season);
	}

	
	@Override
	public DefaultTableModel getModel() {
		// TODO Auto-generated method stub
		 MyTableModel table =new MyTableModel(null,Collum);
	       System.out.println("我们到这里了哦");
	       return table  ;
		
	}

	
	
	@Override
	public String getText(String cityid) {
		// TODO Auto-generated method stub
		return cl.getText(cityid);
	}
	@Override
	public Vector getCollum() {
		// TODO Auto-generated method stub
		return Collum;
	}
	
	//===================================================================================
	//
	//===================================================================================
	
	class MyTableModel extends DefaultTableModel {

		   public MyTableModel(Vector<Vector<String>> data, Vector<String> columnNames) {
		       super(data, columnNames);

		   }}

	@Override
	public boolean isCity(String city) {
		// TODO Auto-generated method stub
		return cl.isCity(city);
	}


	@Override
	public boolean isSeason(String season) {
		// TODO Auto-generated method stub
		return cl.isSeason(season);
	}

	
	 

	
	

}
