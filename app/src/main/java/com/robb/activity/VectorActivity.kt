package com.robb.activity

import android.databinding.DataBindingUtil
import android.graphics.drawable.Animatable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.robb.R
import com.robb.databinding.ActivityVectorBinding
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

/**
 * Created by robbs on 2016/8/6.
 * email:robbslu@gmail.com
 */
class VectorActivity : AppCompatActivity() {
    var animation: Animatable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind = DataBindingUtil.setContentView<ActivityVectorBinding>(this, R.layout.activity_vector)
        if (bind.vectorDrawableCpuAni.drawable is Animatable) {
            animation = (bind.vectorDrawableCpuAni.drawable as Animatable)
            animation?.start()
        }
        Observable.timer(1000, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).subscribe {
            cell ->
            animation?.stop()
        }
    }
}
