package com.modern.movieappmvvm.CartoonApp.Cui

import org.w3c.dom.CharacterData
import java.util.ArrayList

data class RickandMontyList(val result:ArrayList<com.modern.movieappmvvm.CartoonApp.Cui.CharacterData>)
data class CharacterData(val name:String,val species:String,val image:String)