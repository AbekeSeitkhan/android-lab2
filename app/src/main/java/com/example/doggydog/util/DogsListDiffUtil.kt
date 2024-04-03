package com.example.doggydog.util

import androidx.recyclerview.widget.DiffUtil
import com.example.doggydog.model.entity.DogItem

class DogsListDiffUtil: DiffUtil.ItemCallback<DogItem>(){
    override fun areItemsTheSame(oldItem: DogItem, newItem: DogItem): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: DogItem, newItem: DogItem): Boolean {
        return oldItem == newItem
    }

}