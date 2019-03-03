package dev.fanie.fauxcompiler.component

import dev.fanie.fauxcompiler.CompilerContract
import dev.fanie.fauxcompiler.entity.Property
import dev.fanie.fauxcompiler.entity.Provider

class CompilerPresenter : CompilerContract.Presenter {

    private val providersMap: MutableMap<String, Provider> by lazy {
        mutableMapOf<String, Provider>()
    }

    override fun process(model: CompilerContract.Model) {
        model.requestProperties(::handleProperties)
    }

    private fun handleProperties(properties: List<Property>) {
        properties.forEach { property ->
            getProvider(property).properties.add(
                property
            )
        }
    }

    private fun getProvider(property: Property) =
        providersMap[property.providerName] ?: createProvider(property)

    private fun createProvider(property: Property) =
        Provider(property.sourceClass, property.providerName).also {
            providersMap[property.providerName] = it
        }

    override fun generate(view: CompilerContract.View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
