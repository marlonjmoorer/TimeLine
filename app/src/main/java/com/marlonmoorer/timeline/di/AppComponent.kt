package com.marlonmoorer.timeline.di

import com.marlonmoorer.timeline.ui.activities.MainActivity
import com.marlonmoorer.timeline.ui.viewModels.BaseViewModel
import com.marlonmoorer.timeline.ui.viewModels.RailLinesViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = arrayOf(AppModule::class))
@Singleton
interface AppComponent {

    fun inject(activity: MainActivity)
    fun inject(activity: BaseViewModel)

}