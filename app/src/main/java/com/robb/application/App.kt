package com.robb.application

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by robbs on 2016/8/6.
 * email:robbslu@gmail.com
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        val realmConfig = RealmConfiguration.Builder(this).deleteRealmIfMigrationNeeded().build()
        Realm.setDefaultConfiguration(realmConfig)  //数据库初始化
        Fresco.initialize(this)  //图片加载框架初始化
    }
}