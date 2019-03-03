package dev.fanie.fauxapp.model

import dev.fanie.faux.Faux

data class UserModel(

    @Faux(["1", "fakeUser"])
    val id: Int,

    @Faux(["faker", "fakeUser"])
    val username: String

)
