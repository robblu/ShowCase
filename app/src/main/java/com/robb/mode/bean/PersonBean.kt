package com.robb.mode.bean

/**
 * Created by robb on 22/4/2016.
 * email:robbslu@gmail.com
 */
open class PersonBean {

    var resStatus: String? = null

    var resMessage: String? = null

    open var resData: ResData? = null

    open class ResData {
        open var data: PersonData? = null
    }

}