package com.example.example.model.service

import com.example.example.model.DateModel

interface FirestoreService {
    suspend fun getUser(): DateModel?
    suspend fun save(dateModel: DateModel)
}