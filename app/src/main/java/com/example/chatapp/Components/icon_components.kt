package com.example.chatapp.Components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun IconComponentsDrawable(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    size: Dp = 55.dp,  // Updated size to 45.dp
    tint: Color = Color.Unspecified
) {
    Icon(
        painter = painterResource(id = icon),
        contentDescription = null,
        tint = tint,
        modifier = modifier.size(size)  // Using size() to apply size directly
    )
}

@Composable
fun IconComponentImageVector(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    size: Dp = 45.dp,  // Updated size to 45.dp
    tint: Color = Color.Unspecified
) {
    Icon(
        imageVector = icon,
        contentDescription = null,
        tint = tint,
        modifier = modifier.size(size)  // Using size() to apply size directly
    )
}
