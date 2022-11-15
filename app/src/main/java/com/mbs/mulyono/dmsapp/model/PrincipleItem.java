package com.mbs.mulyono.dmsapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class PrincipleItem implements Serializable{
    @SerializedName("user")
    public String user;

    @SerializedName("princp")
    public String princp;

    @SerializedName("priname")
    public String priname;
}
