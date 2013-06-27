package Client.geass.clientController.searchController;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public interface CityControllerInterface {

    public Vector<List> TableVectorByName(String city);

    public Vector<List> TableVectorBySeason(String season);

    public DefaultTableModel getModel();

    public String getText(String cityid);

    public Vector getCollum();

    public boolean isCity(String city);

    public boolean isSeason(String season);
}
