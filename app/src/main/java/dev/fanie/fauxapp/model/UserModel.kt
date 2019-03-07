package dev.fanie.fauxapp.model

import dev.fanie.faux.Faux

data class UserModel(

    @Faux(["1", FAKE_NAME])
    val id: Int,

    @Faux(["faker", FAKE_NAME])
    val username: String

) {

    companion object {

        private const val FAKE_NAME = "fakeUser"

    }

}
