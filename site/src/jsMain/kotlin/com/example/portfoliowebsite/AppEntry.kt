package com.example.portfoliowebsite

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.ScrollBehavior
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.App
import com.varabyte.kobweb.silk.SilkApp
import com.varabyte.kobweb.silk.components.layout.Surface
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.style.common.SmoothColorStyle
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.browser.localStorage
import org.jetbrains.compose.web.css.*

private const val COLOR_MODE_KEY = "itamimobile:colorMode"

@InitSilk
fun initColorMode(ctx: InitSilkContext) {
    ctx.apply {
        config.apply {
            initialColorMode = localStorage.getItem(COLOR_MODE_KEY)?.let { ColorMode.valueOf(it) } ?: ColorMode.DARK
        }
    }
}
@App
@Composable
fun AppEntry(content: @Composable () -> Unit) {
    SilkApp {
        val colorMode = ColorMode.current
        LaunchedEffect(colorMode) {
            localStorage.setItem(COLOR_MODE_KEY, colorMode.name)
        }

        Surface(
            modifier = SmoothColorStyle.toModifier()
                .fillMaxWidth()
                .minHeight(100.vh)
                .scrollBehavior(ScrollBehavior.Smooth)
        ) {
            content()
        }
    }

}