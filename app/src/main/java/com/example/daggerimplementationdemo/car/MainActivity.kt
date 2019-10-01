package com.example.daggerimplementationdemo.car

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.daggerimplementationdemo.MyService
import com.example.daggerimplementationdemo.dagger.DisealEngineModule
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.app.Notification
import android.app.Service
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.example.daggerimplementationdemo.R
import com.example.daggerimplementationdemo.misc.DataSource
import com.example.daggerimplementationdemo.model.Task
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Predicate
import io.reactivex.schedulers.Schedulers
import java.util.Locale.filter


class MainActivity : AppCompatActivity() {
    @set:Inject
    internal  var car: Car?=null


    @set:Inject
    internal  var car1: Car?=null
    @set:Inject
    internal var remote: Remote?=null

    var compoSiteDisposable:CompositeDisposable= CompositeDisposable();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var taskObservable=Observable.fromIterable(com.example.daggerimplementationdemo.misc.DataSource.createTaskList()).

            subscribeOn(Schedulers.io()).filter(Predicate {

        Log.d("On ",Thread.currentThread().name)
            Thread.sleep(1000)

            it.isComplete

        })

            .observeOn(AndroidSchedulers.mainThread())





        taskObservable.subscribe(object : Observer<Task> {
            override fun onSubscribe(d: Disposable) {

                Log.d("On Subscribe","Subscribe");
                compoSiteDisposable.add(d)

            }

            override fun onNext(task: Task) {


                Log.d("On the Observer Next Part",Thread.currentThread().name)

                Log.d("On Next",""+task.description);


            }

            override fun onError(e: Throwable) {

                Log.d("On Error","Subscribe");

            }

            override fun onComplete() {
                Log.d("On Complete","Completed");

            }
        })

        buttonService.run {
            setOnClickListener(View.OnClickListener {


//                val notification: Notification = NotificationCompat.Builder(applicationContext, packageName)
//                    .setSmallIcon(R.drawable.ic_launcher_background)
//                    .setContentTitle(getString(R.string.app_name))
//                    .setContentText(getString(R.string.app_name))
//
//                    .setColor(ContextCompat.getColor(applicationContext, R.color.colorAccent))
//                    .build()
//                startForeground(1,notification)

                Intent(applicationContext, MyService::class.java).also { intent ->

                    startService(intent)

                }



            })
        }

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


    override fun onDestroy() {
        super.onDestroy()

        compoSiteDisposable.dispose()
    }
}
