package dev.fanie.fauxcompiler

import dev.fanie.fauxcompiler.builder.Builder
import dev.fanie.fauxcompiler.entity.Property

interface CompilerContract {

    interface Model {

        fun requestProperties(block: (List<Property>) -> Unit)

    }

    interface View {

        fun createSourceFiles(builders: List<Builder>)

    }

    interface Presenter {

        fun process(model: Model)

        fun generate(view: View)

    }

}
