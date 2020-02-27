package com.example.contacts2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Contact::class], version = 1, exportSchema = false)
abstract class ContactDatabase : RoomDatabase() {

    //Asocio el DAO que es el unico que tengo en esta app
    abstract val contactDao: ContactDao

    //Permite que los clientes accedan  a los metodos para crear u obtener la database sin instanciar la clase
    companion object {

        @Volatile
        private var INSTANCE: ContactDatabase? = null

        fun getInstance(context: Context): ContactDatabase {
            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDatabase::class.java,
                        "contact_list_database"
                    )

                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries() //chequear esto porque sino no anda
                        .build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}
/*

el sincronizado es para que solo pueda ser inicializado 1 vez el database al mismo tiempo, en esta app no pasará igualmente
el Room.databaseBuilder es el que crea el Room, de tipo SleepDatabase Class con el nombre "sleepy_history_database"

 */

