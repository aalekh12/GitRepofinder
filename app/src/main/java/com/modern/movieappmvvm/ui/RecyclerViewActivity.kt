package com.modern.movieappmvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.view.isNotEmpty
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import com.modern.movieappmvvm.R
import com.modern.movieappmvvm.viewmodels.RecyclerViewViewModels
class RecyclerViewActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var recyclerviewAdapter: RecyclerviewAdapter
    lateinit var searchbtn: Button
    lateinit var searchtext: TextView
    lateinit var pbar: ProgressBar
    lateinit var PbTitlee: TextView
    lateinit var labelo: TextView
    var callback1 : (() -> Unit)? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        recyclerView = findViewById(R.id.recycler_view)
        searchbtn = findViewById(R.id.searchbtn)
        searchtext = findViewById(R.id.searchbox)
        labelo = findViewById(R.id.label)
        pbar = findViewById(R.id.loader)
        PbTitlee = findViewById(R.id.loadtitle)
        initrecyclerview()
        if (searchtext.text.isNotEmpty()) {
            createdata()
        }
        searchfeature()

    }

    private fun initrecyclerview() {
        recyclerView.apply {
            pbar.visibility=View.VISIBLE
            layoutManager = LinearLayoutManager(this@RecyclerViewActivity)
            recyclerviewAdapter = RecyclerviewAdapter()
            adapter = recyclerviewAdapter


            val divider = DividerItemDecoration(applicationContext, VERTICAL)
            addItemDecoration(divider)
        }
        pbar.visibility=View.GONE
    }



    fun createdata() {


        val viewmodal = ViewModelProviders.of(this).get(RecyclerViewViewModels::class.java)
            viewmodal.getRecyclerviewObserver(searchtext.text.toString())
                .observe(this, Observer<RecyclerList> {
                    if (it != null) {
                        recyclerviewAdapter.setListData(it.items)
                        recyclerviewAdapter.notifyDataSetChanged()
                        pbar.visibility = View.GONE
                        PbTitlee.visibility = View.GONE
                      } else {
                        pbar.visibility = View.GONE
                        Toast.makeText(this@RecyclerViewActivity,
                            "Error Occured",
                            Toast.LENGTH_LONG).show()
                        PbTitlee.visibility = View.VISIBLE
                    }
                })

    }

    fun searchfeature(){
        searchbtn.setOnClickListener {
            pbar.visibility = View.VISIBLE
            labelo.visibility = View.GONE
            if (searchtext?.text.isNotEmpty()) {
                PbTitlee.visibility = View.VISIBLE
                createdata()

            }

            if (searchtext?.text.isNullOrEmpty()) {
                labelo.visibility = View.VISIBLE
                Log.i("Not Compiled", "Function not works")
                findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
                searchtext.error = "Enter the Repo name"
            }

        }
    }
}