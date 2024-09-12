package com.example.chatapp.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.chatapp.Components.IconComponentImageVector
import com.example.chatapp.Components.IconComponentsDrawable
import com.example.chatapp.Components.SpacerWidth
import com.example.chatapp.R
import com.example.chatapp.R.drawable.mic
import com.example.chatapp.data.Chat
import com.example.chatapp.data.ChatList
import com.example.chatapp.data.Person
import com.example.chatapp.ui.theme.Gray400
import com.example.chatapp.ui.theme.LightRed
import com.example.chatapp.ui.theme.LightYellow
import com.example.chatapp.ui.theme.Yellow

@Composable
fun ChatScreen(navHostController: NavHostController) {
    val person = navHostController.previousBackStackEntry?.savedStateHandle?.get<Person>("data1") ?: Person()
    var message by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            UserEachRow(
                person = person,
                modifier = Modifier.padding(top = 40.dp, start = 20.dp, end = 20.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Color.White, RoundedCornerShape(
                            topStart = 30.dp,
                            topEnd = 30.dp
                        )
                    )
                    .padding(top = 25.dp)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 15.dp, top = 25.dp, bottom = 75.dp)
                ) {
                    items(ChatList, key = { it.id }) {
                        ChatRow(chat = it)
                    }
                }

                TextFieldComponents(
                    text = message,
                    modifier = Modifier
                        .padding(20.dp)
                        .align(Alignment.BottomCenter)
                ) {
                    message = it
                }
            }
        }
    }
}

@Composable
fun ChatRow(chat: Chat) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = if (chat.direction) Alignment.Start else Alignment.End
    ) {
        Box(
            modifier = Modifier
                .background(
                    if (chat.direction) LightRed else LightYellow,
                    shape = RoundedCornerShape(100.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = chat.message,
                style = TextStyle(
                    fontSize = 15.sp,
                    color = Color.Black
                ),
                textAlign = TextAlign.End,
                modifier = Modifier.padding(
                    horizontal = 15.dp,
                    vertical = 8.dp
                )
            )
        }
        Text(
            text = chat.time,
            style = TextStyle(
                fontSize = 12.sp,
                color = Gray
            ),
            modifier = Modifier.padding(
                horizontal = 15.dp,
                vertical = 8.dp
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponents(
    modifier: Modifier = Modifier,
    text: String,
    onValueChange: (String) -> Unit,
) {
    TextField(
        value = text,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(), // Apply the modifier here
        shape = RoundedCornerShape(160.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Gray400,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        placeholder = {
            Text(
                text = "Type Message", style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Black
                )
            )
        },
        leadingIcon = {
            IconButtonComponentImageVector(icon = Icons.Default.Add)
        },
        trailingIcon = {
            IconButtonComponentDrawable(icon = mic)
        }
    )
}

private fun TextFieldDefaults.textFieldColors(
    containerColor: Color,
    unfocusedIndicatorColor: Color,
    focusedIndicatorColor: Color,
): TextFieldColors {
    TODO("Not yet implemented")
}

@Composable
fun IconButtonComponentDrawable(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
) {
    Box(
        modifier = Modifier
            .background(Yellow, CircleShape)
            .size(33.dp), // Fix size
        contentAlignment = Alignment.Center
    ) {
        IconComponentsDrawable(icon = icon, size = 15.dp, tint = Color.Black)
    }
}

@Composable
fun IconButtonComponentImageVector(
    modifier: Modifier = Modifier,
    icon: ImageVector,
) {
    Box(
        modifier = Modifier
            .background(Yellow, CircleShape)
            .size(33.dp), // Fix size
        contentAlignment = Alignment.Center
    ) {
        IconComponentImageVector(icon = icon, size = 15.dp, tint = Color.Black)
    }
}

@Composable
fun UserEachRow(modifier: Modifier = Modifier, person: Person) {
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            IconComponentsDrawable(icon = person.icon, size = 42.dp)
            SpacerWidth()
            Column {
                Text(
                    text = person.name, style = TextStyle(
                        color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = "Online", style = TextStyle(
                        color = Color.White, fontSize = 14.sp
                    )
                )
            }
        }
        IconComponentImageVector(icon = Icons.Default.MoreVert, size = 24.dp, tint = Color.White)
    }
}
