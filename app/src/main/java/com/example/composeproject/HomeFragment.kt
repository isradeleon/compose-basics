package com.example.composeproject

import android.os.Bundle
import android.view.View
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment

class HomeFragment: Fragment(R.layout.home_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<ComposeView>(R.id.composeView).setContent {
            MainContentScreen()
        }
    }
}