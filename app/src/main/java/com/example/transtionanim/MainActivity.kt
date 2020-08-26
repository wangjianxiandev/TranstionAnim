package com.example.transtionanim

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var mContext: Context
    private lateinit var mAdapter: ContactListAdaper
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mCollectList : MutableList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init() {
        mContext = this
        initView()
        initData()
    }

    fun initView() {
        mRecyclerView = findViewById(R.id.recycler)
    }

    fun initData() {
        mCollectList = arrayListOf("1", "2", "3", "4", "5" , "6", "7")
        initAdapter()
    }

    private fun initAdapter() {
        mRecyclerView.layoutManager =
            LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
            )

        mAdapter = ContactListAdaper(this, mCollectList)
        mRecyclerView.setAdapter(mAdapter)
    }
}