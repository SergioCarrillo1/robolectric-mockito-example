package com.example.robolectrictestexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestViewModel(private val repository: TestRepository) :ViewModel() {

     val productLiveData = MutableLiveData<List<Product>>()

    fun getProducts() {
        val response = repository.getProducts()
        productLiveData.postValue(response)
    }


}