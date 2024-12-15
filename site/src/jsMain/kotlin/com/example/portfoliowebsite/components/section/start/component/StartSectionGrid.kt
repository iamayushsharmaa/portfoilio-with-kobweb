package com.example.portfoliowebsite.components.section.start.component


import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.animation.Keyframes
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.*

val StartSectionGridKeyFrames = Keyframes {
    0.percent {
        Modifier
            .margin(right = 50.px)
            .opacity(0)
    }
    100.percent {
        Modifier
            .margin(right = 0.px)
            .opacity(1)
    }
}


val StartSectionGridStyle = CssStyle{
    base {
        Modifier
            .width(100.percent)
            .display(DisplayStyle.Flex)
            .columnGap(1.cssRem)
            .rowGap(3.cssRem)
            .animation(
                StartSectionGridKeyFrames.toAnimation(
                    duration = 0.5.s,
                    timingFunction = AnimationTimingFunction.EaseInOut
                )
            )
    }
    Breakpoint.ZERO {
        Modifier.flexDirection(FlexDirection.ColumnReverse)
    }
    Breakpoint.SM {
        Modifier.flexDirection(FlexDirection.ColumnReverse)
    }
    Breakpoint.MD {
        Modifier.flexDirection(FlexDirection.ColumnReverse)
    }
    Breakpoint.LG {
        Modifier.flexDirection(FlexDirection.Row)
    }
    Breakpoint.XL {
        Modifier.flexDirection(FlexDirection.Row)
    }
}
