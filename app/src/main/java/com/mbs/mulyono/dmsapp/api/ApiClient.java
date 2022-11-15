package com.mbs.mulyono.dmsapp.api;

import com.mbs.mulyono.dmsapp.model.DmsClActivityProsesOverviewResponse;
import com.mbs.mulyono.dmsapp.model.DmsCustomerChainResponse;
import com.mbs.mulyono.dmsapp.model.DmsCustomerGroupResponse;
import com.mbs.mulyono.dmsapp.model.DmsCustomerResponse;
import com.mbs.mulyono.dmsapp.model.DmsDetHistoryResponse;
import com.mbs.mulyono.dmsapp.model.DmsHistoryResponse;
import com.mbs.mulyono.dmsapp.model.DmsMixedBonusResponse;
import com.mbs.mulyono.dmsapp.model.DmsOrderResponse;
import com.mbs.mulyono.dmsapp.model.DmsOrderValueResponse;
import com.mbs.mulyono.dmsapp.model.DmsOverviewResponse;
import com.mbs.mulyono.dmsapp.model.DmsProductGroupResponse;
import com.mbs.mulyono.dmsapp.model.DmsProductResponse;
import com.mbs.mulyono.dmsapp.model.DmsSignatureResponse;
import com.mbs.mulyono.dmsapp.model.DmsXActivityProsesOverviewResponse;
import com.mbs.mulyono.dmsapp.model.PrincipleResponse;
import com.mbs.mulyono.dmsapp.model.UserAksesResponse;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

public interface ApiClient {

    @FormUrlEncoded
    @POST("dmsapp_newservice2a.php?k=dmsandroidx&c=1")
    Call<PrincipleResponse> PrincipalForUse(@Field("selmodul") String selmodul, @Field("username") String uname, @Field("password") String password);

    @FormUrlEncoded
    @POST("dmsapp_newservice2a.php?k=dmsandroidx&c=1")
    Call<UserAksesResponse> GetHakAkesesForUser(@Field("selmodul") String selmodul, @Field("username") String uname);

    //Overview//
    @FormUrlEncoded
    @POST("dmsapp_newservice2a.php?k=dmsandroidx&c=1")
    Call<DmsOverviewResponse> GetDmsOverview(@Field("selmodul") String selmodul, @Field("princp") String principal, @Field("username") String uname, @Field("password") String password);

    //Overview Search//
    @FormUrlEncoded
    @POST("dmsapp_newservice2a.php?k=dmsandroidx&c=1")
    Call<DmsOverviewResponse> GetDmsOverviewSearch(@Field("selmodul") String selmodul, @Field("princp") String principal, @Field("dmslike") String dmslike, @Field("username") String uname, @Field("password") String password);

    //Principal//
    @FormUrlEncoded
    @POST("dmsapp_newservice2a.php?k=dmsandroidx&c=1")
    Call<DmsOverviewResponse> GetDmsPrincipal(@Field("selmodul") String selmodul, @Field("princp") String principal, @Field("dmslike") String dmslike, @Field("username") String uname, @Field("password") String password);

    //History//
    @FormUrlEncoded
    @POST("dmsapp_newservice2a.php?k=dmsandroidx&c=1")
    Call<DmsHistoryResponse> GetDmsHistory(@Field("selmodul") String selmodul, @Field("princp") String principal, @Field("dmslike") String dmslike, @Field("username") String uname, @Field("password") String password);

    // Detail //
    @FormUrlEncoded
    @POST("dmsapp_newservice2a.php?k=dmsandroidx&c=1")
    Call<DmsOverviewResponse> GetDmsDetailContent(@Field("selmodul") String selmodul, @Field("dmslike") String dmslike, @Field("dmsisue") String dmsisue);

    // Customer //
    @FormUrlEncoded
    @POST("dmsapp_newservice2a.php?k=dmsandroidx&c=1")
    Call<DmsCustomerResponse> GetDmsDetailCustomerContent(@Field("selmodul") String selmodul, @Field("dmslike") String dmslike, @Field("dmsisue") String dmsisue);

    // Product //
    @FormUrlEncoded
    @POST("dmsapp_newservice2a.php?k=dmsandroidx&c=1")
    Call<DmsProductResponse> GetDmsDetailProductContent(@Field("selmodul") String selmodul, @Field("dmslike") String dmslike, @Field("dmsisue") String dmsisue);

    // Oder Type //
    @FormUrlEncoded
    @POST("dmsapp_newservice2a.php?k=dmsandroidx&c=1")
    Call<DmsOrderResponse> GetDmsDetailOrderContent(@Field("selmodul") String selmodul, @Field("dmslike") String dmslike, @Field("dmsisue") String dmsisue);

    // Oder Value //
    @FormUrlEncoded
    @POST("dmsapp_newservice2a.php?k=dmsandroidx&c=1")
    Call<DmsOrderValueResponse> GetDmsDetailOrderValueContent(@Field("selmodul") String selmodul, @Field("dmslike") String dmslike, @Field("dmsisue") String dmsisue);

    // Signature //
    @FormUrlEncoded
    @POST("dmsapp_newservice2a.php?k=dmsandroidx&c=1")
    Call<DmsSignatureResponse> GetDmsDetailSignatureContent(@Field("selmodul") String selmodul, @Field("dmslike") String dmslike, @Field("dmsisue") String dmsisue);

    // History DMS //
    @FormUrlEncoded
    @POST("dmsapp_newservice2a.php?k=dmsandroidx&c=1")
    Call<DmsDetHistoryResponse> GetDmsDetailHistoryContent(@Field("selmodul") String selmodul, @Field("dmslike") String dmslike, @Field("dmsisue") String dmsisue);

    // Customer Group //
    @FormUrlEncoded
    @POST("dmsapp_newservice2a.php?k=dmsandroidx&c=1")
    Call<DmsCustomerGroupResponse> GetDmsDetailCustomerGroupContent(@Field("selmodul") String selmodul, @Field("dmslike") String dmslike, @Field("dmsisue") String dmsisue);

    // Product Group //
    @FormUrlEncoded
    @POST("dmsapp_newservice2a.php?k=dmsandroidx&c=1")
    Call<DmsProductGroupResponse> GetDmsDetailProductGroupContent(@Field("selmodul") String selmodul, @Field("dmslike") String dmslike, @Field("dmsisue") String dmsisue);

    // Chains //
    @FormUrlEncoded
    @POST("dmsapp_newservice2a.php?k=dmsandroidx&c=1")
    Call<DmsCustomerChainResponse> GetDmsDetailCustomerChianContent(@Field("selmodul") String selmodul, @Field("dmslike") String dmslike, @Field("dmsisue") String dmsisue);

    // Mixed Bonus //
    @FormUrlEncoded
    @POST("dmsapp_newservice2a.php?k=dmsandroidx&c=1")
    Call<DmsMixedBonusResponse> GetDmsDetailMixedBonusContent(@Field("selmodul") String selmodul, @Field("dmslike") String dmslike, @Field("dmsisue") String dmsisue);

    // retrofit for proses //
    @FormUrlEncoded
    @POST("dmsapp_newservice2a.php?k=dmsandroidx&c=2")
    Call<DmsXActivityProsesOverviewResponse> GetXActivityProsesOverviewContent(@Field("selmodul") String selmodul,
         @Field("username") String username, @Field("password") String password, @Field("dmsno") String dmsno,
         @Field("gpslocation") String gpslocation, @Field("noteapproved") String noteapproved, @Field("actionproses") String actionproses );

    @FormUrlEncoded
    @POST("dmsapp_newservice2a.php?k=dmsandroidx&c=2")
    Call<DmsClActivityProsesOverviewResponse> GetClActivityProsesOverviewContent(@Field("selmodul") String selmodul,
         @Field("username") String username, @Field("password") String password, @Field("dmsno") String dmsno,
         @Field("gpslocation") String gpslocation, @Field("noteapproved") String noteapproved, @Field("actionproses") String actionproses );


}
