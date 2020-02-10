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
import com.example.contacts2.databinding.FragmentListBinding


class List_Fragment : Fragment() {

    private lateinit var listViewModel: ListViewModel

    var lista: RecyclerView? = null
    var adaptador: CustomAdapter? = null
    var layoutManager: RecyclerView.LayoutManager? = null
    var listaParaMostrar: List<Contact> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentListBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_list, container, false
        )

        listViewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)



        lista = binding.rvList
        lista?.setHasFixedSize(true)

        layoutManager = LinearLayoutManager(requireContext())
        lista?.layoutManager = layoutManager



        listViewModel.allContacts.observe(viewLifecycleOwner, Observer { allContacts ->
            listaParaMostrar = allContacts
            adaptador?.setContacts(allContacts)
        })


        adaptador = CustomAdapter(listaParaMostrar)
        lista?.adapter = adaptador

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

            R.id.btDetails -> {
                findNavController().navigate(
                    R.id.action_list_to_details
                )
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
