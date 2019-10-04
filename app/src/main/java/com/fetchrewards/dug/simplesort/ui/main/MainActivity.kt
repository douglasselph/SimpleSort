package com.fetchrewards.dug.simplesort.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fetchrewards.dug.simplesort.R
import com.fetchrewards.dug.simplesort.app.factory.Factory

class MainActivity : AppCompatActivity() {

    private lateinit var factory: Factory
    private lateinit var viewMvc: MainViewMvc
    private lateinit var controller: MainController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        factory = Factory(this, layoutInflater)
        viewMvc = factory.allocMainViewMvc(findViewById(R.id.top))
        controller = factory.allocMainController(viewMvc)
    }
}
