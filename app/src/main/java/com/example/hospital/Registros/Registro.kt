package com.example.hospital


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val CAMERA_PERMISSION_CODE = 1
private const val CAMERA_REQUEST_CODE =2
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Registro.newInstance] factory method to
 * create an instance of this fragment.
 */
class Registro : Fragment() {
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
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val login = inflater.inflate(R.layout.fragment_registro,container, false)
        this.canal = activity as Canal
        val temp: Button = login.findViewById(R.id.Bfoto)
        val temp0: Button = login.findViewById(R.id.Bsalida0)
        val temp1: Button = login.findViewById(R.id.Bregistrar)
        val temp3: EditText = login.findViewById(R.id.Cfecha)
        temp.setOnClickListener {
            //Toast.makeText(context, "foto", Toast.LENGTH_LONG).show()
            canal.SacarFoto()

        }
        temp0.setOnClickListener {
            //Toast.makeText(context, "foto", Toast.LENGTH_LONG).show()
            canal.Salida()

        }
        temp1.setOnClickListener {
            //Toast.makeText(context, "foto", Toast.LENGTH_LONG).show()
            canal.Guardar()

        }
        temp3.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                when (event?.action) {
                    MotionEvent.ACTION_DOWN -> canal.Nacimiento()
                }

                return v?.onTouchEvent(event) ?: true
            }
        })


        return login
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Registro.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Registro().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}