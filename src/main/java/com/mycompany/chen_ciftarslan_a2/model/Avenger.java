

package com.mycompany.chen_ciftarslan_a2.model;

import java.io.Serializable;

/**
 *This is the avenger Bean which hold the main attributes for Avenger characters such as id and name
 * @author Hung-Han, Chen & Ali Cemilcan, Ciftarslan
 */
public class Avenger implements Serializable{
    
    private int id;
    private String name;
    private String description;
    private PowerSource powerSource;
    //Empt constructor for Serializable rules as well as getters and setters.
    public Avenger() {
    }

    public Avenger(String name, String description, PowerSource powerSource) {
        this.name = name;
        this.description = description;
        this.powerSource = powerSource;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PowerSource getPowerSource() {
        return powerSource;
    }

    public void setPowerSource(PowerSource powerSource) {
        this.powerSource = powerSource;
    }
    
    

}
