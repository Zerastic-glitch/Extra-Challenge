package com.angelo.myapplication

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.FrameLayout
import android.widget.GridView
import android.widget.ImageView
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.children


class SpelFragment : Fragment() {

    val symbool1 = R.drawable.kruis
    val symbool2 = R.drawable.cirkel

    //metavlakken met vlakken erin
    var inhoud = Array<Array<Int>> (9){i-> Array<Int>(9){i2-> R.drawable.leeg} }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_spel, container, false)

        val speelveld = v.findViewById<GridView>(R.id.speelveld)

        val spelers = Array<Speler>(2){i-> Speler("Speler ${i%2}", if (i%2==0) symbool1 else symbool2) }
        val spel = Spel(spelers)


//        inhoud = buildFields(spel)


        speelveld.adapter= GridAdapter(requireContext(), inhoud, spel, requireActivity() as MainActivity)



        return v

    }

//    fun buildFields(spel : Spel) : Array<Array<Int>>{
//
//        var metavlakken = Array<Array<Int>>(9){
//            i->Array<Int>(9){
//                i2->if(spel.getMetaVlak(Vector(i,i2))==spel.spelers[0]) {
//                    symbool1
//                } else {
//                    symbool2
//                }
//            }
//        }
//    }

}
class ImageAdapter(private val context: Context, private val imageArray: Array<Int>, private val spel: Spel, private val metaVlak: Int, private val activity: MainActivity) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val container : FrameLayout= FrameLayout(context)
        container.setPadding(5,5,5,5)
        container.setBackgroundResource(R.color.design_default_color_primary_dark)
        val imageView = ImageView(context)


        imageView.setImageResource(imageArray[position])
        imageView.setBackgroundResource(R.color.design_default_color_primary)



        imageView.scaleType=ImageView.ScaleType.CENTER_CROP
        imageView.layoutParams = ViewGroup.LayoutParams(80,80)

        //TODO: setOnclick -> imageView
        imageView.setOnClickListener {
            val metaPunt = Vector(metaVlak%3,metaVlak/3)
            val vlakPunt = Vector(position%3,position/3)

            val spelers = ArrayList<Speler>()
            if (spel.isBeschikbaar(spel.getMetaVlak(metaPunt).getVlak(vlakPunt))&&spel.getMetaVlak(metaPunt).isGewonnen(spel.spelers, 3)==null){
                val speler = spel.nieuweBeurt(spel.getMetaVlak(metaPunt).getVlak(vlakPunt))
                if (spelers.size<2){
                    spelers.add(speler)
                }
                (it as ImageView).setImageResource(speler.symbool)
            }
            if (spel.getMetaVlak(metaPunt).isGewonnen(spelers.toTypedArray(), 3)!=null)
                if (spel.isGewonnen()!=null){
                    activity.eindScherm(spel.isGewonnen()!!)
                }
        }

        container.addView(imageView)
        return container
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
}class GridAdapter(private val context: Context, private val inhoud : Array<Array<Int>>, private val spel : Spel, private val activity: MainActivity) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        //uiteindelijk per 1-9 positie een andere array gebruiken uit de funtionele klassen net als bij ImageAdapter

        val gridView = GridView(context)

        gridView.columnWidth=50
        gridView.adapter= ImageAdapter(context, inhoud[position], spel, position, activity)
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
