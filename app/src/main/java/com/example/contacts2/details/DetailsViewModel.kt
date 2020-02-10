package com.example.contacts2.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.contacts2.database.ContactDatabase
import com.example.contacts2.main.Contact


class DetailsViewModel(
    val database: ContactDatabase,
    application: Application
) : AndroidViewModel(application) {


    lateinit var contacto: Contact
    private val _contactoLv = MutableLiveData<Contact>()
    val contactoLv: LiveData<Contact> get() = _contactoLv


    init {
        contacto = Contact("Daniel", "Orsi", "Freelance", "Adrogue", "58852", "daniel@ho.com")

        _contactoLv.postValue(contacto)


    }


}

