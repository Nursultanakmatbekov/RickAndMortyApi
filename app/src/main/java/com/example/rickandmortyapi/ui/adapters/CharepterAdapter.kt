package com.example.rickandmortyapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.rickandmortyapi.data.models.ChareptersItem
import com.example.rickandmortyapi.databinding.ItemCherepterBinding

class CharacterAdapter:
    ListAdapter<ChareptersItem, CharacterAdapter.CharactersViewHolder>(diffUtil) {

    inner class CharactersViewHolder(private val binding: ItemCherepterBinding) :

        ViewHolder(binding.root) {
        fun onBind(item: ChareptersItem) {
            Glide.with(binding.imCherepters.context)
                .load(item.image)
                .into(binding.imCherepters)
            binding.tvName.text = item.name.replaceFirstChar {
                it.uppercase()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        return CharactersViewHolder(
            ItemCherepterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ChareptersItem>() {
            override fun areItemsTheSame(
                oldItem: ChareptersItem,
                newItem: ChareptersItem
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: ChareptersItem,
                newItem: ChareptersItem
            ): Boolean {
                return oldItem.name == newItem.name
            }
        }
    }
}