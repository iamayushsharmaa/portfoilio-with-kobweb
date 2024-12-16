package com.example.portfoliowebsite.model

import com.example.portfoliowebsite.utils.Res


enum class Work(
    val workName: String,
    val description: String,
    val link: String,
    val imageRes: String,
) {
    HotelX(
        workName = "Grocery App",
        description = "Tablet & Android & Backend & Design",
        link = "https://github.com/iamayushsharmaa/Ecommerce-Admin-App-",
        imageRes = Res.Images.HOTEL
    ),
    HoneyMart(
        workName = "Spritual App",
        description = "Android & Backend & Design",
        link = "https://github.com/iamayushsharmaa/Spritual-App",
        imageRes = Res.Images.HONEY_MART
    ),
    Blog(
        workName = "HabitTrack",
        description = "Android & Backend & Design",
        link = "https://github.com/iamayushsharmaa/Habit-Tracker",
        imageRes = Res.Images.BLOG
    ),
    Teamix(
        workName = "Newz",
        description = "Android & Backend & Design",
        link = "https://github.com/iamayushsharmaa/newsapp",
        imageRes = Res.Images.TEAMIX
    ),
    SkyCast(
        workName = "Weather App",
        description = "Android & Api & Design",
        link = "https://github.com/iamayushsharmaa/weatherapp",
        imageRes = Res.Images.SKY_CAST
    ),
    Movie(
        workName = "Movies App",
        description = "Android & Design",
        link = "https://github.com/iamayushsharmaa/MovieApp",
        imageRes = Res.Images.MOVIE
    ),
}