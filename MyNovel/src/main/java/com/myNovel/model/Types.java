package com.myNovel.model;

import java.io.Serializable;

public class Types implements Serializable{
    private Integer idtypes;

    private String type;

    public Integer getIdtypes() {
        return idtypes;
    }

    public void setIdtypes(Integer idtypes) {
        this.idtypes = idtypes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}