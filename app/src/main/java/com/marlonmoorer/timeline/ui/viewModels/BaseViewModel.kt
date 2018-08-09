package com.marlonmoorer.timeline.ui.viewModels

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.marlonmoorer.timeline.App
import com.marlonmoorer.timeline.Repository
import javax.inject.Inject

abstract class BaseViewModel:ViewModel() {
    @Inject  lateinit var repository:Repository

    class ViewModelFactory: ViewModelProvider.NewInstanceFactory(){
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            val vm=super.create(modelClass)
            if(vm is BaseViewModel){
                App.component.inject(vm)
            }
            return vm
        }
    }
}