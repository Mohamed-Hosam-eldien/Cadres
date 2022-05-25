package com.example.cadres.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.cadres.interfaces.PdfInterface
import com.example.cadres.R

class TubularsAdapter(private val pdfI: PdfInterface,
                      private val list: List<String>)
    : RecyclerView.Adapter<TubularsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.pdfName)
        val card: CardView = itemView.findViewById(R.id.cardPdf)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pdf_list_item,null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list[position]

        holder.card.setOnClickListener{
            pdfI.gotoPdfViewer(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}