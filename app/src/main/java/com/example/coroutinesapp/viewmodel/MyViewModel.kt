package com.example.coroutinesapp.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutinesapp.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {

    private var repository = Repository()

    private var _string = MutableLiveData<String>()
    val string: LiveData<String> = _string

    fun getDataFromRepository() {
        //Coroutine atrelada ao ciclo de vida da view model
        //abre um processo em segundo plano
        viewModelScope.launch(Dispatchers.IO) {
            //coleta os dados emitidos
            repository.getData().collect {
                //coloca o valor do repository
                _string.postValue(it)
            }
        }
    }
}