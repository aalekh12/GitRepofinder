package com.modern.movieappmvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.modern.movieappmvvm.ui.GitRepoActivity

class MainActivity : AppCompatActivity() {
    lateinit var mainbutton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainbutton=findViewById(R.id.mbutton)

        mainbutton.setOnClickListener {
            val intent=Intent(this@MainActivity,GitRepoActivity::class.java)
            startActivity(intent)
        }
    }
}