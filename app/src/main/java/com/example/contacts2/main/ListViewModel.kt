package com.example.contacts2.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.contacts2.database.ContactDatabase
import com.example.contacts2.database.ContactRepository

class ListViewModel(
    val database: ContactDatabase,
    application: Application
) : AndroidViewModel(application) {

    // The ViewModel maintains a reference to the repository to get data.
    private val repository: ContactRepository
    // LiveData gives us updated words when they change.
    val allContacts: LiveData<List<Contact>>

    init {
        // Gets reference to WordDao from WordRoomDatabase to construct
        // the correct WordRepository.
        val contactDao = ContactDatabase.getInstance(application).contactDao()
        repository = ContactRepository(contactDao)
        allContacts = repository.allContacts
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

//    val contactos : ArrayList<Contact>  = arrayListOf()
//    private val _contactLv = MutableLiveData<List <Contact> >()
//    val contactLv: LiveData<List <Contact> > get() = _contactLv
//
//
//
//    init {
//
//
//
//
//        contactos.add(Contact("Daniel","Orsi","Microsoft","Adrogue","58852","daniel@ho.com"))
//        contactos.add(Contact("Jose","Gomez","Carrier","Burzaco","585520","Jose@ho.com"))
//        contactos.add(Contact("Julieta","Ramirez","AR","Temperley","654789","julieta@ho.com"))
//        contactos.add(Contact("Martin","Smith","J&Smith","CABA","652033","martin@ho.com"))
//        contactos.add(Contact("Rodolfo","Burton","Burton","Lomas","652033","rodolf@ho.com"))
//        contactos.add(Contact("Laura","Aldet","Company_Baby","CABA","588854555","laurita@ho.com"))
//        contactos.add(Contact("Florencia","Robles","Freelance","CABA","778555566666","flor@ho.com"))
//
//        _contactLv.postValue(contactos)
//
//
//
//    }


}