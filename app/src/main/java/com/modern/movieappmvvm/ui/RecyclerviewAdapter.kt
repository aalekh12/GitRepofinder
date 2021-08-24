package com.modern.movieappmvvm.ui

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.modern.movieappmvvm.R

class RecyclerviewAdapter:RecyclerView.Adapter<RecyclerviewAdapter.MyViewHoloder>() {
    var items=ArrayList<RecyclerData>()


    fun setListData(data: ArrayList<RecyclerData>){
          this.items=data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHoloder {
        val inflater=LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_row,parent,false)
       return MyViewHoloder(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHoloder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun clearitems(){
        this.items.clear()
    }

    class MyViewHoloder(view:View):RecyclerView.ViewHolder(view){

        val imageview=view.findViewById<ImageView>(R.id.imageview)
        val tvTitle=view.findViewById<TextView>(R.id.tvTitle)
        val tvdescription=view.findViewById<TextView>(R.id.description)

        fun bind(data: RecyclerData){
            tvTitle.text=data.name
            if(!TextUtils.isEmpty(data.description)) {
                tvdescription.text = data.description
            }else{
                tvdescription.text="My Description is not Given"
            }

            val url=data.owner.avatar_url
            Glide.with(imageview)
                .load(url)
                .circleCrop()
                .placeholder(R.drawable.weathersun)
                .into(imageview)
        }


    }


}