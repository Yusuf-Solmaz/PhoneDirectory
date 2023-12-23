package com.yusuf.phonedirectory.ui.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import com.yusuf.phonedirectory.data.entity.Kisiler
import com.yusuf.phonedirectory.data.repository.ContactRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainDirectoryViewModel @Inject constructor(var repo: ContactRepository) : ViewModel() {

    var contactList = MutableLiveData<List<Kisiler>>()


    fun searchContact(contact:String){
        viewModelScope.launch {
            contactList.value = repo.searchContact(contact).kisiler
        }
    }

    fun deleteContact(kisi_id:Int){
        viewModelScope.launch {
            repo.deleteContact(kisi_id)
            Log.i("delete",repo.deleteContact(kisi_id).message)
            Log.i("deleteViewModel",kisi_id.toString())

            getAllContacts()
        }
    }


     fun getAllContacts(){
         val job = CoroutineScope(Dispatchers.Main).launch {
             contactList.value= repo.getAllContacts().kisiler
         }
    }
}