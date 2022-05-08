package com.yanbin.androidworkshop_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val okhttpSample = OkhttpSample()
    private val retrofitSample = RetrofitSample()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textResponse = findViewById<TextView>(R.id.textResponse)

        findViewById<Button>(R.id.btnOkhttp).setOnClickListener {
            textResponse.text  = "Loading..."
            okhttpSample.getGithubUser("hungyanbin", onSuccess = {
                textResponse.text  = it
            })
        }

        findViewById<Button>(R.id.btnRetrofit).setOnClickListener {
            textResponse.text  = "Loading..."
            retrofitSample.getGithubUser("hungyanbin", onSuccess = {
                textResponse.text  = it
            })
        }
    }
}