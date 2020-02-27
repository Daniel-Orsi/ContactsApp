package com.example.contacts2.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.contacts2.database.ContactDao

class ListViewModel(val database: ContactDao, application: Application) :
    AndroidViewModel(application) {

    val allContacts = database.getAllContacts()


    init {


    }


    fun deleteAll() {
        database.clear()
    }


}