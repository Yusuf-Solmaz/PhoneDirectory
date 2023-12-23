package com.yusuf.phonedirectory.data.service

import android.util.Log
import com.yusuf.phonedirectory.data.entity.CRUDResult
import com.yusuf.phonedirectory.data.entity.Kisiler
import com.yusuf.phonedirectory.data.entity.ResultKisiler
import retrofit2.Call
import java.util.ArrayList

interface ContactsService {
    fun saveContact(contactName: String, contactNumber:String)

    fun updateContact(contactName: String, contactNumber:String)

    suspend fun searchContact(contact:String) : ResultKisiler

    suspend fun deleteContact(kisi_id:Int) : CRUDResult

    suspend fun getAllContacts() : ResultKisiler
}