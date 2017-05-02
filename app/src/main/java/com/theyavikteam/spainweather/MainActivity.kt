package com.theyavikteam.spainweather

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.theyavikteam.spainweather.data.TownForecastJob
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class MainActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvDays.layoutManager = LinearLayoutManager(this)
        initializeRetrofit()
        loadLocalities()
    }

    fun initializeRetrofit() {
//        val townForecastJob = TownForecastJob(true)
//        townForecastJob.execute("11032")
//        townForecastJob.useResponse {
//            with(townForecastJob.response) {
//                tvCity.text = city
//                tvProvince.text = province
//                rvDays.adapter = DailyForecastAdapter(prediction.days)
//            }
//        }
//
//    }
        doAsync {
            val townApi = Api.retrofit.create(TownApi::class.java)
            val call = townApi.dailyForecast("11032", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ5YXZpazE0QGdtYWlsLmNvbSIsImp0aSI6Ijg5ZDM2YzZlLTEyOGQtNDAyMC1hNTAxLTM1MjUyODc2OWI3ZiIsImV4cCI6MTUwMDI3NTk5MywiaXNzIjoiQUVNRVQiLCJpYXQiOjE0OTI0OTk5OTMsInVzZXJJZCI6Ijg5ZDM2YzZlLTEyOGQtNDAyMC1hNTAxLTM1MjUyODc2OWI3ZiIsInJvbGUiOiIifQ.RmHivUS37ikYr4LHWiExLJt5yOXTvxCwghieFF7RT7g")
            val result = call.execute().body()
            val resultSplit = result.data.split("sh/")[1]

            val call2 = townApi.dailyForecastPrediction(resultSplit)
            val result2 = call2.execute().body()
            uiThread {
                tvCity.text = result2[0].city
                tvProvince.text = result2[0].province
                rvDays.adapter = DailyForecastAdapter(result2[0].prediction.days)
            }
        }
    }

    fun loadLocalities() {
        try {
            val csvStreamReader: InputStreamReader = InputStreamReader(assets.open("localidades.csv"))
            val csvReader: BufferedReader = BufferedReader(csvStreamReader)
            var line: String?
            line = csvReader.readLine()
            while (line != null) {
                //TODO
                line = csvReader.readLine()
            }
        } catch (exception: IOException) {

        }
    }
}

