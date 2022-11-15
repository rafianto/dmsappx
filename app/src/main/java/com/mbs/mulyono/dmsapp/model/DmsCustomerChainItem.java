package com.mbs.mulyono.dmsapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class DmsCustomerChainItem {
    @SerializedName("dms_no")
    public String ccdmsNo;

    @SerializedName("cust_chain")
    public String cccustchain;

    @SerializedName("incexc")
    public String ccincecx;
}
