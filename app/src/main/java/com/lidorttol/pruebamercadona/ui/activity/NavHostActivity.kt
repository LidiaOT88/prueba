package com.lidorttol.pruebamercadona.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lidorttol.pruebamercadona.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NavHostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nav_host_activity)
    }

}