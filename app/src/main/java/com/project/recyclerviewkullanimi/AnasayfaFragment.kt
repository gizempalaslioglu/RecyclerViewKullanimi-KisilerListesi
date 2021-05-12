package com.project.recyclerviewkullanimi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.recyclerviewkullanimi.databinding.FragmentAnasayfaBinding

class AnasayfaFragment : Fragment() {

    //biz burada bir veri kümesi belirleyeceğiz.Kisiler sınıfından oluşan bir
    //arraylistimiz olacak.Birde kullanacağımız adapterla ilgili global değişken tanımlaması yapacağız.
    //burada da databinding yapıyoruz

    private lateinit var tasarim:FragmentAnasayfaBinding
    private lateinit var adapter: KisilerAdapter//adapterı temsil eden
    private lateinit var kisilerListesi:ArrayList<Kisiler>
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        
        tasarim= DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa, container, false)
        //requireContext bağlı olduğu activity
        tasarim.rv.layoutManager=LinearLayoutManager(requireContext())
        kisilerListesi=ArrayList() //arraylist i oluşturuyorum
        //verilerimiz-->
        var k1=Kisiler(1,"Gizem","1111")
        var k2=Kisiler(2,"Palaslıoğlu","2222")
        kisilerListesi.add(k1)
        kisilerListesi.add(k2)

        //veri kümemizi adapter'a göndereceğiz
        adapter= KisilerAdapter(requireContext(),kisilerListesi)
        //adapter bilgilerimizi yazdıracak
        tasarim.rv.adapter=adapter //bu adapterı recyclerview adapter a ekliyorum



        return tasarim.root
    }
}