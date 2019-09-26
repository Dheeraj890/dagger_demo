package com.example.daggerimplementationdemo.dagger;

import com.example.daggerimplementationdemo.car.Rims;
import com.example.daggerimplementationdemo.car.Tires;
import com.example.daggerimplementationdemo.car.Wheel;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class WheelModule {

    @Provides
    static Rims provideRims(){

       return new Rims();
    }


    @Provides
    static Tires provideTires(){

        Tires tires=new Tires();
        tires.inflate();
        return tires;
    }


    @Provides
    static Wheel provideWheels(Rims rims, Tires tires){

        return new Wheel(rims,tires);
    }
}
