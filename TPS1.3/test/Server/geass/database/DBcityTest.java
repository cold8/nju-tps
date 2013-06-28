package Server.geass.database;

import Shared.geass.dataPOJO.City;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;


public class DBcityTest {
    

    /**
     * Test of mapSearch method, of class DBcity.
     */
    @Test
    public void testMapSearch() {
        System.out.println("mapSearch");
        String cityname = "";
        DBcity instance = new DBcity();
        City expResult = null;
        City result = instance.mapSearch(cityname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchCityBySeason method, of class DBcity.
     */
    @Test
    public void testSearchCityBySeason() {
        System.out.println("searchCityBySeason");
        String bestseason = "冬";
        DBcity instance = new DBcity();
        ArrayList<City> expResult = null;
        ArrayList result = instance.searchCityBySeason(bestseason);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchCityByName method, of class DBcity.
     */
    @Test
    public void testSearchCityByName() {
        System.out.println("searchCityByName");
        String cityname = "";
        DBcity instance = new DBcity();
        ArrayList expResult = null;
        ArrayList result = instance.searchCityByName(cityname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchPlanByTwoDate method, of class DBcity.
     */
    @Test
    public void testSearchPlanByTwoDate() {
        System.out.println("searchPlanByTwoDate");
        Date beginDate = null;
        Date endDate = null;
        DBcity instance = new DBcity();
        ArrayList expResult = null;
        ArrayList result = instance.searchPlanByTwoDate(beginDate, endDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchPlanByCityDate method, of class DBcity.
     */
    @Test
    public void testSearchPlanByCityDate() {
        System.out.println("searchPlanByCityDate");
        String cityName = "";
        Date indate = null;
        DBcity instance = new DBcity();
        ArrayList expResult = null;
        ArrayList result = instance.searchPlanByCityDate(cityName, indate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}