package com.example.portfoliowebsite.components.section.work.component

import androidx.compose.runtime.Composable
import com.example.portfoliowebsite.components.widget.button.LinkIconButton
import com.example.portfoliowebsite.model.Work
import com.example.portfoliowebsite.theme.font.BodyLargeTextStyle
import com.example.portfoliowebsite.theme.font.TextStyle
import com.example.portfoliowebsite.theme.font.TitleTextStyle
import com.example.portfoliowebsite.theme.icons.ExternalLinkIcon
import com.example.portfoliowebsite.theme.icons.IconStyle
import com.example.portfoliowebsite.theme.icons.LargeIconSize
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.graphics.ImageKind
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.before
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.s

val WorkItemStyle  = CssStyle {
    base {
        Modifier
            .position(Position.Relative)
            .borderRadius(30.px)
            .overflow(Overflow.Hidden)
    }
    before {
        Modifier
            .content("")
            .backgroundColor(Color.rgb(r = 29, g = 28, b = 38))
            .opacity(0.75)
            .position(Position.Absolute)
            .fillMaxWidth()
            .height(0.px)
            .transition(CSSTransition("ease-in-out", 0.4.s))
    }
    (hover + before) {
        Modifier.fillMaxHeight()
    }
    cssRule(":hover .work-item-overlay") {
        Modifier.opacity(1)
    }
}

val WorkItemImageStyle = CssStyle {
    base {
        Modifier
            .fillMaxSize()
    }
}

val WorkItemOverlayStyle = CssStyle {
    base {
        Modifier
            .position(Position.Absolute)
            .textAlign(TextAlign.Center)
            .transition(CSSTransition("ease-in-out", 0.5.s))
            .opacity(0)
            .fillMaxWidth()
            .fillMaxHeight()
            .color(Colors.White)
    }
}

@Composable
fun WorkItem(
    work: Work,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = WorkItemStyle.toModifier().then(modifier),
        contentAlignment = Alignment.Center
    ) {
        Image(
            src = work.imageRes,
            modifier = WorkItemImageStyle.toModifier()
        )
        Column(
            modifier = WorkItemOverlayStyle.toModifier(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            SpanText(
                text = work.workName,
                modifier = TextStyle.toModifier(TitleTextStyle)
            )
            SpanText(
                text = work.description,
                modifier = TextStyle.toModifier(BodyLargeTextStyle).margin(top = 0.5.cssRem)
            )
            LinkIconButton(
                modifier = Modifier.margin(top = 1.cssRem),
                path = work.link,
                icon = { ExternalLinkIcon(modifier = IconStyle.toModifier(LargeIconSize).color(Colors.White)) }
            )
        }
    }
}