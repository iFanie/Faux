package dev.fanie.fauxcompiler

import dev.fanie.fauxcompiler.entity.Property

interface CompilerContract {

    interface Model {

        fun requestProperties(block: (List<Property>) -> Unit)

    }

    interface View {

    }

    interface Presenter {

        fun process(model: Model)

        fun generate(view: View)

    }

}
