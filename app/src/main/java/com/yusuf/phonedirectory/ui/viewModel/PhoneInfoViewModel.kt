package com.yusuf.phonedirectory.ui.viewModel

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


    fun updateContact(contactName: String, contactNumber: String){

    }

}