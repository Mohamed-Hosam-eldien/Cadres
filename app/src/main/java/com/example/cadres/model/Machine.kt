package com.example.cadres.model

import java.io.Serializable

data class Machine(
    var machineName:String,
    var nickName: String,
    var machineImage:Int,
    val sizes: List<String>
) : Serializable
