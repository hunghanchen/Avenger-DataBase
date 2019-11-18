package com.mycompany.chen_ciftarslan_a2.model;

import java.io.Serializable;

/**
 * PowerSource Bean that holds the id and description for the power sources.
 *
 * @author Hung-Han, Chen & Ali Cemilcan, Ciftarslan
 */
public class PowerSource implements Serializable {

    private int id;
    private String description;
    
    
    //Empty constructor for Seriizable rules
    public PowerSource() {
    }

    public PowerSource(int id) {
        this.id = id;
    }

    public PowerSource(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
