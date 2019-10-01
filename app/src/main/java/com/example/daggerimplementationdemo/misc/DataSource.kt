package com.example.daggerimplementationdemo.misc

import com.example.daggerimplementationdemo.model.Task

class DataSource {


    companion object{

        fun createTaskList():List<Task>{


            var list=ArrayList<Task>()

            list.add(Task("This is first description",true,5))
            list.add(Task("This is second description",false,1))
            list.add(Task("This is third description",true,3))
            list.add(Task("This is fourth description",false,5))
            list.add(Task("This is fifth description",true,8))
            list.add(Task("This is sixth description",true,2))
            list.add(Task("This is seventh description",false,9))



return list;
        }

    }
}