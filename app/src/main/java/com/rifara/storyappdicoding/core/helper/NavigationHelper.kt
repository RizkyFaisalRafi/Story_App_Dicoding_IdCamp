package com.rifara.storyappdicoding.core.helper

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

object NavigationHelper {
    fun movePagesFragment(fragment: Fragment, id: Int, bundle: Bundle? = null) =
        fragment.view?.findNavController()?.navigate(id, bundle)
}