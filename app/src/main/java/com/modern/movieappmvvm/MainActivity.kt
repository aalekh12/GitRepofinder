package com.modern.movieappmvvm

import android.app.AlertDialog
import android.app.Service
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.modern.movieappmvvm.databinding.ActivityMainBinding
import com.modern.movieappmvvm.Gitapp.ui.GitRepoActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var gitbutton:Button
    lateinit var charbutton:Button
    var context=this
    var connectivity:ConnectivityManager?=null
    var info:NetworkInfo?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        gitbutton=binding.mbutton


        gitbutton.setOnClickListener {
            val intent=Intent(this@MainActivity,GitRepoActivity::class.java)
            startActivity(intent)
        }
         internetmoniter()


    }

    private fun internetmoniter(){
        connectivity= context.getSystemService(Service.CONNECTIVITY_SERVICE ) as ConnectivityManager
        if (connectivity!=null) {
            info = connectivity!!.activeNetworkInfo

            if (info != null) {

                if (info!!.state == NetworkInfo.State.CONNECTED) {
                    //itnernet is avilavle
                    //showAlertDialog()
                    Toast.makeText(context, "INTERNET CONNECTED", Toast.LENGTH_LONG).show()
                }

            } else {
                showAlertDialog2()
                //internet is not avilavle
                Toast.makeText(context, "NOT CONNECTED", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun showAlertDialog() {
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)
        alertDialog.setTitle("SUCCESSFULLY CONNECTED")
        alertDialog.setMessage("Internet Connection Found")
        alertDialog.setPositiveButton(
            "Ok"
        ) { _, _ ->
        }
        alertDialog.setNegativeButton(
            "Cancel"
        ) { _, _ -> }
        val alert: AlertDialog = alertDialog.create()
        alert.setCanceledOnTouchOutside(false)
        alert.show()
    }
    private fun showAlertDialog2() {
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)
        alertDialog.setTitle("NOT SUCCESSFULLY CONNECTED")
        alertDialog.setMessage("Internet Connection Not Found")
        alertDialog.setPositiveButton(
            "Ok"
        ) { _, _ ->
        }
        alertDialog.setNegativeButton(
            "Cancel"
        ) { _, _ -> }
        val alert: AlertDialog = alertDialog.create()
        alert.setCanceledOnTouchOutside(false)
        alert.show()
    }

}