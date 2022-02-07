package com.example.hospital.Cajadeenfermedades

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.hospital.Enfermedades

class Acomodar(
    val items: ArrayList<Fragment>,
    activity: Enfermedades
    ):FragmentStateAdapter(activity){

    override fun getItemCount(): Int{
        return items.size
    }

    override fun createFragment(position: Int): Fragment {
        return items[position]
    }




}