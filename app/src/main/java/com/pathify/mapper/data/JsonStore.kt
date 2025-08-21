package com.pathify.mapper.data

import android.content.Context
import com.pathify.mapper.model.AppState
import com.google.gson.Gson
import java.io.File

class JsonStore(private val context: Context) {
    private val gson = Gson()
    private val stateFile = File(context.filesDir, "mapper_state.json")

    fun loadState(): AppState {
        return if (stateFile.exists()) {
            stateFile.readText().let { gson.fromJson(it, AppState::class.java) ?: AppState() }
        } else AppState()
    }

    fun saveState(state: AppState) {
        stateFile.writeText(gson.toJson(state))
    }
}