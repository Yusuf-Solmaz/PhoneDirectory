package com.yusuf.phonedirectory.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.yusuf.phonedirectory.data.entity.Kisiler
import com.yusuf.phonedirectory.data.service.ContactsService
import java.util.ArrayList

class ContactRepository : ContactsService  {

    override fun saveContact(contactName: String, contactNumber: String) {
        Log.i("saveInfo","$contactName   $contactNumber")
    }

    override fun updateContact(contactName: String, contactNumber: String) {
        Log.i("updateInfo","$contactName   $contactNumber")
    }

    override fun searchContact(query: String) {
        Log.i("updateInfo","$query")
    }

    override fun deleteContact(id: Int) {
        Log.i("deleteInfo","$id")
    }

    override fun getAllContacts() : List<Kisiler>{
        Log.i("getAllContacts", "done")

        var contacts = ArrayList<Kisiler>()

        val kisi1 = Kisiler(1, "Yusuf", "05340334335")
        val kisi2 = Kisiler(2, "Erkam", "053404513335")

        contacts.add(kisi1)
        contacts.add(kisi2)

        return contacts
    }
}