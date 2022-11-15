package com.mbs.mulyono.dmsapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class DmsOrderItem {
    @SerializedName("dms_no")
    public String dmsNo;

    @SerializedName("order_type")
    public String order_type;

    @SerializedName("incexc")
    public String ordincecx;

    @SerializedName("orddesc")
    public String orddesc;

}
