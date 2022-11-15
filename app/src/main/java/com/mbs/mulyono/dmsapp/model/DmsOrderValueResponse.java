package com.mbs.mulyono.dmsapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class DmsOrderValueResponse extends BaseModel {
    @SerializedName("datacontents")
    public ArrayList<DmsOrderValueItem> listOrderValueItem = new ArrayList<>();
}
