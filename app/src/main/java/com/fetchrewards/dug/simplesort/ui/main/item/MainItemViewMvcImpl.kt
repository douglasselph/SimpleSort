package com.fetchrewards.dug.simplesort.ui.main.item

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.fetchrewards.dug.simplesort.R
import com.fetchrewards.dug.simplesort.ui.common.mvc.ViewMvcImpl

class MainItemViewMvcImpl(
    inflater: LayoutInflater,
    container: ViewGroup?
) : ViewMvcImpl(), MainItemViewMvc {

    override val rootView: View =
        inflater.inflate(R.layout.activity_list_item, container, false) as ViewGroup

    private val ageView = findViewById<TextView>(R.id.age)
    private val nameView = findViewById<TextView>(R.id.name)

    override var age: String
        get() = ageView.text.toString()
        set(value) {
            ageView.text = value
        }
    override var name: String
        get() = nameView.text.toString()
        set(value) {
            nameView.text = value
        }

}