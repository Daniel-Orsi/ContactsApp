package com.example.contacts2.newContact


import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.contacts2.R
import com.example.contacts2.databinding.FragmentNewContactBinding

/**
 * A simple [Fragment] subclass.
 */
class NewContact : Fragment() {

    private lateinit var newContactViewModel: NewContactViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentNewContactBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_new_contact, container, false
        )

        newContactViewModel = ViewModelProviders.of(this).get(NewContactViewModel::class.java)


        setHasOptionsMenu(true)

        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.new_contact_menu, menu)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.bt_save -> {

                //aca debería decir que me arme un Contacto con lo datos de los editText del xml
                //luego los mande al ViewModel


                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

}
