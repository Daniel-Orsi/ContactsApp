package com.example.contacts2.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "complete_contact_list_table")
data class Contact(

    @PrimaryKey(autoGenerate = true)
    var contactId: Long = 0L,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "surname")
    var surname: String,

    @ColumnInfo(name = "job")
    var job: String,

    @ColumnInfo(name = "adress")
    var adress: String,

    @ColumnInfo(name = "tel")
    var tel: String,

    @ColumnInfo(name = "eMail")
    var eMail: String
)