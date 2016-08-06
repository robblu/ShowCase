package com.robb.mode.bean

/**
 * Created by robb on 26/4/2016.
 * email:gpicsdesigner@gmail.com
 * 个人信息
 * 数据由Data存储 这里负责基础引用
 */

open class PersonBean {

    var resStatus: String? = null

    var resMessage: String? = null

    open var resData: ResData? = null

    open class ResData {
        open var data: PersonData? = null
    }

}