package com.example.latfragmentsederhana

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnFragmentSatu = findViewById<Button>(R.id.btnFragmentSatu)
        val btnFragmentDua = findViewById<Button>(R.id.btnFragmentDua)

        if(savedInstanceState == null){
            replaceFragment(fSatu())
        }

        btnFragmentSatu.setOnClickListener {
            replaceFragment(fSatu())
        }

        btnFragmentDua.setOnClickListener {
            replaceFragment(fDua())
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        cetakBackStack()

        fragmentTransaction.replace(R.id.fragment_container,fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun cetakBackStack() {
        val count = supportFragmentManager.backStackEntryCount
        Log.d("BackStackLog", "=== ISI BACK STACK: $count ===")

        for (i in 0 until count) {
            val entry = supportFragmentManager.getBackStackEntryAt(i)
            Log.d("BackStackLog", "Indeks $i: Nama Label = ${entry.name}")

        }
        Log.d("BackStackLog", "========================================")
    }
}