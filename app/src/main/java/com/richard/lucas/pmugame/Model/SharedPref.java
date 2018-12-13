package com.richard.lucas.pmugame.Model;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.richard.lucas.pmugame.Controller.MainActivity;

/**
 * Created by lucas on 13/12/2018.
 */
public class SharedPref {
    private static SharedPreferences mSharedPref;
    public static final String DiamondCount = "diamondCount";
    public static final String HeartCount = "heartCount";
    public static final String ClubCount = "clubCount";
    public static final String SpadeCount = "SpadeCount";

    static Context applicationContext = MainActivity.getContextOfApplication();

    private SharedPref() {
    }

    public static void init(Context context) {
        if(mSharedPref == null)
            mSharedPref = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
    }

    public static String read(String key, String defValue) {
        return mSharedPref.getString(key, defValue);
    }

    public static void write(String key, String value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putString(key, value);
        prefsEditor.commit();
    }

    public static boolean read(String key, boolean defValue) {
        return mSharedPref.getBoolean(key, defValue);
    }

    public static void write(String key, boolean value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putBoolean(key, value);
        prefsEditor.commit();
    }

    public static Integer read(String key, int defValue) {
        return mSharedPref.getInt(key, defValue);
    }

    public static void write(String key, Integer value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putInt(key, value).commit();
    }
}