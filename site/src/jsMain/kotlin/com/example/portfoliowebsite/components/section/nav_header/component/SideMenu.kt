package com.example.portfoliowebsite.components.section.nav_header.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import com.example.portfoliowebsite.components.widget.button.IconButton
import com.example.portfoliowebsite.theme.brand
import com.example.portfoliowebsite.theme.text
import com.example.portfoliowebsite.model.Section
import com.example.portfoliowebsite.theme.font.Fonts
import com.example.portfoliowebsite.theme.font.LabelLargeTextStyle
import com.example.portfoliowebsite.theme.font.TextStyle
import com.example.portfoliowebsite.theme.icons.IconStyle
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.icons.CloseIcon
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.LinkStyle
import com.varabyte.kobweb.silk.components.overlay.Overlay
import com.varabyte.kobweb.silk.components.overlay.OverlayVars
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.animation.Keyframes
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.selectors.active
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.thenIf
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.palette.overlay
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import com.varabyte.kobweb.silk.theme.colors.shifted
import org.jetbrains.compose.web.css.*



val SideMenuStyle = CssStyle {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier
            .fillMaxHeight()
            .width(33.percent)
            .padding(top = 1.cssRem, leftRight = 1.cssRem)
            .gap(1.5.cssRem)
            .backgroundColor(colorPalette.overlay)
            .borderRadius(topRight = 30.px, bottomRight = 30.px)
    }
    Breakpoint.ZERO {
        Modifier.width(50.percent)
    }
    Breakpoint.SM {
        Modifier.width(43.percent)
    }
    Breakpoint.MD {
        Modifier.width(30.percent)
    }
}

val SideMenuSlideInAnim = Keyframes {
    from {
        Modifier.translate((-100).percent)
    }

    to {
        Modifier.translateX(0.percent)
    }
}

enum class SideMenuState {
    CLOSED,
    OPEN,
    CLOSING;

    fun close() = when (this) {
        CLOSED -> CLOSED
        OPEN -> CLOSING
        CLOSING -> CLOSING
    }
}

@Composable
fun SideMenu(
    menuState: SideMenuState,
    selectedSectionId: String,
    onCloseRequest: () -> Unit,
    onAnimationEnd: () -> Unit,
) {
    Overlay(
        modifier = Modifier
            .zIndex(2)
            .setVariable(OverlayVars.BackgroundColor, Colors.Transparent)
            .onClick { onCloseRequest() },
        contentAlignment = Alignment.CenterStart
    ) {
        key(menuState) {
            Column(
                SideMenuStyle.toModifier()
                    .animation(
                        SideMenuSlideInAnim.toAnimation(
                            duration = 200.ms,
                            timingFunction = if (menuState == SideMenuState.OPEN) AnimationTimingFunction.EaseOut else AnimationTimingFunction.EaseIn,
                            direction = if (menuState == SideMenuState.OPEN) AnimationDirection.Normal else AnimationDirection.Reverse,
                            fillMode = AnimationFillMode.Forwards
                        )
                    )
                    .onAnimationEnd { onAnimationEnd() }
                    .onClick { it.stopPropagation() },
                horizontalAlignment = Alignment.Start
            ) {
                IconButton(onClick = { onCloseRequest() }) {
                    CloseIcon(modifier = IconStyle.toModifier())
                }
                Column(
                    modifier = Modifier.gap(1.5.cssRem),
                    horizontalAlignment = Alignment.Start
                ) {
                    Section.entries.forEach { section ->
                        SideMenuNavLink(
                            href = section.href,
                            text = section.text,
                            selected = section.id == selectedSectionId,
                            onClick = { onCloseRequest() }
                        )
                    }
                }
            }
        }
    }
}


val SideMenuLinkVariant = LinkStyle.addVariant {

    val colorPalette = colorMode.toPalette()
    val defaultFonts = Fonts[Breakpoint.LG]
    base {
        Modifier
            .textDecorationLine(TextDecorationLine.None)
            .color(colorPalette.text.primary)
            .font { defaultFonts.bodyLarge }
    }
    hover {
        Modifier.color(colorPalette.brand.primary)
    }
    active {
        Modifier.color(colorPalette.brand.primary.shifted(colorMode, 0.15f))
    }
}

val ActiveSideMenuLinkVariant = LinkStyle.addVariant {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier.color(colorPalette.brand.primary)
    }
    hover {
        Modifier
    }
    active {
        Modifier
    }
}

@Composable
private fun SideMenuNavLink(
    href: String,
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
) {
    Link(
        path = href,
        text = text,
        variant = SideMenuLinkVariant.thenIf(selected, ActiveSideMenuLinkVariant),
        modifier = Modifier.onClick { onClick() }
    )
}