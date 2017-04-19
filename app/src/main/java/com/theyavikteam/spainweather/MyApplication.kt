package com.theyavikteam.spainweather

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication:Application(){

    override fun onCreate() {
        super.onCreate()
        val api = Api
        api.context = this
        api.retrofit= Retrofit.Builder()
                .baseUrl("https://opendata.aemet.es/opendata/")
                .client(SelfSigningClientBuilder.createClient(Api.context, Api.client))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}