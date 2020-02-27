package com.example.contacts2.main


import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts2.R
import com.example.contacts2.database.Contact
import com.example.contacts2.database.ContactDatabase
import com.example.contacts2.databinding.FragmentListBinding


class List_Fragment : Fragment() {

    private lateinit var listViewModel: ListViewModel
    private lateinit var list: RecyclerView
    private lateinit var adapter: CustomAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private var contactList: List<Contact> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        //Define el dataSource
        val application = requireNotNull(this.activity).application
//        ContactDatabase.getInstance(application).contactDao

        //Crea instancia de la ViewModelFactory
        val dataSource = ContactDatabase.getInstance(application).contactDao
        val viewModelFactory = ListViewModelFactory(dataSource, application)

        // Get a reference to the ViewModel associated with this fragment.
        listViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(ListViewModel::class.java)


        // Inflate the layout for this fragment and obtain an instance of binding class
        val binding: FragmentListBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_list, container, false
        )

        binding.setLifecycleOwner(this)
        binding.listViewModel = listViewModel


        list = binding.rvList
        list.setHasFixedSize(true)

        layoutManager = LinearLayoutManager(requireContext())
        list.layoutManager = layoutManager


        //observes if the list has changed and passes the list to show
        listViewModel.allContacts.observe(viewLifecycleOwner, Observer { allContacts ->
            contactList = allContacts
            adapter.setContacts(contactList)
        })

        adapter = CustomAdapter(contactList)
        list.adapter = adapter

        list.setOnClickListener(View.OnClickListener {
            val id = getId()

        })



        setHasOptionsMenu(true)
        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu, menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.bt_addContact -> {
                findNavController().navigate(
                    R.id.action_list_to_newContact
                )
                return true
            }

            R.id.btClear -> {
                listViewModel.deleteAll()
                return true
            }

            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    /*
    private fun initSearchOptionMenu(menu: Menu?): Unit {

        //configuracion del boton de busqueda
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val itemBusqueda = menu?.findItem(R.id.app_bar_search)
        val searchView = itemBusqueda?.actionView as SearchView

        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = "buscar contacto..."

        searchView.setOnQueryTextFocusChangeListener { v, hasFocus ->
            //preparar los datos
        }
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                //filtrar datos
                adaptador?.filtrar(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                //filtrar datos
                return true
            }
        })

    }

     */


}
