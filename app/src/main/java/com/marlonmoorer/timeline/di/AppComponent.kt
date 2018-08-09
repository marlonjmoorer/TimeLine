package com.marlonmoorer.timeline.di

import android.support.v7.app.AppCompatActivity
import com.marlonmoorer.timeline.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = arrayOf(AppModule::class))
@Singleton
interface AppComponent {

    fun inject(activity: MainActivity)

}