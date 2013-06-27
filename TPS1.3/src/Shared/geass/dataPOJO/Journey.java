package Shared.geass.dataPOJO;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 13-4-25
 * Time: 下午10:10
 * To change this template use File | Settings | File Templates.
 */
public class Journey implements Serializable {
    private static final long serialVersionUID = 1L;
    private String jouneyid;
    private String userid;
    private String journeyname;
    private String description;
    private Date startdate;
    private Date enddate;
    int date;

    public String getJouneyid() {
        return jouneyid;
    }

    public void setJouneyid(String jouneyid) {
        this.jouneyid = jouneyid;
    }

    public String getUsername() {
        return userid;
    }

    public void setUsername(String username) {
        this.userid = username;
    }

    public String getJourneyname() {
        return journeyname;
    }

    public void setJourneyname(String journeyname) {
        this.journeyname = journeyname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
