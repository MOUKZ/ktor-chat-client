package com.omarmouki.ktorchat.presentation.chat

import com.omarmouki.ktorchat.domain.model.Message


data class ChatState(
    val messages: List<Message>  = emptyList(),
    val isLoading :Boolean = false ,

)
