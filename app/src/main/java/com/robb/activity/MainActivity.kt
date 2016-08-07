package com.robb.activity

import android.content.Intent
import android.databinding.DataBindingUtil
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.robb.R
import com.robb.databinding.ActivityMainBinding
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

/**
 *  Created by robb on 12/5/2016.
 *  email:robbslu@gmail.com
 * 默认界面启动入口
 *
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.startImg.setImageURI(Uri.parse(""), null)
        Observable.timer(3000, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
                .subscribe {
                    cell: Long ->
                    startActivity(Intent(this, NextActivity::class.java))
                    finish()
                }
    }
}
