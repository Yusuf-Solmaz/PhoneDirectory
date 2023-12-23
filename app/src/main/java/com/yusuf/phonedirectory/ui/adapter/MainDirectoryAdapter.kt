package com.yusuf.phonedirectory.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.yusuf.phonedirectory.data.entity.Kisiler
import com.yusuf.phonedirectory.databinding.FragmentMainDirectoryBinding
import com.yusuf.phonedirectory.databinding.MainDirectoryRecyclerViewRowBinding
import com.yusuf.phonedirectory.ui.MainDirectoryFragmentDirections
import com.yusuf.phonedirectory.ui.viewModel.MainDirectoryViewModel

class MainDirectoryAdapter(val viewModel:MainDirectoryViewModel,private val contacts: List<Kisiler>, val context:Context) : RecyclerView.Adapter<MainDirectoryAdapter.MainDirectoryHolder>()  {

    class MainDirectoryHolder(val binding: MainDirectoryRecyclerViewRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainDirectoryHolder {
        val itemBinding = MainDirectoryRecyclerViewRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MainDirectoryHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: MainDirectoryHolder, position: Int) {
        holder.binding.contactsNfo.text = "${contacts[position].kisi_ad} - ${contacts[position].kisi_tel}"

        holder.binding.contactsCardView.setOnClickListener {
            val action = MainDirectoryFragmentDirections.actionMainDirectoryFragmentToPhoneInfoFragment(contacts[position],1)
            holder.binding.root.findNavController().navigate(action)

        }

        holder.binding.imageView.setOnClickListener {
            Snackbar.make(it,"${contacts[position].kisi_ad} Will Delete!",Snackbar.LENGTH_LONG)
                .setAction("Yes!"){
                    viewModel.deleteContact(contacts[position].kisi_id)
                   // Log.i("id",contacts[position].kisi_id.toString())
                }.show()
        }
    }

}

