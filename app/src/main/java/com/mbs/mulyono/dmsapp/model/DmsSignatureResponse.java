package com.mbs.mulyono.dmsapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class DmsSignatureResponse extends BaseModel {
    @SerializedName("datacontents")
    public ArrayList<DmsSignatureItem> listSignatureItem = new ArrayList<>();
}
