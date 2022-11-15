package com.mbs.mulyono.dmsapp.preference;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class AppPreference {
    private String KEY_PREFS_NAME = "dmsApp";
    private String KEY_USERNAME = "username";
    private String KEY_PASSWORD = "password";
    private String KEY_MODE = "mode";
    private SharedPreferences.Editor editor;
    private SharedPreferences sharedPreferences;
    private Activity activity;

    public AppPreference(Activity activity){
        this.activity = activity;
        sharedPreferences = activity.getSharedPreferences(KEY_PREFS_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setUsername(String username){
        editor.putString(KEY_USERNAME, username);
        editor.commit();
    }

    public String getUsername(){
        return sharedPreferences.getString(KEY_USERNAME, "");
    }

    public void setPassword(String password){
        editor.putString(KEY_PASSWORD, password);
        editor.commit();
    }

    public String getPassword(){
        return sharedPreferences.getString(KEY_PASSWORD, "");
    }


    public void setMode(String mode){
        editor.putString(KEY_MODE, mode);
        editor.commit();
    }

    public String getMode(){
        return sharedPreferences.getString(KEY_MODE, "");
    }

    public void clear(){
        editor.clear();
        editor.commit();
    }
}
