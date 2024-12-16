package com.example.portfoliowebsite.components.section.about

import androidx.compose.runtime.Composable
import com.example.portfoliowebsite.components.section.about.component.AboutSectionSkillsGridVariant
import com.example.portfoliowebsite.components.widget.section.SectionContainer
import com.example.portfoliowebsite.components.widget.section.SectionContainerStyle
import com.example.portfoliowebsite.components.widget.section.SectionKind
import com.example.portfoliowebsite.components.widget.skill.SkillItem
import com.example.portfoliowebsite.model.Section
import com.example.portfoliowebsite.model.Skill
import com.example.portfoliowebsite.theme.brand
import com.example.portfoliowebsite.theme.font.*
import com.example.portfoliowebsite.utils.Res
import com.varabyte.kobweb.compose.css.CSSPosition
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.functions.RadialGradient
import com.varabyte.kobweb.compose.css.functions.radialGradient
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.SimpleGridKind
import com.varabyte.kobweb.silk.components.layout.SimpleGridStyle
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.*
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.auto


val AboutSectionVariant : CssStyleVariant<SectionKind> = SectionContainerStyle.addVariant {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier.minHeight(100.vh)
    }
    Breakpoint.ZERO {
        Modifier
            .maxWidth(100.percent)
            .backgroundImage(
                radialGradient(RadialGradient.Shape.Circle, CSSPosition(x = 50.percent, y = 30.percent)) {
                    add(colorPalette.brand.primary.toRgb().copyf(alpha = if (colorMode.isDark) 0.1f else 0.2f))
                    add(Colors.Transparent, 50.percent)
                }
            )
    }
    Breakpoint.SM {
        Modifier.maxWidth(100.percent)
    }
    Breakpoint.MD {
        Modifier
            .maxWidth(90.percent)
            .backgroundImage(
                radialGradient(RadialGradient.Shape.Circle, CSSPosition(x = 50.percent, y = 50.percent)) {
                    add(colorPalette.brand.primary.toRgb().copyf(alpha = if (colorMode.isDark) 0.1f else 0.2f))
                    add(Colors.Transparent, 63.percent)
                }
            )
    }
    Breakpoint.LG {
        Modifier.maxWidth(80.percent)
    }
    Breakpoint.XL {
        Modifier.maxWidth(70.percent)
    }
}



//val SimpleGridStyle = CssStyle<SimpleGridKind> {}



@Composable
fun AboutSection() {
    SectionContainer(
        modifier = Modifier,
        variant = AboutSectionVariant,
        section = Section.About,
        verticalArrangement = Arrangement.Center,
    ) {
        TextContent()
        SimpleGrid(
            variant = AboutSectionSkillsGridVariant,
            numColumns = numColumns(base = 2, md = 5, lg = 5)
        ) {
            Skill.entries.forEach { skill ->
                SkillItem(
                    skill = skill,
                    modifier = Modifier.flexGrow(1)
                )
            }
        }
    }
}

@Composable
private fun TextContent() {
    Column(
        modifier = Modifier
            .padding(top = 8.5.cssRem)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SpanText(
            modifier = TextStyle.toModifier(DisplayTextStyle, TextStylePrimaryColor)
                .textAlign(TextAlign.Center),
            text = Res.Strings.ABOUT_SECTION_TITLE
        )
        SpanText(
            modifier = TextStyle.toModifier(SubDisplayTextStyle, TextStyleSecondaryColor)
                .padding(top = 1.cssRem)
                .textAlign(TextAlign.Center),
            text = Res.Strings.ABOUT_SECTION_SUBTITLE
        )
    }
}

