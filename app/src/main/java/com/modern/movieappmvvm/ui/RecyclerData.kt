
package com.modern.movieappmvvm.ui


data class RecyclerList(val items:ArrayList<RecyclerData>)
data class RecyclerData(val name:String,val description:String,val owner: com.modern.movieappmvvm.ui.Owner)
data class Owner(val avatar_url:String)