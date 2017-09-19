package com.example.maciek.paragon;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Maciek on 17.09.2017.
 */

public class SharedPrefsHelper {

    public static final String MY_PREFS = "MY_PREFS";
    public static final String SELLER = "SELLER";
    public static final String DATE = "DATE";
    public static final String VALUE = "VALUE";
    //public static final String RECEIPTIMAGE = "RECEIPTIMAGE";

    SharedPreferences mSharedPreferences;

    public SharedPrefsHelper(Context context) {
        mSharedPreferences = context.getSharedPreferences(MY_PREFS, MODE_PRIVATE);
    }

    public void clear() {
        mSharedPreferences.edit().clear().apply();
    }

    public void putSeller(String seller) {
        mSharedPreferences.edit().putString(SELLER, seller).apply();
    }

    public String getSeller() {
        return mSharedPreferences.getString(SELLER, null);
    }

    public void putDate(String date) {
        mSharedPreferences.edit().putString(DATE, date).apply();
    }

    public String getDate() {
        return mSharedPreferences.getString(DATE, null);
    }

    public void putValue(String val) {
        mSharedPreferences.edit().putString(VALUE, val).apply();
    }

    public String getValue() {
        return mSharedPreferences.getString(VALUE, null);
    }

//    public boolean getLoggedInMode() {
//        return mSharedPreferences.getBoolean("IS_LOGGED_IN", false);
//    }
//
//    public void setLoggedInMode(boolean loggedIn) {
//        mSharedPreferences.edit().putBoolean("IS_LOGGED_IN", loggedIn).apply();
//    }

}
