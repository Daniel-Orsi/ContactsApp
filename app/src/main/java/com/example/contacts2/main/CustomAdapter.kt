package com.example.contacts2.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts2.R
import com.example.contacts2.database.Contact


class CustomAdapter(contactos: List<Contact>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    var viewHolder: ViewHolder? = null
    var contactos: List<Contact> = arrayListOf()
    var copyContacts: List<Contact> =
        arrayListOf() //esto es una copia de items, que guarda informacion para no sobreescribirla 1.

    init {
        this.contactos = contactos
        this.copyContacts = contactos
    }

    fun setContacts(contactList: List<Contact>) {
        contactos = contactList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista =
            LayoutInflater.from(parent.context).inflate(R.layout.template_contact, parent, false)
        viewHolder = ViewHolder(vista)
        return viewHolder!!
    }

    //regresar el numero de elementos de mi lista (el doble signo !! es para obtener el valor)
    override fun getItemCount(): Int {
        //2- Mapeo de Datos
        return contactos.count()
    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {

        //2- Mapeo de Datos

        val item = contactos.get(position)

        holder.name?.text = item.name
        holder.surname?.text = item.surname
        holder.job?.text = item.job

    }


    //aca defino a la clase ViewHolder que es la encargada de crear el objeto ordenado Nombre,Foto,Empresa
    class ViewHolder(vista: View) : RecyclerView.ViewHolder(vista) {

        var vista = vista

        var name: TextView? = null
        var surname: TextView? = null
        var job: TextView? = null

        init {
            name = vista.findViewById(R.id.tv_contact_name)
            surname = vista.findViewById(R.id.tv_contact_surname)
            job = vista.findViewById(R.id.tv_contact_job)

        }


    }

    /*
    fun filtrar(str:String){
        contactos.clear()

        if(str.isEmpty()){
            contactos = ArrayList(copyContacts) //vuelvo a crear una lista de los items originales si esta vacio, o sea que ingresa texto  elimina
            notifyDataSetChanged()
            return
        }
        var busqueda = str
        busqueda = busqueda.toLowerCase()      //todo a minuscula lo paso

        for(item in copyContacts){
            val nombre = item.name.toLowerCase()
            if(nombre.contains(busqueda)){
                contactos.add(item)
            }
        }
        notifyDataSetChanged()
    }

*/


}


