package com.example.chatapp.data

import androidx.annotation.DrawableRes
import androidx.versionedparcelable.ParcelField
import androidx.versionedparcelable.VersionedParcelize
import com.example.chatapp.R


@VersionedParcelize
data class Person(
    val id:Int=0,
    val name:String=" ",

    @DrawableRes val icon:Int= R.drawable.ic_launcher_foreground)

val personList= listOf(
    Person(1,"John",R.drawable.person_1),
    Person(2,"John",R.drawable.person_2),
    Person(3,"John",R.drawable.person_3),
    Person(4,"John",R.drawable.person_4),
    Person(5,"John",R.drawable.person_1),
    Person(6,"John",R.drawable.person_2),
    Person(7,"John",R.drawable.person_3),
    Person(8,"John",R.drawable.person_4),

)