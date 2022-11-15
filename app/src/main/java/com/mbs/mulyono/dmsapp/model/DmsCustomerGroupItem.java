package com.mbs.mulyono.dmsapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class DmsCustomerGroupItem {
    @SerializedName("dms_no")
    public String csgdmsNo;

    @SerializedName("cust_group")
    public String csgcust_group;

    @SerializedName("excinc")
    public String csgexcinc;

    @SerializedName("descgrp")
    public String csgdescgrp;
}
