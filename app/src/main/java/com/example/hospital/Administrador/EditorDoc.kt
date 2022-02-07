package com.example.hospital.Administrador

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.hospital.Canal
import com.example.hospital.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EditorDoc.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditorDoc : Fragment() {
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.canal = activity as Canal
        val login = inflater.inflate(R.layout.fragment_editor_doc,container, false)
        val temp: Button = login.findViewById(R.id.button5)
        val temp0: Button = login.findViewById(R.id.button4)
        val temp1: Button = login.findViewById(R.id.button6)
        temp1.setOnClickListener {
            canal.EditarDoctorModificar()
        }

        temp0.setOnClickListener {
            canal.EditarDoctorMuestra()
        }

        temp.setOnClickListener {
            canal.Limpiaadmin()
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
         * @return A new instance of fragment EditorDoc.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EditorDoc().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}