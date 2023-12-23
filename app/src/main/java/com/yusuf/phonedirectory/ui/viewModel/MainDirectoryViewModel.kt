package com.yusuf.phonedirectory.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yusuf.phonedirectory.data.entity.Kisiler
import com.yusuf.phonedirectory.data.repository.ContactRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainDirectoryViewModel @Inject constructor(var repo: ContactRepository) : ViewModel() {

    var contactList = MutableLiveData<List<Kisiler>>()


    fun searchContact(query:String){
        repo.searchContact(query)
    }

    fun deleteContact(id:Int){
        repo.deleteContact(id)
    }

    fun getAllContacts(){
        contactList.value= repo.getAllContacts()
    }
}