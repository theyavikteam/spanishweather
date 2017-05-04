package com.theyavikteam.spainweather

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication : Application() {

    val aemetEndpoint = "https://opendata.aemet.es/opendata/"

    override fun onCreate() {
        super.onCreate()
        val api = Api
        api.retrofit = Retrofit.Builder()
                .baseUrl(aemetEndpoint)
                .client(SelfSigningClientBuilder.createClient(this, Api.client))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}