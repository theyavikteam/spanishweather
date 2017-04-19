package com.theyavikteam.spainweather

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeRetrofit()
    }

    fun initializeRetrofit(){
        val client = OkHttpClient.Builder().build()
        val retrofit = Retrofit.Builder()
                .baseUrl("https://opendata.aemet.es/opendata/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val townApi = retrofit.create(TownApi::class.java)
        val call = townApi.dailyForecast("11032", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ5YXZpazE0QGdtYWlsLmNvbSIsImp0aSI6Ijg5ZDM2YzZlLTEyOGQtNDAyMC1hNTAxLTM1MjUyODc2OWI3ZiIsImV4cCI6MTUwMDI3NTk5MywiaXNzIjoiQUVNRVQiLCJpYXQiOjE0OTI0OTk5OTMsInVzZXJJZCI6Ijg5ZDM2YzZlLTEyOGQtNDAyMC1hNTAxLTM1MjUyODc2OWI3ZiIsInJvbGUiOiIifQ.RmHivUS37ikYr4LHWiExLJt5yOXTvxCwghieFF7RT7g")
        val result = call.execute().body()
    }
}
