package com.yusuf.phonedirectory.ui.viewModel

import androidx.lifecycle.ViewModel
import com.yusuf.phonedirectory.data.repository.ContactRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PhoneInfoViewModel @Inject constructor(var repo: ContactRepository) : ViewModel() {



    fun saveContact(contactName: String, contactNumber: String){
        repo.saveContact(contactName, contactNumber)
    }


    fun updateContact(contactName: String, contactNumber: String){
        repo.updateContact(contactName, contactNumber)
    }

}