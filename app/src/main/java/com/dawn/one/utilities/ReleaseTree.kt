package com.dawn.one.utilities

import timber.log.Timber

class ReleaseTree  : Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        super.log(priority, tag, message, t)
    }
}