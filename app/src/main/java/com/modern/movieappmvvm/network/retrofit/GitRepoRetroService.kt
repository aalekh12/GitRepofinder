package com.modern.movieappmvvm.network.retrofit

import com.modern.movieappmvvm.ui.RecyclerList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query



interface GitRepoRetroService {

    @GET("repositories")
    fun getDatafromAPI(@Query("q")query:String):Call<RecyclerList>
}