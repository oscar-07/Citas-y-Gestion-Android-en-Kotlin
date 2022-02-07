package com.example.hospital.BaseDeDatosDoctores

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.hospital.BaseDeDatos.Plantilla

class CajaDoctor(context: Context): SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION) {
    private val db: SQLiteDatabase
    private val values: ContentValues
    companion object{
        private val DATABASE_VERSION=2
        private val DATABASE_NAME="doctores"
    }
    init {
        db = this.writableDatabase
        values = ContentValues()
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE "+
                PlantillaDR.Doctores.TABLE_NAME+" ("+
                PlantillaDR.Doctores.ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                PlantillaDR.Doctores.NOMBRE+" TEXT NOT NULL,"+
                PlantillaDR.Doctores.PATERNO+" TEXT NOT NULL,"+
                PlantillaDR.Doctores.MATERNO+" TEXT NOT NULL,"+
                PlantillaDR.Doctores.ESPECIALIDAD+" TEXT NOT NULL,"+
                PlantillaDR.Doctores.COSTO+" TEXT NOT NULL,"+
                PlantillaDR.Doctores.FECHA+" TEXT NOT NULL,"+
                PlantillaDR.Doctores.HORARIOS+" TEXT NOT NULL,"+
                PlantillaDR.Doctores.ESTADO+" TEXT NOT NULL,"+
                PlantillaDR.Doctores.FOTO+" TEXT NOT NULL)");
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insert(nombre: String, paterno: String, materno: String,especialidad: String,costo: Int,fecha: String,horarios: String, estado: String, foto: ByteArray){
        values.put(PlantillaDR.Doctores.NOMBRE,nombre)
        values.put(PlantillaDR.Doctores.PATERNO,paterno)
        values.put(PlantillaDR.Doctores.MATERNO,materno)
        values.put(PlantillaDR.Doctores.ESPECIALIDAD,especialidad)
        values.put(PlantillaDR.Doctores.COSTO,costo)
        values.put(PlantillaDR.Doctores.FECHA,fecha)
        values.put(PlantillaDR.Doctores.HORARIOS,horarios)
        values.put(PlantillaDR.Doctores.ESTADO,estado)
        values.put(PlantillaDR.Doctores.FOTO,foto)
        db.insert(PlantillaDR.Doctores.TABLE_NAME,null , values)
    }


    fun MuestraDatos(): MutableList<Doctor> {
        PlantillaDR.Doctores.doctores.clear()
        val columnas = arrayOf(
                PlantillaDR.Doctores.ID,
                PlantillaDR.Doctores.NOMBRE,
                PlantillaDR.Doctores.PATERNO,
                PlantillaDR.Doctores.MATERNO,
                PlantillaDR.Doctores.ESPECIALIDAD,
                PlantillaDR.Doctores.COSTO,
                PlantillaDR.Doctores.FECHA,
                PlantillaDR.Doctores.HORARIOS,
                PlantillaDR.Doctores.ESTADO,
                Plantilla.Usuarios.FOTO)
        val c = db.query(PlantillaDR.Doctores.TABLE_NAME, columnas, null, null, null, null, null)
        if (c.moveToFirst()) {
            do {
                PlantillaDR.Doctores.doctores.add(Doctor(
                        c.getInt(0),
                        c.getString(1),
                        c.getString(2),
                        c.getString(3),
                        c.getString(4),
                        c.getInt(5),
                        c.getString(6),
                        c.getString(7),
                        c.getString(8),
                        c.getBlob(9)))
            } while (c.moveToNext())
        }
        return PlantillaDR.Doctores.doctores

    }

    fun Editar(id: Int,nombre: String, paterno: String, materno: String,especialidad: String,costo: Int,fecha: String,horarios: String, estado: String, foto: ByteArray){
        val args = arrayOf(id.toString())
        values.put(PlantillaDR.Doctores.NOMBRE,nombre)
        values.put(PlantillaDR.Doctores.PATERNO,paterno)
        values.put(PlantillaDR.Doctores.MATERNO,materno)
        values.put(PlantillaDR.Doctores.ESPECIALIDAD,especialidad)
        values.put(PlantillaDR.Doctores.COSTO,costo)
        values.put(PlantillaDR.Doctores.FECHA,fecha)
        values.put(PlantillaDR.Doctores.HORARIOS,horarios)
        values.put(PlantillaDR.Doctores.ESTADO,estado)
        values.put(PlantillaDR.Doctores.FOTO,foto)
        db.update(PlantillaDR.Doctores.TABLE_NAME,values,PlantillaDR.Doctores.ID+"=?",args)
    }

    fun borrar(condicion: String){
        val args = arrayOf(condicion)
        db.delete(PlantillaDR.Doctores.TABLE_NAME,PlantillaDR.Doctores.ID+"=?",args)
    }


}



