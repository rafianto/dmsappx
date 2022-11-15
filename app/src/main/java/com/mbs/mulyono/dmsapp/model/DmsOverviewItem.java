package com.mbs.mulyono.dmsapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class DmsOverviewItem {
    @SerializedName("dms_no")
    public String dmsNo;

    @SerializedName("date_from")
    public String dateFrom;

    @SerializedName("date_to")
    public String dateTo;

    @SerializedName("principal")
    public String principal;

    @SerializedName("tdms_focus")
    public String tdmsFocus;

    @SerializedName("note_text")
    public String noteText;

    @SerializedName("state")
    public String state;

    @SerializedName("hna_flag")
    public String hnaflag;

    @SerializedName("netto_flag")
    public String nettoflag;

}
