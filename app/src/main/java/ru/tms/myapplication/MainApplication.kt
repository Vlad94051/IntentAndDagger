package ru.tms.myapplication

import android.app.Application
import ru.tms.myapplication.di.ApplicationComponent
import ru.tms.myapplication.di.DaggerApplicationComponent

class MainApplication: Application() {
    companion object {
        var appComponent: ApplicationComponent? = null
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = initDagger()
    }

    private fun initDagger(): ApplicationComponent {

        return DaggerApplicationComponent.builder()
            .bindContext(this@MainApplication)
            .build()

    }
}