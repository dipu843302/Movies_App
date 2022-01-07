package com.example.movies_app.viewpageradapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies_app.R
import com.example.movies_app.model.ComingSoon
import kotlinx.android.synthetic.main.item_lalyout_viewpager.view.*


class ViewPagerAdapter(private val list2:List<ComingSoon>):
    RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_lalyout_viewpager,parent,false)
        return PagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
      val movies=list2[position]
        holder.setData(movies)
    }

    override fun getItemCount(): Int {
       return list2.size
    }
    class PagerViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        fun setData(comingSoon: ComingSoon){
            itemView.apply {
                if (comingSoon.posterurl!=null){
                    Glide.with(ivViewPager)
                        .load(comingSoon.posterurl)
                        .placeholder(R.drawable.avenger)
                        .into(ivViewPager);
                }

            }
        }
    }
}