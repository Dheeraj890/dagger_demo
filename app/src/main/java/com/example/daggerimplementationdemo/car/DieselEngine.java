package com.example.daggerimplementationdemo.car;

import android.util.Log;

import com.example.daggerimplementationdemo.dagger.Engine;

import javax.inject.Inject;

public class DieselEngine implements Engine {

    private static final String TAG="Car";

    private int horsePower;

//  //@Inject
//    public DieselEngine(int horsePower){
//
//
//        this.horsePower=horsePower;
//    }


    ////Second Approach without instantiating horsepower object


    @Inject
    public DieselEngine(int horsePower){


        this.horsePower=horsePower;
    }



    @Override
    public void start() {


        Log.d(TAG,"Diseal Engine started , horsepower : "+horsePower);

    }
}
