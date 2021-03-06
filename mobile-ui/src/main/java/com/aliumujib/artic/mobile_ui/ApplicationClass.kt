package com.aliumujib.artic.mobile_ui

import android.content.Context
import com.aliumujib.artic.mobile_ui.di.DaggerApplicationComponent
import com.aliumujib.artic.di.components.CoreComponent
import com.aliumujib.artic.di.components.DaggerCoreComponent
import com.aliumujib.artic.di.modules.ContextModule
import com.google.android.play.core.splitcompat.SplitCompatApplication
import timber.log.Timber

class ApplicationClass : SplitCompatApplication() {

    lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        super.onCreate()

        initCoreDependencyInjection()
        initAppDependencyInjection()

        initTimber()
    }

    /**
     * Initialize core dependency injection component.
     */
    private fun initAppDependencyInjection() {
        DaggerApplicationComponent
            .builder()
            .coreComponent(coreComponent)
            .build()
            .inject(this)
    }

    /**
     * Initialize core dependency injection component.
     */
    private fun initCoreDependencyInjection() {
        coreComponent = DaggerCoreComponent
            .builder()
            .contextModule(ContextModule(this))
            .build()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        Timber.i("%s %d", BuildConfig.VERSION_NAME, BuildConfig.VERSION_CODE)
    }



    companion object {

        /**
         * Obtain core dagger component.
         *
         * @param context The application context
         */
        @JvmStatic
        fun coreComponent(context: Context) =
            (context.applicationContext as? ApplicationClass)?.coreComponent
    }

}