package com.example.daggerimplementationdemo.car;


import com.example.daggerimplementationdemo.dagger.DisealEngineModule;
import com.example.daggerimplementationdemo.dagger.PetrolEngineModule;
import com.example.daggerimplementationdemo.dagger.WheelModule;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {WheelModule.class, PetrolEngineModule.class})
public interface CarComponent {


    Car getCar();

    void inject(MainActivity mainActivity);

    @Component.Builder
    interface Builder{


        CarComponent build();

        @BindsInstance
        Builder horsePower(@Named("horse power") int horsePower);


        @BindsInstance
        Builder engineCapacity(@Named("engine capacity") int engineCapacity);

    }
}
