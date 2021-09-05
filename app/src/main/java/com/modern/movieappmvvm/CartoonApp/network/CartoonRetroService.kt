package com.modern.movieappmvvm.CartoonApp.network

import com.modern.movieappmvvm.CartoonApp.Cui.RickandMontyList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CartoonRetroService {

    @GET("character")
    fun getCartoonDatafromAPI(@Query("pages")pages:Int): Call<RickandMontyList>
}