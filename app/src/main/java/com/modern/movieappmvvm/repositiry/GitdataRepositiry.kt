package com.modern.movieappmvvm.repositiry

import androidx.lifecycle.MutableLiveData
import com.modern.movieappmvvm.network.retrofit.GitRepoRetroInstance
import com.modern.movieappmvvm.network.retrofit.GitRepoRetroService
import com.modern.movieappmvvm.ui.RecyclerList
import retrofit2.Call
import retrofit2.Response

object GitdataRepositiry {
    var recyclerlistdata=MutableLiveData<RecyclerList>()

    fun makeapiCall(input:String):MutableLiveData<RecyclerList>{
        val retroInstance= GitRepoRetroInstance.getRetrofitinstance().create(GitRepoRetroService::class.java)
        val call =retroInstance.getDatafromAPI(input)
        call.enqueue(object :  retrofit2.Callback<RecyclerList>{

            override fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {
                if (response.isSuccessful) {
                    recyclerlistdata.postValue(response.body())
                } else {
                    recyclerlistdata.postValue(null)
                }
            }

            override fun onFailure(call: retrofit2.Call<RecyclerList>, t: Throwable) {
                //Toast.makeText(this@RecyclerViewActivity,"Error Occured", Toast.LENGTH_LONG).show()
                recyclerlistdata.postValue(null)
            }

        })
        return recyclerlistdata
    }
}