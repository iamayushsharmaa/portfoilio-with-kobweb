package com.example.portfoliowebsite.model

import com.example.portfoliowebsite.utils.Res


enum class Work(
    val workName: String,
    val description: String,
    val link: String,
    val imageRes: String,
) {
    Cartify(
        workName = "Cartify",
        description = "Tablet & Android & Backend & Design",
        link = "https://github.com/iamayushsharmaa/Cartify",
        imageRes = Res.Images.CARTIFY
    ),
    Spritual(
        workName = "Spritual App",
        description = "Android & Design",
        link = "https://github.com/iamayushsharmaa/Spritual-App",
        imageRes = Res.Images.SPRITUAL
    ),
    HabitSpark(
        workName = "HabitSpark",
        description = "Android & Backend & Design",
        link = "https://github.com/iamayushsharmaa/Habit-Spark",
        imageRes = Res.Images.HABITSPARK
    ),
    GlobeWise(
        workName = "GlobeWise",
        description = "Android & Backend & Design",
        link = "https://github.com/iamayushsharmaa/GlobeWise",
        imageRes = Res.Images.GLOBEWISE
    ),
    Cloudify(
        workName = "Cloudify",
        description = "Android & Api & Design",
        link = "https://github.com/iamayushsharmaa/Cloudify",
        imageRes = Res.Images.CLOUDIFY
    ),
    CinemaSync(
        workName = "CinemaSync",
        description = "Android & Design",
        link = "https://github.com/iamayushsharmaa/CinemaSync",
        imageRes = Res.Images.CINEMASYNC
    ),
}