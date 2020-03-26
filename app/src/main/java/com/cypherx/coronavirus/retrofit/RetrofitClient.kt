package com.cypherx.coronavirus.retrofit

import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {
    companion object {
    var host = "coronavirus-monitor.p.rapidapi.com"
        var key = "f20c2bac0emsh5f6771358dcd556p14e6d6jsnf8ae7e313818"
        public fun getClient(BASE_URL: String): Retrofit {
            var interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            var client = OkHttpClient.Builder()
                .addInterceptor(object : Interceptor {
                    override fun intercept(chain: Interceptor.Chain): Response {
                        val original = chain.request()
                        val request = original.newBuilder()
                            .addHeader("x-rapidapi-host", host)
                            .addHeader("x-rapidapi-key", key)
                            .method(original.method, original.body)
                            .build()
                        return chain.proceed(request)
                    }

                })
                .addInterceptor(interceptor)
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().serializeNulls().create()))
                .client(client)
                .build()

        }
    }


}