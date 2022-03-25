package com.omarmouki.ktorchat.data.remote

import com.omarmouki.ktorchat.domain.model.Message
import com.omarmouki.ktorchat.util.Resource


interface MessageService {

    suspend fun getAllMessages(): List<Message>

    companion object {
        const val BASE_URL = "http://192.168.1.7:8080"
    }

    sealed class Endpoints(val url: String) {
        object GetAllMessages: Endpoints("$BASE_URL/messages")
    }
}

//10.0.2.2
//const val BASE_URL ="http://192.168.1.7:8080"