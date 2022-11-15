package com.mbs.mulyono.dmsapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class DmsOrderValueItem {
    @SerializedName("dms_no")
    public String dmsNo;

    @SerializedName("line_no")
    public String ovline_no;

    @SerializedName("min_value")
    public String ovmin_value;

    @SerializedName("max_value")
    public String ovmax_value;

    @SerializedName("discount_type")
    public String ovtype_discount;

    @SerializedName("discount_value")
    public String ovdiscount_value;

}
