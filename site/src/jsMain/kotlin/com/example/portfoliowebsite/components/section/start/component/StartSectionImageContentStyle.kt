package com.example.portfoliowebsite.components.section.start.component


import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.px

val StartSectionImageStyle = CssStyle {
    Breakpoint.ZERO {
        Modifier.height(222.px)
    }
    Breakpoint.SM {
        Modifier.height(264.px)
    }
    Breakpoint.MD {
        Modifier.height(333.px)
    }
    Breakpoint.LG {
        Modifier.height(443.px)
    }
    Breakpoint.XL {
        Modifier.height(500.px)
    }
}