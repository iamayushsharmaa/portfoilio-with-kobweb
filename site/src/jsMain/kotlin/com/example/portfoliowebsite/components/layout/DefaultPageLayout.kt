package com.example.portfoliowebsite.components.layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.portfoliowebsite.components.section.footer.Footer
import com.example.portfoliowebsite.components.section.nav_header.NavHeader
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import kotlinx.browser.document

@Composable
fun DefaultPageLayout(
    title: String,
    content: @Composable () -> Unit,
) {
    LaunchedEffect(title) {
        document.title = "Ayush Sharma - $title"
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NavHeader()
        content()
        Footer()
    }
}