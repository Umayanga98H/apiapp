package com.hiumayanga.apiapp.api

import retrofit2.Retrofit

class RetrofitAPI {
    companion object {

        var BASE_URL = "https://jsonplaceholder.typicode.com/"

        fun create() : ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}