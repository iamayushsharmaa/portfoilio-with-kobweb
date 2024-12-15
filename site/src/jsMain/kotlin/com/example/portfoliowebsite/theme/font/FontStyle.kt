package com.example.portfoliowebsite.theme.font

import com.example.portfoliowebsite.theme.brand
import com.example.portfoliowebsite.theme.text
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.font
import com.varabyte.kobweb.silk.style.ComponentKind
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette


interface TextKind : ComponentKind
val TextStyle = CssStyle<TextKind> {

    val defaultFonts = Fonts[Breakpoint.LG]
    base {
        Modifier.font { defaultFonts.bodyLarge }
    }
}

val TextStylePrimaryColor = TextStyle.addVariant {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier.color(colorPalette.text.primary)
    }
}

val TextStyleSecondaryColor = TextStyle.addVariant {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier.color(colorPalette.text.secondary)
    }
}

val TextStyleBrandColor = TextStyle.addVariant {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier.color(colorPalette.brand.primary)
    }
}

val DisplayTextStyle = TextStyle.addVariant {
    Breakpoint.ZERO {
        val fontsSM = Fonts[Breakpoint.SM]
        Modifier.font { siteFont(fontsSM.display) }
    }
    Breakpoint.SM {
        val fontsSM = Fonts[Breakpoint.SM]
        Modifier.font { siteFont(fontsSM.display) }
    }
    Breakpoint.MD {
        val fontsMD = Fonts[Breakpoint.MD]
        Modifier.font { siteFont(fontsMD.display) }
    }
    Breakpoint.LG {
        val fontsLG = Fonts[Breakpoint.LG]
        Modifier.font { siteFont(fontsLG.display) }
    }
    Breakpoint.XL {
        val fontsXL = Fonts[Breakpoint.XL]
        Modifier.font { siteFont(fontsXL.display) }
    }
}

val SubDisplayTextStyle = TextStyle.addVariant {
    Breakpoint.ZERO {
        val fontsSM = Fonts[Breakpoint.SM]
        Modifier.font { siteFont(fontsSM.subDisplay) }
    }
    Breakpoint.SM {
        val fontsSM = Fonts[Breakpoint.SM]
        Modifier.font { siteFont(fontsSM.subDisplay) }
    }
    Breakpoint.MD {
        val fontsMD = Fonts[Breakpoint.MD]
        Modifier.font { siteFont(fontsMD.subDisplay) }
    }
    Breakpoint.LG {
        val fontsLG = Fonts[Breakpoint.LG]
        Modifier.font { siteFont(fontsLG.subDisplay) }
    }
    Breakpoint.XL {
        val fontsXL = Fonts[Breakpoint.XL]
        Modifier.font { siteFont(fontsXL.subDisplay) }
    }
}

val TitleTextStyle = TextStyle.addVariant {
    Breakpoint.ZERO {
        val fontsSM = Fonts[Breakpoint.SM]
        Modifier.font { siteFont(fontsSM.title) }
    }
    Breakpoint.SM {
        val fontsSM = Fonts[Breakpoint.SM]
        Modifier.font { siteFont(fontsSM.title) }
    }
    Breakpoint.MD {
        val fontsMD = Fonts[Breakpoint.MD]
        Modifier.font { siteFont(fontsMD.title) }
    }
    Breakpoint.LG {
        val fontsLG = Fonts[Breakpoint.LG]
        Modifier.font { siteFont(fontsLG.title) }
    }
    Breakpoint.XL {
        val fontsXL = Fonts[Breakpoint.XL]
        Modifier.font { siteFont(fontsXL.title) }
    }
}

val LabelLargeTextStyle = TextStyle.addVariant {
    Breakpoint.ZERO {
        val fontsSM = Fonts[Breakpoint.SM]
        Modifier.font { siteFont(fontsSM.labelLarge) }
    }
    Breakpoint.SM {
        val fontsSM = Fonts[Breakpoint.SM]
        Modifier.font { siteFont(fontsSM.labelLarge) }
    }
    Breakpoint.MD {
        val fontsMD = Fonts[Breakpoint.MD]
        Modifier.font { siteFont(fontsMD.labelLarge) }
    }
    Breakpoint.LG {
        val fontsLG = Fonts[Breakpoint.LG]
        Modifier.font { siteFont(fontsLG.labelLarge) }
    }
    Breakpoint.XL {
        val fontsXL = Fonts[Breakpoint.XL]
        Modifier.font { siteFont(fontsXL.labelLarge) }
    }
}

val LabelMediumTextStyle = TextStyle.addVariant {
    Breakpoint.ZERO {
        val fontsSM = Fonts[Breakpoint.SM]
        Modifier.font { siteFont(fontsSM.labelMedium) }
    }
    Breakpoint.SM {
        val fontsSM = Fonts[Breakpoint.SM]
        Modifier.font { siteFont(fontsSM.labelMedium) }
    }
    Breakpoint.MD {
        val fontsMD = Fonts[Breakpoint.MD]
        Modifier.font { siteFont(fontsMD.labelMedium) }
    }
    Breakpoint.LG {
        val fontsLG = Fonts[Breakpoint.LG]
        Modifier.font { siteFont(fontsLG.labelMedium) }
    }
    Breakpoint.XL {
        val fontsXL = Fonts[Breakpoint.XL]
        Modifier.font { siteFont(fontsXL.labelMedium) }
    }
}

val BodyLargeTextStyle = TextStyle.addVariant {
    Breakpoint.ZERO {
        val fontsSM = Fonts[Breakpoint.SM]
        Modifier.font { siteFont(fontsSM.bodyLarge) }
    }
    Breakpoint.SM {
        val fontsSM = Fonts[Breakpoint.SM]
        Modifier.font { siteFont(fontsSM.bodyLarge) }
    }
    Breakpoint.MD {
        val fontsMD = Fonts[Breakpoint.MD]
        Modifier.font { siteFont(fontsMD.bodyLarge) }
    }
    Breakpoint.LG {
        val fontsLG = Fonts[Breakpoint.LG]
        Modifier.font { siteFont(fontsLG.bodyLarge) }
    }
    Breakpoint.XL {
        val fontsXL = Fonts[Breakpoint.XL]
        Modifier.font { siteFont(fontsXL.bodyLarge) }
    }
}

val BodyMediumTextStyle = TextStyle.addVariant {
    Breakpoint.ZERO {
        val fontsSM = Fonts[Breakpoint.SM]
        Modifier.font { siteFont(fontsSM.bodyMedium) }
    }
    Breakpoint.SM {
        val fontsSM = Fonts[Breakpoint.SM]
        Modifier.font { siteFont(fontsSM.bodyMedium) }
    }
    Breakpoint.MD {
        val fontsMD = Fonts[Breakpoint.MD]
        Modifier.font { siteFont(fontsMD.bodyMedium) }
    }
    Breakpoint.LG {
        val fontsLG = Fonts[Breakpoint.LG]
        Modifier.font { siteFont(fontsLG.bodyMedium) }
    }
    Breakpoint.XL {
        val fontsXL = Fonts[Breakpoint.XL]
        Modifier.font { siteFont(fontsXL.bodyMedium) }
    }
}

val BodySmallTextStyle = TextStyle.addVariant {
    Breakpoint.ZERO {
        val fontsSM = Fonts[Breakpoint.SM]
        Modifier.font { siteFont(fontsSM.bodySmall) }
    }
    Breakpoint.SM {
        val fontsSM = Fonts[Breakpoint.SM]
        Modifier.font { siteFont(fontsSM.bodySmall) }
    }
    Breakpoint.MD {
        val fontsMD = Fonts[Breakpoint.MD]
        Modifier.font { siteFont(fontsMD.bodySmall) }
    }
    Breakpoint.LG {
        val fontsLG = Fonts[Breakpoint.LG]
        Modifier.font { siteFont(fontsLG.bodySmall) }
    }
    Breakpoint.XL {
        val fontsXL = Fonts[Breakpoint.XL]
        Modifier.font { siteFont(fontsXL.bodySmall) }
    }
}