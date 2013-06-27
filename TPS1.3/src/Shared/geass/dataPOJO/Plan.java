package Shared.geass.dataPOJO;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 13-4-25
 * Time: 下午10:01
 * To change this template use File | Settings | File Templates.
 */
public class Plan implements Serializable {
    private static final long serialVersionUID = 1L;
    int planid;
    String plantitle;
    String username;
    Date startdate;
    Date enddate;
    
    public Plan(){
    }

    public Plan(String plantitle,String username, Date startdate, Date enddate) {
		this.plantitle = plantitle;
		this.username = username;
		this.startdate = startdate;
		this.enddate = enddate;
	}
    public Plan(int planid,String plantitle,String username, Date startdate, Date enddate) {
    	this.planid = planid;
		this.plantitle = plantitle;
		this.username = username;
		this.startdate = startdate;
		this.enddate = enddate;
	}

    
    
	public int getPlanid() {
        return planid;
    }

    public void setPlanid(int planid) {
        this.planid = planid;
    }

    public String getPlantitle() {
        return plantitle;
    }

    public void setPlantitle(String plantitle) {
        this.plantitle = plantitle;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }


}
