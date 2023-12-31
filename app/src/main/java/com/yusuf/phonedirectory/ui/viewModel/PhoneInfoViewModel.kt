package com.yusuf.phonedirectory.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusuf.phonedirectory.data.repository.ContactRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhoneInfoViewModel @Inject constructor(var repo: ContactRepository) : ViewModel() {



    fun saveContact(contactName: String, contactNumber: String){
        viewModelScope.launch {
            repo.insertContact(contactName, contactNumber)
        }

    }


    fun updateContact(contactId:Int,contactName: String, contactNumber: String){
        viewModelScope.launch {
            repo.updateContact(contactId, contactName, contactNumber)
            Log.i("updateNew","${contactId} ${contactName.toString()} ${contactNumber }")

        }
        }
    }

