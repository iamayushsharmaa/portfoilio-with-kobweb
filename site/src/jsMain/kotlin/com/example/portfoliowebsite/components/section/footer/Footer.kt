package com.example.portfoliowebsite.components.section.footer

import androidx.compose.runtime.Composable
import com.example.portfoliowebsite.components.widget.button.LinkIconButton
import com.example.portfoliowebsite.model.Social
import com.example.portfoliowebsite.theme.font.LabelLargeTextStyle
import com.example.portfoliowebsite.theme.font.TextStyle
import com.example.portfoliowebsite.theme.font.TextStyleSecondaryColor
import com.example.portfoliowebsite.utils.Res
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.ComponentKind
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.breakpoint.displayUntil
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.overlay
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px



val FooterStyle = CssStyle {
    val colorMode = colorMode.toPalette()
    base {
        Modifier
            .fillMaxWidth()
            .background(Colors.Transparent)
    }
    Breakpoint.ZERO {
        Modifier.padding(left = 12.px, right = 12.px, top = 24.px, bottom = 24.px)
    }
    Breakpoint.SM {
        Modifier.padding(left = 24.px, right = 24.px, top = 24.px, bottom = 24.px)
    }
    Breakpoint.MD {
        Modifier.padding(left = 34.px, right = 34.px, top = 34.px, bottom = 34.px)
    }
    Breakpoint.LG {
        Modifier.padding(left = 54.px, right = 54.px, top = 40.px, bottom = 40.px)
    }
    Breakpoint.XL {
        Modifier.padding(left = 104.px, right = 104.px, top = 40.px, bottom = 40.px)
    }
}

@Composable
fun Footer() {
    Row(
        modifier = FooterStyle.toModifier().displayIfAtLeast(Breakpoint.MD),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(modifier = Modifier.flex(1), contentAlignment = Alignment.CenterStart) {
            Copyright()
        }
        Box(modifier = Modifier.flex(1), contentAlignment = Alignment.Center) {
            SocialLinks()
        }
        Box(modifier = Modifier.flex(1), contentAlignment = Alignment.CenterEnd) {
            PoweredByKobweb()
        }
    }
    Column(
        modifier = FooterStyle.toModifier().displayUntil(Breakpoint.MD).gap(1.cssRem),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SocialLinks()
        Copyright()
    }
}

@Composable
private fun SocialLinks() {
    val breakpoint = rememberBreakpoint()
    Row(
        modifier = Modifier.gap(if (breakpoint == Breakpoint.XL) 1.25.em else 1.em),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Social.entries.forEach { social ->
            LinkIconButton(
                path = social.link,
                iconRes = if (ColorMode.current.isLight) social.iconResLight else social.iconResDark
            )
        }
    }
}

@Composable
private fun Copyright() {
    SpanText(
        modifier = TextStyle.toModifier(LabelLargeTextStyle, TextStyleSecondaryColor)
            .textAlign(TextAlign.Start),
        text = Res.Strings.COPYRIGHT
    )
}

@Composable
private fun PoweredByKobweb() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        SpanText(
            modifier = TextStyle.toModifier(LabelLargeTextStyle, TextStyleSecondaryColor)
                .textAlign(TextAlign.Center),
            text = "Powered by"
        )
        Link(path = "https://kobweb.varabyte.com/") {
            Image(
                src = Res.Images.KOBWEB,
                modifier = Modifier
                    .display(DisplayStyle.Flex)
                    .height(1.25.cssRem)
                    .margin(left = 0.375.cssRem)
            )
        }
    }
}