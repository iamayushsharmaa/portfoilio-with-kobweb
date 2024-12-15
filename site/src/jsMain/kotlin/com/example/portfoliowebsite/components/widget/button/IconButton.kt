package com.example.portfoliowebsite.components.widget.button

import androidx.compose.runtime.Composable
import com.example.portfoliowebsite.theme.brand
import com.varabyte.kobweb.browser.dom.ElementTarget
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.forms.ButtonKind
import com.varabyte.kobweb.silk.components.forms.ButtonStyle
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.overlay.Tooltip
import com.varabyte.kobweb.silk.style.ComponentKind
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.CssStyleVariant
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.selectors.active
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.theme.colors.palette.button
import com.varabyte.kobweb.silk.theme.colors.palette.overlay
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import com.varabyte.kobweb.silk.theme.colors.shifted
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.auto

val IconButtonVariant : CssStyleVariant<ButtonKind> = ButtonStyle.addVariant {
val colorPalette = colorMode.toPalette()
    base {
        Modifier
            .width(auto)
            .height(auto)
            .background(Colors.Transparent)
            .alignContent(AlignContent.Center)
            .justifyContent(JustifyContent.Center)
            .display(DisplayStyle.Flex)
            .padding(0.5.cssRem)
            .borderRadius(50.percent)
    }
    hover {
        Modifier.background(colorPalette.overlay.shifted(colorMode, 0.1f))
    }
    active {
        Modifier.background(colorPalette.overlay.shifted(colorMode, 0.2f))
    }
}

val PrimaryIconButtonVariant = ButtonStyle.addVariant {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier.background(colorPalette.brand.primary)
    }
    hover {
        Modifier.background(colorPalette.button.hover)
    }
    active {
        Modifier.background(colorPalette.button.pressed)
    }
}

@Composable
fun IconButton(
    modifier: Modifier = Modifier,
    tooltipText: String? = null,
    onClick: (() -> Unit)? = null,
    icon: @Composable () -> Unit,
) {
    Button(
        onClick = {
            onClick?.invoke()
        },
        modifier = modifier,
        variant = IconButtonVariant
    ) {
        icon()
    }
    if (tooltipText != null) {
        Tooltip(
            target = ElementTarget.PreviousSibling,
            text = tooltipText
        )
    }
}

@Composable
fun IconButton(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    iconRes: String,
    tooltipText: String? = null,
    iconSize: CSSSizeValue<CSSUnit.rem> = 1.5.cssRem,
) {
    Button(
        onClick = {
            onClick?.invoke()
        },
        modifier = modifier,
        variant = IconButtonVariant
    ) {
        Image(
            src = iconRes,
            modifier = Modifier.size(iconSize)
        )
    }
    if (tooltipText != null) {
        Tooltip(
            target = ElementTarget.PreviousSibling,
            text = tooltipText
        )
    }
}

@Composable
fun PrimaryIconButton(
    modifier: Modifier = Modifier,
    tooltipText: String? = null,
    onClick: (() -> Unit)? = null,
    icon: @Composable () -> Unit,
) {
    Button(
        onClick = {
            onClick?.invoke()
        },
        modifier = modifier,
        variant = IconButtonVariant.then(PrimaryIconButtonVariant),
    ) {
        icon()
    }
    if (tooltipText != null) {
        Tooltip(
            target = ElementTarget.PreviousSibling,
            text = tooltipText
        )
    }
}