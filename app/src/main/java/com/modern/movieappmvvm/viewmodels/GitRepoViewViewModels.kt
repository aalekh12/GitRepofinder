package com.modern.movieappmvvm.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.modern.movieappmvvm.repositiry.GitdataRepositiry
import com.modern.movieappmvvm.ui.RecyclerList

class GitRepoViewViewModels:ViewModel() {
    lateinit var recyclerlistdata:MutableLiveData<RecyclerList>


    init {
        recyclerlistdata=MutableLiveData()
    }


    fun getRecyclerviewObserver(bronze:String):MutableLiveData<RecyclerList>{
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