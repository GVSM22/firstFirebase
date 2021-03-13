package com.magri.models

import com.google.firebase.database.{DataSnapshot, DatabaseError, DatabaseReference, ValueEventListener}
import com.magri.firebase.Firebase
import com.twitter.util.{Future, Promise}

case class User(name: String, groupInfo: GroupInfoClass, address: AddressClass) {
  def toBean: UserClass = {
    val user = new UserClass
    user.name = name
    user.groupInfo = groupInfo
    user.address = address
    user
  }
}

object User {
  def create(user: User): Unit = {
    val ref = Firebase.ref(user.name)
    val userRecord = user.toBean

    ref.setValueAsync(userRecord).get
    ()
  }

  def get(name: String): Future[User] = {
    val ref = Firebase.ref(name)
    val promise = new Promise[User]

    ref.addListenerForSingleValueEvent(new ValueEventListener {
      override def onDataChange(dataSnapshot: DataSnapshot): Unit = {
        val userRecord: Option[UserClass] = Option(dataSnapshot.getValue(classOf[UserClass]))
        userRecord.foldLeft(promise.setException(new Throwable("user não encontrado!")))((_, user) => promise.setValue(user.toCase))
      }

      override def onCancelled(databaseError: DatabaseError): Unit = promise.setException(new Throwable(databaseError.getMessage))
    })
    promise
  }
}
