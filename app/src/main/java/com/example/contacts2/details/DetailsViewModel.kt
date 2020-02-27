package com.example.contacts2.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.contacts2.database.Contact
import com.example.contacts2.database.ContactDatabase


class DetailsViewModel(
    val database: ContactDatabase,
    application: Application
) : AndroidViewModel(application) {


    var contacId = 0L //esta id tiene que pasarla el list cuando tocas un contacto
    lateinit var showContact: Contact
    lateinit var contactToDelete: Contact

//    private val _showContactLv : MutableLiveData<Contact>
//    val showContactLv: LiveData<Contact> get() = _showContactLv



    init {

//        _showContactLv = database.contactDao.get(contacId)


    }

    fun getContactForShow(contactId: Long): Contact {
        showContact = database.contactDao.get(contactId)

        return showContact
    }

    fun deleteContact(contactId: Long) {
        contactToDelete = getContactForShow(contactId)
        database.contactDao.delete(contactToDelete)
    }





}

