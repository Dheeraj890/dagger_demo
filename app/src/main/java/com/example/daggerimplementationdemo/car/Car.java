package com.example.daggerimplementationdemo.car;

import android.util.Log;

import com.example.daggerimplementationdemo.dagger.Engine;

import javax.inject.Inject;

public class Car {

private static final String TAG="Car";

Engine engine;

Wheel wheel;


   @Inject
    public Car(Engine engine, Wheel wheel) {
        this.engine = engine;
        this.wheel = wheel;
    }

    public void drive(){

       engine.start();
        Log.d(TAG,"driving");
    }

    @Inject
    public void enableRemote(Remote remote){

       remote.setListener(this);
    }
}

//Video to continue from 6
//Link -:  https://www.youtube.com/watch?v=3itfTHKFOqY
