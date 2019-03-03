package dev.fanie.fauxcompiler.entity

data class Provider(

    val sourceClass: String,
    val name: String,
    val properties: MutableList<Property> = mutableListOf()

)
