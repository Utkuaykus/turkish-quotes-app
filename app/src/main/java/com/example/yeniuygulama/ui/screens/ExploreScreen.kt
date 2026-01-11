package com.example.yeniuygulama.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yeniuygulama.data.Quote
import com.example.yeniuygulama.data.QuotesData
import com.example.yeniuygulama.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreScreen(
    onCategoryClick: (String) -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }
    val allQuotes = remember { QuotesData.getAllQuotes() }
    val categories = remember { QuotesData.getAllCategories() }
    
    val searchResults = remember(searchQuery) {
        if (searchQuery.isBlank()) {
            emptyList()
        } else {
            allQuotes.filter {
                it.text.contains(searchQuery, ignoreCase = true) ||
                it.author.contains(searchQuery, ignoreCase = true)
            }.take(20)
        }
    }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground)
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        
        // Title
        Text(
            text = "Ara",
            style = MaterialTheme.typography.headlineMedium,
            color = TextPrimary,
            fontWeight = FontWeight.Bold
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Search bar
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("Söz veya yazar ara...", color = TextSecondary)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = TextSecondary
                )
            },
            singleLine = true,
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = AccentBlue,
                unfocusedBorderColor = DarkCard,
                focusedContainerColor = DarkCard,
                unfocusedContainerColor = DarkCard,
                focusedTextColor = TextPrimary,
                unfocusedTextColor = TextPrimary
            )
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        if (searchQuery.isBlank()) {
            // Show categories
            Text(
                text = "Kategoriler",
                style = MaterialTheme.typography.titleLarge,
                color = TextPrimary,
                fontWeight = FontWeight.SemiBold
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.weight(1f)
            ) {
                items(categories) { category ->
                    CategoryCard(
                        category = category,
                        quoteCount = allQuotes.count { it.category == category },
                        onClick = { onCategoryClick(category) }
                    )
                }
            }
        } else {
            // Show search results
            Text(
                text = "${searchResults.size} sonuç bulundu",
                style = MaterialTheme.typography.bodyMedium,
                color = TextSecondary
            )
            
            Spacer(modifier = Modifier.height(12.dp))
            
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.weight(1f)
            ) {
                items(searchResults) { quote ->
                    SearchResultCard(quote = quote)
                }
            }
        }
    }
}

@Composable
fun CategoryCard(
    category: String,
    quoteCount: Int,
    onClick: () -> Unit
) {
    val gradientColors = CategoryColors.getGradientForCategory(category)
    val icon = CategoryColors.getIconForCategory(category)
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(gradientColors.first, gradientColors.second)
                    )
                )
                .padding(16.dp)
        ) {
            Column {
                Text(
                    text = icon,
                    fontSize = 28.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = category,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "$quoteCount söz",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White.copy(alpha = 0.8f)
                )
            }
        }
    }
}

@Composable
fun SearchResultCard(quote: Quote) {
    val gradientColors = CategoryColors.getGradientForCategory(quote.category)
    
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = DarkCard)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.Top
        ) {
            // Color indicator
            Box(
                modifier = Modifier
                    .width(4.dp)
                    .height(60.dp)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(gradientColors.first, gradientColors.second)
                        ),
                        shape = RoundedCornerShape(2.dp)
                    )
            )
            
            Spacer(modifier = Modifier.width(12.dp))
            
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "\"${quote.text}\"",
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextPrimary,
                    maxLines = 3
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "— ${quote.author}",
                    style = MaterialTheme.typography.bodySmall,
                    color = TextSecondary
                )
            }
        }
    }
}
