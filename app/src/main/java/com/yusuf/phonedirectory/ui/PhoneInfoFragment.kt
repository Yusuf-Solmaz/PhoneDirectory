package com.yusuf.phonedirectory.ui

import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.yusuf.phonedirectory.R
import com.yusuf.phonedirectory.databinding.FragmentPhoneInfoBinding
import com.yusuf.phonedirectory.ui.viewModel.PhoneInfoViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PhoneInfoFragment : Fragment() {

    private lateinit var binding: FragmentPhoneInfoBinding
    private lateinit var viewModel: PhoneInfoViewModel
    private  var id: Int? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_phone_info,container,false)
        binding.phoneInfoFragment = this


        (activity as? AppCompatActivity)?.setSupportActionBar(binding.toolbarPhoneInfo)


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel : PhoneInfoViewModel by viewModels()
        viewModel = tempViewModel



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.back_menu,menu)

                val item = menu.findItem(R.id.backArrow)

            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {

                when(menuItem.itemId){
                     R.id.backArrow->{
                         val action = PhoneInfoFragmentDirections.actionPhoneInfoFragmentToMainDirectoryFragment()
                         findNavController().navigate(action)
                         return true
                    }
                }
                return true
            }

        },viewLifecycleOwner,Lifecycle.State.RESUMED)


        val bundle : com.yusuf.phonedirectory.ui.PhoneInfoFragmentArgs by navArgs()




        when (bundle.info){
            0 -> {
                binding.Save.visibility = Button.VISIBLE
                binding.update.visibility = Button.GONE
                binding.editTextContactName.isEnabled = true
                binding.toolbarPhoneInfo.isEnabled = true
            }

            1 -> {

                bundle.kisi.let {
                    id = it!!.kisi_id
                }


                binding.update.visibility = Button.VISIBLE
                binding.Save.visibility = Button.GONE
                binding.editTextContactName.isEnabled = true
                binding.toolbarPhoneInfo.isEnabled = false

                binding.editTextContactName.text = Editable.Factory.getInstance().newEditable(bundle.kisi!!.kisi_ad)
                binding.editTextContactNu.text = Editable.Factory.getInstance().newEditable(bundle.kisi!!.kisi_tel)



                binding.update.setOnClickListener {
                    viewModel.updateContact(id!!,binding.editTextContactName.text.toString(),binding.editTextContactNu.text.toString())
                    Log.i("name",binding.editTextContactName.toString())
                    goToMainDirectoryFragment()
                }
            }

        }




    }


    fun saveContact(contactName: String, contactNumber:String){
        viewModel.saveContact(contactName, contactNumber)
        goToMainDirectoryFragment()
    }

    /*fun updateContact(id:Int,contactName: String, contactNumber:String){
        viewModel.updateContact(id,contactName, contactNumber)
        goToMainDirectoryFragment()
    }*/

    private fun goToMainDirectoryFragment(){
        val action = PhoneInfoFragmentDirections.actionPhoneInfoFragmentToMainDirectoryFragment()
        findNavController().navigate(action)
    }

}

