package dev.fanie.faux

@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.FIELD)
@Repeatable
annotation class Faux(

    val value: Array<String>

)
