package com.example.efinal.ui.viewmodels.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.efinal.R
import com.example.efinal.model.Digimon

class DigimonAdapter (
    val context: Context,
    var listaDigimons: List<Digimon>
    ):RecyclerView.Adapter<DigimonAdapter.ViewHolder>() {
    class ViewHolder(item: View):RecyclerView.ViewHolder(item) {
        val cvDigimon = item.findViewById(R.id.cv_item_digimon) as CardView
        val ivDigimon = item.findViewById(R.id.ivDigimon) as ImageView
        val tvNomDigimon= item.findViewById(R.id.txtDigimonname) as TextView
        val tvNivDigimon= item.findViewById(R.id.txtDigimonlevel) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DigimonAdapter.ViewHolder {
        val vista= LayoutInflater.from(parent.context).inflate(R.layout.item_rv_digimon,parent,false)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val digimon = listaDigimons[position]

        Glide
            .with(context)
            .load(digimon.img)
            .centerInside()
            .into(holder.ivDigimon)
        holder.tvNomDigimon.text=digimon.name
        holder.tvNivDigimon.text=digimon.level
    }

    override fun getItemCount(): Int {
        return listaDigimons.size
    }


}