package com.example.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val sharedPreferences = getSharedPreferences("SP_INFO", MODE_PRIVATE)


        btnSave.setOnClickListener{

            val nameIn = txtNameIn.text.toString().trim()
            val stats = switchYes.isChecked

            val editor=sharedPreferences.edit()

            editor.putString("String",nameIn)
            editor.putBoolean("Boolean_value",stats)
            editor.apply()
        }

        btnShowData.setOnClickListener{

            val nameOut = sharedPreferences.getString("String","")
            val switchYes = sharedPreferences.getBoolean("Boolean_value",false)

            txtDataOut.text="String : $nameOut \nBoolean value : $switchYes"

        }

    }
}