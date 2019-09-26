package com.example.daggerimplementationdemo.car;

import javax.inject.Inject;

public class Wheel {

    @Inject
    public Wheel(){


    }

    public Wheel(Rims rims, Tires tires) {
    }
}
