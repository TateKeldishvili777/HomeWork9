package com.example.homework9.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.homework9.model.DataUser
import com.example.homework9.network.RetroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: RetroRepository):
    ViewModel() {

    fun getAllRepositoryList(): LiveData<List<DataUser>> {
        return repository.getAllRecords()
    }

    fun makeApiCall() {
        repository.makeApiCall("1")
    }
}