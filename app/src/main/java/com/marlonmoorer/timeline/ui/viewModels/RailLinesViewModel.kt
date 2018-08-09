package com.marlonmoorer.timeline.ui.viewModels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.marlonmoorer.timeline.App
import com.marlonmoorer.timeline.api.models.Line
import io.reactivex.schedulers.Schedulers

class RailLinesViewModel:BaseViewModel(){

  private val railLines:MutableLiveData<List<Line>>

  init {
    railLines=MutableLiveData()
  }

    fun loadRalLines():LiveData<List<Line>>{
        repository.getRailLines()
                .subscribeOn(Schedulers.newThread())
                .subscribe{
                    railLines.postValue(it.lines)
                }
        return  railLines
    }



}