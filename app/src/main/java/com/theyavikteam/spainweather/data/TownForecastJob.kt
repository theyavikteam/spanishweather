package com.theyavikteam.spainweather.data

import com.theyavikteam.spainweather.AemetDailyResponse
import com.theyavikteam.spainweather.Api
import com.theyavikteam.spainweather.TownApi
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TownForecastJob(var waitUI: Boolean) {

    var dailyResponse: List<AemetDailyResponse> = emptyList()
    val response: AemetDailyResponse by lazy { dailyResponse[0] }

    private fun askQuestion(question: String): List<AemetDailyResponse> {
        val townApi = Api.retrofit.create(TownApi::class.java)
        val firstCall = townApi.dailyForecast(question, "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ5YXZpazE0QGdtYWlsLmNvbSIsImp0aSI6Ijg5ZDM2YzZlLTEyOGQtNDAyMC1hNTAxLTM1MjUyODc2OWI3ZiIsImV4cCI6MTUwMDI3NTk5MywiaXNzIjoiQUVNRVQiLCJpYXQiOjE0OTI0OTk5OTMsInVzZXJJZCI6Ijg5ZDM2YzZlLTEyOGQtNDAyMC1hNTAxLTM1MjUyODc2OWI3ZiIsInJvbGUiOiIifQ.RmHivUS37ikYr4LHWiExLJt5yOXTvxCwghieFF7RT7g")
        val firstResult = firstCall.execute().body()
        val firstResultSplit = firstResult.data.split("sh/")[1]

        val secondCall = townApi.dailyForecastPrediction(firstResultSplit)
        return secondCall.execute().body()
    }

    fun execute(question: String) {
        doAsync {
            dailyResponse = askQuestion(question)
        }
    }

    fun useResponse(body: AemetDailyResponse?.() -> Unit) {
        doAsync {
            if (waitUI) {
                uiThread { body(response) }
            } else {
                body(response)
            }
        }
    }
}