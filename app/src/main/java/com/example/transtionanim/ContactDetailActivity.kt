package com.example.transtionanim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.transition.ArcMotion
import android.util.Log
import android.view.animation.AnimationUtils
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_contact_detail.*

class ContactDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)
        Log.e("WJX", "test")
        val fragmentManager = supportFragmentManager
        val transaction  = fragmentManager.beginTransaction()
        transaction.add(R.id.container, ContactInfoFragment())
        transaction.commit()
    }
}