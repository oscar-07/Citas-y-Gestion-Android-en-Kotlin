package com.example.hospital.BaseDeDatos

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hospital.R

class AdaptadorUsu (val usuario:MutableList<Usuario>,var clickListner: Canalmedio2):RecyclerView.Adapter<AdaptadorUsu.HeroUsuario>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroUsuario {
        lateinit var heroes: HeroUsuario
        heroes = HeroUsuario(LayoutInflater.from(parent.context).inflate(R.layout.contenedordeusuarios, parent, false))
        return heroes
    }

    override fun onBindViewHolder(holder: HeroUsuario, position: Int) {
        holder.initialize(usuario.get(position),clickListner)
    }

    override fun getItemCount(): Int = usuario.size

    class HeroUsuario(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun initialize(item: Usuario,action: Canalmedio2){
            itemView.findViewById<TextView>(R.id.IDES).setText("Id : "+item.getId())
            itemView.findViewById<TextView>(R.id.nombreusu).setText("Nombre : "+item.getNombre())
            itemView.findViewById<TextView>(R.id.paternousu).setText("Paterno : "+item.getPaterno())
            itemView.findViewById<TextView>(R.id.maternousu).setText("Materno : "+item.getMaterno())
            itemView.findViewById<TextView>(R.id.fechausu).setText("Fecha : "+item.getNacimiento())
            val fantasma = BitmapFactory.decodeByteArray(item.getFoto(),0,item.getFoto().size)
            itemView.findViewById<ImageView>(R.id.carausu).setImageBitmap(fantasma)
            itemView.setOnClickListener{
                action.mandausu(item,adapterPosition)
            }

        }
    }

    interface Canalmedio2 {
        fun mandausu(cosa1: Usuario, position: Int)
    }
}
