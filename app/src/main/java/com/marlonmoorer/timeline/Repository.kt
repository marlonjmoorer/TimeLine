package com.marlonmoorer.timeline

import com.marlonmoorer.timeline.api.WmataService
import com.marlonmoorer.timeline.api.models.LineListResults
import io.reactivex.Maybe
import javax.inject.Inject

class Repository @Inject constructor(val wmataService: WmataService){



    fun getRailLines(): Maybe<LineListResults> {
       return wmataService.getRailLines()
    }



}