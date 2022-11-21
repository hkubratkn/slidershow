package com.example.example.ui.model.service

interface LogService {
    fun logNonFatalCrash(throwable: Throwable)
}