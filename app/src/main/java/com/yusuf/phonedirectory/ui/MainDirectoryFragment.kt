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


class MainDirectoryFragment : Fragment() {


    private lateinit var binding: FragmentMainDirectoryBinding

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

        // Toolbar'ın yüksekliğini ayarlayın.
        //binding.toolbar.layoutParams?.height = resources.getDimensionPixelSize(R.dimen.toolbar_height)


        binding.mainDirectoryRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        //adapter

        binding.fab.setOnClickListener {
            val action = MainDirectoryFragmentDirections.actionMainDirectoryFragmentToPhoneInfoFragment(
                Kisiler(0,"",""),0)
            findNavController().navigate(action)
        }


    }


}