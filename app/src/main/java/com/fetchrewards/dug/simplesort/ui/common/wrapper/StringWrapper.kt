package com.fetchrewards.dug.simplesort.ui.common.wrapper

import android.content.Context
import androidx.annotation.StringRes

/**
 * This wrapper is useful once unit tests are developed.
 */
class StringWrapper(
    private val context: Context
) {

    fun getString(@StringRes res: Int): String = context.getString(res)

}