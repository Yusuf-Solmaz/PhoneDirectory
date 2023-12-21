package com.yusuf.phonedirectory.ui

import android.os.Build
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.navArgs
import com.yusuf.phonedirectory.R
import com.yusuf.phonedirectory.databinding.FragmentPhoneInfoBinding

class PhoneInfoFragment : Fragment() {

    private lateinit var binding: FragmentPhoneInfoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentPhoneInfoBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle : PhoneInfoFragmentArgs by navArgs()

        when (bundle.info){
            0 -> {
                binding.Save.visibility = Button.VISIBLE
                binding.editTextContactName.isEnabled = true
                binding.toolbarPhoneInfo.isEnabled = true
            }

            1 -> {
                binding.Save.visibility = Button.INVISIBLE
                binding.editTextContactName.isEnabled = false
                binding.toolbarPhoneInfo.isEnabled = false

                binding.editTextContactName.text = Editable.Factory.getInstance().newEditable(bundle.kisi.kisi_ad)
                binding.editTextContactNu.text = Editable.Factory.getInstance().newEditable(bundle.kisi.kisi_tel)

            }

        }
    }

}