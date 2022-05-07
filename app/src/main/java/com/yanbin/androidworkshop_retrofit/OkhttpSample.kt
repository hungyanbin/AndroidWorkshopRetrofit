package com.yanbin.androidworkshop_retrofit

import okhttp3.*
import java.io.IOException

class OkhttpSample {

    private val client = OkHttpClient()

    fun getGithubUser(userName: String, onSuccess: (String) -> Unit) {
        val request = Request.Builder()
            .url("https://api.github.com/users/$userName")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {
                onSuccess(response.body!!.string())
            }
        })
    }
}