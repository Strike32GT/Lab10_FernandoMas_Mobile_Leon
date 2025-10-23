package com.mas.semana10_servicios.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mas.semana10_servicios.data.model.User
import com.mas.semana10_servicios.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class UserUIState {
    object Loading : UserUIState()
    data class Success(val users: List<User>) : UserUIState()
    data class Error(val message: String) : UserUIState()

}
    class UserViewModel : ViewModel(){

        private val repository = UserRepository()

        private val _uiState = MutableStateFlow<UserUIState>(UserUIState.Loading)

        val uiState: StateFlow<UserUIState> = _uiState

        init{
            loadUsers()
        }

        fun loadUsers(){
            viewModelScope.launch {
                _uiState.value= UserUIState.Loading

                try {
                    val users=repository.getUsers()
                    _uiState.value= UserUIState.Success(users)
                }catch (e: Exception){
                    _uiState.value= UserUIState.Error(
                        e.message ?: "Error desconocido al cargar usuarios"
                    )
                }
            }
        }
    }
