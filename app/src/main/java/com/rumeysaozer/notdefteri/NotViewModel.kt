package com.rumeysaozer.notdefteri

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotViewModel (application : Application) : AndroidViewModel(application) {

    val notlar: LiveData<List<Notlar>>
    val repository: NotRepository

    init {
        val dao = NotlarDatabase.getDatabase(application).getNotDao()
        repository = NotRepository(dao)
        notlar = repository.notlar
    }

    fun deleteNot(not: Notlar) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(not)
    }
    fun updateNot(not: Notlar) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(not)
    }fun insertNot(not: Notlar) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(not)
    }

}