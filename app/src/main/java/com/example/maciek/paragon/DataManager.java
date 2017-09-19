package com.example.maciek.paragon;

/**
 * Created by Maciek on 17.09.2017.
 */

public class DataManager {

    SharedPrefsHelper mSharedPrefsHelper;

    public DataManager(SharedPrefsHelper sharedPrefsHelper) {
        mSharedPrefsHelper = sharedPrefsHelper;
    }

    public void clear() {
        mSharedPrefsHelper.clear();
    }

    public void saveSellerId(String seller) {
        mSharedPrefsHelper.putSeller(seller);
    }

    public String getSellerId() {
        return mSharedPrefsHelper.getSeller();
    }

    public void saveTransactionDate(String date) {
        mSharedPrefsHelper.putDate(date);
    }

    public String getTransactionDate() {
        return mSharedPrefsHelper.getDate();
    }

    public void saveTransactionValue(String value) {
        mSharedPrefsHelper.putSeller(value);
    }

    public String getTransactionValue() {
        return mSharedPrefsHelper.getSeller();
    }

//    public void setLoggedIn() {
//        mSharedPrefsHelper.setLoggedInMode(true);
//    }
//
//    public Boolean getLoggedInMode() {
//        return mSharedPrefsHelper.getLoggedInMode();
//    }
}