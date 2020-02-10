package com.example.contacts2.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "complete_contact_list_table")
data class ContactListTable(

    @PrimaryKey(autoGenerate = true)
    var contactId: Long = 0L,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "surname")
    val surname: String,

    @ColumnInfo(name = "job")
    val job: String,

    @ColumnInfo(name = "tel")
    val tel: String,

    @ColumnInfo(name = "eMail")
    val eMail: String,

    @ColumnInfo(name = "adress")
    val adress: String


)