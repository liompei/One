package com.dawn.one.utilities

import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat

object Jump {

    fun startActivityInternal(
        activity: AppCompatActivity,
        targetActivityClass: Class<out AppCompatActivity>,
        sharedElement: View? = null,
    ) {
        val intent = Intent()
        intent.setClass(activity, targetActivityClass)
        if (sharedElement != null) {
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                activity,
                sharedElement,
                sharedElement.transitionName
            )

//            val transform = MaterialContainerTransform(activity, true)
//            transform.containerColor = MaterialColors.getColor(
//                sharedElement,
//                com.google.android.material.R.attr.colorSurface
//            )
//            transform.fadeMode=MaterialContainerTransform.FADE_MODE_THROUGH
//            activity.window.enterTransition=transform as Transition
            activity.startActivity(intent, options.toBundle())
        } else {
            activity.startActivity(intent)
        }


    }

}