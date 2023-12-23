package com.yusuf.phonedirectory.data.repository

import android.util.Log
import com.yusuf.phonedirectory.data.api.ContactsApi
import com.yusuf.phonedirectory.data.entity.CRUDResult
import com.yusuf.phonedirectory.data.entity.ResultKisiler
import com.yusuf.phonedirectory.data.service.ContactsService

class ContactRepository (val api:ContactsApi) : ContactsService  {
    override suspend fun insertContact(contactName: String, contactNumber: String): CRUDResult {
        return api.insertContact(contactName,contactNumber)
    }

    override suspend fun updateContact(contactName: String, contactNumber: String): CRUDResult {
        TODO("Not yet implemented")
    }


    override suspend fun searchContact(contact: String): ResultKisiler {
        return api.searchContact(contact)
    }

    override suspend fun deleteContact(kisi_id: Int): CRUDResult {
        Log.i("deleteRepo",kisi_id.toString())
        return api.deleteContact(kisi_id)
    }


    override suspend fun getAllContacts() : ResultKisiler {

        Log.i("getAllContacts", api.getAllContacts().kisiler.toString())
        return api.getAllContacts()
    }
}