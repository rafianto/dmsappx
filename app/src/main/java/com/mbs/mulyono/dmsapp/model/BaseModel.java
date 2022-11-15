package com.mbs.mulyono.dmsapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class BaseModel {
    @SerializedName("command")
    public String command;

    @SerializedName("status")
    public String status;
}
