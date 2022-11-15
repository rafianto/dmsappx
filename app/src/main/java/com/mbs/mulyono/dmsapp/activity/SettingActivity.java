package com.mbs.mulyono.dmsapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.mbs.mulyono.dmsapp.R;
import com.mbs.mulyono.dmsapp.base.BaseActivity;
import com.mbs.mulyono.dmsapp.base.BaseApplication;

import java.util.Observable;
import java.util.Observer;

public class SettingActivity extends BaseActivity implements Observer{
    private EditText edtUsername,edtPassword;
    private CheckBox edtMode;
    private Button btnSubmit;

    private boolean isFirst = false;
    private BaseApplication baseApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        edtUsername = (EditText)findViewById(R.id.edt_username);
        edtPassword = (EditText)findViewById(R.id.edt_password);
        edtMode = (CheckBox)findViewById(R.id.edt_mode);
        btnSubmit = (Button)findViewById(R.id.btn_save);

        baseApplication = (BaseApplication)getApplication();
        baseApplication.getAppObserver().addObserver(this);

        if (!appPreference.getUsername().equals("") || !appPreference.getPassword().equals("")){
            isFirst = false;
            edtUsername.setText(appPreference.getUsername());
            edtPassword.setText(appPreference.getPassword());

            Log.d("debug-sa : ",appPreference.getMode().toString().trim());
            if (appPreference.getMode().toString().trim()=="Y") {
                edtMode.setChecked(true);
            } else {
                edtMode.setChecked(false);
            }

        }else{
            isFirst = true;
        }

        getSupportActionBar().setTitle("Settings");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                String modex;
                if (edtMode.isChecked()) {
                    edtMode.setChecked(true);
                    modex = "Y";
                } else {
                    edtMode.setChecked(false);
                    modex = "N";
                }

                if (!username.equals("") || !password.equals("")){
                    appPreference.setUsername(username);
                    appPreference.setPassword(password);
                    appPreference.setMode(modex);
                    if (isFirst){
                        MainActivity.toMainActivity(SettingActivity.this);
                    }else{
                        baseApplication.getAppObserver().notifyUsenameChanged();
                        baseApplication.getAppObserver().notifyPasswordChanged();
                    }
                    Toast.makeText(SettingActivity.this, "Data username & password tersimpan ", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(SettingActivity.this, "Username & Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public static void toSettingActivity(Activity activity){
        Intent intent = new Intent(activity, SettingActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public void update(Observable observable, Object data) {

    }

    @Override
    protected void onDestroy() {
        baseApplication.getAppObserver().deleteObserver(this);
        super.onDestroy();
    }
}
