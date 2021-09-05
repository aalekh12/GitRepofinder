package com.modern.movieappmvvm.CartoonApp.ViewModel

import androidx.lifecycle.MutableLiveData
import com.modern.movieappmvvm.CartoonApp.Cui.CharacterData
import com.modern.movieappmvvm.CartoonApp.PagingData.ChracterListDataSource
import javax.sql.DataSource

class CartoonViewModalFactory():androidx.paging.DataSource.Factory<Int,CharacterData>() {

    private var mutableLiveData: MutableLiveData<ChracterListDataSource>? = null

    init {
        mutableLiveData=MutableLiveData()
    }



    override fun create(): androidx.paging.DataSource<Int, CharacterData> {
        val listDataSource=ChracterListDataSource()
        mutableLiveData?.postValue(listDataSource)
        return listDataSource
    }
}