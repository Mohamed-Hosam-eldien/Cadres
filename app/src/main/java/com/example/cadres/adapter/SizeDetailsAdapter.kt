package com.example.cadres.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.cadres.interfaces.ISpecification
import com.example.cadres.R
import com.example.cadres.utils.Utils
import java.lang.StringBuilder

class SizeDetailsAdapter(
    private val specificationInterface: ISpecification,
    private val list: List<String>)

    : RecyclerView.Adapter<SizeDetailsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val size: TextView = itemView.findViewById(R.id.txtSize)
        val specification: CardView = itemView.findViewById(R.id.cardSpec)
        val operationManual: CardView = itemView.findViewById(R.id.cardOper)
        val calculation: CardView = itemView.findViewById(R.id.cardCalc)

        val txtOper: TextView = itemView.findViewById(R.id.txtOper)
        val txtSpec: TextView = itemView.findViewById(R.id.txtSpec)
        val txtCalc: TextView = itemView.findViewById(R.id.txtCalc)
        val unit: TextView = itemView.findViewById(R.id.txtUnit)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.size_details_layout,null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.size.text = list[position]
        holder.unit.text = StringBuilder(Utils.currentMachine.nickName).append(" Size")

        when (Utils.currentMachine.nickName) {
            "SHOOK TOOL" -> {
                holder.calculation.visibility = View.GONE
            }
            "TUBULARS" -> {
                holder.size.visibility = View.GONE
                holder.unit.visibility = View.GONE
                holder.calculation.visibility = View.GONE

                holder.txtSpec.text = "Drill Pipes"
                holder.txtOper.text = "Heavy Weight Drill Pipes"
            }
            "PBL" -> {
                holder.txtOper.text = "Operation Instruction"
                holder.txtCalc.text = "Troubleshooting"
            }
        }


        holder.specification.setOnClickListener{
            if(Utils.currentMachine.nickName == "TUBULARS") {
                specificationInterface.navToDrill("yes")
            } else {
                specificationInterface.navToSpecScreen(
                    Utils.currentMachine.nickName,
                    position,
                    list[position]
                )
            }
        }

        holder.operationManual.setOnClickListener{
            if(Utils.currentMachine.nickName == "TUBULARS") {
                specificationInterface.navToDrill("no")
            } else {
                specificationInterface.navToPdfScreen(Utils.currentMachine.nickName, position)
            }
        }

        holder.calculation.setOnClickListener{
            if(Utils.currentMachine.nickName == "PBL") {
                specificationInterface.navToPBLInstructionPdf(position)
            } else {
                specificationInterface.navToCalc(list[position], position)
            }
        }

    }

    override fun getItemCount(): Int {
        return if(Utils.currentMachine.nickName == "TUBULARS") {
            list.size-1
        } else {
            list.size
        }
    }
}