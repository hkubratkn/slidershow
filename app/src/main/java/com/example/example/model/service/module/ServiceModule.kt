package com.example.example.model.service.module

import com.example.example.model.service.FirestoreService
import com.example.example.model.service.impl.FirestoreServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModule {

    @Binds abstract fun provideFirestoreService(impl: FirestoreServiceImpl): FirestoreService
}