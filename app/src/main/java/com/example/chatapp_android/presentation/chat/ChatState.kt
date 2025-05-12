package com.example.chatapp_android.presentation.chat

import com.example.chatapp_android.domain.model.Message


data class ChatState(
    val messages: List<Message> = emptyList(),
    val isLoading: Boolean = false
)