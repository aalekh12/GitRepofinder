package com.modern.movieappmvvm.CartoonApp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.modern.movieappmvvm.CartoonApp.Cui.CharacterData
import com.modern.movieappmvvm.CartoonApp.repositiry.CartoonDataRepositiry
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class CartoonViewModel: ViewModel() {

    private var characterlist: LiveData<PagedList<CharacterData>>?=null

    init {
        initpagging()
    }


    private fun initpagging(){
        val factory=CartoonViewModalFactory()
        val config= PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(20)
            .build()

        val excutors:Executor= Executors.newFixedThreadPool(5)
        characterlist=LivePagedListBuilder<Int,CharacterData>(factory,config)
            .setFetchExecutor(excutors)
            .build()
    }


    fun getcatroonviewobserver():LiveData<PagedList<CharacterData>>?{
        return characterlist
    }
}