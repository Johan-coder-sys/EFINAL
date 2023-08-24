package com.example.efinal.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.efinal.data.core.RetrofitClient
import com.example.efinal.model.Digimon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListViewModel: ViewModel() {
    private var _listaDigimons = MutableLiveData<List<Digimon>>()
    val listaDigimons: LiveData<List<Digimon>> get() =_listaDigimons

    fun obtenerDigimons(){
        viewModelScope.launch(Dispatchers.IO){
            val reponse = RetrofitClient.webService.obtenerDigimons()
            withContext(Dispatchers.Main){
                _listaDigimons.value=reponse.body()
            }
        }
    }

}