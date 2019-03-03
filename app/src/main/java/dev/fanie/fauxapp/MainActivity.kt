package dev.fanie.fauxapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.fanie.fauxprovider.fakeUser

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fu = fakeUser()
    }
}
