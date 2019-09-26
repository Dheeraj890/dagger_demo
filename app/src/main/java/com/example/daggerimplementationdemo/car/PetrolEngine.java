package com.example.daggerimplementationdemo.car;

import android.util.Log;

import com.example.daggerimplementationdemo.dagger.Engine;

import javax.inject.Inject;
import javax.inject.Named;

public class PetrolEngine implements Engine {

    private static final String TAG="Car";

    private int horsePower;

    private int engineCapacity;

    public PetrolEngine(){}

    @Inject
    public PetrolEngine(@Named("horse power") int horsePower, @Named("engine capacity") int engineCapacity) {
        this.horsePower = horsePower;
        this.engineCapacity=engineCapacity;
    }

    @Override
    public void start() {


        Log.d(TAG,"Petrol Engine started.HorsePower "+horsePower+"\n engine capacity "+engineCapacity);
    }
}
