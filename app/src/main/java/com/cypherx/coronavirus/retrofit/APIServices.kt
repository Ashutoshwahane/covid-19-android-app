package com.cypherx.coronavirus.retrofit

import com.cypherx.coronavirus.model.AllData
import com.cypherx.coronavirus.model.WorldStat
import com.cypherx.coronavirus.model.latest
import com.cypherx.coronavirus.model.locations
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface APIServices {

    @GET("v2/latest?source=jhu")
    fun getAllStatics() : Call<AllData>

    @GET("v2/locations?source=jhu&county={country_name}")
    fun getCountryStatics() : Call<locations>

    @GET("coronavirus/worldstat.php")
    fun getWorldStat() : Call<WorldStat>

}