package com.fetchrewards.dug.simplesort.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.fetchrewards.dug.simplesort.R
import com.fetchrewards.dug.simplesort.app.factory.Factory

/**
 * It wasn't specified in the instructions but typically a NAT requires demonstration of how
 * code might anticipate growth. Thus a MVC architecture here is employed.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var factory: Factory
    private lateinit var viewMvc: MainViewMvc
    private lateinit var controller: MainController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        factory = Factory(this, layoutInflater)
        // Important: keep MVC 'View' distinct from Activity
        viewMvc = factory.allocMainViewMvc(findViewById(R.id.top))
        controller = factory.allocMainController(viewMvc)
        controller.invalidateOptionsMenu = {
            invalidateOptionsMenu()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        return if (controller.onPrepareOptionsMenu(menu)) {
            true
        } else {
            super.onPrepareOptionsMenu(menu)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (controller.onOptionsItemSelected(item)) {
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }

}
