package com.example.portfoliowebsite.model

import com.example.portfoliowebsite.utils.Res


enum class Social(
    val link: String,
    val iconResLight: String,
    val iconResDark: String,
) {
    Email(
        link = Res.Strings.EMAIL_LINK,
        iconResLight = Res.Images.MAIL_LIGHT,
        iconResDark = Res.Images.MAIL_DARK
    ),
    X(
        link = Res.Strings.X_Link,
        iconResLight = Res.Images.X_LIGHT,
        iconResDark = Res.Images.X_DARK
    ),
    GitHub(
        link = Res.Strings.GITHUB_LINK,
        iconResLight = Res.Images.GITHUB_LIGHT,
        iconResDark = Res.Images.GITHUB_DARK
    ),
    LinkedIn(
        link = Res.Strings.LINKEDIN_LINK,
        iconResLight = Res.Images.LINKEDIN_LIGHT,
        iconResDark = Res.Images.LINKEDIN_DARK
    );
}