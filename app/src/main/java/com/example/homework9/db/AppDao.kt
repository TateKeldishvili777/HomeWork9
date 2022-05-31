package com.example.homework9.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.homework9.model.DataUser

@Dao
interface AppDao {

    @Query("SELECT * FROM data")
    fun getAllRecords(): LiveData<List<DataUser>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRecords(dataUser: DataUser)

    @Query("DELETE FROM data")
    fun deleteAllRecords()

    @Query("SELECT * FROM data WHERE id = :id")
    fun getDataUserById(id: Int): DataUser

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateRecord(dataUser: DataUser)

    @Delete
    fun deleteRecord(dataUser: DataUser)
}