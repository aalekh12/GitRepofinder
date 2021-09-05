package com.modern.movieappmvvm.Gitapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.modern.movieappmvvm.Gitapp.repositiry.GitdataRepositiry
import com.modern.movieappmvvm.Gitapp.ui.GitRepoList

class GitRepoViewViewModels:ViewModel() {
    lateinit var recyclerlistdata:MutableLiveData<GitRepoList>


    init {
        recyclerlistdata=MutableLiveData()
    }

    fun getapidata(bronze:String){
        recyclerlistdata=GitdataRepositiry.makeapiCall(bronze)
    }

    fun getRecyclerviewObserver(bronze:String):MutableLiveData<GitRepoList>{
        if (bronze.isNotEmpty())
        recyclerlistdata=GitdataRepositiry.makeapiCall(bronze)
        return recyclerlistdata
    }

    /*fun makeapiCall(input:String){
        val retroInstance= RetroInstance.getRetrofitinstance().create(RetroService::class.java)
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
    }*/

}