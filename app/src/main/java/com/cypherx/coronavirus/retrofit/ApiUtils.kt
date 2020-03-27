package com.cypherx.coronavirus.retrofit

class ApiUtils {
    companion object {
//        var BASE_URL = "https://coronavirus-tracker-api.herokuapp.com/"
//        var BASE_URL = "https://coronavirus-monitor.p.rapidapi.com/"
        var BASE_URL = "https://ashutoshwahane.github.io/"

        fun getApiService(): APIServices {
            return RetrofitClient.getClient(BASE_URL).create(APIServices::class.java)
        }
    }
}