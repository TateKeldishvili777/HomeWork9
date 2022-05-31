package com.example.homework9.network

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.homework9.db.AppDao
import com.example.homework9.model.DataUser
import com.example.homework9.model.RepositoriesList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RetroRepository @Inject constructor(
    private val retroServiceInterface: RetroServiceInterface,
    private val appDao: AppDao
) {

    fun getAllRecords(): LiveData<List<DataUser>> {
        return appDao.getAllRecords()
    }

    fun insertRecord(dataUser: DataUser) {
        appDao.insertRecords(dataUser)
    }


    fun makeApiCall(query: String?) {
        val call: Call<RepositoriesList> = retroServiceInterface.getDataFromAPI(query!!)
        call.enqueue(object : Callback<RepositoriesList> {
            override fun onResponse(
                call: Call<RepositoriesList>,
                response: Response<RepositoriesList>
            ) {
                if (response.isSuccessful) {
                    appDao.deleteAllRecords()
                    response.body()?.data?.forEach {
                        insertRecord(it)
                    }
                    Log.d("logging", "Success")
                }
            }

            override fun onFailure(call: Call<RepositoriesList>, t: Throwable) {
                Log.d("logging", "Failure")
            }
        })
    }

}