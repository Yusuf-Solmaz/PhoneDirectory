package com.yusuf.phonedirectory.ui

import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.yusuf.phonedirectory.R
import com.yusuf.phonedirectory.databinding.FragmentPhoneInfoBinding

class PhoneInfoFragment : Fragment() {

    private lateinit var binding: FragmentPhoneInfoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_phone_info,container,false)
        binding.phoneInfoFragment = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle : com.yusuf.phonedirectory.ui.PhoneInfoFragmentArgs by navArgs()

        when (bundle.info){
            0 -> {
                binding.Save.visibility = Button.VISIBLE
                binding.update.visibility = Button.GONE
                binding.editTextContactName.isEnabled = true
                binding.toolbarPhoneInfo.isEnabled = true
            }

            1 -> {
                binding.update.visibility = Button.VISIBLE
                binding.Save.visibility = Button.GONE
                binding.editTextContactName.isEnabled = false
                binding.toolbarPhoneInfo.isEnabled = false

                binding.editTextContactName.text = Editable.Factory.getInstance().newEditable(bundle.kisi!!.kisi_ad)
                binding.editTextContactNu.text = Editable.Factory.getInstance().newEditable(bundle.kisi!!.kisi_tel)

            }

        }
    }


    fun saveContact(contactName: String, contactNumber:String){
        Log.e("saveInfo", contactName + contactNumber)
    }

    fun updateContact(contactName: String, contactNumber:String){
        Log.e("saveInfo", contactName + contactNumber)
    }


}

