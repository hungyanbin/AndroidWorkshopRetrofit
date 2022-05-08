package com.yanbin.androidworkshop_retrofit

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*


interface GitHubApi {

    @GET("users/{user}")
    fun getUserInfo(@Path("user") user: String): Call<User>
}

class RetrofitSample {

    private val gitHubApi: GitHubApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        gitHubApi = retrofit.create(GitHubApi::class.java)
    }

    fun getGithubUser(user: String, onSuccess: (String) -> Unit){
        val call = gitHubApi.getUserInfo(user)
        call.enqueue(object: Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                onSuccess(response.body()?.toString() ?: "")
            }

            override fun onFailure(call: Call<User>, t: Throwable) {

            }
        })
    }
}