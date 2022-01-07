package com.example.movies_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies_app.R
import com.example.movies_app.frontpage.ItemClickListner
import com.example.movies_app.model.NowShowing
import kotlinx.android.synthetic.main.item_layout.view.*

class MoviesAdapter(private val list: List<NowShowing>,private val itemClickListner: ItemClickListner):RecyclerView.Adapter<MoviesAdapter.MovieVewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieVewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return MovieVewHolder(view,itemClickListner)
    }

    override fun onBindViewHolder(holder: MovieVewHolder, position: Int) {
        val movie=list[position]
        holder.setData(movie)
    }

    override fun getItemCount(): Int {
       return list.size
    }
    class MovieVewHolder(itemView:View,private val itemClickListner: ItemClickListner):RecyclerView.ViewHolder(itemView){

        fun setData(nowShowing: NowShowing){
            itemView.apply {
                if (nowShowing.posterurl!=null){
                    Glide.with(movieImage)
                        .load(nowShowing.posterurl)
                        .placeholder(R.drawable.avenger)
                        .into(movieImage)
                }
               movieImage.setOnClickListener{
                   itemClickListner.ItemClick(nowShowing,adapterPosition)
               }

            }
        }

    }
}