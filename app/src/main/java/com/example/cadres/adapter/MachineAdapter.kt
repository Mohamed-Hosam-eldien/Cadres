package com.example.cadres.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cadres.model.Machine
import com.example.cadres.databinding.MachineItemBinding
import com.example.cadres.interfaces.OnClickListener

class MachineAdapter(private var context: Context, var machineList: ArrayList<Machine>, var onClickListener: OnClickListener) :
    RecyclerView.Adapter<MachineAdapter.MachineViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MachineViewHolder {
        val view = MachineItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MachineViewHolder(view)
    }

    override fun onBindViewHolder(holder: MachineViewHolder, position: Int) {

        val machineItem = machineList[position]

        holder.view.machineItemName.text = machineItem.machineName

        Glide.with(context)
            .load(machineItem.machineImage)
            .into(holder.view.machineImage)

        holder.view.cardView.setOnClickListener {
            onClickListener.onClick(machineItem)
        }

    }

    override fun getItemCount(): Int {
        return machineList.size
    }


    class MachineViewHolder(var view: MachineItemBinding) : RecyclerView.ViewHolder(view.root)

}