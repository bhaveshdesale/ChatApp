package com.example.chatapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.chatapp.Components.ButtonComponent
import com.example.chatapp.Components.IconComponentImageVector
import com.example.chatapp.Components.SpacerHeight
import com.example.chatapp.Components.SpacerWidth
import com.example.chatapp.R
import com.example.chatapp.navigation.Home
import com.example.chatapp.ui.theme.Aqua

@Composable
fun StartScreen(
    navHostController: NavHostController,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        // Safely load the image
        val painter = painterResource(id = R.drawable.new1)
        Image(
            painter = painter,
            contentDescription = null, // Use null for decorative images
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 220.dp)
                .background(Color.Black)
                .align(Alignment.Center)
        ) {
            Column(modifier = Modifier.padding(20.dp, vertical = 20.dp)) {

                Text(
                    text = stringResource(R.string.stay_connected_with_your_family),
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                SpacerHeight()
                CustomCheckBox()
            }
        }
        ButtonComponent(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 30.dp)
                .align(Alignment.BottomCenter)
        ) {
            navHostController.navigate(Home)
        }
    }
}

@Composable
fun CustomCheckBox(modifier: Modifier = Modifier) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topStart = 10.dp,
                        topEnd = 10.dp,
                        bottomEnd = 80.dp,
                        bottomStart = 80.dp
                    )
                )
                .background(Aqua)
                .sizeIn(24.dp),
            contentAlignment = Alignment.Center
        ) {
            IconComponentImageVector(icon = Icons.Default.Check, size = 15.dp, tint = Color.Black)
        }
        SpacerWidth()
        Text(
            text = stringResource(R.string.secure_private_messaging), style = TextStyle(
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        )
    }
}
