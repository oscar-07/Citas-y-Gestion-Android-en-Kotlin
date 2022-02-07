package com.example.hospital

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hospital.Administrador.AccesoAdmin
import com.example.hospital.Administrador.EditorDoc
import com.example.hospital.Administrador.EditorUsu
import com.example.hospital.BaseDeDatos.AdaptadorUsu
import com.example.hospital.BaseDeDatos.CajaUsuario
import com.example.hospital.BaseDeDatos.Usuario
import com.example.hospital.BaseDeDatosDoctores.Adaptador
import com.example.hospital.BaseDeDatosDoctores.CajaDoctor
import com.example.hospital.BaseDeDatosDoctores.Doctor
import com.example.hospital.FechasyCitas.FechaCita
import com.example.hospital.FechasyCitas.FechaFragment
import com.example.hospital.Registros.RegistroDoctor
import java.io.ByteArrayOutputStream
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity(),Canal, Adaptador.Canalmedio, AdaptadorUsu.Canalmedio2 {
    val REQUEST_IMAGE_CAPTURE = 1
    var foto: Uri? =null

    private var dbusuario: CajaUsuario? = null
    private var dbdoctor: CajaDoctor? = null

    var contador=0
    var RegistroUsu: MutableList<Usuario> = ArrayList()
    var RegistroDocto: MutableList<Doctor> = ArrayList()
    var Temporal: MutableList<Usuario> = ArrayList()

    var Casita:Int =0
    var imagenrara: ByteArray= ByteArray(Casita)

    var PunteroEditor: String = ""
    var PunteroEditorDoctor: String = ""



    private var Llaveusuario=0
    private var Punterouser1 = ""
    private var Punterouser2 = ""

    private var Llavedoctor=0
    private val Punterodoctor1=""
    private var Punterodoctor2 = ""
    var spinner: Spinner? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val transaction = this.supportFragmentManager.beginTransaction()
        val login = Login()
        transaction.replace(R.id.Mesa, login).commit()
        dbdoctor= CajaDoctor(this)
        dbusuario= CajaUsuario(this)

        RegistroUsu = dbusuario!!.MuestraDatos()
        RegistroDocto = dbdoctor!!.MuestraDatos()
    }

    override fun Listadoctores() {
        val cajita:MutableList<Doctor> = dbdoctor!!.MuestraDatos()
        findViewById<RecyclerView>(R.id.Useruser).layoutManager=LinearLayoutManager(this)
        val adapter = Adaptador(cajita,this)
        findViewById<RecyclerView>(R.id.Useruser).adapter=adapter
    }
    override fun Listausuarios() {
        val cajita:MutableList<Usuario> = dbusuario!!.MuestraDatos()
        findViewById<RecyclerView>(R.id.Useruser).layoutManager=LinearLayoutManager(this)
        val adapter = AdaptadorUsu(cajita,this)
        findViewById<RecyclerView>(R.id.Useruser).adapter=adapter
    }
    override fun EntraUser() {
        val menu = Menu()
        supportFragmentManager.beginTransaction().replace(R.id.Mesa, menu).commit()
        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.Mesa, menu).commit()
    }
    override fun EntraEnfermedades() {
        val enfermedades = Enfermedades()
        supportFragmentManager.beginTransaction().replace(R.id.Mesa, enfermedades).commit()
        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.Mesa, enfermedades).commit()
    }
    override fun RegistroUser() {
        val registro = Registro()
        supportFragmentManager.beginTransaction().replace(R.id.Mesa, registro).commit()
        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.Mesa, registro).commit()
    }
    override fun RegistrarDoctor() {
        val registrodoctor = RegistroDoctor()
        supportFragmentManager.beginTransaction().replace(R.id.Mesa, registrodoctor).commit()
        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.Mesa, registrodoctor).commit()
    }
    override fun Limpiaadmin(){
        val acceso = AccesoAdmin()
        supportFragmentManager.beginTransaction().replace(R.id.Mesa, acceso).commit()
        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.Mesa, acceso).commit()
    }
    override fun EntraCitas() {
        val agendacita = AgendaCita()
        supportFragmentManager.beginTransaction().replace(R.id.Mesa, agendacita).commit()
        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.Mesa, agendacita).commit()
    }
    override fun EntraFecha() {
        val fechacita = FechaCita()
        supportFragmentManager.beginTransaction().replace(R.id.Mesa, fechacita).commit()
        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.Mesa, fechacita).commit()
    }
    override fun EntraDatos() {
        val entradatos = Datos()
        supportFragmentManager.beginTransaction().replace(R.id.Mesa, entradatos).commit()
        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.Mesa, entradatos).commit()

    }
    override fun EntraCosto() {
        val costo = Costo()
        supportFragmentManager.beginTransaction().replace(R.id.Mesa, costo).commit()
        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.Mesa, costo).commit()
    }
    override fun Salida() {
        val transaction = this.supportFragmentManager.beginTransaction()
        val login = Login()
        transaction.replace(R.id.Mesa, login).commit()
    }
    override fun Muestra() {
        var temporal: MutableList<Usuario> =dbusuario!!.MuestraDatos()
        findViewById<TextView>(R.id.citasT).visibility = View.VISIBLE
        findViewById<TextView>(R.id.citasT)!!.setText(temporal[Llaveusuario].getCita())
        findViewById<TextView>(R.id.nombreT).visibility = View.VISIBLE
        findViewById<TextView>(R.id.nombreT)!!.setText("Nombre: "+temporal[Llaveusuario].getNombre())
        findViewById<TextView>(R.id.paternoT).visibility = View.VISIBLE
        findViewById<TextView>(R.id.paternoT)!!.setText("Apellido paterno: "+temporal[Llaveusuario].getPaterno())
        findViewById<TextView>(R.id.maternoT).visibility = View.VISIBLE
        findViewById<TextView>(R.id.maternoT)!!.setText("Apellido materno: "+temporal[Llaveusuario].getMaterno())
        findViewById<TextView>(R.id.nacimientoT).visibility = View.VISIBLE
        findViewById<TextView>(R.id.nacimientoT)!!.setText("Fecha de nacimiento: "+temporal[Llaveusuario].getNacimiento())

        val fantasma =BitmapFactory.decodeByteArray(temporal[Llaveusuario].getFoto(),0,temporal[Llaveusuario].getFoto().size)
        findViewById<ImageView>(R.id.CajaDatos).setImageBitmap(fantasma)

        findViewById<Button>(R.id.cargarInfo).visibility = View.INVISIBLE
    }
    override fun Guardar(){
        if(findViewById<EditText>(R.id.Cnombre).text.toString().isEmpty() || findViewById<EditText>(R.id.Cpaterno).text.toString().isEmpty() || findViewById<EditText>(R.id.Cmaterno).text.toString().isEmpty() || findViewById<EditText>(R.id.Cfecha).text.toString().isEmpty()){
            Toast.makeText(this, " Completa todos los campos", Toast.LENGTH_LONG).show()
        }else{
            //Toast.makeText(this, " Paso la prueba ", Toast.LENGTH_LONG).show()
            RegistroUsu.add(Usuario(0,
                findViewById<EditText>(R.id.Cnombre).text.toString(),
                findViewById<EditText>(R.id.Cpaterno).text.toString(),
                findViewById<EditText>(R.id.Cmaterno).text.toString(),
                findViewById<EditText>(R.id.Cfecha).text.toString(),
                "No tienes citas",
                "",
                "",
                "si",
                imagenrara))
            dbusuario!!.insert(
                findViewById<EditText>(R.id.Cnombre).text.toString(),
                findViewById<EditText>(R.id.Cpaterno).text.toString(),
                findViewById<EditText>(R.id.Cmaterno).text.toString(),
                findViewById<EditText>(R.id.Cfecha).text.toString(),
                "No tienes citas",
                "",
                "",
                "si",
                imagenrara)
            Toast.makeText(this, " Registro listo", Toast.LENGTH_LONG).show()
            Salida()
        }
    }
    override fun GuardarDoctor() {
        if(findViewById<EditText>(R.id.DCnombre).text.toString().isEmpty() || findViewById<EditText>(R.id.DCpaterno).text.toString().isEmpty() || findViewById<EditText>(R.id.DCmaterno).text.toString().isEmpty() || findViewById<EditText>(R.id.DCespecialidad).text.toString().isEmpty() || findViewById<EditText>(R.id.DCcosto).text.toString().isEmpty() || findViewById<EditText>(R.id.DCfecha2).text.toString().isEmpty()){
            Toast.makeText(this, " Completa todos los campos", Toast.LENGTH_LONG).show()
        }else{
            RegistroDocto.add(Doctor(0,
                findViewById<EditText>(R.id.DCnombre).text.toString(),
                findViewById<EditText>(R.id.DCpaterno).text.toString(),
                findViewById<EditText>(R.id.DCmaterno).text.toString(),
                findViewById<EditText>(R.id.DCespecialidad).text.toString(),
                findViewById<EditText>(R.id.DCcosto).text.toString().toInt(),
                findViewById<EditText>(R.id.DCfecha2).text.toString(),
                "",
                "si" ,
                imagenrara))


            dbdoctor!!.insert(
                findViewById<EditText>(R.id.DCnombre).text.toString(),
                findViewById<EditText>(R.id.DCpaterno).text.toString(),
                findViewById<EditText>(R.id.DCmaterno).text.toString(),
                findViewById<EditText>(R.id.DCespecialidad).text.toString(),
                findViewById<EditText>(R.id.DCcosto).text.toString().toInt(),
                findViewById<EditText>(R.id.DCfecha2).text.toString(),
                "",
                "si" ,
                imagenrara)
            //Toast.makeText(this, " Registro listo", Toast.LENGTH_LONG).show()
            val acceso = AccesoAdmin()
            supportFragmentManager.beginTransaction().replace(R.id.Mesa, acceso).commit()
            val transaction = this.supportFragmentManager.beginTransaction()
            transaction.replace(R.id.Mesa, acceso).commit()
        }
    }
    override fun mandadoc(cosa1: Doctor, position: Int) {
        if(cosa1.getEstado()=="no"){
            val alerta = AlertDialog.Builder(this)
            alerta.setTitle("Atención")
            alerta.setMessage(" Lo sentimos.\n         El Doctor : ${cosa1.getPaterno()}.\n         No esta disponible selecione otro.")
            alerta.setNeutralButton("Enterado") { dialog, which ->
            }
            alerta.show()
            EntraUser()
        }else{
            findViewById<TextView>(R.id.Edocseleccionado)!!.setText(cosa1.getPaterno()+" "+cosa1.getNombre())
            Llavedoctor = position
            findViewById<Button>(R.id.Bbuscarfecha).visibility = View.VISIBLE
        }


    }
    override fun mandausu(cosa1: Usuario, position: Int) {
        findViewById<TextView>(R.id.Resultadousuario)!!.setText(cosa1.getId().toString())
        PunteroEditor=position.toString()
    }
    override fun ValidaUser(user: String, pass: String) {
        var salida=false
        RegistroUsu = dbusuario!!.MuestraDatos()
        if (RegistroUsu.isEmpty()) {
            Toast.makeText(this, "Datos erróneos.", Toast.LENGTH_LONG).show()
        }else{
            for(posicion in RegistroUsu.indices) {
                if (user == RegistroUsu[posicion].getNombre() && pass == RegistroUsu[posicion].getPaterno()) {
                    salida=true
                    EntraUser()
                    Llaveusuario=posicion
                    Punterouser1=user
                    Punterouser2=pass
                }
            }
        }
        if(!salida){
            Toast.makeText(this, "Error en credenciales", Toast.LENGTH_SHORT).show()
        }
        if(user=="¿'0" && pass=="¿'0"){
            val acceso = AccesoAdmin()
            supportFragmentManager.beginTransaction().replace(R.id.Mesa, acceso).commit()
            val transaction = this.supportFragmentManager.beginTransaction()
            transaction.replace(R.id.Mesa, acceso).commit()
        }
    }
    override fun showDatePickerDialog() {
        val datePicker = FechaFragment { day, month, year -> onDateSelected(day, month, year) }
        datePicker.show(supportFragmentManager, "datePicker")
    }
    fun onDateSelected(day: Int, month: Int, year: Int) {
        findViewById<TextView>(R.id.Eregistrofecha)!!.setText("${day}/${month+1}/${year}")
        findViewById<Spinner>(R.id.spinspin).visibility = View.VISIBLE
        val fechausuario="${day}/${month+1}/${year}"
        val GIJOE=operacionHorarios(RegistroDocto[Llavedoctor].getHorarios(),fechausuario).split(",").toTypedArray()
        val adaptador = ArrayAdapter(this,android.R.layout.simple_spinner_item,GIJOE)
        spinner = findViewById<Spinner>(R.id.spinspin)
        spinner!!.adapter = adaptador
        spinner!!.onItemSelectedListener =object:
            AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //Toast.makeText(this@MainActivity, "Doctor ", Toast.LENGTH_SHORT).show()
                findViewById<TextView>(R.id.Eregistrohora)!!.setText(GIJOE[position])
                findViewById<Button>(R.id.Bregistrarfecha).visibility = View.VISIBLE
                findViewById<Button>(R.id.Blimpiarfecha).visibility = View.VISIBLE
            }

        }
    }
    override fun Global() {
        val fechausuario = findViewById<TextView>(R.id.Eregistrofecha).text.toString()
        val horaseleccionada = findViewById<TextView>(R.id.Eregistrohora).text.toString()
        val listo = operacionRegistra(RegistroDocto[Llavedoctor].getHorarios(),fechausuario,horaseleccionada)
        dbdoctor!!.Editar(Llavedoctor+1,RegistroDocto[Llavedoctor].getNombre(),RegistroDocto[Llavedoctor].getPaterno(),RegistroDocto[Llavedoctor].getMaterno(),RegistroDocto[Llavedoctor].getEspecialidad(),RegistroDocto[Llavedoctor].getCosto(),RegistroDocto[Llavedoctor].getFecha(),listo,RegistroDocto[Llavedoctor].getEstado(),RegistroDocto[Llavedoctor].getFoto())
        //Toast.makeText(this, listo, Toast.LENGTH_LONG).show()
        val alerta = AlertDialog.Builder(this)
        alerta.setTitle("Atención")
        alerta.setMessage(" \n          Tu cita es : $fechausuario.\n          Hora : $horaseleccionada.\n          Doctor : ${RegistroDocto[Llavedoctor].getNombre()}.\n")
        alerta.setNeutralButton("Enterado") { dialog, which ->
        }
        alerta.show()
        EntraUser()

        val Ecita = " \n          Tu cita es : $fechausuario.\n          Hora : $horaseleccionada.\n          Doctor : ${RegistroDocto[Llavedoctor].getNombre()}.\n"

        dbusuario!!.Editar(Llaveusuario+1,RegistroUsu[Llaveusuario].getNombre(),RegistroUsu[Llaveusuario].getPaterno(),RegistroUsu[Llaveusuario].getMaterno(),RegistroUsu[Llaveusuario].getNacimiento(),Ecita," ${RegistroUsu[Llaveusuario].getHistorial()} \n ${fechausuario}   $${RegistroDocto[Llavedoctor].getCosto()}.00",RegistroDocto[Llavedoctor].getCosto().toString(),"no",RegistroUsu[Llaveusuario].getFoto())
    }
    override fun Valida(){
        RegistroUsu = dbusuario!!.MuestraDatos()
        if(RegistroUsu[Llaveusuario].getEstado()=="no"){

            val alerta = AlertDialog.Builder(this)
            alerta.setTitle("Estimado Usuario")
            alerta.setMessage(" Tienes una cita pendiente : ${RegistroUsu[Llaveusuario].getCita()}")
            alerta.setNeutralButton("Estoy de acuerdo") { dialog, which ->
            }
            alerta.show()
        }else{
            //Toast.makeText(this, "no valido", Toast.LENGTH_LONG).show()
            EntraCitas()
        }

    }
    override fun Ensena(){
        RegistroUsu = dbusuario!!.MuestraDatos()
        findViewById<TextView>(R.id.Etotal)!!.setText("$${RegistroUsu[Llaveusuario].getSaldo()}.00")
        findViewById<TextView>(R.id.ContenidoSaldo)!!.setText(RegistroUsu[Llaveusuario].getHistorial())
    }
    override fun Nacimiento() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val datePicker = FechaFragment { day, month, year -> onDateSelected(day, month, year) }
        val dpd = DatePickerDialog(this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            var calendar = GregorianCalendar(year,monthOfYear,dayOfMonth)
            findViewById<EditText>(R.id.Cfecha)!!.setText("")
            if (year<SimpleDateFormat("yyyy").format(Date()).toInt() ){
                //Toast.makeText(this, " $year <= ${SimpleDateFormat("yyyy").format(Date()).toInt()} && ${monthOfYear+1} <=${SimpleDateFormat("M").format(Date()).toInt()} $dayOfMonth < ${SimpleDateFormat("dd").format(Date()).toInt()}", Toast.LENGTH_LONG).show()
                findViewById<EditText>(R.id.Cfecha)!!.setText("$dayOfMonth/${monthOfYear+1}/$year")
            }else{
                Toast.makeText(this, "Error fecha fuera de rango", Toast.LENGTH_LONG).show()
            }
            }, year, month, day)
        dpd.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dpd.show()
    }
    override fun EliminaUser(){
        dbusuario!!.borrar(findViewById<EditText>(R.id.Cborauser).text.toString())
        findViewById<EditText>(R.id.Cborauser)!!.setText("")
        Toast.makeText(this, "Usuario borrado", Toast.LENGTH_LONG).show()
    }
    override fun EliminaDoctor() {
        dbdoctor!!.borrar(findViewById<EditText>(R.id.Cborauser).text.toString())
        findViewById<EditText>(R.id.Cborauser)!!.setText("")
        Toast.makeText(this, "Doctor borrado", Toast.LENGTH_LONG).show()
    }
    override fun NacimientoDoctor() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val datePicker = FechaFragment { day, month, year -> onDateSelected(day, month, year) }
        val dpd = DatePickerDialog(this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                var calendar = GregorianCalendar(year,monthOfYear,dayOfMonth)
                findViewById<EditText>(R.id.DCfecha2)!!.setText("")
                if (year<SimpleDateFormat("yyyy").format(Date()).toInt()){
                    //Toast.makeText(this, " $year <= ${SimpleDateFormat("yyyy").format(Date()).toInt()} && ${monthOfYear+1} <=${SimpleDateFormat("M").format(Date()).toInt()} $dayOfMonth < ${SimpleDateFormat("dd").format(Date()).toInt()}", Toast.LENGTH_LONG).show()
                    findViewById<EditText>(R.id.DCfecha2)!!.setText("$dayOfMonth/${monthOfYear+1}/$year")
                }else{
                    Toast.makeText(this, "Error fecha fuera de rango", Toast.LENGTH_LONG).show()
                }
            }, year, month, day)
        dpd.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dpd.show()
    }
    override fun SacarFoto() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            val temp: ImageView = findViewById(R.id.PoneFoto)
            //temp.setImageBitmap(imageBitmap)

            val stream = ByteArrayOutputStream()// crea apartado
            imageBitmap.compress(Bitmap.CompressFormat.PNG,90,stream)//comprime
            Casita= stream.toByteArray().size
            imagenrara= stream.toByteArray()
            val carga = stream.toByteArray()//recuerda a stream y lo mete a carga en FORMA DE BYTESARRAY
            val fantasma =BitmapFactory.decodeByteArray(carga,0,carga.size)//descomprime
            temp.setImageBitmap(fantasma)// lo pone en el image


        }


    }
    override fun EditarUsuario(){
        //PunteroEditorDoctor= findViewById<EditText>(R.id.Cborauser).text.toString()
        val acceso = EditorUsu()
        supportFragmentManager.beginTransaction().replace(R.id.Mesa, acceso).commit()
        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.Mesa, acceso).commit()
    }
    override fun EditarUsuarioMuestra(){
        var temporal: MutableList<Usuario> =dbusuario!!.MuestraDatos()
        findViewById<EditText>(R.id.editTextTextPersonName2)!!.setText(temporal[PunteroEditor.toInt()].getNombre())
        findViewById<EditText>(R.id.editTextTextPersonName3)!!.setText(temporal[PunteroEditor.toInt()].getPaterno())
        findViewById<EditText>(R.id.editTextTextPersonName4)!!.setText(temporal[PunteroEditor.toInt()].getMaterno())
        findViewById<EditText>(R.id.editTextTextPersonName5)!!.setText(temporal[PunteroEditor.toInt()].getNacimiento())
        findViewById<EditText>(R.id.editTextTextPersonName10)!!.setText(temporal[PunteroEditor.toInt()].getCita())
        findViewById<EditText>(R.id.editTextTextPersonName6)!!.setText(temporal[PunteroEditor.toInt()].getEstado())
        findViewById<EditText>(R.id.editTextTextPersonName7)!!.setText(temporal[PunteroEditor.toInt()].getSaldo())
    }
    override fun EditarUsuarioModificar(){
        var temporal: MutableList<Usuario> =dbusuario!!.MuestraDatos()
        dbusuario!!.Editar(PunteroEditor.toInt()+1,
            findViewById<EditText>(R.id.editTextTextPersonName2).text.toString(),//nombre
            findViewById<EditText>(R.id.editTextTextPersonName3).text.toString(),//paterno
            findViewById<EditText>(R.id.editTextTextPersonName4).text.toString(),//materno
            findViewById<EditText>(R.id.editTextTextPersonName5).text.toString(),//nacimiento
            findViewById<EditText>(R.id.editTextTextPersonName10).text.toString(),//cita
            temporal[PunteroEditor.toInt()].getHistorial(),//historial
            findViewById<EditText>(R.id.editTextTextPersonName7).text.toString(),//saldo
            findViewById<EditText>(R.id.editTextTextPersonName6).text.toString(),//estado
            temporal[PunteroEditor.toInt()].getFoto()  //foto
        )
        Limpiaadmin()
        Toast.makeText(this, " Edicion lista", Toast.LENGTH_LONG).show()
    }
    override fun EditarDoctor() {
        PunteroEditorDoctor= findViewById<EditText>(R.id.Cborauser).text.toString()
        PunteroEditorDoctor = (PunteroEditorDoctor.toInt()-1).toString()
        val acceso = EditorDoc()
        supportFragmentManager.beginTransaction().replace(R.id.Mesa, acceso).commit()
        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.Mesa, acceso).commit()
    }
    override fun EditarDoctorMuestra() {
        var temporal: MutableList<Doctor> =dbdoctor!!.MuestraDatos()

        findViewById<EditText>(R.id.editTextTextPersonName8)!!.setText(temporal[PunteroEditorDoctor.toInt()].getId().toString())
        findViewById<EditText>(R.id.editTextTextPersonName9)!!.setText(temporal[PunteroEditorDoctor.toInt()].getNombre())
        findViewById<EditText>(R.id.editTextTextPersonName11)!!.setText(temporal[PunteroEditorDoctor.toInt()].getPaterno())
        findViewById<EditText>(R.id.editTextTextPersonName12)!!.setText(temporal[PunteroEditorDoctor.toInt()].getMaterno())
        findViewById<EditText>(R.id.editTextTextPersonName13)!!.setText(temporal[PunteroEditorDoctor.toInt()].getEspecialidad())
        findViewById<EditText>(R.id.editTextTextPersonName14)!!.setText(temporal[PunteroEditorDoctor.toInt()].getCosto().toString())
        findViewById<EditText>(R.id.editTextTextPersonName15)!!.setText(temporal[PunteroEditorDoctor.toInt()].getFecha())
        findViewById<EditText>(R.id.editTextTextPersonName16)!!.setText(temporal[PunteroEditorDoctor.toInt()].getHorarios())
        findViewById<EditText>(R.id.editTextTextPersonName17)!!.setText(temporal[PunteroEditorDoctor.toInt()].getEstado())

    }
    override fun EditarDoctorModificar() {

        var temporal: MutableList<Doctor> =dbdoctor!!.MuestraDatos()
        dbdoctor!!.Editar(PunteroEditorDoctor.toInt()+1,
            findViewById<EditText>(R.id.editTextTextPersonName9).text.toString(),//nombre
            findViewById<EditText>(R.id.editTextTextPersonName11).text.toString(),//paterno
            findViewById<EditText>(R.id.editTextTextPersonName12).text.toString(),//materno
            findViewById<EditText>(R.id.editTextTextPersonName13).text.toString(),//especialidad
            findViewById<EditText>(R.id.editTextTextPersonName14).text.toString().toInt(),//costo
            findViewById<EditText>(R.id.editTextTextPersonName15).text.toString(),//fecha
            findViewById<EditText>(R.id.editTextTextPersonName16).text.toString(),//horarios
            findViewById<EditText>(R.id.editTextTextPersonName17).text.toString(),//estado
            temporal[PunteroEditorDoctor.toInt()].getFoto()  //foto
        )
        Limpiaadmin()
        Toast.makeText(this, " Edicion lista", Toast.LENGTH_LONG).show()

    }
    fun operacionHorarios(a1 :String, a2:String): String{
        val cadenota: List<String> = a1.split(",")
        val fecha = a2

        val horario ="7:00 am a 7:20 am,7:20 am a 7:40 am,7:40 am a 8:00 am,8:00 am a 8:20 am,8:20 am a 8:40 am,8:40 am a 9:00 am,9:00 am a 9:20 am,9:20 am a 9:40 am,9:40 am a 10:00 am,10:00 am a 10:20 am,10:20 am a 10:40 am,10:40 am a 11:00 am,11:00 am a 11:20 am,11:20 am a 11:40 am,11:40 am a 12:00 pm,12:00 pm a 12:20 pm,12:20 pm a 12:40 pm,12:40 pm a 1:00 pm".split(",").toTypedArray()
        var permitido=""  //rollo

        var x=0
        var estado=true
        while(estado){
            if(cadenota[x].split(Regex("cha"))[0]==fecha){//busca el horario seleccionado antes de cha
                val separa=cadenota[x].split(Regex("cha"))[1]//separa la hora de la fecha
                val divide=separa.split(Regex("xo")).toTypedArray()//divide con xo los horarios
                var muta: MutableList<String> = ArrayList()
                for (i in horario) {
                    muta.add(i)  //agrega a muta
                }

                for (i in divide) {
                    muta.remove(i) //elimina los que aparecen y deja los que no
                }
                for (i in muta) {
                    permitido+=i+","
                }

                //println("aqui esta ${cadenota[x].split(Regex("cha"))[1]}")
                estado=false
            }
            x++
            if(x==cadenota.size && estado==true){
                estado=false
                permitido="7:00 am a 7:20 am,7:20 am a 7:40 am,7:40 am a 8:00 am,8:00 am a 8:20 am,8:20 am a 8:40 am,8:40 am a 9:00 am,9:00 am a 9:20 am,9:20 am a 9:40 am,9:40 am a 10:00 am,10:00 am a 10:20 am,10:20 am a 10:40 am,10:40 am a 11:00 am,11:00 am a 11:20 am,11:20 am a 11:40 am,11:40 am a 12:00 pm,12:00 pm a 12:20 pm,12:20 pm a 12:40 pm,12:40 pm a 1:00 pm"
            }
        }
        return permitido
    }
    fun operacionRegistra(a1 :String, a2:String,a3:String,): String{
        val cadenota: List<String> = a1.split(",")
        val fecha = a2
        val horaseleccionada =a3

        var resultado=""
        var estado=true
        var x=0
        var contador=0
        //"8.5.2021cha7:00 am a 7:20 am,9.5.2021cha7:00 am a 7:20 am,8.6.2021cha7:00 am a 7:20 amxo7:40 am a 8:00 amxo10:00 am a 10:20 am"
        while(estado){
            if(cadenota[0].isEmpty()){
                resultado+=fecha+"cha"+horaseleccionada+","
                estado=false
            }else if(cadenota[x].split(Regex("cha"))[0]==fecha){
                val fech = cadenota[x].split(Regex("cha"))[0]
                val separa=cadenota[x].split(Regex("cha"))[1]//separa la hora de la fecha

                resultado+=fech+"cha"+separa+"xo"+horaseleccionada+","
                if(x==cadenota.size-1){
                    estado=false
                }
            } else{
                contador++
                resultado+=cadenota[x]+","
                if(x==cadenota.size-1){
                    estado=false
                }
            }
            x++
            if(x==cadenota.size && x==contador){
                println("entro")
                resultado=cadenota.joinToString(",")+","+fecha+"cha"+horaseleccionada+","
                estado=false
            }
        }

        return resultado

    }


}