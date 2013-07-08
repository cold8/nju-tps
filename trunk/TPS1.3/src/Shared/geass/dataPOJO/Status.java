/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Shared.geass.dataPOJO;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author tin
 */
public class Status implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private int statusid;
    private int planid;
    private Date date;
    private String text;
    private String picturehref;
    private String videohref;
    private String description;
    
    public Status(){
        
        
    }

    public Status(int planid, Date date, String text, String picturehref, String videohref, String description) {
        this.planid = planid;
        this.date = date;
        this.text = text;
        this.picturehref = picturehref;
        this.videohref = videohref;
        this.description = description;
    }

    
    
    public int getStatusid() {
        return statusid;
    }

    public void setStatusid(int statusid) {
        this.statusid = statusid;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPicturehref() {
        return picturehref;
    }

    public void setPicturehref(String picturehref) {
        this.picturehref = picturehref;
    }

    public String getVideohref() {
        return videohref;
    }

    public void setVideohref(String videohref) {
        this.videohref = videohref;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
    
    
}
