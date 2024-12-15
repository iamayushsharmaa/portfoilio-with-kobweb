package com.example.portfoliowebsite.theme.icons


import com.example.portfoliowebsite.theme.brand
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.silk.style.ComponentKind
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.colors.palette.color
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.cssRem

sealed interface IconKind : ComponentKind

val IconStyle = CssStyle<IconKind> {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier.color(colorPalette.color)
    }
    Breakpoint.ZERO {
        Modifier.size(1.55.cssRem)
    }
    Breakpoint.SM {
        Modifier.size(1.55.cssRem)
    }
    Breakpoint.MD {
        Modifier.size(1.65.cssRem)
    }
    Breakpoint.LG {
        Modifier.size(1.65.cssRem)
    }
    Breakpoint.XL {
        Modifier.size(1.75.cssRem)
    }
}

// Variant: Icon with Brand Color
val IconBrandColorVariant = IconStyle.addVariant<IconKind> {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier.color(colorPalette.brand.primary)
    }
}

// Variant: Icon with On-Brand Color
val IconOnBrandColorVariant = IconStyle.addVariant<IconKind> {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier.color(colorPalette.brand.onPrimary)
    }
}

// Variant: Large Icon Size
val LargeIconSize = IconStyle.addVariant<IconKind> {
    Breakpoint.ZERO {
        Modifier.size(1.8.cssRem)
    }
    Breakpoint.SM {
        Modifier.size(2.2.cssRem)
    }
    Breakpoint.MD {
        Modifier.size(2.5.cssRem)
    }
    Breakpoint.LG {
        Modifier.size(2.8.cssRem)
    }
    Breakpoint.XL {
        Modifier.size(3.cssRem)
    }
}

// Variant: Medium Icon Size
val MediumIconSize = IconStyle.addVariant<IconKind> {
    Breakpoint.ZERO {
        Modifier.size(1.8.cssRem)
    }
    Breakpoint.SM {
        Modifier.size(2.cssRem)
    }
    Breakpoint.MD {
        Modifier.size(2.2.cssRem)
    }
    Breakpoint.LG {
        Modifier.size(2.3.cssRem)
    }
    Breakpoint.XL {
        Modifier.size(2.5.cssRem)
    }
}
