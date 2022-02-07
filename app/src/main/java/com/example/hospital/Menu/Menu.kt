package com.example.hospital

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Menu.newInstance] factory method to
 * create an instance of this fragment.
 */
class Menu : Fragment() {
    private lateinit var canal: Canal

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val login = inflater.inflate(R.layout.fragment_menu,container, false)
        this.canal = activity as Canal
        val temp: Button = login.findViewById(R.id.BCita)
        val temp0: Button = login.findViewById(R.id.BDatos)
        val temp1: Button = login.findViewById(R.id.BCosto)
        val temp2: Button = login.findViewById(R.id.BEnfermedades)
        val temp3: Button = login.findViewById(R.id.BSalida)

        temp.setOnClickListener {
            /*
            val alerta = AlertDialog.Builder(context)
            alerta.setTitle("Consejo")
            alerta.setMessage(" \n          Selecciona cuidadosamente al Doctor.")
            alerta.setNeutralButton("Estoy de acuerdo") { dialog, which ->
            }
            alerta.show()

             */
            canal.Valida()
            //canal.EntraCitas()
        }
        temp0.setOnClickListener {
            //Toast.makeText(context, "Hola", Toast.LENGTH_LONG).show()
            canal.EntraDatos()
        }
        temp1.setOnClickListener {
            //Toast.makeText(context, "Hola", Toast.LENGTH_LONG).show()
            canal.EntraCosto()
        }
        temp2.setOnClickListener {
            //Toast.makeText(context, "Hola", Toast.LENGTH_LONG).show()
            canal.EntraEnfermedades()
        }
        temp3.setOnClickListener {
            //Toast.makeText(context, "Hola", Toast.LENGTH_LONG).show()
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
         * @return A new instance of fragment Menu.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Menu().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}