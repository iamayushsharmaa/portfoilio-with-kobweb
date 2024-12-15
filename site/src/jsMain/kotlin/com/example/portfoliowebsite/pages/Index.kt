package com.example.portfoliowebsite.pages

import androidx.compose.runtime.*
import com.example.portfoliowebsite.components.layout.DefaultPageLayout
import com.example.portfoliowebsite.components.section.start.StartSection
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page

@Page
@Composable
fun HomePage() {

    DefaultPageLayout(title = "Home") {
        Column(
            modifier = Modifier.fillMaxSize().color(Colors.Black),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            StartSection()
//            WorksSection()
//            AboutSection()
//            ContactSection()
        }
    }

}


