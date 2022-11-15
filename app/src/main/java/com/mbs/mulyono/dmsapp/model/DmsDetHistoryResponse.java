package com.mbs.mulyono.dmsapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class DmsDetHistoryResponse extends BaseModel {
    @SerializedName("datacontents")
    public ArrayList<DmsDetHistoryItem> listDetHistoryItem = new ArrayList<>();
}
