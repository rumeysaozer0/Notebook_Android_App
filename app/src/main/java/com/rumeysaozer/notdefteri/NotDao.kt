package com.rumeysaozer.notdefteri

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(not: Notlar)

    @Update
    suspend fun update(not: Notlar)

    @Delete
    suspend fun delete(not: Notlar)

    @Query("SELECT * FROM NOTLAR ORDER BY id DESC")
    fun getNot(): LiveData<List<Notlar>>
}