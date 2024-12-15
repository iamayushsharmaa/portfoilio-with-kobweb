package com.example.portfoliowebsite.components.section.contact


import androidx.compose.runtime.Composable
import com.example.portfoliowebsite.components.section.contact.component.ContactCard
import com.example.portfoliowebsite.components.widget.section.SectionContainer
import com.example.portfoliowebsite.components.widget.section.SectionContainerStyle
import com.example.portfoliowebsite.components.widget.section.SectionKind
import com.example.portfoliowebsite.model.Section
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.silk.style.ComponentKind
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.CssStyleVariant
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh



val ContactSectionVariant : CssStyleVariant<SectionKind> =  SectionContainerStyle.addVariant {
    base {
        Modifier.minHeight(600.px)
    }
    Breakpoint.ZERO {
        Modifier.height(100.vh)
    }
    Breakpoint.MD {
        Modifier.height(85.vh)
    }
}

@Composable
fun ContactSection() {
    SectionContainer(
        variant = ContactSectionVariant,
        section = Section.Contact,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContactCard()
    }
}