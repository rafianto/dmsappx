package com.mbs.mulyono.dmsapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class DmsOverviewResponse extends BaseModel {
    @SerializedName("datacontents")
    public ArrayList<DmsOverviewItem> listItem = new ArrayList<>();
}
