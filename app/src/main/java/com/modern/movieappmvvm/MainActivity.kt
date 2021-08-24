package com.modern.movieappmvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.modern.movieappmvvm.ui.RecyclerViewActivity

class MainActivity : AppCompatActivity() {
    lateinit var mainbutton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainbutton=findViewById(R.id.mbutton)

        mainbutton.setOnClickListener {
            val intent=Intent(this@MainActivity,RecyclerViewActivity::class.java)
            startActivity(intent)
        }
    }
}