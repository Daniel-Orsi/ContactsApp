package com.example.contacts2.details


import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.contacts2.R
import com.example.contacts2.database.ContactDatabase
import com.example.contacts2.databinding.FragmentDetailsBinding
import com.example.contacts2.main.Contact

/**
 * A simple [Fragment] subclass.
 */
class Details : Fragment() {

    private lateinit var detailsViewModel: DetailsViewModel


    lateinit var contacto: Contact


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
        ContactDatabase.getInstance(applicacion).contactDao()

        val dataSource = ContactDatabase.getInstance(applicacion).contactDao()

        val detailsViewModel = ViewModelProviders.of(this).get(DetailsViewModel::class.java)

        // binding.detailsViewModel = detailsViewModel

//        DetailsViewModel.contactoLv.observe(viewLifecycleOwner, Observer { contactLv ->
//            contacto = contactLv
//
//        })
//
//        binding.tvNombre.text = contacto.name
//        binding.tvApellido.text = contacto.surname
//        binding.tvEmpresa.text = contacto.job
//        binding.tvTelefono.text = contacto.tel
//        binding.tvEmail.text = contacto.email
//        binding.tvDireccion.text = contacto.adress


        setHasOptionsMenu(true)

        return binding.root


    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.details_menu, menu)
    }
}

