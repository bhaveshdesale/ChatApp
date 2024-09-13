package com.example.chatapp.data

import java.sql.Time

data class Chat(
    val id:Int,
    val message:String,
    val time:String,
    val direction:Boolean

) val ChatList=listOf(
    Chat(
        1,
        "Hey, what’s up?",
        "12:15 PM",
        true
    ),
    Chat(
        2,
        "Just avoiding my laundry. 😅",
        "12:16 PM",
        false
    ),
    Chat(
        3,
        "Oh no, the laundry monster strikes again?",
        "12:16 PM",
        true
    ),
    Chat(
        4,
        "Yup. It’s growing. I think it’s sentient now.",
        "12:17 PM",
        false
    ),
    Chat(
        5,
        "Need a rescue team?",
        "12:18 PM",
        true
    ),
    Chat(
        6,
        "Yes, with snacks. The snacks are crucial. \uD83C\uDF55",
        "12:20 PM",
        false
    ),
    Chat(
        7,
        "Got it. I’ll bring a pizza and a flashlight. \uD83D\uDD75\uFE0F\u200D♂\uFE0F",
        "12:21 PM",
        true
    ),
    Chat(
        8,
        "Perfect. We might need a crane too. \uD83D\uDE02",
        "12:21 PM",
        false
    ),
    Chat(
        9,
        "I’ll pack it. Be there in 10!.",
        "12:22 PM",
        true
    ),
    Chat(
        10,
        "Thanks! Don’t let the laundry bite. \uD83E\uDDFA",
        "12:23 PM",
        false
    ),
    Chat(
        11,
        "I’ll bring my battle gear. \uD83D\uDE06",
        "12:23 PM",
        true
    ),


)

