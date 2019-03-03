package dev.fanie.fauxcompiler

import com.izikode.izilib.basekotlincompiler.BaseKotlinCompiler
import dev.fanie.faux.Faux
import dev.fanie.fauxcompiler.component.CompilerModel
import dev.fanie.fauxcompiler.component.CompilerPresenter
import kotlin.reflect.KClass

class FauxCompiler : BaseKotlinCompiler() {

    private val presenter: CompilerPresenter by lazy { CompilerPresenter() }

    override val processes: Array<KClass<out Any>> = arrayOf(
        Faux::class
    )

    override val roundHandler: CompilationRoundHandler.() -> Unit = {
        presenter.process(
            CompilerModel(this)
        )
    }

    override val finallyHandler: FinallyHandler.() -> Unit = {

    }

}
