package com.rumeysaozer.notdefteri

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notlar")
class Notlar (@ColumnInfo(name="title")val title:String,
              @ColumnInfo(name = "not") val not:String,
              @ColumnInfo(name = "date") val date:String)
                {
    @PrimaryKey(autoGenerate = true) var id: Int? = null
}

