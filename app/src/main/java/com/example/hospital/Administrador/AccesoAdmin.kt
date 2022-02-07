package com.example.hospital.Administrador

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.hospital.Canal
import com.example.hospital.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AccesoAdmin.newInstance] factory method to
 * create an instance of this fragment.
 */
class AccesoAdmin : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var canal: Canal
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        this.canal = activity as Canal
        val login = inflater.inflate(R.layout.fragment_acceso_admin,container, false)
        val temp: Button = login.findViewById(R.id.Bllamarusuarios)
        val temp0: Button = login.findViewById(R.id.Bregresar)
        val temp1: Button = login.findViewById(R.id.Bllamadoctores)
        val Doctor: Button = login.findViewById(R.id.AreaDoctores)
        val Usuario: Button = login.findViewById(R.id.AreaUsuarios)
        val Registro: Button = login.findViewById(R.id.BagregarDoctores)
        val borrauser: Button = login.findViewById(R.id.BBorraUsuarios)
        val borradoctor: Button = login.findViewById(R.id.BBorraDoctores)
        val limpiar: Button = login.findViewById(R.id.BBlimpiar)
        val modificaUsuarios: Button = login.findViewById(R.id.BmodificaUsuarios)
        val modificaDoctores: Button = login.findViewById(R.id.BmodificaDoctores)

        modificaDoctores.setOnClickListener{
            canal.EditarDoctor()
        }

        limpiar.setOnClickListener{
            canal.Limpiaadmin()
        }

        modificaUsuarios.setOnClickListener {
            canal.EditarUsuario()
        }



        Usuario.setOnClickListener {
            login.findViewById<Button>(R.id.AreaDoctores).visibility = View.INVISIBLE
            login.findViewById<Button>(R.id.AreaUsuarios).visibility = View.INVISIBLE
            login.findViewById<TextView>(R.id.Eaviso).visibility = View.INVISIBLE
            login.findViewById<Button>(R.id.Bllamarusuarios).visibility = View.VISIBLE
            login.findViewById<Button>(R.id.BBorraUsuarios).visibility = View.VISIBLE
            login.findViewById<TextView>(R.id.Resultadousuario).visibility = View.VISIBLE
            login.findViewById<TextView>(R.id.BmodificaUsuarios).visibility = View.VISIBLE
        }

        Doctor.setOnClickListener {
            login.findViewById<Button>(R.id.AreaDoctores).visibility = View.INVISIBLE
            login.findViewById<Button>(R.id.AreaUsuarios).visibility = View.INVISIBLE
            login.findViewById<TextView>(R.id.Eaviso).visibility = View.INVISIBLE
            login.findViewById<Button>(R.id.Bllamadoctores).visibility = View.VISIBLE
            login.findViewById<Button>(R.id.BagregarDoctores).visibility = View.VISIBLE
            login.findViewById<Button>(R.id.BBorraDoctores).visibility = View.VISIBLE
            login.findViewById<Button>(R.id.BmodificaDoctores).visibility = View.VISIBLE
            login.findViewById<TextView>(R.id.Cborauser).visibility = View.VISIBLE
        }
        borradoctor.setOnClickListener {
            canal.EliminaDoctor()
        }

        borrauser.setOnClickListener {
            canal.EliminaUser()
        }


        Registro.setOnClickListener {
            canal.RegistrarDoctor()
        }

        temp1.setOnClickListener{
            canal.Listadoctores()
        }

        temp.setOnClickListener {
            canal.Listausuarios()
        }
        temp0.setOnClickListener{
            canal.Salida()
        }


        return login

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AccesoAdmin.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                AccesoAdmin().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}