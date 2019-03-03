package dev.fanie.fauxcompiler.mapper

import com.izikode.izilib.basekotlincompiler.source.member.field.AnnotatedVariableSource
import dev.fanie.faux.Faux
import dev.fanie.fauxcompiler.entity.Property

fun AnnotatedVariableSource<Faux>.toProperty(): Property {
    val annotation = this.annotation.value

    return Property(
        this.parent.info.name,
        annotation[1],
        this.info.name,
        annotation[0]
    )
}

fun ArrayList<AnnotatedVariableSource<Faux>>.toProperties() = mutableListOf<Property>().apply {
    this@toProperties.forEach { source ->
        this.add(
            source.toProperty()
        )
    }
}
