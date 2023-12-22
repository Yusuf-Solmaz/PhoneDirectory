package com.yusuf.phonedirectory.ui.viewModel

import androidx.lifecycle.ViewModel
import com.yusuf.phonedirectory.data.repository.ContactRepository

class MainDirectoryViewModel : ViewModel() {

    val repo = ContactRepository()
}