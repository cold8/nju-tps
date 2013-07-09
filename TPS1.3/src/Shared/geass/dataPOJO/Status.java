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
    private String audiohref;
    private String videohref;
    private String description;
    private String username;
    private int nice;
    
    public Status(){
        
        
    }

    public Status(int planid, Date date, String text, String picturehref, String audiohref, String videohref, String description) {
        this.planid = planid;
        this.date = date;
        this.text = text;
        this.picturehref = picturehref;
        this.audiohref = audiohref;
        this.videohref = videohref;
        this.description = description;
    }

    public int getNice() {
        return nice;
    }

    public void setNice(int nice) {
        this.nice = nice;
    }

    
    
    public String getAudiohref() {
        return audiohref;
    }

    public void setAudiohref(String audiohref) {
        this.audiohref = audiohref;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
