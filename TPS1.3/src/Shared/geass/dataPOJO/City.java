package Shared.geass.dataPOJO;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 13-4-25
 * Time: 下午10:11
 * To change this template use File | Settings | File Templates.
 */
public class City implements Serializable {
    private static final long serialVersionUID = 1L;

    String cityid;
    String cityname;
    String province;
    String country;
    String description;
    String bestseason;
    String picturehref;
    String longtitude;
    String latitude;





    public City(String cityid, String cityname, String province, String country, String description, String bestseason, String picturehref, String longtitude, String latitude) {
        this.cityid = cityid;
        this.cityname = cityname;
        this.province = province;
        this.country = country;
        this.description = description;
        this.bestseason = bestseason;
        this.picturehref = picturehref;
        this.longtitude = longtitude;
        this.latitude = latitude;
    }

    public City() {
		// TODO Auto-generated constructor stub
	}



	public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBestseason() {
        return bestseason;
    }

    public void setBestseason(String bestseason) {
        this.bestseason = bestseason;
    }

    public String getPicturehref() {
        return picturehref;
    }

    public void setPicturehref(String picturehref) {
        this.picturehref = picturehref;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
