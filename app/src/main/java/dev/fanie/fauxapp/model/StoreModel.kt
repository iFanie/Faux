package dev.fanie.fauxapp.model

import dev.fanie.faux.Faux

data class StoreModel(

    @Faux(["1", FAKE_NAME])
    val id: Int,

    @Faux(["Awesome store", FAKE_NAME])
    val name: String,

    @Faux(["Mr Amazing", FAKE_NAME])
    val owner: String

) {

    companion object {

        const val FAKE_NAME = "fakeStore"

    }

}
