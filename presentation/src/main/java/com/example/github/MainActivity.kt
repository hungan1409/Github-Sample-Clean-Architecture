package com.example.github

import android.os.Bundle
import androidx.navigation.findNavController
import com.example.github.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val navController = findNavController(R.id.nav_fragment)
    }
}
