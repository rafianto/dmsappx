package com.mbs.mulyono.dmsapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class DmsMixedBonusItem {
    @SerializedName("dms_no")
    public String dmsNo;

    @SerializedName("min_qty")
    public String mxbminqty;

    @SerializedName("max_qty")
    public String mxbmaxqty;

    @SerializedName("bonus_qty")
    public String mxbbonusqty;

    @SerializedName("ket_disc")
    public String mxbketdisc;

}
