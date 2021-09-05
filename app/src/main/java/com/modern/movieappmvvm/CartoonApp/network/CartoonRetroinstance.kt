package com.modern.movieappmvvm.CartoonApp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CartoonRetroinstance {

    companion object{
        val baseurl="https://rickandmortyapi.com/api/"

        fun getretroinstancbuilder():Retrofit{
            return Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}