package com.example.homework9.viewmodel

import androidx.lifecycle.ViewModel
import com.example.homework9.db.RoomRepository
import com.example.homework9.model.DataUser
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EditActivityViewModel @Inject constructor(private val repository: RoomRepository):
    ViewModel() {

    fun getDataUserById(id: Int): DataUser {
        return repository.getDataUserById(id)
    }

    fun updateRecord(dataUser: DataUser) {
        repository.updateRecord(dataUser)
    }

    fun deleteRecord(dataUser: DataUser) {
        repository.deleteRecord(dataUser)
    }
}