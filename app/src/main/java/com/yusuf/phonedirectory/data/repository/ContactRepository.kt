package com.yusuf.phonedirectory.data.repository

import android.util.Log
import com.yusuf.phonedirectory.data.entity.Kisiler
import com.yusuf.phonedirectory.data.service.ContactsService

class ContactRepository : ContactsService  {

    override fun saveContact(contactName: String, contactNumber: String) {
        Log.i("saveInfo","$contactName   $contactNumber")
    }

    override fun updateContact(contactName: String, contactNumber: String) {
        Log.i("updateInfo","$contactName   $contactNumber")
    }
}