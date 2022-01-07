package com.example.movies_app.frontpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movies_app.MovieDetailsActivity
import com.example.movies_app.R
import com.example.movies_app.adapter.MoviesAdapter
import com.example.movies_app.api.MovieApi
import com.example.movies_app.api.Network
import com.example.movies_app.model.ComingSoon
import com.example.movies_app.model.NowShowing
import com.example.movies_app.repository.MovieRepository
import com.example.movies_app.viewmodel.MoviesViewModel
import com.example.movies_app.viewmodel.MoviesViewModelFactory
import com.example.movies_app.viewpageradapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),ItemClickListner {

    val comingMovieList= mutableListOf<ComingSoon>()

    lateinit var moviesViewModel: MoviesViewModel
    var moivesList= mutableListOf<NowShowing>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api=Network.getInstance().create(MovieApi::class.java)
        val repository=MovieRepository(api)

        moviesViewModel =ViewModelProvider(this,MoviesViewModelFactory(repository)).get(MoviesViewModel::class.java)

         moviesViewModel.get().observe(this, Observer {
          it.let {
              moivesList.clear()
              moivesList.addAll(it.now_showing)
              setRecycle()
          }

         })
        moviesViewModel.get().observe(this, Observer {
            it.let {
                comingMovieList.clear()
                comingMovieList.addAll(it.coming_soon)
                setViewPager()
            }

        })
    }

    private fun setViewPager(){
        viewPager.adapter=ViewPagerAdapter(comingMovieList)

    }

    private fun setRecycle(){
        recycler2.adapter=MoviesAdapter(moivesList,this)
        recycler2.layoutManager=GridLayoutManager(this,3)
    }

    override fun ItemClick(nowShowing: NowShowing, position: Int) {
        val intent = Intent(this@MainActivity, MovieDetailsActivity::class.java)
        intent.putExtra("poster",nowShowing.posterurl)
        intent.putExtra("story",nowShowing.storyline)
        intent.putExtra("tittle",nowShowing.title)
        intent.putExtra("duration",nowShowing.duration)
        intent.putExtra("date",nowShowing.releaseDate)
        intent.putExtra("rating",nowShowing.contentRating)
        startActivity(intent)
    }

}