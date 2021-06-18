package com.example.kotlinapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.video_row.view.*

class MainAdapter(private val response: CallResponse): RecyclerView.Adapter<CustomViewHolder>() {

    override fun getItemCount(): Int {
        return response.videos?.count() ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.video_row, parent, false)
        return CustomViewHolder(cellForRow)
    }


    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val video = response.videos?.get(position)
        holder.itemView.textView_video_title.text = video?.name ?: ""
        Picasso.get().load(video?.imageUrl).into(holder.itemView.imageView)
    }
}

class CustomViewHolder(v: View): RecyclerView.ViewHolder(v) {

}