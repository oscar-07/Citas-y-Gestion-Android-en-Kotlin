package com.example.hospital

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AgendaCita.newInstance] factory method to
 * create an instance of this fragment.
 */
class AgendaCita : Fragment() {
    private lateinit var canal: Canal
    lateinit var opcion : Spinner
    lateinit var result : TextView
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
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val login = inflater.inflate(R.layout.fragment_agenda_cita,container, false)
        this.canal = activity as Canal
        //val temp: ImageButton = login.findViewById(R.id.BFecha)
        val temp0: Button = login.findViewById(R.id.Brecargar)
        val temp1: Button = login.findViewById(R.id.regresaAgenda)
        val Fecha: Button = login.findViewById(R.id.Bbuscarfecha)
        val global: Button = login.findViewById(R.id.Bregistrarfecha)
        val limpiar: Button = login.findViewById(R.id.Blimpiarfecha)

        limpiar.setOnClickListener {
            //canal.EntraUser()
            canal.EntraCitas()
        }

        Fecha.setOnClickListener {
            canal.showDatePickerDialog()
        }

        global.setOnClickListener {
            //Toast.makeText(context, "Hola", Toast.LENGTH_LONG).show()
            canal.Global()
        }

        temp0.setOnClickListener {
            //Toast.makeText(context, "Hola", Toast.LENGTH_LONG).show()
            canal.Listadoctores()
        }

        temp1.setOnClickListener {
            //Toast.makeText(context, "Hola", Toast.LENGTH_LONG).show()
            canal.EntraUser()
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
         * @return A new instance of fragment AgendaCita.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AgendaCita().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}