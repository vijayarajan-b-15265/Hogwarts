package com.example.mailjet.ui.theme

import androidx.annotation.DrawableRes
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import com.example.mailjet.R

private val DarkColorPalette = darkColors(
    primary = Color.Black,
    primaryVariant = darkGrey,
    secondary = lightBlue
)

private val LightColorPalette = lightColors(
    primary = Companion.White,
    primaryVariant = lightGrey,
    secondary = darkBlue

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
        @DrawableRes val navigationUp : Int
)

val LocalDrawableResources = staticCompositionLocalOf<DrawableResources>{
    error("Local drawable are not present")
}

private val DarkThemeDrawables = DrawableResources(
    navigationUp = R.drawable.navigation_icon_white
)

private val LightThemeDrawables = DrawableResources(
    navigationUp = R.drawable.navigation_icon_black
)

@Composable
fun MailJetTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val appDrawables = if (darkTheme){
        DarkThemeDrawables
    }
    else {
        LightThemeDrawables
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
    )
    {
        CompositionLocalProvider( LocalDrawableResources provides appDrawables, LocalContentAlpha provides ContentAlpha.medium,
            content = content )
    }
}