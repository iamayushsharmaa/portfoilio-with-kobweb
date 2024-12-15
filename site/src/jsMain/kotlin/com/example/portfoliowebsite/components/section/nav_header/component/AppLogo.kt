package com.example.portfoliowebsite.components.section.nav_header.component

import androidx.compose.runtime.Composable
import com.example.portfoliowebsite.utils.Res
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.navigation.Anchor
import com.varabyte.kobweb.silk.style.*
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.dom.Img


val AppLogoStyle = CssStyle {
    base {
        Modifier.display(DisplayStyle.Flex)
    }
    Breakpoint.ZERO {
        Modifier.height(1.825.cssRem)
    }
    Breakpoint.SM {
        Modifier.height(1.95.cssRem)
    }
    Breakpoint.MD {
        Modifier.height(2.cssRem)
    }
    Breakpoint.LG {
        Modifier.height(2.10.cssRem)
    }
    Breakpoint.XL {
        Modifier.height(2.99.cssRem)
    }
    hover {
        Modifier
            .transform { rotate((-6).deg) }
    }
}

@Composable
fun AppLogo(
    colorMode: ColorMode,
    variant: CssStyleVariant<ComponentKind>? = null
) {
    Anchor(href = "/") {
        Img(
            src = when (colorMode) {
                ColorMode.LIGHT -> Res.Images.LOGO_LIGHT
                ColorMode.DARK -> Res.Images.LOGO_DARK
            },
            attrs = AppLogoStyle.toAttrs()
           )
    }
}