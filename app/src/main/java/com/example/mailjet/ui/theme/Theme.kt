package com.example.mailjet.ui.theme

import androidx.annotation.DrawableRes
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.example.mailjet.R

private val DarkColorPalette = darkColorScheme(
    primary = Color.Black,
    onPrimaryContainer = darkGrey,
    secondary = Color.Black,
    background = darkGrey,
    surface = Color.Black
)

private val LightColorPalette = lightColorScheme(
    primary = Color.White,
    onPrimaryContainer = lightGrey,
    secondary = Color.White,
    background = lightGrey,
    surface = Color.White

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

class DrawableResources(
    @DrawableRes val navigationUp: Int,
    @DrawableRes val fabIcon: Int

)

val LocalDrawableResources = staticCompositionLocalOf<DrawableResources> {
    error("Local drawable are not present")
}

private val DarkThemeDrawables = DrawableResources(
    navigationUp = R.drawable.navigation_icon_white,
    fabIcon = R.drawable.navigation_icon_black
)

private val LightThemeDrawables = DrawableResources(
    navigationUp = R.drawable.navigation_icon_black,
    fabIcon = R.drawable.navigation_icon_black
)

@Composable
fun MailJetTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val appDrawables = if (darkTheme) {
        DarkThemeDrawables
    } else {
        LightThemeDrawables
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes
    )
    {
        CompositionLocalProvider(
            LocalDrawableResources provides appDrawables,
            content = content
        )
    }
}