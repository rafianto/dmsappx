package com.mbs.mulyono.dmsapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class DmsCustomerItem {
    @SerializedName("dms_no")
    public String dmsNo;

    @SerializedName("customer_id")
    public String customerid;

    @SerializedName("namecust")
    public String namacust;

    @SerializedName("incexc")
    public String incecx;
}
