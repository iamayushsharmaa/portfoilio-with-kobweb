package com.example.portfoliowebsite.model

import com.example.portfoliowebsite.utils.Res


enum class Work(
    val workName: String,
    val description: String,
    val link: String,
    val imageRes: String,
) {
    HotelX(
        workName = "Hotel Management System",
        description = "Tablet & Android & Backend & Design",
        link = "",
        imageRes = Res.Images.HOTEL
    ),
    HoneyMart(
        workName = "Honey Mart",
        description = "Android & Backend & Design",
        link = "https://github.com/MohamedElgohary88/Honey-Mart",
        imageRes = Res.Images.HONEY_MART
    ),
    Blog(
        workName = "Blog Multi-Platform",
        description = "Android & Backend & Design",
        link = "https://github.com/MohamedElgohary88/BlogMultiplatform",
        imageRes = Res.Images.BLOG
    ),
    Teamix(
        workName = "Teamix App",
        description = "Android & Backend & Design",
        link = "https://github.com/MohamedElgohary88/Teamix",
        imageRes = Res.Images.TEAMIX
    ),
    SkyCast(
        workName = "SkyCast Weather App",
        description = "Desktop & Api & Design",
        link = "https://github.com/MohamedElgohary88/SkyCast",
        imageRes = Res.Images.SKY_CAST
    ),
    Movie(
        workName = "Movies App",
        description = "Android & Design",
        link = "https://github.com/MohamedElgohary88/MovieApp",
        imageRes = Res.Images.MOVIE
    ),
}