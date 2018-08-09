package com.marlonmoorer.timeline.api

import com.marlonmoorer.timeline.api.models.LineListResults
import io.reactivex.Maybe
import retrofit2.Call
import retrofit2.http.GET
import rx.Observable
import rx.Observer


interface WmataService {
    companion object {
        val baseUrl="https://api.wmata.com/"
    }

    @GET("Rail.svc/json/jLines")
    fun getRailLines(): Maybe<LineListResults>

}