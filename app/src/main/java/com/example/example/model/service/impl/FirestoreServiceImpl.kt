package com.example.example.model.service.impl

import android.net.Uri
import com.example.example.model.DateModel
import com.example.example.model.service.FirestoreService
import com.example.example.model.service.trace
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.snapshots
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.firestore.ktx.toObjects
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.awaitAll
import javax.inject.Inject
import kotlinx.coroutines.tasks.await

class FirestoreServiceImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
) : FirestoreService {

    override suspend fun getUser(): DateModel? = userDocument().get().await().toObject()

    override suspend fun save(dateModel: DateModel): Unit = trace(SAVE_TRACE){ userDocument().set(dateModel).await()}


    private fun userCollection(): CollectionReference = firestore.collection(USER_COLLECTION)
    private fun userDocument(): DocumentReference = userCollection().document(USER_COLLECTION)

    companion object {
        private const val USER_COLLECTION = "User"
        private const val SAVE_TRACE = "save"
    }

}