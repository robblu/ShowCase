package com.robb.mode

import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes
import com.google.gson.GsonBuilder
import io.realm.RealmObject
import retrofit.GsonConverterFactory
import retrofit.Retrofit
import retrofit.RxJavaCallAdapterFactory

/**
 * Created by robb on 22/4/2016.
 * email:gpicsdesigner@gmail.com
 * 单例模式 的服务提供类
 */
class BaseServer private constructor() {

    private object Holder {
        val INSTANCE = BaseServer()
    }

    companion object {
        val instance: BaseServer by lazy { Holder.INSTANCE }
    }

    fun getDataServer(): DataService {
        val gson = GsonBuilder().setExclusionStrategies(object : ExclusionStrategy {
            override fun shouldSkipField(f: FieldAttributes): Boolean {
                return f.declaringClass == RealmObject::class.java
            }

            override fun shouldSkipClass(clazz: Class<*>): Boolean {
                return false
            }
        }).create()

        val retrofit: Retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("http://qmdj.xinle366.com")
                .build()

        val dataService = retrofit.create(DataService::class.java)
        return dataService
    }

}