package com.rumeysaozer.notdefteri

import androidx.lifecycle.LiveData

class NotRepository(private val notDao: NotDao) {

    val notlar: LiveData<List<Notlar>> = notDao.getNot()
    suspend fun insert(not: Notlar){
        notDao.insert(not)
    }
    suspend fun delete(not: Notlar){
        notDao.delete(not)
    }
    suspend fun update(not: Notlar){
        notDao.update(not)
    }
}