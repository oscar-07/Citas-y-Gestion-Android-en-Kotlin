package com.example.hospital.BaseDeDatos

import java.util.*

class Plantilla {
    abstract class Usuarios{
        companion object{
            val ID = "id"
            val TABLE_NAME="usuarios"
            val NOMBRE = "nombre"
            val PATERNO = "paterno"
            val MATERNO = "materno"
            val NACIMIENTO = "nacimiento"
            val CITA = "cita"
            val HISTORIAL = "historial"
            val SALDO = "saldo"
            val ESTADO = "estado"
            val FOTO = "foto"
            var usuarios: MutableList<Usuario> = ArrayList()
        }
    }

}