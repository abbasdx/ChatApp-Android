//package com.example.chatapp_android.data.remote
//
//
//import io.ktor.client.engine.cio.*
//import com.example.chatapp_android.data.remote.dto.MessageDto
//import com.example.chatapp_android.domain.model.Messsage
//import io.ktor.client.*
//import io.ktor.client.request.*
//
//class MessageServiceImpl(
//    private val client: HttpClient
//): MessageService {
//
//    override suspend fun getAllMessages(): List<Messsage> {
//        return try {
//            client.get<List<MessageDto>>(MessageService.Endpoints.GetAllMessages.url)
//                .map { it.toMessage() }
//        } catch (e: Exception) {
//            emptyList()
//        }
//    }
//}

package com.example.chatapp_android.data.remote

import com.example.chatapp_android.data.remote.dto.MessageDto
import com.example.chatapp_android.domain.model.Message
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.call.*

class MessageServiceImpl(
    private val client: HttpClient
) : MessageService {

    override suspend fun getAllMessages(): List<Message> {
        return try {
            client.get(MessageService.Endpoints.GetAllMessages.url)
                .body<List<MessageDto>>() // this properly deserializes the response
                .map { it.toMessage() }
        } catch (e: Exception) {
            emptyList()
        }
    }
}
