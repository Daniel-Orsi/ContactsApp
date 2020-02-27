package com.example.contacts2.newContact


import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.contacts2.R
import com.example.contacts2.database.Contact
import com.example.contacts2.database.ContactDatabase
import com.example.contacts2.databinding.FragmentNewContactBinding

/**
 * A simple [Fragment] subclass.
 */
class New_Fragment : Fragment() {

    private lateinit var newContactViewModel: NewContactViewModel
    private lateinit var newBinding: FragmentNewContactBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Define el dataSource
        val application = requireNotNull(this.activity).application
        ContactDatabase.getInstance(application).contactDao

        //Crea instancia de la ViewModelFactory
        val dataSource = ContactDatabase.getInstance(application).contactDao
        val viewModelFactory = NewContactViewModelFactory(dataSource, application)

        // Get a reference to the ViewModel associated with this fragment.
        newContactViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(NewContactViewModel::class.java)


        // Inflate the layout for this fragment
        newBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_new_contact,
            container,
            false
        )
//
//        newContactViewModel = ViewModelProviders.of(this).get(NewContactViewModel::class.java)
//
//
        setHasOptionsMenu(true)
        return newBinding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.new_contact_menu, menu)


    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.bt_save -> {
                val name = newBinding.etName
                val surname = newBinding.etSurname
                val job = newBinding.etJob
                val tel = newBinding.etTel
                val email = newBinding.etEmail
                val adress = newBinding.etAdress

                var datos = ArrayList<String>()
                datos.add(name.text.toString())         //pos 0
                datos.add(surname.text.toString())      //pos 1
                datos.add(job.text.toString())          //pos 2
                datos.add(tel.text.toString())          //pos 3
                datos.add(email.text.toString())        //pos 4
                datos.add(adress.text.toString())       //pos 5

                newContactViewModel.addContact(
                    Contact(
                        0L,
                        datos.get(0),
                        datos.get(1),
                        datos.get(2),
                        datos.get(5),
                        datos.get(3),
                        datos.get(4)
                    )
                )

                findNavController().navigate(R.id.action_newContact_to_list)

                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

}
