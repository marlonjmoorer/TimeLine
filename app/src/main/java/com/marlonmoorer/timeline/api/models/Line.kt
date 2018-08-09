package com.marlonmoorer.timeline.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Line {

    @SerializedName("DisplayName")
    @Expose
    var displayName: String? = null
    @SerializedName("EndStationCode")
    @Expose
    var endStationCode: String? = null
    @SerializedName("InternalDestination1")
    @Expose
    var internalDestination1: String? = null
    @SerializedName("InternalDestination2")
    @Expose
    var internalDestination2: String? = null
    @SerializedName("LineCode")
    @Expose
    var lineCode: String? = null
    @SerializedName("StartStationCode")
    @Expose
    var startStationCode: String? = null

}