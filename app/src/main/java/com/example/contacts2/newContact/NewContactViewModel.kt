package com.example.contacts2.newContact

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.contacts2.database.Contact
import com.example.contacts2.database.ContactDao

class NewContactViewModel(val database: ContactDao, application: Application) :
    AndroidViewModel(application) {


    fun addContact(new: Contact) {
        database.insert(new)
    }

/* ESTO ES PARA LA SCREEN DE NEW CONTACTO

    /**
     * The implementation of insert() in the database is completely hidden from the UI.
     * Room ensures that you're not doing any long running operations on
     * the main thread, blocking the UI, so we don't need to handle changing Dispatchers.
     * ViewModels have a coroutine scope based on their lifecycle called
     * viewModelScope which we can use here.
     */
    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }
}

*/

}