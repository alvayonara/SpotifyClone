package com.project.spotifyclone.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.project.spotifyclone.entities.Song
import com.project.spotifyclone.other.Constants.SONG_COLLECTION
import kotlinx.coroutines.tasks.await
import java.lang.Exception

class MusicDatabase {

    private val _firestore = FirebaseFirestore.getInstance()
    private val _songCollection = _firestore.collection(SONG_COLLECTION)

    suspend fun getAllSongs(): List<Song> {
        return try {
            _songCollection.get().await().toObjects(Song::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }
}