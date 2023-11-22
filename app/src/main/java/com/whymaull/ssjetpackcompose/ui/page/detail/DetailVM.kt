package com.whymaull.ssjetpackcompose.ui.page.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.whymaull.ssjetpackcompose.data.local.PhoneEntity
import com.whymaull.ssjetpackcompose.data.repository.Repository
import com.whymaull.ssjetpackcompose.utils.StateUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class DetailVM (private val reps : Repository) : ViewModel() {

    private val _phone = MutableStateFlow<StateUi<PhoneEntity>>(StateUi.Load)
    val phone = _phone.asStateFlow()

    fun getPhone(id : Int){
        viewModelScope.launch(Dispatchers.IO){
            reps.getPhone(id)
                .catch { _phone.value = StateUi.Error(it.message.toString()) }
                .collect{ _phone.value = StateUi.Success(it) }
        }
    }

    fun updateFavPhone(id: Int, isFav : Boolean){
        viewModelScope.launch(Dispatchers.IO){
            reps.updateFavPhone(id, isFav)
        }
    }
}