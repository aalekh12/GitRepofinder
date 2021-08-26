package com.modern.movieappmvvm.network.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GitRepoRetroInstance {

    companion object{
        val basdeurl="https://api.github.com/search/"

        fun getRetrofitinstance():Retrofit{

            return Retrofit.Builder()
                .baseUrl(basdeurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
    }
}