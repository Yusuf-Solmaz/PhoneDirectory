package com.yusuf.phonedirectory.data.service

import android.util.Log
import com.yusuf.phonedirectory.data.entity.Kisiler
import java.util.ArrayList

interface ContactsService {
    fun saveContact(contactName: String, contactNumber:String)

    fun updateContact(contactName: String, contactNumber:String)

    fun searchContact(query:String)

    fun deleteContact(id:Int)

    fun getAllContacts() : List<Kisiler>
}