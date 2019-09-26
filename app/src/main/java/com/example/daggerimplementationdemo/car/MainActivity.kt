package com.example.daggerimplementationdemo.car

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerimplementationdemo.R
import com.example.daggerimplementationdemo.dagger.DisealEngineModule
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @set:Inject
    internal  var car: Car?=null


    @set:Inject
    internal  var car1: Car?=null
    @set:Inject
    internal var remote: Remote?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //When there is no constuctor defined in module
        //var component=DaggerCarComponent.create()

     //   car=component.car
       // component.inject(this)

       // var component=DaggerCarComponent.builder().disealEngineModule(DisealEngineModule(100)).build()

        var component=DaggerCarComponent.builder().horsePower(150).engineCapacity(1400).build()
         component.inject(this)


        car=component.car
        car?.drive()
        car?.enableRemote(remote)

        car1=component.car
        car1?.drive()
        car1?.enableRemote(remote)
    }
}
