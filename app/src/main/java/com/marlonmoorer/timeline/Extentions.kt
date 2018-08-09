package com.marlonmoorer.timeline

import android.arch.lifecycle.ViewModel
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import com.marlonmoorer.timeline.ui.viewModels.BaseViewModel
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders

fun <T> Observable<T>.observe(): Observable<T> {
    return this.subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
}
inline fun <reified T : ViewModel> Fragment.getViewModel(): T {
    return ViewModelProviders.of(this.activity!!, BaseViewModel.ViewModelFactory()).get(T::class.java)
}

fun FragmentManager.commit(block:FragmentTransaction.()->FragmentTransaction){
    beginTransaction().run {
        block(this)
    }.commit()
}