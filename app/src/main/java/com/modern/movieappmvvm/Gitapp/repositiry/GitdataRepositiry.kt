package com.modern.movieappmvvm.Gitapp.repositiry

import androidx.lifecycle.MutableLiveData
import com.modern.movieappmvvm.Gitapp.retrofit.GitRepoRetroInstance
import com.modern.movieappmvvm.Gitapp.retrofit.GitRepoRetroService
import com.modern.movieappmvvm.Gitapp.ui.GitRepoList
import retrofit2.Call
import retrofit2.Response

object GitdataRepositiry {
    var recyclerlistdata=MutableLiveData<GitRepoList>()

    fun makeapiCall(input:String):MutableLiveData<GitRepoList>{
        val retroInstance= GitRepoRetroInstance.getRetrofitinstance().create(GitRepoRetroService::class.java)
        val call =retroInstance.getDatafromAPI(input)
        call.enqueue(object :  retrofit2.Callback<GitRepoList>{

            override fun onResponse(call: Call<GitRepoList>, response: Response<GitRepoList>) {
                if (response.isSuccessful) {
                    recyclerlistdata.postValue(response.body())
                } else {
                    recyclerlistdata.postValue(null)
                }
            }

            override fun onFailure(call: retrofit2.Call<GitRepoList>, t: Throwable) {
                //Toast.makeText(this@RecyclerViewActivity,"Error Occured", Toast.LENGTH_LONG).show()
                recyclerlistdata.postValue(null)
            }

        })
        return recyclerlistdata
    }
}