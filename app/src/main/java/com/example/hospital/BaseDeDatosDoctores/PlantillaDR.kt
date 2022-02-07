package com.example.hospital.BaseDeDatosDoctores


import java.util.ArrayList

class PlantillaDR {
    abstract class Doctores{
        companion object{
            val ID = "id"
            val TABLE_NAME="doctores"
            val NOMBRE = "nombre"
            val PATERNO = "paterno"
            val MATERNO = "materno"
            val ESPECIALIDAD = "especialidad"
            val COSTO = "costo"
            val FECHA = "fecha"
            val HORARIOS = "horarios"
            val ESTADO = "estado"
            val FOTO = "foto"
            var doctores: MutableList<Doctor> = ArrayList()
        }
    }
}