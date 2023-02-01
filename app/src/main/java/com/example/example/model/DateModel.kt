package com.example.example.model

import com.google.firebase.Timestamp
import com.google.firebase.firestore.ServerTimestamp

data class DateModel (
    @ServerTimestamp
    val date: Timestamp? = null
)