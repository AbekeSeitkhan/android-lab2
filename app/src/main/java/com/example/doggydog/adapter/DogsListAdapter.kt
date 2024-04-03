package com.example.doggydog.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.doggydog.R
import com.example.doggydog.databinding.ItemDogBinding
import com.example.doggydog.model.entity.DogItem
import com.example.doggydog.util.DogsListDiffUtil

class DogsListAdapter:ListAdapter<DogItem, DogsListAdapter.ViewHolder>(DogsListDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemDogBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemDogBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val context = binding.root.context

        fun bind(dogItem: DogItem) {
            with(binding){
                dogName.text = dogItem.name
                dogPlayfulness.text = dogItem.playfulness.toString()
                dogProtectiveness.text = dogItem.protectiveness.toString()
                dogTrainability.text = dogItem.trainability.toString()

                Glide.with(itemView.context)
                    .load(dogItem.imageLink)
                    .into(dogImage)

            }

        }
    }
}