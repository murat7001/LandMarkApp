package com.murat.landmarkbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.murat.landmarkbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var landMarkList: ArrayList<LandMark>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        landMarkList= ArrayList<LandMark>()

        val pisa=LandMark("Pisa","Italy",R.drawable.pisa)
        val colosseum=LandMark("Colosseum","Italy",R.drawable.collesum)
        val eiffel=LandMark("Eifeel","France",R.drawable.eiffel)
        val londonBridge=LandMark("London Bridge","Paris",R.drawable.london)


        landMarkList.add(pisa)
        landMarkList.add(colosseum)
        landMarkList.add(eiffel)
        landMarkList.add(londonBridge)

        val adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,landMarkList.map { landMark ->landMark.name })

        binding.listView.adapter=adapter

        binding.listView.onItemClickListener=AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val intent=Intent(MainActivity@this,DetailsActivity::class.java)
            intent.putExtra("landmark",landMarkList.get(i))
            startActivity(intent)
        }




    }
}