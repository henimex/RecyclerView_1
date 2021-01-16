package com.hendev.recyclerviewkullanm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(private val mContext: Context, private val ulkelerDisaridanGelenListe: List<Ulkeler>)
    : RecyclerView.Adapter<RVAdapter.CardViewTasaraimNesneleriniTutucu>()
{

    inner class CardViewTasaraimNesneleriniTutucu(view: View) : RecyclerView.ViewHolder(view) {

        var satirCardView: CardView //= view.findViewById(R.id.satirCardView) //uygulama birlesebilir diye uyarı verdi ama bu sekilde denenmedi
        var satirYazi: TextView
        var noktaResim: ImageView

        init {
            satirCardView = view.findViewById(R.id.satirCardView)
            satirYazi = view.findViewById(R.id.satirYazi)
            noktaResim = view.findViewById(R.id.noktaResim)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): CardViewTasaraimNesneleriniTutucu { //tasarımı yazılım alanı ile bagladıgımız alan
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.card_tasarimi,parent,false)
        return CardViewTasaraimNesneleriniTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardViewTasaraimNesneleriniTutucu, position: Int) {  //veri kümesi içeriside gezerek verileri aktaran yapı
        val ulke = ulkelerDisaridanGelenListe[position]

        holder.satirYazi.text = ulke.ulkeAdi
        holder.satirCardView.setOnClickListener{
            Toast.makeText(mContext,"Seçilen : ${ulke.ulkeAdi}",Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int { //recycler in kac defa tekrarlanacagını belirtilen alan
        return ulkelerDisaridanGelenListe.size
    }


}