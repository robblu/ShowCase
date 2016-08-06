package com.robb.mode.bean

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

/**
 * Created by robb on 26/4/2016.
 * email:gpicsdesigner@gmail.com
 */
@RealmClass
open class PersonData : RealmObject() {
    @PrimaryKey
    @SerializedName("uid")
    @Expose
    open var uid: String? = null

    @SerializedName("digit")
    @Expose
    open var digit: String? = null

    @SerializedName("uname")
    @Expose
    open var uname: String? = null

    @SerializedName("cellNum")
    @Expose
    open var cellNum: String? = null

    @SerializedName("avatar")
    @Expose
    open var avatar: String? = null

    @SerializedName("nickName")
    @Expose
    open var nickName: String? = null

    @SerializedName("codeInvite")
    @Expose
    open var codeInvite: String? = null

    @SerializedName("fullName")
    @Expose
    open var fullName: String? = null

    @SerializedName("bankAccount")
    @Expose
    open var bankAccount: String? = null

    @SerializedName("bankName")
    @Expose
    open var bankName: String? = null

    @SerializedName("bankBranch")
    @Expose
    open var bankBranch: String? = null

    @SerializedName("amountFee")
    @Expose
    open var amountFee: String? = null

    @SerializedName("idcardNum")
    @Expose
    open var idcardNum: String? = null

    @SerializedName("brokerType")
    @Expose
    open var brokerType: String? = null
}