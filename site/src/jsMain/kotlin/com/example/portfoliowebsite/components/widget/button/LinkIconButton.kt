package com.example.portfoliowebsite.components.widget.button


import androidx.compose.runtime.Composable
import com.example.portfoliowebsite.theme.icons.IconStyle
import com.varabyte.kobweb.browser.dom.ElementTarget
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.scale
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.LinkKind
import com.varabyte.kobweb.silk.components.navigation.LinkStyle
import com.varabyte.kobweb.silk.components.overlay.Tooltip
import com.varabyte.kobweb.silk.style.*
import com.varabyte.kobweb.silk.style.selectors.active
import com.varabyte.kobweb.silk.style.selectors.hover


val LinkIconButtonVariant: CssStyleVariant<LinkKind> = LinkStyle.addVariant {
    base {
        Modifier.transition(Transition.of("0.15s", null, null, null))
    }
    hover {
        Modifier.scale(1.1)
    }
    active {
        Modifier.scale(1.2)
    }
}

@Composable
fun LinkIconButton(
    path: String,
    modifier: Modifier = Modifier,
    tooltipText: String? = null,
    onClick: (() -> Unit)? = null,
    icon: @Composable () -> Unit,
    openLinkStrategy: OpenLinkStrategy = OpenLinkStrategy.IN_NEW_TAB
) {
    Link(
        path = path,
        openExternalLinksStrategy = openLinkStrategy,
        openInternalLinksStrategy = openLinkStrategy,
        variant = LinkIconButtonVariant,
        modifier = modifier.onClick { onClick?.invoke() },
    ) {
        icon()
        if (tooltipText != null) {
            Tooltip(
                target = ElementTarget.PreviousSibling,
                text = tooltipText
            )
        }
    }
}

@Composable
fun LinkIconButton(
    path: String,
    iconRes: String,
    modifier: Modifier = Modifier,
    iconModifier: Modifier = IconStyle.toModifier(),
    tooltipText: String? = null,
    onClick: (() -> Unit)? = null,
    openLinkStrategy: OpenLinkStrategy = OpenLinkStrategy.IN_NEW_TAB
) {
    Link(
        path = path,
        openExternalLinksStrategy = openLinkStrategy,
        openInternalLinksStrategy = openLinkStrategy,
        variant = LinkIconButtonVariant,
        modifier = modifier.onClick { onClick?.invoke() },
    ) {
        Image(
            modifier = iconModifier,
            src = iconRes
        )
        if (tooltipText != null) {
            Tooltip(
                target = ElementTarget.PreviousSibling,
                text = tooltipText
            )
        }
    }
}