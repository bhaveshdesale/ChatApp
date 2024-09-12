package com.example.chatapp.Components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp

@Composable
fun IconComponentsDrawable(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    //we want icons from drawable so we use annotation called @DrawableRes
    size: Dp,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = icon),
        contentDescription = null,
        tint = tint,
        modifier = modifier.sizeIn(size)
    )


}

@Composable
fun IconComponentImageVector(
    modifier: Modifier = Modifier,
    icon: ImageVector,

    size: Dp,
    tint: Color = Color.Unspecified,
) {
    Icon(
        imageVector = icon,
        contentDescription = null,
        tint = tint,
        modifier = modifier.sizeIn(size)
    )


}