package com.example.homework9.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.homework9.Constants.Companion.ARG_AVATAR
import com.example.homework9.Constants.Companion.ARG_DATA_USER_ID
import com.example.homework9.Constants.Companion.ARG_EMAIL
import com.example.homework9.Constants.Companion.ARG_FIRSTNAME
import com.example.homework9.Constants.Companion.ARG_LASTNAME
import com.example.homework9.R
import com.example.homework9.model.DataUser
import com.example.homework9.viewmodel.EditActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_edit_user.*

@AndroidEntryPoint
class EditUserFragment : Fragment() {

    private lateinit var viewModel: EditActivityViewModel
    private var dataUserId = -1
    private lateinit var avatar: String


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_edit_user,
            container, false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataUserId = arguments?.getInt(ARG_DATA_USER_ID) ?: -1
        avatar = arguments?.getString(ARG_AVATAR).toString()
        Log.d("logging", "edit user # $dataUserId")

        setContent()
        viewModel = ViewModelProvider(this).get(EditActivityViewModel::class.java)
        btn_delete_user.setOnClickListener {
            Log.d("logging", "delete user")
            viewModel.deleteRecord(viewModel.getDataUserById(dataUserId!!))
            Toast.makeText(context, "User deleted", Toast.LENGTH_SHORT).show()
            requireActivity().finish()
        }
        btn_save_user.setOnClickListener {
            Log.d("logging", "update user")
            updateUser()
            requireActivity().finish()
            Toast.makeText(context, "User updated", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setContent() {
        first_name_edit_text.setText(arguments?.getString(ARG_FIRSTNAME))
        last_name_edit_text.setText(arguments?.getString(ARG_LASTNAME))
        email_edit_text.setText(arguments?.getString(ARG_EMAIL))
    }

    private fun updateUser() {
        val firstname = first_name_edit_text.text.toString()
        val lastname = last_name_edit_text.text.toString()
        val email = email_edit_text.text.toString()
        val user = DataUser(
            first_name = firstname,
            last_name = lastname,
            email = email,
            id = dataUserId,
            avatar = avatar
        )
        viewModel.updateRecord(user)
    }
}