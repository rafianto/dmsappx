package com.mbs.mulyono.dmsapp.observer;

import java.util.Observable;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class AppObserver extends Observable{
    public static String EVENT_USERNAME_CHANGED = "username_changed";
    public static String EVENT_PASSWORD_CHANGED = "password_changed";
    public static String EVENT_PROSESS_CHANGED = "prosesdms_changed";

    public void notifyUsenameChanged(){
        setChanged();
        notifyObservers(EVENT_USERNAME_CHANGED);
    }

    public void notifyPasswordChanged(){
        setChanged();
        notifyObservers(EVENT_PASSWORD_CHANGED);
    }

    public void notifyProsessChanged() {
        setChanged();
        notifyObservers(EVENT_PROSESS_CHANGED);
    }


}
