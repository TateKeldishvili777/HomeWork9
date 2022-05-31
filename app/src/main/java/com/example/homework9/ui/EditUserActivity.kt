package com.example.homework9.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.homework9.Constants.Companion.ARG_AVATAR
import com.example.homework9.Constants.Companion.ARG_DATA_USER_ID
import com.example.homework9.Constants.Companion.ARG_EMAIL
import com.example.homework9.Constants.Companion.ARG_FIRSTNAME
import com.example.homework9.Constants.Companion.ARG_LASTNAME
import com.example.homework9.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditUserActivity : AppCompatActivity() {

    private var dataUserId = -1
    private lateinit var firstname: String
    private lateinit var lastname: String
    private lateinit var email: String
    private lateinit var avatar: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_user)

        val mode = intent.getStringExtra(EXTRA_SCREEN_MODE)
        Log.d("logging", mode.toString())

        dataUserId = intent.getIntExtra(ARG_DATA_USER_ID, -1)
        firstname = intent.getStringExtra(ARG_FIRSTNAME).toString()
        lastname = intent.getStringExtra(ARG_LASTNAME).toString()
        email = intent.getStringExtra(ARG_EMAIL).toString()
        avatar = intent.getStringExtra(ARG_AVATAR).toString()
        initFragment()
    }

    private fun initFragment() {
        val bundle = Bundle()
        bundle.putInt(ARG_DATA_USER_ID, dataUserId)
        bundle.putString(ARG_FIRSTNAME, firstname)
        bundle.putString(ARG_LASTNAME, lastname)
        bundle.putString(ARG_EMAIL, email)
        bundle.putString(ARG_AVATAR, avatar)

        val transaction = this.supportFragmentManager.beginTransaction()
        val editUserFragment = EditUserFragment()
        editUserFragment.arguments = bundle

        transaction.replace(R.id.edit_user_container, editUserFragment)
        transaction.commit()
    }

    companion object {

        private const val EXTRA_SCREEN_MODE = "extra_mode"
        private const val MODE_EDIT = "mode_edit"

        fun newIntentEditDataUser(context: Context, dataUserId: Int, firstname: String, lastname: String, email: String, avatar: String): Intent {
            val intent = Intent(context, EditUserActivity::class.java)
            intent.putExtra(EXTRA_SCREEN_MODE, MODE_EDIT)
            intent.putExtra(ARG_DATA_USER_ID, dataUserId)
            intent.putExtra(ARG_FIRSTNAME, firstname)
            intent.putExtra(ARG_LASTNAME, lastname)
            intent.putExtra(ARG_EMAIL, email)
            intent.putExtra(ARG_AVATAR, avatar)
            return intent
        }
    }
}