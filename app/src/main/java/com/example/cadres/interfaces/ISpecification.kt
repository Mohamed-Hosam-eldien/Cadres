package com.example.cadres.interfaces

interface ISpecification {

    fun navToSpecScreen(machineName: String, sizeNum: Int, sizeName: String)

    fun navToPdfScreen(machineName: String, sizeNum: Int)

    fun navToDrill(text:String)

    fun navToCalc(sizeName: String, position: Int)

    fun navToPBLInstructionPdf(position: Int)

}