package com.example.daggerimplementationdemo.car;

import android.util.Log;

import com.example.daggerimplementationdemo.dagger.Engine;

import javax.inject.Inject;

public class Car {

private static final String TAG="Car";

Engine engine;

Wheel wheel;

private Driver driver;

   @Inject
    public Car(Driver driver,Engine engine, Wheel wheel) {
       this.driver=driver;
        this.engine = engine;
        this.wheel = wheel;
    }

    public void drive(){

       engine.start();
        Log.d(TAG,"driver "+driver+" drives "+this );
    }

    @Inject
    public void enableRemote(Remote remote){

       remote.setListener(this);
    }
}

//Video to continue from 6
//Link -:  https://www.youtube.com/watch?v=V-CF0BGA-3w
