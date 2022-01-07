package com.example.movies_app.frontpage

import com.example.movies_app.model.NowShowing

interface ItemClickListner {

    fun ItemClick(nowShowing: NowShowing,position:Int)
}