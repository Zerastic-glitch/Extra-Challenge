package com.angelo.myapplication

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.children


class SpelFragment : Fragment() {

    val symbool1 = R.drawable.kruis
    val symbool2 = R.drawable.cirkel

    //metavlakken met vlakken erin
    var inhoud = Array<Array<Int>> (9){i-> Array<Int>(9){i2-> R.drawable.leeg} }

    val spelers = Array<Speler>(2){i-> Speler("Speler ${i%2}", if (i%2==0) symbool1 else symbool2) }

    var spel : Spel = Spel(spelers)
    var beurtSpeler : TextView? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_spel, container, false)

        val speelveld = v.findViewById<GridView>(R.id.speelveld)

        beurtSpeler = v.findViewById<TextView>(R.id.speler)
        beurtSpeler!!.text= "Speler 1"


        speelveld.adapter= GridAdapter(requireContext(), inhoud, spel, this)

        return v

    }

    var container1 : RelativeLayout? = null
    var container2 : RelativeLayout? = null
    fun setImage (container: RelativeLayout, vlakPosition: Int, metaPosition: Int) {

        val imageView = container.getChildAt(0) as ImageView
        if (spel.isValideZet(spel.getMetaVlak(metaPosition).getVlak(vlakPosition))&&spel.getMetaVlak(metaPosition).isGewonnen(spelers, 3)==null) {
            val speler = spel.nieuweBeurt(spel.getMetaVlak(metaPosition).getVlak(vlakPosition))
            if(speler==spelers[0]){
                beurtSpeler!!.text= "Speler 2"

                container1?.setBackgroundResource(R.color.design_default_color_primary_dark)
                container1=container
                container2?.setBackgroundColor(Color.BLUE)
            }
            else{
                beurtSpeler!!.text= "Speler 1"

                container2?.setBackgroundResource(R.color.design_default_color_primary_dark)
                container2=container
                container1?.setBackgroundColor(Color.GREEN)
            }

            imageView.setImageResource(speler.symbool)
            setMeta(container,metaPosition, speler)
        }
    }

    fun setMeta (container: RelativeLayout, metaPosition: Int, speler: Speler) {
//        var kiesbaar : Int? = null
//        for (i in 0..8){
//            spel.getMetaVlak(i).getVlakken().forEach {
//                if (spel.isValideZet(it)){
//                    kiesbaar=i
//                }
//            }
//        }
//        for (i in 0..(container.parent.parent as GridView).children.count()){
//            if (i==kiesbaar){
//                (container.parent as GridView).children.forEach { it.setBackgroundColor(if (speler==spelers[0]) Color.GREEN else Color.BLUE) }
//            }
//        }
        if (spel.getMetaVlak(metaPosition).isGewonnen(spelers, 3)!=null) {
            val gridView = container.parent as GridView
            if (spel.getMetaVlak(metaPosition).isGewonnen(spelers, 3)==spelers[0]){
                gridView.children.forEach {
                    (it as RelativeLayout).setBackgroundColor(Color.GRAY)
                }
            } else {
                gridView.children.forEach {
                    (it as RelativeLayout).setBackgroundColor(Color.GRAY)
                }
            }
            if (spel.isGewonnen() != null) {
                (this.requireActivity() as MainActivity).eindScherm(spel.isGewonnen()!!)
            }
        }
    }


}
class ImageAdapter(private val context: Context, private val imageArray: Array<Int>, private val spel: Spel, private val metaVlak: Int, private val fragment: SpelFragment) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val container : RelativeLayout= RelativeLayout(context)
        container.setPadding(5,5,5,5)
        container.setBackgroundResource(R.color.design_default_color_primary_dark)
        val imageView = ImageView(context)



        imageView.setImageResource(imageArray[position])
        imageView.setBackgroundResource(R.color.design_default_color_primary)


        imageView.scaleType=ImageView.ScaleType.CENTER_CROP
        imageView.layoutParams = ViewGroup.LayoutParams(80,80)

        //TODO: setOnclick -> imageView
        imageView.setOnClickListener {
//            val metaPunt = Vector(metaVlak%3,metaVlak/3)
//            val vlakPunt = Vector(position%3,position/3)

//            val spelers = ArrayList<Speler>()
//            if (spel.isBeschikbaar(spel.getMetaVlak(metaPunt).getVlak(vlakPunt))&&spel.getMetaVlak(metaPunt).isGewonnen(spel.spelers, 3)==null){
//                val speler = spel.nieuweBeurt(spel.getMetaVlak(metaPunt).getVlak(vlakPunt))
//                if (spelers.size<2){
//                    spelers.add(speler)
//                }
//                (it as ImageView).setImageResource(speler.symbool)
//            }
//            if (spel.getMetaVlak(metaPunt).isGewonnen(spelers.toTypedArray(), 3)!=null)
//                if (spel.isGewonnen()!=null){
//                    activity.eindScherm(spel.isGewonnen()!!)
//                }
            fragment.setImage (container, position, metaVlak)
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
}class GridAdapter(private val context: Context, private val inhoud: Array<Array<Int>>, private val spel: Spel, private val fragment: SpelFragment) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        //uiteindelijk per 1-9 positie een andere array gebruiken uit de funtionele klassen net als bij ImageAdapter

        val gridView = GridView(context)

        gridView.adapter= ImageAdapter(context, inhoud[position], spel, position, fragment)
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
        return inhoud.size
    }
}
