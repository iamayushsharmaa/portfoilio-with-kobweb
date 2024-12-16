package com.example.portfoliowebsite.components.section.start.component


import androidx.compose.runtime.Composable
import com.example.portfoliowebsite.components.widget.skill.SkillItem
import com.example.portfoliowebsite.model.Skill
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.ComponentKind
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.palette.overlay
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.vh


sealed interface SectionKind : ComponentKind
val SkillSectionDividerStyle = CssStyle<SectionKind>{
    val colorPalette = colorMode.toPalette()
    base {
        Modifier
            .fillMaxWidth()
            .background(Colors.Transparent)
    }
    Breakpoint.ZERO {
        Modifier
            .padding(top = 2.5.cssRem, bottom = 2.5.cssRem)
            .height(18.vh)
    }
    Breakpoint.SM {
        Modifier
            .height(17.vh)
            .padding(topBottom = 2.4.cssRem)
    }
    Breakpoint.MD {
        Modifier
            .padding(bottom = 1.cssRem)
    }
}

@Composable
fun SkillsSectionDivider(
    skillsToDisplay: List<Skill> = listOf(Skill.AndroidStudio, Skill.Kotlin, Skill.Ktor, Skill.Figma),
    modifier: Modifier = Modifier,
) {
    val breakpoint = rememberBreakpoint()
    Box(
        modifier = SkillSectionDividerStyle.toModifier().then(modifier),
        contentAlignment = Alignment.Center
    ) {
        SimpleGrid(
            modifier = Modifier
                .gap(if (breakpoint >= Breakpoint.MD) 1.9.cssRem else 1.cssRem)
                .padding(left = if (breakpoint <= Breakpoint.SM) 2.25.cssRem else 0.cssRem),
            numColumns = numColumns(base = 2, sm = 4, md = 4)
        ) {
            skillsToDisplay.forEach { skill ->
                SkillItem(
                    skill = skill,
                    modifier = Modifier.flexGrow(1),
                    horizontalArrangement = if (breakpoint >= Breakpoint.MD) Arrangement.Center else Arrangement.Start
                )
            }
        }
    }
}