package com.land.software.irelandtourismguide

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nostra13.universalimageloader.core.DisplayImageOptions
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.assist.ImageScaleType
import kotlinx.android.synthetic.main.place_row.view.*

class PlaceAdapter(val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var items = mutableListOf<Place>()
    val imageLoader = ImageLoader.getInstance()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PlaceViewHolder(LayoutInflater.from(context).inflate(R.layout.place_row, null))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        (holder as PlaceAdapter.PlaceViewHolder).bind(item)
    }

    fun setList(list: List<Place>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    inner class PlaceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(place: Place) {
            itemView.apply {
                namePlace.text = place.name
                countyPlace.text = place.county

                val options = DisplayImageOptions.Builder().imageScaleType(ImageScaleType.EXACTLY_STRETCHED).build()
                imageLoader.displayImage(place.imageUrl, imagePlace, options)
            }
        }
    }
}
