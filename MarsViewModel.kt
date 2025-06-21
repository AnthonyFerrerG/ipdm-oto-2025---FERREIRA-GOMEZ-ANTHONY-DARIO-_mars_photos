package com.example.marsgallery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marsgallery.model.MarsPhoto
import com.example.marsgallery.network.MarsApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MarsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<List<MarsPhoto>>(emptyList())
    val uiState: StateFlow<List<MarsPhoto>> = _uiState

    init {
        fetchPhotos()
    }

    private fun fetchPhotos() {
        viewModelScope.launch {
            try {
                val listResult = MarsApi.retrofitService.getPhotos()
                _uiState.value = listResult
            } catch (e: Exception) {
                _uiState.value = emptyList()
            }
        }
    }
}
