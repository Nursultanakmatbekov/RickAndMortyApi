package com.example.rickandmortyapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.rickandmortyapi.data.models.ChereptersItem
import com.example.rickandmortyapi.databinding.ItemCherepterBinding

class CheracterAdapter :
    ListAdapter<ChereptersItem, CheracterAdapter.CheractersViewHolder>(diffUtil) {

    inner class CheractersViewHolder(private val binding: ItemCherepterBinding) :

        ViewHolder(binding.root) {
        fun onBind(item: ChereptersItem) {
            Glide.with(binding.imCherepters.context)
                .load(item.image)
                .into(binding.imCherepters)
            binding.tvName.text = item.name.replaceFirstChar {
                it.uppercase()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheractersViewHolder {
        return CheractersViewHolder(
            ItemCherepterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CheractersViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ChereptersItem>() {
            override fun areItemsTheSame(
                oldItem: ChereptersItem,
                newItem: ChereptersItem
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: ChereptersItem,
                newItem: ChereptersItem
            ): Boolean {
                return oldItem.name == newItem.name
            }
        }
    }
}