package com.theyavikteam.spainweather

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TownApi {

    //https://opendata.aemet.es/opendata/api/prediccion/especifica/municipio/horaria/11032?api_key=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ5YXZpazE0QGdtYWlsLmNvbSIsImp0aSI6Ijg5ZDM2YzZlLTEyOGQtNDAyMC1hNTAxLTM1MjUyODc2OWI3ZiIsImV4cCI6MTUwMDI3NTk5MywiaXNzIjoiQUVNRVQiLCJpYXQiOjE0OTI0OTk5OTMsInVzZXJJZCI6Ijg5ZDM2YzZlLTEyOGQtNDAyMC1hNTAxLTM1MjUyODc2OWI3ZiIsInJvbGUiOiIifQ.RmHivUS37ikYr4LHWiExLJt5yOXTvxCwghieFF7RT7g
    //https://opendata.aemet.es/opendata/sh/690704ba
    //https://opendata.aemet.es/opendata/api/prediccion/especifica/municipio/diaria/11032?api_key=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ5YXZpazE0QGdtYWlsLmNvbSIsImp0aSI6Ijg5ZDM2YzZlLTEyOGQtNDAyMC1hNTAxLTM1MjUyODc2OWI3ZiIsImV4cCI6MTUwMDI3NTk5MywiaXNzIjoiQUVNRVQiLCJpYXQiOjE0OTI0OTk5OTMsInVzZXJJZCI6Ijg5ZDM2YzZlLTEyOGQtNDAyMC1hNTAxLTM1MjUyODc2OWI3ZiIsInJvbGUiOiIifQ.RmHivUS37ikYr4LHWiExLJt5yOXTvxCwghieFF7RT7g
    //https://opendata.aemet.es/opendata/sh/d0cd3a87

    @GET("api/prediccion/especifica/municipio/horaria/{townId}")
    fun timeForecast(@Path("townId") townId:String, @Query("api_key") apiKey:String):Call<AemetResponse>

    @GET("api/prediccion/especifica/municipio/diaria/{townId}")
    fun dailyForecast(@Path("townId") townId:String, @Query("api_key") apiKey:String):Call<AemetResponse>

    @GET("sh/{forecastId}")
    fun dailyForecastPrediction(@Path("forecastId")forecastId:String):Call<List<AemetDailyResponse>>

}