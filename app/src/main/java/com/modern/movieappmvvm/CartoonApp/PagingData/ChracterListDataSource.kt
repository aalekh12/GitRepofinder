package com.modern.movieappmvvm.CartoonApp.PagingData

import android.widget.Toast
import androidx.paging.PageKeyedDataSource
import com.modern.movieappmvvm.CartoonApp.Cui.CharacterData
import com.modern.movieappmvvm.CartoonApp.Cui.RickandMontyList
import com.modern.movieappmvvm.CartoonApp.network.CartoonRetroService
import com.modern.movieappmvvm.CartoonApp.network.CartoonRetroinstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class ChracterListDataSource():PageKeyedDataSource<Int,CharacterData>() {


    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, CharacterData>) {
        val retroinstance=CartoonRetroinstance.getretroinstancbuilder().create(CartoonRetroService::class.java)
        val call=retroinstance.getCartoonDatafromAPI(params.key)
        call.enqueue(object :Callback<RickandMontyList>{


            override fun onResponse(
                call: Call<RickandMontyList>,
                response: Response<RickandMontyList>,
            ) {
                if (response.isSuccessful){
                    callback.onResult(response?.body()?.result!!,params.key+2)
                }
            }
            override fun onFailure(call: Call<RickandMontyList>, t: Throwable) {

            }

        })
    }




    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, CharacterData>) {

    }



    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, CharacterData>,
    ) {

        val retroinstance=CartoonRetroinstance.getretroinstancbuilder().create(CartoonRetroService::class.java)
        val call=retroinstance.getCartoonDatafromAPI(1)
        call.enqueue(object :Callback<RickandMontyList>{


            override fun onResponse(
                call: Call<RickandMontyList>,
                response: Response<RickandMontyList>,
            ) {
                if (response.isSuccessful){
                    callback.onResult(response?.body()?.result!!,null,1)
                }
            }


            override fun onFailure(call: Call<RickandMontyList>, t: Throwable) {
                //Toast.makeText(this@ChracterListDataSource,"Soemthing Went Wrong",Toast.LENGTH_SHORT)
            }

        })
    }


}