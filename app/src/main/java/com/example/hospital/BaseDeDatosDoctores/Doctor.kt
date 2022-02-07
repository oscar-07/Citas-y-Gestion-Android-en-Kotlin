package com.example.hospital.BaseDeDatosDoctores

class Doctor{
    private var id: Int = 0
    private var nombre: String = ""
    private var paterno: String = ""
    private var materno: String = ""
    private var especialidad: String = ""
    private var costo: Int = 0
    private var fecha: String = ""
    private var horarios: String = ""
    private var estado: String = ""
    private var foto: ByteArray //aqui cambio
                    //en el constructor igual
    constructor(id:Int,nombre: String, paterno: String, materno: String,especialidad: String,costo: Int,fecha: String,horarios: String, estado: String, foto: ByteArray) {
        this.id =id
        this.nombre = nombre
        this.paterno = paterno
        this.materno = materno
        this.especialidad = especialidad
        this.costo = costo
        this.fecha = fecha
        this.horarios = horarios
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
        return materno
    }
    fun getEspecialidad():String{
        return especialidad
    }
    fun getCosto(): Int{
        return costo;
    }
    fun getFecha():String{
        return fecha
    }
    fun getHorarios():String{
        return horarios
    }
    fun getEstado():String{
        return estado
    }

    fun getFoto():ByteArray{
        return foto
    }


}