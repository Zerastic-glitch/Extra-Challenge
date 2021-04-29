package com.challenge.myapplication

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
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_spel, container, false)
        val speelveld = v.findViewById<GridView>(R.id.speelveld)
        speelveld.adapter=GridAdapter(requireContext())

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

}class GridAdapter(private val context: Context) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        //uiteindelijk per 1-9 positie een andere array gebruiken uit de funtionele klassen net als bij ImageAdapter
        val inhoud= arrayOf(R.drawable.kruis,R.drawable.cirkel,R.drawable.kruis,R.drawable.cirkel,R.drawable.kruis,R.drawable.cirkel,R.drawable.cirkel,R.drawable.cirkel,R.drawable.cirkel)

        val gridView = GridView(context)
        gridView.columnWidth=50
        gridView.adapter=ImageAdapter(context, inhoud)
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
