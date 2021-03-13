package com.magri.firebase

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.database.{DatabaseReference, FirebaseDatabase}
import com.google.firebase.{FirebaseApp, FirebaseOptions}

import java.io.InputStream

object Firebase {

  private val serviceAccount: InputStream = getClass.getResourceAsStream("/firstfirebase-config.json")
  private val options: FirebaseOptions = FirebaseOptions.builder()
    .setDatabaseUrl("https://firstfirebase-7111a-default-rtdb.firebaseio.com")
    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
    .build()
  FirebaseApp.initializeApp(options)
  private val database: FirebaseDatabase = FirebaseDatabase.getInstance()

  def ref(path: String): DatabaseReference = database.getReference(path)
}
