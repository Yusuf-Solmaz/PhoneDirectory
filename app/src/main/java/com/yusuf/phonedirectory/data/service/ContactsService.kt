package com.yusuf.phonedirectory.data.service

import android.util.Log
import com.yusuf.phonedirectory.data.entity.CRUDResult
import com.yusuf.phonedirectory.data.entity.Kisiler
import com.yusuf.phonedirectory.data.entity.ResultKisiler
import retrofit2.Call
import java.util.ArrayList

interface ContactsService {
    suspend fun insertContact(contactName: String, contactNumber:String) : CRUDResult

    suspend fun updateContact(contactId:Int,contactName: String, contactNumber:String) : CRUDResult

    suspend fun searchContact(contact:String) : ResultKisiler

    suspend fun deleteContact(kisi_id:Int) : CRUDResult

    suspend fun getAllContacts() : ResultKisiler
}