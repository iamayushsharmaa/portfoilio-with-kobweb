package com.example.portfoliowebsite.components.section.nav_header.component


import androidx.compose.runtime.Composable
import com.example.portfoliowebsite.theme.brand
import com.example.portfoliowebsite.theme.text
import com.example.portfoliowebsite.model.Section
import com.example.portfoliowebsite.theme.font.Fonts
import com.varabyte.kobweb.compose.css.ListStyleType
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.autoLength
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.LinkKind
import com.varabyte.kobweb.silk.components.navigation.LinkStyle
import com.varabyte.kobweb.silk.style.*
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.selectors.active
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.theme.colors.palette.overlay
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import com.varabyte.kobweb.silk.theme.colors.shifted
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Nav
import org.jetbrains.compose.web.dom.Text

val NavBarStyle = CssStyle {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier
            .size(autoLength)
            .background(Colors.Transparent)
            .borderRadius(30.px)
            .listStyle(ListStyleType.None)
            .display(DisplayStyle.Flex)
            .justifyContent(JustifyContent.Center)
            .flex(1)
    }
}

@Composable
fun NavBar(
    selectedSectionId: String
) {
    Nav(
        attrs = NavBarStyle.toAttrs()
    ) {
        Section.entries.forEach { section ->
            NavBarLink(
                href = section.href,
                text = section.text,
                selected = section.id == selectedSectionId
            )
        }
    }
}

val NavBarLinkVariant : CssStyleVariant<LinkKind> = LinkStyle.addVariant {
    val colorPalette = colorMode.toPalette()
    val defaultFonts = Fonts[Breakpoint.LG]

    base {
        Modifier
            .alignContent(AlignContent.Center)
            .color(colorPalette.text.primary)
            .background(Colors.Transparent)
            .borderRadius(r = 30.px)
            .textDecorationLine(TextDecorationLine.None)
            .transition(Transition.of("0.2s" ))
            .font { defaultFonts.bodyLarge }
    }
    hover {
        Modifier.background(Colors.Transparent)
    }
    active {
        Modifier.background(Colors.Transparent)
    }
    Breakpoint.LG {
        Modifier.size(width = 10.9.em, height = 3.0.em)
    }
    Breakpoint.XL {
        Modifier.size(width = 12.0.em, height = 3.2.em)
    }
}

val ActiveNavBarLinkVariant : CssStyleVariant<LinkKind> = LinkStyle.addVariant {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier
            .color(colorPalette.brand.onPrimary)
            .background(colorPalette.brand.primary)
            .backgroundColor(colorPalette.brand.primary)
            .transition(Transition.of("0.1s"))
    }
    hover {
        Modifier.background(colorPalette.brand.primary)
    }
}

@Composable
private fun NavBarLink(
    href: String,
    text: String,
    selected: Boolean,
) {
    Link(
        path = href,
        variant = NavBarLinkVariant.thenIf(selected, ActiveNavBarLinkVariant),
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text)
        }
    }
}