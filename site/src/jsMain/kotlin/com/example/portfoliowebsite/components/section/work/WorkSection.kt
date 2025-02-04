package com.example.portfoliowebsite.components.section.work

import androidx.compose.runtime.Composable
import com.example.portfoliowebsite.components.section.start.StartSectionVariant
import com.example.portfoliowebsite.components.section.work.component.WorkItem
import com.example.portfoliowebsite.components.section.work.component.WorkItemsSimpleGridVariant
import com.example.portfoliowebsite.components.widget.section.SectionContainer
import com.example.portfoliowebsite.components.widget.section.SectionContainerStyle
import com.example.portfoliowebsite.components.widget.section.SectionKind
import com.example.portfoliowebsite.model.Section
import com.example.portfoliowebsite.model.Work
import com.example.portfoliowebsite.theme.font.*
import com.example.portfoliowebsite.utils.Res
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.*
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.overlay
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh

val WorkSectionContainerVariant : CssStyleVariant<SectionKind> = SectionContainerStyle.addVariant {
    base {
        Modifier
            .width(100.percent)
            .height(auto)
            .maxWidth(130.cssRem)
    }
    Breakpoint.ZERO {
        Modifier.padding(leftRight = 16.px)
    }
    Breakpoint.SM {
        Modifier.padding(leftRight = 28.px)
    }
    Breakpoint.MD {
        Modifier.padding(leftRight = 48.px)
    }
    Breakpoint.LG {
        Modifier.padding(leftRight = 94.px)
    }
    Breakpoint.XL {
        Modifier.padding(leftRight = 134.px)
    }
}


@Composable
fun WorksSection() {
    val breakpoint = rememberBreakpoint()
    SectionContainer(
        modifier = Modifier,
        variant = WorkSectionContainerVariant,
        section = Section.Works,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextContent(breakpoint = breakpoint)
        SimpleGrid(
            numColumns = numColumns(base = 1, sm = 2, lg = 3),
            variant = WorkItemsSimpleGridVariant
        ) {
            Work.entries.forEach {
                WorkItem(
                    work = it,
                    modifier = Modifier.flex(1)
                )
            }
            MoreIsYetToCome()
        }
    }
}

@Composable
private fun MoreIsYetToCome() {
    val colorPalette = ColorMode.current.toPalette()
    Box(
        modifier = Modifier
            .backgroundColor(colorPalette.overlay)
            .borderRadius(30.px),
        contentAlignment = Alignment.Center
    ) {
        SpanText(
            text = "More is yet to come...",
            modifier = TextStyle.toModifier(TitleTextStyle)
        )
    }
}

@Composable
private fun  TextContent(
    breakpoint: Breakpoint,
) {
    Column(
        modifier = Modifier.margin(top = 8.5.cssRem),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SpanText(
            modifier = TextStyle.toModifier(DisplayTextStyle, TextStylePrimaryColor).textAlign(TextAlign.Center),
            text = Res.Strings.WORKS_SECTION_TITLE
        )
        SpanText(
            modifier = TextStyle.toModifier(SubDisplayTextStyle, TextStyleSecondaryColor)
                .maxWidth(if (breakpoint >= Breakpoint.SM) 75.percent else 100.percent)
                .margin(top = 1.cssRem)
                .textAlign(TextAlign.Center),
            text = Res.Strings.WORKS_SECTION_SUBTITLE
        )
    }
}

