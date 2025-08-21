package com.pathify.mapper.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import com.pathify.mapper.data.JsonStore
import com.pathify.mapper.databinding.ActivityManageBuildingsBinding
import com.pathify.mapper.model.AppState
import com.pathify.mapper.model.Building
import com.pathify.mapper.databinding.ActivityNewBuildingBinding

class NewBuildingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewBuildingBinding
    private lateinit var store: JsonStore
    private lateinit var state: AppState

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewBuildingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        store = JsonStore(this)
        state = store.loadState()

        binding.btnSaveBuilding.setOnClickListener {
            val id = binding.etBuildingId.text.toString().trim()
            val name = binding.etBuildingName.text.toString().trim()
            if (id.isEmpty() || name.isEmpty()) {
                Toast.makeText(this, "Please fill ID and Name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val lat = binding.etLat.text.toString().toDoubleOrNull()
            val lon = binding.etLon.text.toString().toDoubleOrNull()

            if (state.buildings.any { it.id.equals(id, ignoreCase = true) }) {
                Toast.makeText(this, "Building ID already exists", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            state.buildings.add(Building(id = id, name = name, geoLat = lat, geoLon = lon))
            store.saveState(state)
            finish()
        }
    }
}