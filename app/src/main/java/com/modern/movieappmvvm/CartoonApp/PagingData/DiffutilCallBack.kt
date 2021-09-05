package com.modern.movieappmvvm.CartoonApp.PagingData

import androidx.recyclerview.widget.DiffUtil
import com.modern.movieappmvvm.CartoonApp.Cui.CharacterData

class DiffutilCallBack: DiffUtil.ItemCallback<CharacterData>() {
    override fun areItemsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean {
        return oldItem.name==newItem.name
    }

    override fun areContentsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean {
        return oldItem.name==newItem.name && oldItem.species==newItem.species
    }

}