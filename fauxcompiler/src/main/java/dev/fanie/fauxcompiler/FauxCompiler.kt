package dev.fanie.fauxcompiler

import com.izikode.izilib.basekotlincompiler.BaseKotlinCompiler
import dev.fanie.faux.Faux
import kotlin.reflect.KClass

class FauxCompiler : BaseKotlinCompiler() {

    override val processes: Array<KClass<out Any>> = arrayOf(
        Faux::class
    )

    override val roundHandler: CompilationRoundHandler.() -> Unit = {

    }

    override val finallyHandler: FinallyHandler.() -> Unit = {

    }

}
