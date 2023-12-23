package com.yusuf.phonedirectory.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.yusuf.phonedirectory.R
import com.yusuf.phonedirectory.data.entity.Kisiler
import com.yusuf.phonedirectory.databinding.FragmentMainDirectoryBinding
import com.yusuf.phonedirectory.ui.adapter.MainDirectoryAdapter
import com.yusuf.phonedirectory.ui.viewModel.MainDirectoryViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainDirectoryFragment : Fragment(), SearchView.OnQueryTextListener {


    private lateinit var binding: FragmentMainDirectoryBinding
    private lateinit var adapter: MainDirectoryAdapter


    private lateinit var viewModel: MainDirectoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_directory,container, false)
        binding.phoneMainFragment=this



        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : MainDirectoryViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);


        (activity as? AppCompatActivity)?.setSupportActionBar(binding.toolbar)



        viewModel.getAllContacts()

        viewModel.contactList.observe(viewLifecycleOwner){

            contacts ->

            contacts?.let {
                adapter = MainDirectoryAdapter(viewModel,it,requireContext())

                binding.mainDirectoryRecyclerView.adapter = adapter
            }

        }

        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu,menu)

                val item = menu.findItem(R.id.search)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@MainDirectoryFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }

        },viewLifecycleOwner,Lifecycle.State.RESUMED)

        //binding.mainDirectoryRecyclerView.layoutManager = LinearLayoutManager(requireContext())


        


    }

    override fun onQueryTextSubmit(p0: String?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        viewModel.searchContact(p0!!)
        return true
    }

    fun fabButtonOnClick(){
        val action =
            com.yusuf.phonedirectory.ui.MainDirectoryFragmentDirections.actionMainDirectoryFragmentToPhoneInfoFragment(
                null,
                0
            )
        findNavController().navigate(action)
    }


    override fun onResume() {
        super.onResume()
        viewModel.getAllContacts()
    }
}