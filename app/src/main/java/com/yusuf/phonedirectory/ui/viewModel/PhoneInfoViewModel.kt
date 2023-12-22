package com.yusuf.phonedirectory.ui.viewModel

import androidx.lifecycle.ViewModel
import com.yusuf.phonedirectory.data.repository.ContactRepository

class PhoneInfoViewModel : ViewModel() {

    private var repo = ContactRepository()

    fun saveContact(contactName: String, contactNumber: String){
        repo.saveContact(contactName, contactNumber)
    }


    fun updateContact(contactName: String, contactNumber: String){
        repo.updateContact(contactName, contactNumber)
    }

}