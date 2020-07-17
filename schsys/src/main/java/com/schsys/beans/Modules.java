/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schsys.beans;

import java.io.Serializable;

/**
 *
 * @author Naim
 */
public class Modules implements Serializable {

    private Integer modId;
    private String modName;

    public Modules() {
    }

    public Modules(Integer modId) {
        this.modId = modId;
    }

    public Integer getModId() {
        return modId;
    }

    public void setModId(Integer modId) {
        this.modId = modId;
    }

    public String getModName() {
        return modName;
    }

    public void setModName(String modName) {
        this.modName = modName;
    } 
}
