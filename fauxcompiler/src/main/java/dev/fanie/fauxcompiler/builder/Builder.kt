package dev.fanie.fauxcompiler.builder

import com.izikode.izilib.basekotlincompiler.component.AbstractKotlinClass
import dev.fanie.fauxcompiler.entity.Property
import dev.fanie.fauxcompiler.entity.Provider

class Builder(

    fileName: String,
    val providers: MutableList<Provider> = mutableListOf()

) : AbstractKotlinClass() {

    override val packageName: String = PACKAGE

    override val simpleName: String = "Faux$fileName"

    override val sourceCode: String get() =
"""package $packageName

    ${getProvidersSource()}

"""

    private fun getProvidersSource() = buildString {
        providers.forEach { provider ->
            append(
                provider.toSourceCode()
            )

            append('\n')
        }
    }

    private fun Provider.toSourceCode() =
"""
   fun ${this.name}() = ${this.sourceClass}(
        ${this.properties.toNamedParameters()}
   )
"""

    private fun Property.toNamedParameter() = "${this.name} = ${this.value}"

    private fun List<Property>.toNamedParameters() = buildString {
        this@toNamedParameters.forEachIndexed { index, property ->
            append(
                property.toNamedParameter()
            )

            if (index < this@toNamedParameters.size - 1) {
                append(", ")
            }
        }
    }

    companion object {

        const val PACKAGE = "dev.fanie.fauxprovider"

    }

}
