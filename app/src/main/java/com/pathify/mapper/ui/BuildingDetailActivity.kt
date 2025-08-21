package com.pathify.mapper.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pathify.mapper.databinding.ActivityBuildingDetailBinding

class BuildingDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBuildingDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuildingDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Building Details"
    }
}
