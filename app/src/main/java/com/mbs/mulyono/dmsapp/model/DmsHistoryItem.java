package com.mbs.mulyono.dmsapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class DmsHistoryItem {
    @SerializedName("dms_no")
    public String hisdmsNo;

    @SerializedName("date_from")
    public String hisdateFrom;

    @SerializedName("date_to")
    public String hisdateTo;

    @SerializedName("principal")
    public String hisprincipal;

    @SerializedName("tdms_focus")
    public String histdmsFocus;

    @SerializedName("note_text")
    public String hisnoteText;

    @SerializedName("state")
    public String hisstate;

    @SerializedName("hna_flag")
    public String hishnaflag;

    @SerializedName("netto_flag")
    public String hisnettoflag;
}
