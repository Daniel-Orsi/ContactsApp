package com.example.contacts2.database

import androidx.lifecycle.LiveData
import com.example.contacts2.main.Contact

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class ContactRepository(private val contactDao: ContactDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allContacts: LiveData<List<Contact>> = contactDao.getAllContacts()

    suspend fun insert(newContact: Contact) {
        contactDao.insert(newContact)
    }

}
