package com.example.hospital.BaseDeDatos

class Usuario {
    private var id: Int = 0
    private var nombre: String = ""
    private var paterno: String = ""
    private var materno: String = ""
    private var nacimiento: String = ""
    private var cita: String = ""
    private var historial: String = ""
    private var saldo: String = ""
    private var estado: String = ""
    private var foto: ByteArray //aqui cambio
                                //en el constructor igual

    constructor(id: Int,nombre:String, paterno: String, materno: String, nacimiento: String, cita: String, historial: String, saldo: String, estado: String, foto: ByteArray){

        this.id = id
        this.nombre = nombre
        this.paterno = paterno
        this.materno = materno
        this.nacimiento = nacimiento
        this.cita = cita
        this.historial = historial
        this.saldo = saldo
        this.estado = estado
        this.foto = foto
    }


    fun getId(): Int{
        return id;
    }
    fun getNombre():String{
        return nombre
    }
    fun getPaterno():String{
        return paterno
    }
    fun getMaterno():String{
        return nombre
    }
    fun getNacimiento():String{
        return nacimiento
    }
    fun getCita():String{
        return cita
    }
    fun getHistorial():String{
        return historial
    }
    fun getSaldo():String{
        return saldo
    }
    fun getEstado():String{
        return estado
    }
    fun getFoto():ByteArray{  //aqui cambio
        return foto
    }

}