package com.example.yeniuygulama.ui.screens

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yeniuygulama.data.Quote
import com.example.yeniuygulama.data.QuotesData
import com.example.yeniuygulama.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryDetailScreen(
    categoryName: String,
    onBackClick: () -> Unit
) {
    val quotes = remember(categoryName) {
        QuotesData.getQuotesByCategory(categoryName)
    }
    val gradientColors = CategoryColors.getGradientForCategory(categoryName)
    val categoryIcon = CategoryColors.getIconForCategory(categoryName)
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground)
    ) {
        // Header with gradient
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(gradientColors.first, gradientColors.second)
                    )
                )
                .padding(top = 8.dp, bottom = 24.dp)
        ) {
            Column {
                // Back button
                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier.padding(start = 4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Geri",
                        tint = Color.White
                    )
                }
                
                // Category info
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = categoryIcon,
                        fontSize = 40.sp
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(
                            text = categoryName,
                            style = MaterialTheme.typography.headlineMedium,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "${quotes.size} söz",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.White.copy(alpha = 0.8f)
                        )
                    }
                }
            }
        }
        
        // Quotes list
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            items(quotes) { quote ->
                QuoteCard(quote = quote)
            }
        }
    }
}

@Composable
fun QuoteCard(quote: Quote) {
    val context = LocalContext.current
    val gradientColors = CategoryColors.getGradientForCategory(quote.category)
    
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = DarkCard)
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            // Quote text
            Text(
                text = "\"${quote.text}\"",
                style = MaterialTheme.typography.bodyLarge,
                color = TextPrimary,
                lineHeight = 26.sp
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Author and share row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = quote.author,
                        style = MaterialTheme.typography.titleSmall,
                        color = gradientColors.first,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = quote.title,
                        style = MaterialTheme.typography.bodySmall,
                        color = TextSecondary,
                        fontStyle = FontStyle.Italic
                    )
                }
                
                // Share button
                IconButton(
                    onClick = {
                        val shareText = "\"${quote.text}\"\n\n— ${quote.author}"
                        val sendIntent = Intent().apply {
                            action = Intent.ACTION_SEND
                            putExtra(Intent.EXTRA_TEXT, shareText)
                            type = "text/plain"
                        }
                        context.startActivity(Intent.createChooser(sendIntent, "Paylaş"))
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "Paylaş",
                        tint = TextSecondary,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}
