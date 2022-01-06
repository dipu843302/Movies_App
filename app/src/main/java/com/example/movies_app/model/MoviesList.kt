package com.example.movies_app.model

data class MoviesList(
    val coming_soon: List<ComingSoon>,
    val now_showing: List<NowShowing>
)