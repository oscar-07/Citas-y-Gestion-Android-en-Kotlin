package com.example.hospital.BaseDeDatos

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class CajaUsuario(context: Context): SQLiteOpenHelper(context, DATABASE_NAME,null,DATABASE_VERSION) {
    private val db: SQLiteDatabase
    private val values: ContentValues
    companion object{
        private val DATABASE_VERSION=1
        private val DATABASE_NAME="usuarios"
    }
    init {
        db = this.writableDatabase
        values = ContentValues()
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE "+
                Plantilla.Usuarios.TABLE_NAME+" ("+
                Plantilla.Usuarios.ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                Plantilla.Usuarios.NOMBRE+" TEXT NOT NULL,"+
                Plantilla.Usuarios.PATERNO+" TEXT NOT NULL,"+
                Plantilla.Usuarios.MATERNO+" TEXT NOT NULL,"+
                Plantilla.Usuarios.NACIMIENTO+" TEXT NOT NULL,"+
                Plantilla.Usuarios.CITA+" TEXT NOT NULL,"+
                Plantilla.Usuarios.HISTORIAL+" TEXT NOT NULL,"+
                Plantilla.Usuarios.SALDO+" TEXT NOT NULL,"+
                Plantilla.Usuarios.ESTADO+" TEXT NOT NULL,"+
                Plantilla.Usuarios.FOTO+" TEXT NOT NULL)");
    }

    fun insert(nombre:String, paterno: String, materno: String, nacimiento: String, cita: String, historial: String, saldo: String, estado: String, foto: ByteArray){
        values.put(Plantilla.Usuarios.NOMBRE,nombre)
        values.put(Plantilla.Usuarios.PATERNO,paterno)
        values.put(Plantilla.Usuarios.MATERNO,materno)
        values.put(Plantilla.Usuarios.NACIMIENTO,nacimiento)
        values.put(Plantilla.Usuarios.CITA,cita)
        values.put(Plantilla.Usuarios.HISTORIAL,historial)
        values.put(Plantilla.Usuarios.SALDO,saldo)
        values.put(Plantilla.Usuarios.ESTADO,estado)
        values.put(Plantilla.Usuarios.FOTO,foto)
        db.insert(Plantilla.Usuarios.TABLE_NAME,null , values)
    }

    fun MuestraDatos(): MutableList<Usuario>{
        Plantilla.Usuarios.usuarios.clear()
        val columnas = arrayOf(
            Plantilla.Usuarios.ID,
            Plantilla.Usuarios.NOMBRE,
            Plantilla.Usuarios.PATERNO,
            Plantilla.Usuarios.MATERNO,
            Plantilla.Usuarios.NACIMIENTO,
            Plantilla.Usuarios.CITA,
            Plantilla.Usuarios.HISTORIAL,
            Plantilla.Usuarios.SALDO,
            Plantilla.Usuarios.ESTADO,
            Plantilla.Usuarios.FOTO)
        val c = db.query(Plantilla.Usuarios.TABLE_NAME,columnas,null,null,null,null,null)
        if(c.moveToFirst()){
            do{
                Plantilla.Usuarios.usuarios.add(Usuario(
                    c.getInt(0),
                    c.getString(1),
                    c.getString(2),
                    c.getString(3),
                    c.getString(4),
                    c.getString(5),
                    c.getString(6),
                    c.getString(7),
                    c.getString(8),
                    c.getBlob(9)))// aqui cambio
            }while (c.moveToNext())
        }
        return Plantilla.Usuarios.usuarios

    }



    fun Editar(id: Int,nombre:String, paterno: String, materno: String, nacimiento: String, cita: String, historial: String, saldo: String, estado: String, foto: ByteArray){
        val args = arrayOf(id.toString())
        values.put(Plantilla.Usuarios.NOMBRE,nombre)
        values.put(Plantilla.Usuarios.PATERNO,paterno)
        values.put(Plantilla.Usuarios.MATERNO,materno)
        values.put(Plantilla.Usuarios.NACIMIENTO,nacimiento)
        values.put(Plantilla.Usuarios.CITA,cita)
        values.put(Plantilla.Usuarios.HISTORIAL,historial)
        values.put(Plantilla.Usuarios.SALDO,saldo)
        values.put(Plantilla.Usuarios.ESTADO,estado)
        values.put(Plantilla.Usuarios.FOTO,foto)
        db.update(Plantilla.Usuarios.TABLE_NAME,values,Plantilla.Usuarios.ID+"=?",args)
    }



    fun borrar(condicion: String){
        val args = arrayOf(condicion)
        db.delete(Plantilla.Usuarios.TABLE_NAME,Plantilla.Usuarios.ID+"=?",args)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }




}




