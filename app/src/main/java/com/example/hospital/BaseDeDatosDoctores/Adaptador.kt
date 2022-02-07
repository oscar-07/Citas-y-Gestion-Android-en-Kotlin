package com.example.hospital.BaseDeDatosDoctores

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hospital.R


class Adaptador(val doctor:MutableList<Doctor>, var clickListner: Canalmedio):RecyclerView.Adapter<Adaptador.HeroHolder>() {
    override fun getItemCount(): Int = doctor.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder {
        lateinit var heroes: HeroHolder
        heroes = HeroHolder(LayoutInflater.from(parent.context).inflate(R.layout.contenedordedoctores, parent, false))
        return heroes
    }

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        holder.initialize(doctor.get(position),clickListner)
    }

    class HeroHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun initialize(item: Doctor,action: Canalmedio){
            itemView.findViewById<TextView>(R.id.IDDC).setText("ID : "+item.getId())
            itemView.findViewById<TextView>(R.id.nombreDC).setText("Nombre : "+item.getNombre())
            itemView.findViewById<TextView>(R.id.paternoDC).setText("Paterno : "+item.getPaterno())
            itemView.findViewById<TextView>(R.id.especialidadDC).setText("Especialidad : "+item.getEspecialidad())
            itemView.findViewById<TextView>(R.id.costoDC).setText("Costo : "+item.getCosto().toString())
            val fantasma = BitmapFactory.decodeByteArray(item.getFoto(),0,item.getFoto().size)
            itemView.findViewById<ImageView>(R.id.cara).setImageBitmap(fantasma)
            itemView.setOnClickListener{
                action.mandadoc(item,adapterPosition)
            }

        }
    }


    interface Canalmedio{
        fun mandadoc(cosa1: Doctor,position: Int)
    }



}
