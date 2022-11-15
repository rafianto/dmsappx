package com.mbs.mulyono.dmsapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class DmsSignatureItem {
    @SerializedName("dms_no")
    public String dmsNo;

    @SerializedName("person_id")
    public String sigperson_id;

    @SerializedName("pname")
    public String sigpname;

}
