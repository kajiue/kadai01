package com.example.kadai01

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Password : RealmObject() {
    @PrimaryKey
    var id: Long = 0
    var title: String =""
    var user: String =""
    var password: Int = 0
}