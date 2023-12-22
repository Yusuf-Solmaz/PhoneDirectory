package com.yusuf.phonedirectory.data.service

import android.util.Log

interface ContactsService {
    fun saveContact(contactName: String, contactNumber:String)

    fun updateContact(contactName: String, contactNumber:String)
}