package com.modern.movieappmvvm.CartoonApp.Cui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.paging.PagedList
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.modern.movieappmvvm.CartoonApp.ViewModel.CartoonViewModel
import com.modern.movieappmvvm.R

class CartoonActivity : AppCompatActivity() {
    private lateinit var receyclerview:RecyclerView
    private lateinit var cartoonviewadapter:CartoonViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cartoon)
        receyclerview=findViewById(R.id.cartton_view)
        initrecyclerview()
        initviewmodal()
    }

    private fun initrecyclerview(){
        receyclerview.apply {
            layoutManager=LinearLayoutManager(this@CartoonActivity)
            val decorator=DividerItemDecoration(applicationContext,DividerItemDecoration.VERTICAL)
            addItemDecoration(decorator)
             cartoonviewadapter= CartoonViewAdapter()
            adapter=cartoonviewadapter
        }
    }
    private fun initviewmodal(){
    val viewmodal= ViewModelProvider(this).get(CartoonViewModel::class.java)
        viewmodal.getcatroonviewobserver()?.observe(this, Observer<PagedList<CharacterData>>{
                if (it!=null){
                    cartoonviewadapter.submitList(it)
                }else{
                    Toast.makeText(this@CartoonActivity,"Something went Rong",Toast.LENGTH_LONG).show()
                }
        })

    }
}