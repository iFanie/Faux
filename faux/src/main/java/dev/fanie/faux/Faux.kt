package dev.fanie.faux

@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.PROPERTY)
annotation class Faux(

    val value: Array<String>

)
