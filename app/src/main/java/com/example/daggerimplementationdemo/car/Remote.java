package com.example.daggerimplementationdemo.car;

import android.util.Log;

import javax.inject.Inject;

class Remote {


    @Inject
    public Remote(){}

    public void setListener(Car car) {

        Log.d("Remote","Remote connected");
    }
}
