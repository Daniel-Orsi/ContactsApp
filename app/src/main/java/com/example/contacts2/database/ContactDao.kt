package com.example.contacts2.database

import androidx.lifecycle.LiveData
import androidx.room.*



@Dao
interface ContactDao {

    //Las 3 interacciones que tendré con data van a ser 1-Insertar, 2-actualizar y 3-consultar (Eliminar esta como una Query)

    //1-Especifico una funcion que inserte como fila una Instancia de la clase SleepNight
    @Insert
    fun insert(contact: Contact)

    //2-Especifico una funcion que actualice
    @Update
    fun update(contact: Contact)

    @Delete
    fun delete(contact: Contact)

    //3.1- Especifico una funcion que consulte la fila con el ID key
    @Query("SELECT * from complete_contact_list_table WHERE contactId = :key")
    fun get(key: Long): Contact

    //3.2- Especifico una funcion para borrar todas las filas sin borrar la tabla
    @Query("DELETE FROM complete_contact_list_table")
    fun clear()

    //3.3- Especifico una funcion que me de toda la lista ordenada descendiente por Id
    @Query("SELECT * FROM complete_contact_list_table ORDER BY contactId DESC")
    fun getAllContacts(): LiveData<List<Contact>>

    //3.4- Especifico una funcion que me de la ultima
    @Query("SELECT * FROM complete_contact_list_table ORDER BY contactId DESC LIMIT 1")
    fun getContacts(): List<Contact>


}