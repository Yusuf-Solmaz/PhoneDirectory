package com.yusuf.phonedirectory.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.yusuf.phonedirectory.R
import com.yusuf.phonedirectory.data.entity.Kisiler
import com.yusuf.phonedirectory.databinding.FragmentMainDirectoryBinding
import com.yusuf.phonedirectory.ui.adapter.MainDirectoryAdapter


class MainDirectoryFragment : Fragment() {


    private lateinit var binding: FragmentMainDirectoryBinding
    private lateinit var adapter: MainDirectoryAdapter
    private lateinit var contacts: MutableList<Kisiler>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainDirectoryBinding.inflate(inflater, container, false)



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as? AppCompatActivity)?.setSupportActionBar(binding.toolbar)

       contacts = mutableListOf()

        val kisi1 = Kisiler(1,"Yusuf","05340334335")
        val kisi2 = Kisiler(1,"Erkam","053404513335")

        contacts.add(kisi1)
        contacts.add(kisi2)

        binding.mainDirectoryRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = MainDirectoryAdapter(contacts,requireContext())

        binding.mainDirectoryRecyclerView.adapter = adapter

        binding.fab.setOnClickListener {
            val action = MainDirectoryFragmentDirections.actionMainDirectoryFragmentToPhoneInfoFragment(
                Kisiler(0,"",""),0)
            findNavController().navigate(action)
        }


    }


}