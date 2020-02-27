package com.example.contacts2.details


import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.contacts2.R
import com.example.contacts2.database.Contact
import com.example.contacts2.database.ContactDatabase
import com.example.contacts2.databinding.FragmentDetailsBinding


/**
 * A simple [Fragment] subclass.
 */
class Details : Fragment() {

    private lateinit var detailsViewModel: DetailsViewModel


    lateinit var showContact: Contact


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentDetailsBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_details, container, false
        )

        binding.lifecycleOwner = this

        // Associate ViewModel with this fragment

        detailsViewModel = ViewModelProviders.of(this).get(DetailsViewModel::class.java)


        // Conexion con ViewModel y Datasource

        val applicacion = requireNotNull(this.activity).application
        ContactDatabase.getInstance(applicacion).contactDao

        val dataSource = ContactDatabase.getInstance(applicacion).contactDao

        val detailsViewModel = ViewModelProviders.of(this).get(DetailsViewModel::class.java)

        // binding.detailsViewModel = detailsViewModel

//        DetailsViewModel.showContactLv.observe(viewLifecycleOwner, Observer { showContactLv ->
//            showContact = showContactLv
//
//        })

        var showContact: Contact = DetailsViewModel.getContactForShow(contacId)

        binding.tvNombre.text = showContact.name
        binding.tvApellido.text = showContact.surname
        binding.tvEmpresa.text = showContact.job
        binding.tvTelefono.text = showContact.tel
        binding.tvEmail.text = showContact.eMail
        binding.tvDireccion.text = showContact.adress


        setHasOptionsMenu(true)

        return binding.root


    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.details_menu, menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.bt_delete -> {

                DetailsViewModel.deleteContact(contactId)

                findNavController().navigate(R.id.action_details_to_list)
                return true
            }

            R.id.bt_edit -> {

                //te lleva al menu NUEvo pero con los campos llenos de info, y podes editarlos
                return true
            }

            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }
}

