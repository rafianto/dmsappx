package com.mbs.mulyono.dmsapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class DmsXActivityProsesOverviewItem {
    @SerializedName("username")
    public String xpusename;

    @SerializedName("password")
    public String xppassword;

    @SerializedName("dms_no")
    public String xpdmsNo;

    @SerializedName("gpslocation")
    public String xpgpsloc;

    @SerializedName("noteapproved")
    public String xpnotetext;

    @SerializedName("actionproses")
    public String xpaction;

}
