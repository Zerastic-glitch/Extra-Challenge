package com.angelo.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView


class SpelFragment : Fragment() {


    //metavlakken met vlakken erin
    var inhoud = arrayOf(
        arrayOf(R.drawable.kruis,R.drawable.cirkel,R.drawable.kruis,R.drawable.cirkel,R.drawable.kruis,R.drawable.cirkel,R.drawable.cirkel,R.drawable.cirkel,R.drawable.cirkel),
        arrayOf(R.drawable.kruis,R.drawable.cirkel,R.drawable.kruis,R.drawable.cirkel,R.drawable.kruis,R.drawable.cirkel,R.drawable.cirkel,R.drawable.cirkel,R.drawable.cirkel),
        arrayOf(R.drawable.kruis,R.drawable.cirkel,R.drawable.kruis,R.drawable.cirkel,R.drawable.kruis,R.drawable.cirkel,R.drawable.cirkel,R.drawable.cirkel,R.drawable.cirkel),
        arrayOf(R.drawable.kruis,R.drawable.cirkel,R.drawable.kruis,R.drawable.cirkel,R.drawable.kruis,R.drawable.cirkel,R.drawable.cirkel,R.drawable.cirkel,R.drawable.cirkel),
        arrayOf(R.drawable.kruis,R.drawable.cirkel,R.drawable.kruis,R.drawable.cirkel,R.drawable.kruis,R.drawable.cirkel,R.drawable.cirkel,R.drawable.cirkel,R.drawable.cirkel),
        arrayOf(R.drawable.kruis,R.drawable.cirkel,R.drawable.kruis,R.drawable.cirkel,R.drawable.kruis,R.drawable.cirkel,R.drawable.cirkel,R.drawable.cirkel,R.drawable.cirkel),
        arrayOf(R.drawable.kruis,R.drawable.cirkel,R.drawable.kruis,R.drawable.cirkel,R.drawable.kruis,R.drawable.cirkel,R.drawable.cirkel,R.drawable.cirkel,R.drawable.cirkel),
        arrayOf(R.drawable.kruis,R.drawable.cirkel,R.drawable.kruis,R.drawable.cirkel,R.drawable.kruis,R.drawable.cirkel,R.drawable.cirkel,R.drawable.cirkel,R.drawable.cirkel),
        arrayOf(R.drawable.kruis,R.drawable.cirkel,R.drawable.kruis,R.drawable.cirkel,R.drawable.kruis,R.drawable.cirkel,R.drawable.cirkel,R.drawable.cirkel,R.drawable.cirkel)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_spel, container, false)
//
        val speelveld = v.findViewById<GridView>(R.id.speelveld)


        speelveld.adapter= GridAdapter(requireContext(), inhoud)

        return v
    }



}
class ImageAdapter(private val context: Context, private val imageArray: Array<Int>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView = ImageView(context)
        imageView.setImageResource(imageArray[position])
        imageView.scaleType=ImageView.ScaleType.CENTER_CROP
        imageView.layoutParams = ViewGroup.LayoutParams(80,80)

        //TODO: setOnclick -> imageView

        return imageView
    }
    override fun getItem(position: Int): Any {
        return imageArray[position]
    }
    override fun getItemId(position: Int): Long {
        return 0
    }
    override fun getCount(): Int {
        return imageArray.size
    }
}class GridAdapter(private val context: Context, private val inhoud : Array<Array<Int>>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        //uiteindelijk per 1-9 positie een andere array gebruiken uit de funtionele klassen net als bij ImageAdapter

        val gridView = GridView(context)
        gridView.columnWidth=50
        gridView.adapter= ImageAdapter(context, inhoud[position])
        gridView.layoutParams = ViewGroup.LayoutParams(300,300)
        gridView.numColumns=3

        return gridView
    }
    override fun getItem(position: Int): Any {
        return 0
    }
    override fun getItemId(position: Int): Long {
        return 0
    }
    override fun getCount(): Int {
        return 9
    }
}
