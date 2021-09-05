package com.modern.movieappmvvm.CartoonApp.Cui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.DifferCallback
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.modern.movieappmvvm.CartoonApp.PagingData.DiffutilCallBack
import com.modern.movieappmvvm.R

class CartoonViewAdapter:PagedListAdapter<CharacterData,CartoonViewAdapter.MyViewHolder>(DiffutilCallBack()) {

    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        var title:TextView=view.findViewById(R.id.charTitle)
        var description:TextView=view.findViewById(R.id.char_description)
        var imageicon:ImageView=view.findViewById(R.id.char_imageview)
        fun bind(data: CharacterData){
            title.text=data.name
            description.text=data.species

            val url =imageicon
            Glide.with(imageicon)
                .load(url)
                .circleCrop()
                .into(imageicon)
        }

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater=LayoutInflater.from(parent.context).inflate(R.layout.cartoon_rowview,parent)
        return MyViewHolder(inflater)
    }
}