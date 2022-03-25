package com.omarmouki.ktorchat.data.remote

import android.util.Log
import com.omarmouki.ktorchat.data.remote.dto.MessageDto
import com.omarmouki.ktorchat.domain.model.Message
import com.omarmouki.ktorchat.util.Resource
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.lang.Exception

class MessageServiceImpl(
    private val client: HttpClient
): MessageService {

    override suspend fun getAllMessages(): List<Message> {
        return try {
            client.get<List<MessageDto>>(MessageService.Endpoints.GetAllMessages.url)
                .map { it.toMessage() }
        } catch (e: Exception) {
            emptyList()
        }
    }
}