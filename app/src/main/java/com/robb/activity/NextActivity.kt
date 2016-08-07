package com.robb.activity

import android.databinding.DataBindingUtil
import android.graphics.Color
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.robb.R
import com.robb.databinding.ActivityNextBinding
import com.robb.databinding.VpItemBinding
import com.robb.material.view.NavigationTabBar
import com.robb.mode.BaseServer
import io.realm.Realm
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.*


/**
 * Created by robbs on 2016/8/6.
 * email:robbslu@gmail.com
 */

class NextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind = DataBindingUtil.setContentView<ActivityNextBinding>(this, R.layout.activity_next)
        initUI(bind)
        val realm = Realm.getDefaultInstance()
//        val savedUser: PersonData? = RealmQuery.createQuery(realm, PersonData::class.java).findFirst()
        //        updateView(bind, savedUser)
        BaseServer.instance.getDataServer().takePersonInfo("f14c44cd6c74f7b4f7e154e7fa805bcb")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    person ->
                    realm.beginTransaction()
                    realm.copyToRealmOrUpdate(person.resData?.data)
                    realm.commitTransaction()
                    //                    updateView(bind, person.resData?.data)
                }, {
                    error ->
                    Toast.makeText(this, "Oops Sorry obtain data fail", Toast.LENGTH_SHORT).show()
                })
    }

    private fun initUI(bind: ActivityNextBinding) {

        bind.vpHorizontalNtb.adapter = object : PagerAdapter() {
            override fun getCount(): Int {
                return 3
            }

            override fun destroyItem(container: ViewGroup?, position: Int, `object`: Any?) {
                (container as ViewPager).removeView(`object` as View)
            }

            override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
                return view!!.equals(`object`)
            }

            override fun instantiateItem(container: ViewGroup, position: Int): Any {
                val binding = DataBindingUtil.inflate<VpItemBinding>(layoutInflater, R.layout.vp_item, container, false)
                binding.txtVpItemPage.text = String.format("Page #%d", position)
                container.addView(binding.root)
                return binding.root
            }
        }

        val colors = resources.getStringArray(R.array.default_preview)
        val models = ArrayList<NavigationTabBar.Model>()


        models.add(NavigationTabBar.Model.Builder(ContextCompat.getDrawable(this, R.mipmap.ic_first), Color.parseColor(colors[0])).title("学校")
                .badgeTitle("with")
                .build())
        models.add(NavigationTabBar.Model.Builder(ContextCompat.getDrawable(this, R.mipmap.ic_second), Color.parseColor(colors[1])).title("奖杯")
                .badgeTitle("with")
                .build())
        models.add(NavigationTabBar.Model.Builder(ContextCompat.getDrawable(this, R.mipmap.ic_third), Color.parseColor(colors[2])).title("学历")
                .badgeTitle("with")
                .build())
        val ntb = findViewById(R.id.ntb_tab) as NavigationTabBar
        ntb.models = models
        ntb.setViewPager(bind.vpHorizontalNtb, 0)
        ntb.onTabBarSelectedIndexListener = object : NavigationTabBar.OnTabBarSelectedIndexListener {
            override fun onStartTabSelected(model: NavigationTabBar.Model?, index: Int) {

            }

            override fun onEndTabSelected(model: NavigationTabBar.Model?, index: Int) {
                model?.hideBadge()
            }
        }

        ntb.post({
            bind.bgNtbHorizontal.layoutParams.height = ntb.barHeight.toInt()
            bind.bgNtbHorizontal.requestLayout()
        })

        ntb.postDelayed({
            for (i in 0..ntb.models.size - 1) {
                val model = ntb.models[i]
                when (i) {
                    0 ->
                        model.badgeTitle = "千千静听"

                    1 ->
                        model.badgeTitle = "旅途"

                    2 ->
                        model.badgeTitle = "校园"
                }
                ntb.postDelayed({
                    model.showBadge()
                }, i * 100.toLong())
            }
        }, 500)

    }

    override fun onDestroy() {
        super.onDestroy()
        System.runFinalization()
        Runtime.getRuntime().gc()
        System.gc()
    }

}
