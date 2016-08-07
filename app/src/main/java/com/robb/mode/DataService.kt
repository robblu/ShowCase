package com.robb.mode

import com.robb.mode.bean.PersonBean
import retrofit.http.Field
import retrofit.http.FormUrlEncoded
import retrofit.http.POST
import rx.Observable

/**
 * Created by robb on 22/4/2016.
 * email:robbslu@gmail.com
 */

interface DataService {
    //    @GET("users/{username}")
    //    fun getGithubUser(@Path("username") username: String): Observable<GithubBean>

    //获取个人信息
    @FormUrlEncoded
    @POST("/dif/account/userInfo?client_id=10000&response_type=token")
    fun takePersonInfo(@Field("token") token: String): Observable<PersonBean>

}



