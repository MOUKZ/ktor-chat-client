package com.omarmouki.ktorchat.presentation.username

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserNameViewModel @Inject constructor(
): ViewModel(){
    private val _usernameText = mutableStateOf("")
     val  usernameText: State <String> = _usernameText

    private val _onJoinChat = MutableSharedFlow<String>()
    val onJoinChat = _onJoinChat.asSharedFlow()


    fun onUsernameChange(newUsername:String){
        _usernameText.value = newUsername
    }
    fun onJoinClick(){
        viewModelScope.launch{
            if(_usernameText.value.isNotBlank()){
                _onJoinChat.emit(_usernameText.value)
            }

        }
    }

}