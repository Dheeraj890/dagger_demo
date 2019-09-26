package com.example.daggerimplementationdemo.dagger;


import android.util.Log;

import com.example.daggerimplementationdemo.car.DieselEngine;

import javax.inject.Inject;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public  class DisealEngineModule {

     int horsePower;

    public DisealEngineModule(int horsePower) {
        this.horsePower = horsePower;
    }

//    @Provides
//    Engine provideEngine(PetrolEngine engine){
//
//        return engine;
//    }



    //Bind annotation can be used on the case of Interface.We can directlly return a Interface instance without calling the claaa
    //which has implemented this.
//    @Binds
//    abstract Engine bindEngine(DieselEngine engine);

//
//        @Provides
//    Engine provideEngine(){
//
//            Log.d("Diseal Engine module ",horsePower+"");
//        return new DieselEngine(horsePower);
//    }




    @Provides
    Engine provideEngine(DieselEngine dieselEngine){


        return dieselEngine;
    }

    @Provides
    int provideHorsePower(){

        return horsePower;
    }


}
