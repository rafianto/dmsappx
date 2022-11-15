package com.mbs.mulyono.dmsapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class DmsDetHistoryItem {
    @SerializedName("dms_no")
    public String dmsNo;

    @SerializedName("rowstate")
    public String hstrowstate;

    @SerializedName("date_entered")
    public String htsdateentered;

    @SerializedName("userid")
    public String htsduserid;

}
