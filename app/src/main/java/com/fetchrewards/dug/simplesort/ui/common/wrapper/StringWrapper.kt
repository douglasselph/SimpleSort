package com.fetchrewards.dug.simplesort.ui.common.wrapper

import android.content.Context
import androidx.annotation.StringRes

class StringWrapper(
    private val context: Context
) {

    fun getString(@StringRes res: Int): String = context.getString(res)

}