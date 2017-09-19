package com.example.maciek.paragon;

/**
 * Created by Maciek on 17.09.2017.
 */

public interface ParPresenter<V extends ParView> {

    void onAttach(V ParView);
}
