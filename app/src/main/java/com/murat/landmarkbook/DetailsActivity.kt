package com.murat.landmarkbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.murat.landmarkbook.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent=intent
        val selectedLandMark=intent.getSerializableExtra("landmark",) as LandMark
        binding.nameText.text=selectedLandMark.name
        binding.countryText.text=selectedLandMark.country
        binding.imageView.setImageResource(selectedLandMark.image)



    }
}