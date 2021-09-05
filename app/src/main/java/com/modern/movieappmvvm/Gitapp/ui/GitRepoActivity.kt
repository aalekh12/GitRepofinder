package com.modern.movieappmvvm.Gitapp.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import com.modern.movieappmvvm.R
import com.modern.movieappmvvm.Gitapp.viewmodels.GitRepoViewViewModels
class GitRepoActivity : AppCompatActivity() {
    private lateinit var viewmodal: GitRepoViewViewModels

    lateinit var recyclerView: RecyclerView
    lateinit var gitRepoAdapter: GitRepoAdapter
    lateinit var searchbtn: Button
    lateinit var searchtext: TextView
    lateinit var pbar: ProgressBar
    lateinit var PbTitlee: TextView
    lateinit var labelo: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gitrepo_view)
        viewmodal = ViewModelProviders.of(this).get(GitRepoViewViewModels::class.java)
        recyclerView = findViewById(R.id.recycler_view)
        searchbtn = findViewById(R.id.searchbtn)
        searchtext = findViewById(R.id.searchbox)
        labelo = findViewById(R.id.label)
        pbar = findViewById(R.id.loader)
        PbTitlee = findViewById(R.id.loadtitle)
        initrecyclerview()
        createdata()
        searchfeature()

    }

    private fun initrecyclerview() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@GitRepoActivity)
            gitRepoAdapter = GitRepoAdapter()
            adapter = gitRepoAdapter


            val divider = DividerItemDecoration(applicationContext, VERTICAL)
            addItemDecoration(divider)
        }
    }



    fun createdata() {
        viewmodal.getRecyclerviewObserver("$viewmodal")
                .observe(this, Observer<GitRepoList> {
                    if (it != null) {
                        gitRepoAdapter.setListData(it.items)
                        gitRepoAdapter.notifyDataSetChanged()
                        pbar.visibility = View.GONE
                        PbTitlee.visibility = View.GONE
                        labelo.visibility=View.GONE
                      }
                    /*else
                      {
                        pbar.visibility = View.GONE
                        Toast.makeText(this@GitRepoActivity,
                            "No Internet Connection Found",
                            Toast.LENGTH_LONG).show()
                        PbTitlee.visibility = View.GONE
                    }*/
                })

    }

    fun searchfeature(){
        searchbtn.setOnClickListener {

            pbar.visibility = View.VISIBLE
            labelo.visibility = View.VISIBLE
            if (searchtext?.text.isNotEmpty()) {
                closekkeyboard(searchtext)
                PbTitlee.visibility = View.VISIBLE
                labelo.visibility = View.GONE
                viewmodal.getapidata(searchtext.text.toString())
                pbar.visibility=View.VISIBLE

            }

            if (searchtext?.text.isNullOrEmpty()) {
                Log.i("Not Compiled", "Function not works")
                findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
                searchtext.error = "Enter the Repo name"
            }

        }
    }


    private fun closekkeyboard(view:View){
        val imm:InputMethodManager=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }

}