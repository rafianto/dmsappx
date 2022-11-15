package com.mbs.mulyono.dmsapp.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.mbs.mulyono.dmsapp.R;
import com.mbs.mulyono.dmsapp.adapter.MenuAdapter;
import com.mbs.mulyono.dmsapp.api.ApiClient;
import com.mbs.mulyono.dmsapp.api.ApiService;
import com.mbs.mulyono.dmsapp.base.BaseActivity;
import com.mbs.mulyono.dmsapp.base.BaseApplication;
import com.mbs.mulyono.dmsapp.model.PrincipleItem;
import com.mbs.mulyono.dmsapp.model.PrincipleResponse;
import com.mbs.mulyono.dmsapp.model.UserAksesResponse;
import com.mbs.mulyono.dmsapp.observer.AppObserver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends BaseActivity implements Observer{
    private Spinner spnPrinciple;
    private ProgressBar pbIndicator;
    private ListView lvItem;
    private String akseskpst;

    ArrayList<PrincipleItem> lisPrinciple;
    private BaseApplication baseApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        baseApplication = (BaseApplication)getApplication();
        baseApplication.getAppObserver().addObserver(this);

        if (appPreference.getUsername().equals("") || appPreference.getPassword().equals("")){
            SettingActivity.toSettingActivity(MainActivity.this);
            finish();
        }else{
            setContentView(R.layout.activity_main);
            apiClient = ApiService.CreateService(ApiClient.class);
            spnPrinciple = (Spinner)findViewById(R.id.spn_principle);
            spnPrinciple.setBackgroundColor(Color.rgb(214,214,245));
            pbIndicator = (ProgressBar)findViewById(R.id.pb_indicator);
            lvItem = (ListView)findViewById(R.id.lv_item);

            getPrincipleAsyn();

            lvItem.setAdapter(new MenuAdapter(MainActivity.this));
            lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    switch (position){
                        case 0:
                            if (gethakAksesKpstAsyn()==false) {
                                Toast.makeText(MainActivity.this, "Anda tidak berhak untuk Menu ini ", Toast.LENGTH_LONG).show();
                            } else {
                                DmsOverviewActivity.toDmsOverviewActivity(MainActivity.this,
                                        lisPrinciple.get(spnPrinciple.getSelectedItemPosition()));
                            }
                            break;
                        case 1:
                            DmsPrincipalActivity.toDmsPrincipalActivity(MainActivity.this,
                                    lisPrinciple.get(spnPrinciple.getSelectedItemPosition()));
                            break;
                        case 2:
                            DmsHistoryActivity.toDmsHistoryActivity(MainActivity.this,
                                    lisPrinciple.get(spnPrinciple.getSelectedItemPosition()));
                            break;
                        case 3:
                            SettingActivity.toSettingActivity(MainActivity.this);
                            break;
                    }
                }
            });
        }
    }

    private void getPrincipleAsyn(){
        String module = "A";
        String user = appPreference.getUsername();
        String passwd = appPreference.getPassword();
        pbIndicator.setVisibility(View.VISIBLE);
        spnPrinciple.setEnabled(false);

        Call<PrincipleResponse> getPrinciple = apiClient.PrincipalForUse(module, user, passwd);
        getPrinciple.enqueue(new Callback<PrincipleResponse>() {
            @Override
            public void onResponse(Response<PrincipleResponse> response, Retrofit retrofit) {
                pbIndicator.setVisibility(View.GONE);
                parsingResponse(response);
            }

            @Override
            public void onFailure(Throwable t) {
                pbIndicator.setVisibility(View.GONE);
            }
        });
    }

    private void parsingResponse(Response<PrincipleResponse> response){
        PrincipleResponse res = response.body();
        if (res.status.equals(REQUEST_SUCCESS)) {
            if (res.listItem.size() > 0) {
                lisPrinciple = res.listItem;
                ArrayList<String> principleNames = new ArrayList<>();
                Collections.sort(principleNames);
                for (int i = 0; i < lisPrinciple.size(); i++) {
                    principleNames.add(lisPrinciple.get(i).priname);
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_dropdown_item_1line,
                        android.R.id.text1, principleNames);
                spnPrinciple.setEnabled(true);
                spnPrinciple.setAdapter(adapter);
            }
        }
    }

    public static void toMainActivity(Activity activity){
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public void update(Observable observable, Object data) {
        if (data.equals(AppObserver.EVENT_USERNAME_CHANGED) || data.equals(AppObserver.EVENT_PASSWORD_CHANGED) ){
            getPrincipleAsyn();
        }
    }

    public boolean gethakAksesKpstAsyn(){
        String module = "F";
        String user = appPreference.getUsername();
        Call<UserAksesResponse> getUserAkses = apiClient.GetHakAkesesForUser(module, user);
        getUserAkses.enqueue(new Callback<UserAksesResponse>() {
            @Override
            public void onResponse(Response<UserAksesResponse> response, Retrofit retrofit) {
                UserAksesResponse res = response.body();
                if (res.status.equals(REQUEST_SUCCESS)) {
                    if (res.listUserAksesItem.size() > 0) {
                        String akseskpst = res.listUserAksesItem.get(0).usraprkpst;
                    }
                } else {
                    String akseskpst = "N";
                }
            }
            @Override
            public void onFailure(Throwable t) {
                String akseskpst = "N";
            }
        });
        return true;
    }

    public boolean gethakAksesPrncAsyn(){
        String module = "F";
        String user = appPreference.getUsername();
        Call<UserAksesResponse> getUserAkses = apiClient.GetHakAkesesForUser(module, user);
        getUserAkses.enqueue(new Callback<UserAksesResponse>() {
            @Override
            public void onResponse(Response<UserAksesResponse> response, Retrofit retrofit) {
                UserAksesResponse res = response.body();
                if (res.status.equals(REQUEST_SUCCESS)) {
                    if (res.listUserAksesItem.size() > 0) {
                        String aksesprnc = res.listUserAksesItem.get(0).usraprprinc;
                    }
                } else {
                    String aksesprnc = "N";
                }
            }
            @Override
            public void onFailure(Throwable t) {
                String akseskpst = "N";
            }
        });
        return true;
    }

    // menu setting dan info aplication
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            SettingActivity.toSettingActivity(MainActivity.this);
            return true;
        }
        if (id == R.id.action_info) {
            AlertDialog alertHelp = new AlertDialog.Builder(MainActivity.this).create();
            alertHelp.setTitle("Info Aplication V.2.0 (2018)");
            alertHelp.setMessage("OVERVIEW : melihat list DMS Pengajuan dari Cabang dan ready untuk di approved(Sent) atau Cancel" +
                    "\n\nPRINCIPAL : melihat list DMS setelah Approved(Sent) oleh KPST yang menjadi beban Principal untuk Approved(Final/dapat di fakturkan) / Cancel (DMS tidak di setujui)\n\nHISTORY : list DMS yang saat ini " +
                    "aktif berlaku sampai masa berlaku nya berakhir atau sampai DMS di Closed\n\n" +
                    "Search : masukan no DMS / Cabang / Site untuk mencari cepat " +
                    " \n\nJika ada usulan atau kesulitan dalam penggunaan Aplikasi dapat menghubungi : software@mbs.co.id");
            alertHelp.setButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(final DialogInterface dialog, final int which) {
                    return;
                }
            });

            alertHelp.show();
        }
        return super.onOptionsItemSelected(item);
    }
}
