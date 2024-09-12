package com.example.chatapp.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.example.chatapp.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val id: Int=0,
    val name: String="",
    @DrawableRes val icon: Int= R.drawable.person_1
) : Parcelable

val personList = listOf(
    Person(1, "John", R.drawable.person_1),
    Person(2, "Jane", R.drawable.person_2),
    Person(3, "Alice", R.drawable.person_3),
    Person(4, "Bob", R.drawable.person_4)
)
