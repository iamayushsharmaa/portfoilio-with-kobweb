package com.example.portfoliowebsite.components.section.nav_header.component


import androidx.compose.runtime.Composable
import com.example.portfoliowebsite.components.widget.button.PrimaryIconButton
import com.example.portfoliowebsite.theme.icons.DarkModeIcon
import com.example.portfoliowebsite.theme.icons.IconOnBrandColorVariant
import com.example.portfoliowebsite.theme.icons.IconStyle
import com.example.portfoliowebsite.theme.icons.LightModeIcon
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode

@Composable
fun ThemeIconButton(
    colorMode: ColorMode = ColorMode.current,
    onClick: () -> Unit,
) {
    PrimaryIconButton(
        onClick = {
            onClick()
        },
    ) {
        val iconModifier = IconStyle.toModifier(IconOnBrandColorVariant)
        when (colorMode) {
            ColorMode.LIGHT -> LightModeIcon(modifier = iconModifier)
            ColorMode.DARK -> DarkModeIcon(modifier = iconModifier)
        }
    }
}