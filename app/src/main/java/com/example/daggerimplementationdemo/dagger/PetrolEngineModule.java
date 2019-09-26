package com.example.daggerimplementationdemo.dagger;


import com.example.daggerimplementationdemo.car.PetrolEngine;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class PetrolEngineModule {


//    @Provides
//    Engine provideEngine(PetrolEngine engine){
//
//        return engine;
//    }


    @Binds
    abstract Engine bindEngine(PetrolEngine engine);

}
