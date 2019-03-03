package dev.fanie.fauxcompiler.component

import dev.fanie.fauxcompiler.CompilerContract
import dev.fanie.fauxcompiler.builder.Builder
import dev.fanie.fauxcompiler.entity.Property
import dev.fanie.fauxcompiler.entity.Provider

class CompilerPresenter : CompilerContract.Presenter {

    private val providersMap: MutableMap<String, Provider> by lazy {
        mutableMapOf<String, Provider>()
    }

    private val buildersMap: MutableMap<String, Builder> by lazy {
        mutableMapOf<String, Builder>()
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
        view.createSourceFiles(
            getBuilders(
                providersMap.values.distinct()
            )
        )
    }

    private fun getBuilders(providers: List<Provider>) = mutableListOf<Builder>().apply {
        providers.forEach { provider ->
            add(
                getBuilder(provider).apply {
                    this.providers.add(
                        provider
                    )
                }
            )
        }
    }

    private fun getBuilder(provider: Provider) =
        buildersMap[provider.sourceClass] ?: createBuilder(provider)

    private fun createBuilder(provider: Provider) =
        Builder(provider.sourceClass).also {
            buildersMap[provider.sourceClass] = it
        }

}
