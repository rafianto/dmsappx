package com.mbs.mulyono.dmsapp.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mbs.mulyono.dmsapp.api.ApiClient;
import com.mbs.mulyono.dmsapp.api.ApiService;
import com.mbs.mulyono.dmsapp.preference.AppPreference;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class BaseActivity extends AppCompatActivity {
    public ApiClient apiClient;
    public AppPreference appPreference;
    public String REQUEST_SUCCESS = "Success";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiClient = ApiService.CreateService(ApiClient.class);
        appPreference = new AppPreference(BaseActivity.this);
    }
}
