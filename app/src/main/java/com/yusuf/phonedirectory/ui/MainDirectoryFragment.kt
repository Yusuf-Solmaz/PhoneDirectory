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


class MainDirectoryFragment : Fragment(), SearchView.OnQueryTextListener {


    private lateinit var binding: FragmentMainDirectoryBinding
    private lateinit var adapter: MainDirectoryAdapter
    private lateinit var contacts: MutableList<Kisiler>

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

       contacts = mutableListOf()

        val kisi1 = Kisiler(1,"Yusuf","05340334335")
        val kisi2 = Kisiler(1,"Erkam","053404513335")

        contacts.add(kisi1)
        contacts.add(kisi2)

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

        adapter = MainDirectoryAdapter(contacts,requireContext())

        binding.mainDirectoryRecyclerView.adapter = adapter
        


    }

    override fun onQueryTextSubmit(p0: String?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        Log.e("info",p0.toString())
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

}