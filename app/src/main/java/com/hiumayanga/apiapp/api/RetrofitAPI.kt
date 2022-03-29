package com.hiumayanga.apiapp.api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitAPI {

    @GET("users/1")
    fun getUser1(): Call<User>

    companion object {

        var BASE_URL = "https://jsonplaceholder.typicode.com/"

        fun create(): RetrofitAPI {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(RetrofitAPI::class.java)

        }
    }
}
