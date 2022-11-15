package com.mbs.mulyono.dmsapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class DmsProductItem {
    @SerializedName("dms_no")
    public String dmsNo;

    @SerializedName("line_no")
    public String line_no;

    @SerializedName("part_no")
    public String part_no;

    @SerializedName("partdesc1")
    public String partdesc1;

    @SerializedName("min_qty")
    public String min_qty;

    @SerializedName("max_qty")
    public String max_qty;

    @SerializedName("ketdisc")
    public String ketdisc;

    @SerializedName("bonus_part")
    public String bonus_part;

    @SerializedName("bonusdesc1")
    public String bonusdesc1;

    @SerializedName("bonus_qty")
    public String bonus_qty;

    @SerializedName("kelipatan")
    public String kelipatan;

}
