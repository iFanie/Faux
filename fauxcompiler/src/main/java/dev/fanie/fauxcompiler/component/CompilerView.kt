package dev.fanie.fauxcompiler.component

import com.izikode.izilib.basekotlincompiler.BaseKotlinCompiler
import dev.fanie.fauxcompiler.CompilerContract
import dev.fanie.fauxcompiler.builder.Builder

class CompilerView(

    private val finally: BaseKotlinCompiler.FinallyHandler

) : CompilerContract.View {

    override fun createSourceFiles(builders: List<Builder>) {
        finally.generateClasses {
            builders.toTypedArray()
        }
    }

}
