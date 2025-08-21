package com.pathify.mapper.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.pathify.mapper.data.JsonStore
import com.pathify.mapper.databinding.ActivityManageBuildingsBinding
import com.pathify.mapper.model.AppState

class ManageBuildingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityManageBuildingsBinding
    private lateinit var store: JsonStore
    private lateinit var state: AppState
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManageBuildingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        store = JsonStore(this)
        state = store.loadState()

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, state.buildings.map { "${it.id} - ${it.name}" })
        binding.listBuildings.adapter = adapter

        binding.btnAddBuilding.setOnClickListener {
            startActivity(Intent(this, NewBuildingActivity::class.java))
        }

        binding.listBuildings.setOnItemClickListener { _, _, position, _ ->
            val b = state.buildings[position]
            val i = Intent(this, BuildingDetailActivity::class.java)
            i.putExtra("BUILDING_ID", b.id)
            startActivity(i)
        }
    }

    override fun onResume() {
        super.onResume()
        state = store.loadState()
        adapter.clear()
        adapter.addAll(state.buildings.map { "${it.id} - ${it.name}" })
        adapter.notifyDataSetChanged()
    }
}