package com.example.yeniuygulama.ui.theme

import androidx.compose.ui.graphics.Color

// Original theme colors (required by Theme.kt)
val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

// Dark theme colors
val DarkBackground = Color(0xFF0D1117)
val DarkSurface = Color(0xFF161B22)
val DarkCard = Color(0xFF21262D)

// Text colors
val TextPrimary = Color(0xFFFFFFFF)
val TextSecondary = Color(0xFFB0B0B0)

// Category gradient colors
object CategoryColors {
    // Atatürk - Red gradient
    val AtaturkStart = Color(0xFFE53935)
    val AtaturkEnd = Color(0xFFB71C1C)
    
    // Bilim - Blue gradient
    val BilimStart = Color(0xFF42A5F5)
    val BilimEnd = Color(0xFF1565C0)
    
    // Girişimcilik - Orange gradient
    val GirisimcilikStart = Color(0xFFFF9800)
    val GirisimcilikEnd = Color(0xFFE65100)
    
    // Liderlik - Purple gradient
    val LiderlikStart = Color(0xFFAB47BC)
    val LiderlikEnd = Color(0xFF6A1B9A)
    
    // Felsefe - Teal gradient
    val FelsefeStart = Color(0xFF26A69A)
    val FelsefeEnd = Color(0xFF00695C)
    
    // Sanat - Pink gradient
    val SanatStart = Color(0xFFEC407A)
    val SanatEnd = Color(0xFFC2185B)
    
    // Spor - Gold gradient
    val SporStart = Color(0xFFFFD54F)
    val SporEnd = Color(0xFFF9A825)
    
    // Hayat - Purple-Pink gradient
    val HayatStart = Color(0xFF7C4DFF)
    val HayatEnd = Color(0xFFE040FB)
    
    fun getGradientForCategory(category: String): Pair<Color, Color> {
        return when (category) {
            "Atatürk" -> Pair(AtaturkStart, AtaturkEnd)
            "Bilim" -> Pair(BilimStart, BilimEnd)
            "Girişimcilik" -> Pair(GirisimcilikStart, GirisimcilikEnd)
            "Liderlik" -> Pair(LiderlikStart, LiderlikEnd)
            "Felsefe" -> Pair(FelsefeStart, FelsefeEnd)
            "Sanat" -> Pair(SanatStart, SanatEnd)
            "Spor" -> Pair(SporStart, SporEnd)
            "Hayat" -> Pair(HayatStart, HayatEnd)
            else -> Pair(HayatStart, HayatEnd)
        }
    }
    
    fun getIconForCategory(category: String): String {
        return when (category) {
            "Atatürk" -> "🇹🇷"
            "Bilim" -> "🔬"
            "Girişimcilik" -> "👔"
            "Liderlik" -> "✊"
            "Felsefe" -> "📚"
            "Sanat" -> "🎭"
            "Spor" -> "🏆"
            "Hayat" -> "💫"
            else -> "💡"
        }
    }
}

// Accent colors
val AccentBlue = Color(0xFF2196F3)
val AccentPurple = Color(0xFF9C27B0)