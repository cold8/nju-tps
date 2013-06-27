package Shared.geass.dataPOJO;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 13-4-25
 * Time: 下午10:05
 * To change this template use File | Settings | File Templates.
 */
public class Phase implements Serializable {

    private static final long serialVersionUID = 1L;

    int planid;
    int phaseid;
    Date date;
    Date begintime;
    Date endtime;
    String cityname;
    String transport;
    String site;
    String breakfast;
    String lunch;
    String dinner;
    String comment;
    

    public Phase(){
    	
    	
    }

	public Phase(int planid, int phaseid, java.sql.Date date,
			Date begintime, Date endtime, String cityname, String transport,
			String site, String breakfast, String lunch, String dinner,
			String comment) {
		this.planid = planid;
		this.phaseid = phaseid;
		this.date = date;
		this.begintime = begintime;
		this.endtime = endtime;
		this.cityname = cityname;
		this.transport = transport;
		this.site = site;
		this.breakfast = breakfast;
		this.lunch = lunch;
		this.dinner = dinner;
		this.comment = comment;
	}

	public int getPhaseid(){
    	return phaseid;
    }
    
    public void setPhaseid(int phaseid){
    	this.phaseid = phaseid;
    }
    
    public int getPlanid() {
        return planid;
    }

    public void setPlanid(int planid) {
        this.planid = planid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCityname() {
        return cityname;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

	public Date getEndtime() {
		return endtime;
	}

	public Date getBegintime() {
		return begintime;
	}

	public String getBreakfast() {
		return breakfast;
	}
	
	public String getLunch() {
		return lunch;
	}
	
	public String getDinner() {
		return dinner;
	}
	
	public String getComment() {
		return comment;
	}
}
