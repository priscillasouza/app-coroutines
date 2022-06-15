package com.example.coroutinesapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutinesapp.databinding.LayoutItemRecyclerViewBinding

class ListAdapter: RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    private var listOfStrings = ArrayList<String>()

    class ViewHolder(val binding: LayoutItemRecyclerViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: String) {
            binding.textViewItemRecycler.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutItemRecyclerViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(listOfStrings[position])
    }

    override fun getItemCount(): Int {
        return listOfStrings.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addNewString(string: String) {
        listOfStrings.add(listOfStrings.size, string)
        notifyDataSetChanged()
    }
}