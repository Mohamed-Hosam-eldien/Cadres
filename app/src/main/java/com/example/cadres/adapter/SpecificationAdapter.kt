package com.example.cadres.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cadres.databinding.SpecificationItemBinding


class SpecificationAdapter(var headres: List<String>, var valueList: List<String>) :
    RecyclerView.Adapter<SpecificationAdapter.SpecificationViewHolder>() {

    class SpecificationViewHolder(var view: SpecificationItemBinding) :
        RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecificationViewHolder {
        val view =
            SpecificationItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SpecificationViewHolder(view)
    }

    override fun onBindViewHolder(holder: SpecificationViewHolder, position: Int) {
        val key = headres[position]
        val value = valueList[position]

        holder.view.key.text = key
        holder.view.value.text = value
    }

    override fun getItemCount(): Int {
        return headres.size
    }
}