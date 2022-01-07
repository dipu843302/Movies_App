package com.example.movies_app

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_movie_details.*
import com.bumptech.glide.Glide
import com.example.movies_app.frontpage.MainActivity


class MovieDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        back.setOnClickListener {
            val intent:Intent=Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val  intent:Intent = getIntent()


        story.setText(intent.getStringExtra("story"))
        tvDuration.setText(intent.getStringExtra("duration"))
        tvDate.setText( intent.getStringExtra("date"))
        tvRating.setText(intent.getStringExtra("rating"))
        tvTittle.setText(intent.getStringExtra("tittle"))

       // tvposter.setImageResource( intent.getIntExtra("poster",0))



        if (getIntent().hasExtra("poster")) {
            val imageUrl = getIntent().getStringExtra("poster")
            Glide.with(this).asBitmap().load(imageUrl).into(tvposter)
        }
    }


}