package dev.fanie.fauxcompiler.component

import com.izikode.izilib.basekotlincompiler.BaseKotlinCompiler
import dev.fanie.faux.Faux
import dev.fanie.fauxcompiler.CompilerContract
import dev.fanie.fauxcompiler.entity.Property
import dev.fanie.fauxcompiler.mapper.toProperties

class CompilerModel(

    private val round: BaseKotlinCompiler.CompilationRoundHandler

) : CompilerContract.Model {

    override fun requestProperties(block: (List<Property>) -> Unit) {
        round.fetchVariables(Faux::class) {
            block(it.toProperties())
        }
    }

}
