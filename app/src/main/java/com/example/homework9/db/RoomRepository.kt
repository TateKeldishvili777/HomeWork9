package com.example.homework9.db

import com.example.homework9.model.DataUser
import javax.inject.Inject

class RoomRepository @Inject constructor(private val appDao: AppDao) {

    fun insertRecords(dataUser: DataUser) {
        appDao.insertRecords(dataUser)
    }

    fun getDataUserById(id: Int): DataUser {
        return appDao.getDataUserById(id)
    }

    fun updateRecord(dataUser: DataUser) {
        appDao.updateRecord(dataUser)
    }

    fun deleteRecord(dataUser: DataUser) {
        appDao.deleteRecord(dataUser)
    }
}