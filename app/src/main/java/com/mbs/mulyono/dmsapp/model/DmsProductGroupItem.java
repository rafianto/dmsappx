package com.mbs.mulyono.dmsapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class DmsProductGroupItem {
    @SerializedName("dms_no")
    public String pgdmsNo;

    @SerializedName("sales_group")
    public String pgsalesgroup;

    @SerializedName("excinc")
    public String pgexcinc;

    @SerializedName("namegrp")
    public String pgnamegrp;
}
