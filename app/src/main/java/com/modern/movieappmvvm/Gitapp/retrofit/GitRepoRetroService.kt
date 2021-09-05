package com.modern.movieappmvvm.Gitapp.retrofit

import com.modern.movieappmvvm.Gitapp.ui.GitRepoList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query



interface GitRepoRetroService {

    @GET("repositories")
    fun getDatafromAPI(@Query("q")query:String):Call<GitRepoList>
}