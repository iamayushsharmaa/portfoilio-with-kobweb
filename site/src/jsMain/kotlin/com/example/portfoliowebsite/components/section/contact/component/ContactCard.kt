package com.example.portfoliowebsite.components.section.contact.component

import androidx.compose.runtime.Composable
import com.example.portfoliowebsite.components.widget.button.LinkIconButton
import com.example.portfoliowebsite.model.Social
import com.example.portfoliowebsite.theme.font.*
import com.example.portfoliowebsite.theme.icons.IconStyle
import com.example.portfoliowebsite.theme.icons.MediumIconSize
import com.example.portfoliowebsite.utils.Res
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.ComponentKind
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.overlay
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text


sealed interface CardKind : ComponentKind

val ContactCardStyle = CssStyle<CardKind> {
    val colors = colorMode.toPalette()

    base {
        Modifier
            .fillMaxWidth()
            .background(Colors.Transparent)
            .borderRadius(30.px)
            .padding(topBottom = 1.cssRem, leftRight = 1.cssRem)
    }
    Breakpoint.LG {
        Modifier
            .fillMaxWidth(65.percent)
            .padding(topBottom = 2.cssRem, leftRight = 2.cssRem)
    }
    Breakpoint.XL {
        Modifier
            .fillMaxWidth(60.percent)
            .maxWidth(64.cssRem)
            .padding(topBottom = 2.25.cssRem, leftRight = 2.25.cssRem)
    }
}

@Composable
fun ContactCard(
    modifier: Modifier = Modifier,
    colorMode: ColorMode = ColorMode.current
) {
    Column(
        modifier = ContactCardStyle.toModifier().then(modifier),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        SpanText(
            modifier = TextStyle.toModifier(DisplayTextStyle, TextStylePrimaryColor)
                .textAlign(TextAlign.Center),
            text = Res.Strings.CONTACT_SECTION_TITLE
        )
        P(
            attrs = TextStyle.toModifier(BodyLargeTextStyle, TextStyleSecondaryColor)
                .textAlign(TextAlign.Center)
                .margin(top = 0.6.em, leftRight = 0.6.em)
                .toAttrs(),
        ) {
            Text("If you have any questions, don't hesitate to contact me via email at ")
            SpanText(
                text = Res.Strings.EMAIL_ADDRESS,
                modifier = TextStyle.toModifier(BodyLargeTextStyle, TextStylePrimaryColor)
                    .fontFamily(Res.FontFamilies.POPPINS_MEDIUM)
                    .textAlign(TextAlign.Center),
            )
            Text(" or text me on Telegram at ")
            SpanText(
                text = Res.Strings.TELEGRAM_USERNAME,
                modifier = TextStyle.toModifier(BodyLargeTextStyle, TextStylePrimaryColor)
                    .fontFamily(Res.FontFamilies.POPPINS_MEDIUM)
                    .textAlign(TextAlign.Center),
            )
        }
        Row(
            modifier = Modifier
                .margin(top = 3.em)
                .gap(1.5.em),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Social.entries.forEach { social ->
                LinkIconButton(
                    path = social.link,
                    iconRes = if (colorMode.isLight) social.iconResLight else social.iconResDark,
                    iconModifier = IconStyle.toModifier(MediumIconSize)
                )
            }
        }
    }
}