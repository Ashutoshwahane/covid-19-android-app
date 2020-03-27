package com.cypherx.coronavirus.retrofit

import com.cypherx.coronavirus.model.IndiaState
import com.cypherx.coronavirus.model.WorldStat
import retrofit2.Call
import retrofit2.http.GET

interface APIServices {

    @GET("world_stats.json")
    fun getWorldStat() : Call<WorldStat>

    @GET("state_stats.json")
    fun getStateStat() : Call <IndiaState>

}