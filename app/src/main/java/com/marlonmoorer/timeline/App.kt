package com.marlonmoorer.timeline

import android.app.Application
import com.marlonmoorer.timeline.di.AppComponent
import com.marlonmoorer.timeline.di.AppModule
import com.marlonmoorer.timeline.di.DaggerAppComponent

class App:Application(){

    companion object {
        private lateinit var appComponent: AppComponent
        val component
            get() = appComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent= DaggerAppComponent.builder()
                .appModule(AppModule(this.applicationContext))
                .build()

    }

}