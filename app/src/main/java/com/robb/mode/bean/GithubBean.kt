package com.robb.mode.bean

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

/**
 * Created by robb on 22/4/2016.
 * email:gpicsdesigner@gmail.com
 */
@RealmClass
open class GithubBean : RealmObject() {
    @PrimaryKey
    @SerializedName("id")
    @Expose
    open var id: Int = 0

    @SerializedName("avatar_url")
    @Expose
    open var avatarUrl: String? = null

    @SerializedName("name")
    @Expose
    open var name: String? = null

    @SerializedName("public_repos")
    @Expose
    open var publicRepos: Int? = null

}