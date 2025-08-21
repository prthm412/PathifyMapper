package com.pathify.mapper.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pathify.mapper.data.JsonStore
import com.pathify.mapper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var store: JsonStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        store = JsonStore(this)

        binding.btnManageBuildings.setOnClickListener {
            startActivity(Intent(this, ManageBuildingsActivity::class.java))
        }
    }
}
