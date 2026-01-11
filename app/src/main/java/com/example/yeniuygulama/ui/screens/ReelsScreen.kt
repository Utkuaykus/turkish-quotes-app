package com.example.yeniuygulama.ui.screens

import android.content.Intent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yeniuygulama.data.Quote
import com.example.yeniuygulama.data.QuotesData
import com.example.yeniuygulama.ui.theme.*

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ReelsScreen() {
    val allQuotes = remember { QuotesData.getAllQuotes().shuffled() }
    val pagerState = rememberPagerState(pageCount = { allQuotes.size })
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground)
    ) {
        VerticalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            ReelItem(quote = allQuotes[page])
        }
        
        // Page indicator hint
        if (pagerState.currentPage == 0) {
            Text(
                text = "↕ Kaydır",
                color = TextSecondary,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 16.dp)
            )
        }
    }
}

@Composable
fun ReelItem(quote: Quote) {
    val context = LocalContext.current
    val gradientColors = CategoryColors.getGradientForCategory(quote.category)
    val categoryIcon = CategoryColors.getIconForCategory(quote.category)
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        gradientColors.first,
                        gradientColors.second,
                        gradientColors.second.copy(alpha = 0.8f)
                    )
                )
            )
    ) {
        // Category badge
        Surface(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(20.dp),
            shape = RoundedCornerShape(20.dp),
            color = Color.Black.copy(alpha = 0.3f)
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = categoryIcon, fontSize = 16.sp)
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = quote.category,
                    color = Color.White,
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
        
        // Quote content - centered
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Quote marks
            Text(
                text = "❝",
                fontSize = 64.sp,
                color = Color.White.copy(alpha = 0.3f)
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Quote text
            Text(
                text = quote.text,
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium,
                lineHeight = 40.sp
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Divider
            Box(
                modifier = Modifier
                    .width(80.dp)
                    .height(3.dp)
                    .background(Color.White.copy(alpha = 0.5f))
            )
            
            Spacer(modifier = Modifier.height(20.dp))
            
            // Author name
            Text(
                text = quote.author,
                style = MaterialTheme.typography.titleLarge,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            
            // Author title
            Text(
                text = quote.title,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White.copy(alpha = 0.8f),
                fontStyle = FontStyle.Italic
            )
        }
    }
}
