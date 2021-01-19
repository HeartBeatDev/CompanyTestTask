package com.heartbeat.develop.urancompanytesttask.ui.widget

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.heartbeat.develop.model.Exhibit
import com.heartbeat.develop.urancompanytesttask.R

class ExhibitWidget(private val view: View) : RecyclerView.ViewHolder(view) {

    private val exhibitTitle: TextView by lazy { view.findViewById(R.id.exhibitTitle) }
    private val exhibitImages: ViewPager2 by lazy { view.findViewById(R.id.exhibitImages) }
    private val exhibitsImagesAdapter: ExhibitsImagesAdapter by lazy { ExhibitsImagesAdapter() }

    fun onBindView(exhibit: Exhibit) {
        exhibitTitle.text = exhibit.title
        exhibitImages.apply {
            offscreenPageLimit = 3
            exhibitsImagesAdapter.setList(exhibit.images)
            adapter = exhibitsImagesAdapter
        }
    }

    private inner class ExhibitsImagesAdapter(
        private var images: List<String> = listOf()
    ) : RecyclerView.Adapter<ExhibitsImagesViewHolder>() {

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): ExhibitsImagesViewHolder {
            return ExhibitsImagesViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.widget_exhibit_image_item, parent, false)
            )
        }

        override fun getItemCount(): Int = images.size

        override fun onBindViewHolder(holder: ExhibitsImagesViewHolder, position: Int) {
            holder.onBindView(images[position])
        }

        fun setList(images: List<String>) {
            this.images = images
            notifyDataSetChanged()
        }
    }

    private inner class ExhibitsImagesViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private val exhibitImage: ImageView by lazy { itemView.findViewById(R.id.exhibitImage) }

        fun onBindView(imageUrl: String) {
            Glide
                .with(itemView.context)
                .load(imageUrl)
                .centerCrop()
                .into(exhibitImage)
        }
    }
}