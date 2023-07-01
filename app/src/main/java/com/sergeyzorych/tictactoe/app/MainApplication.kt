package com.sergeyzorych.tictactoe.app

import android.app.Application
import timber.log.Timber

/**
 * Created by Android Studio on 07/01/2023 20:56
 *
 * @author Sergey Zorych
 */
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}