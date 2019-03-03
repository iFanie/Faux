package dev.fanie.faux

@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.PROPERTY)
annotation class Faux(

    val value: Array<String>

)

infix fun Any.`for`(fauxName: String) = arrayOf(this.toString(), fauxName)
