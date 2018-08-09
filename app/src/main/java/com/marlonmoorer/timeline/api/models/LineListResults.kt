package com.marlonmoorer.timeline.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class LineListResults {

    @SerializedName("Lines")
    @Expose
    var lines: List<Line>? = null

}

