package com.project.recyclerviewkullanimi
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.recyclerviewkullanimi.databinding.CardTasarimBinding

//
class KisilerAdapter(var mContext:Context,var kisilerListesi:List<Kisiler>)
    : RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>() { //sınıfı kişileradapter'a bağladık

    inner class CardTasarimTutucu(cardTasarimBinding: CardTasarimBinding) :
        RecyclerView.ViewHolder(cardTasarimBinding.root) {
        //tasarim değişkeni oluşturuyoruz.Bununla görsel nesnelere erişmiş olacağız.
        var cardTasarim:CardTasarimBinding

        init {
            this.cardTasarim=cardTasarimBinding
        }
    }
    //tasarimla bağlama işlemi
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
     val layoutInflater=LayoutInflater.from(mContext)
     val tasarim=CardTasarimBinding.inflate(layoutInflater,parent,false)
        //CardTasarimTutucu sınıfından bir nesne istiyor
        return CardTasarimTutucu(tasarim)

    }
    //card a özgü işlemler burada gerçekleşir ve kaç eleman varsa o kadar çalışır(position)
    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
       val kisi=kisilerListesi.get(position) //position:0 ilk kişiyi,1 gelirse ikinciyi..
        //holder nesnesi cardTasarima erişmemizi sağlıyor

        //ad ve teli getiriyorum
        holder.cardTasarim.textViewKisiBilgi.text="${kisi.kisi_ad}-${kisi.kisi_tel}"


    }

    override fun getItemCount(): Int { //veri kümesinin içinde kaç eleman var,kaç satır oluşturacağım vs.
      return kisilerListesi.size //kisilerlistesinin büyüklüğü kadar döndürürürüm
    }
}