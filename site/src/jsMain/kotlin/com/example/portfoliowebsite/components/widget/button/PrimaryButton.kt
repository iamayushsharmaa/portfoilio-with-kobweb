package com.example.portfoliowebsite.components.widget.button

import androidx.compose.runtime.Composable
import androidx.compose.web.events.SyntheticMouseEvent
import com.example.portfoliowebsite.theme.brand
import com.example.portfoliowebsite.theme.font.Fonts
import com.example.portfoliowebsite.theme.font.LabelLargeTextStyle
import com.example.portfoliowebsite.theme.font.TextStyle
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.forms.ButtonKind
import com.varabyte.kobweb.silk.components.forms.ButtonStyle
import com.varabyte.kobweb.silk.style.*
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Text



val PrimaryButtonVariant: CssStyleVariant<ButtonKind> = ButtonStyle.addVariant {
    val colorPalette = colorMode.toPalette()
    val defaultFonts = Fonts[Breakpoint.LG]

    base {
        Modifier
            .width(auto)
            .height(auto)
            .background(colorPalette.brand.primary)
            .color(colorPalette.brand.onPrimary)
            .padding(leftRight = 2.25.em, topBottom = 1.1.em)
            .font { defaultFonts.bodyLarge }
    }
}

val PrimaryButtonWithIconPadding = ButtonStyle.addVariant {
    base {
        Modifier.padding(left = 2.25.em, right = 2.em, top = 1.em, bottom = 1.em)
    }
}

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    icon: (@Composable () -> Unit)? = null,
    onClick: (SyntheticMouseEvent) -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        variant = PrimaryButtonVariant.thenIf(icon != null, PrimaryButtonWithIconPadding),
    ) {
        Row(
            modifier = Modifier.gap(12.px),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text)
            icon?.invoke()
        }
    }
}
