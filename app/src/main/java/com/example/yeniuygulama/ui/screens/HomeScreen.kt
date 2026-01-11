package com.example.yeniuygulama.ui.screens

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.window.Dialog
import com.example.yeniuygulama.data.QuotesData
import com.example.yeniuygulama.ui.theme.*
import java.time.LocalTime

@Composable
fun HomeScreen() {
    val context = LocalContext.current
    val quote = remember { QuotesData.getQuoteOfTheDay() }
    val gradientColors = CategoryColors.getGradientForCategory(quote.category)
    var showNameDialog by remember { mutableStateOf(false) }
    
    // SharedPreferences ile ismi kaydet/oku
    val sharedPrefs = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
    var userName by remember { mutableStateOf(sharedPrefs.getString("user_name", "Kullanıcı") ?: "Kullanıcı") }
    
    // Get greeting based on time
    val greeting = remember {
        when (LocalTime.now().hour) {
            in 5..11 -> "Günaydın"
            in 12..17 -> "İyi günler"
            in 18..21 -> "İyi akşamlar"
            else -> "İyi geceler"
        }
    }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground)
            .padding(20.dp)
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "$greeting! 👋",
                    style = MaterialTheme.typography.headlineSmall,
                    color = TextPrimary,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = userName,
                    style = MaterialTheme.typography.bodyLarge,
                    color = TextSecondary
                )
            }
            
            IconButton(
                onClick = { showNameDialog = true },
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(DarkCard)
            ) {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Profil",
                    tint = TextSecondary
                )
            }
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        // Quote of the day label
        Text(
            text = "Günün Sözü",
            style = MaterialTheme.typography.labelLarge,
            color = TextSecondary,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        
        // Quote card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            shape = RoundedCornerShape(24.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(gradientColors.first, gradientColors.second)
                        )
                    )
                    .padding(28.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    // Quote marks
                    Text(
                        text = "❝",
                        fontSize = 48.sp,
                        color = Color.White.copy(alpha = 0.4f)
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Quote text
                    Text(
                        text = "\"${quote.text}\"",
                        style = MaterialTheme.typography.headlineSmall,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Medium,
                        lineHeight = 32.sp
                    )
                    
                    Spacer(modifier = Modifier.height(24.dp))
                    
                    // Divider line
                    Box(
                        modifier = Modifier
                            .width(60.dp)
                            .height(3.dp)
                            .background(Color.White.copy(alpha = 0.5f))
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Author
                    Text(
                        text = quote.author,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                    
                    // Author title
                    Text(
                        text = quote.title,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White.copy(alpha = 0.8f),
                        fontStyle = FontStyle.Italic
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Share button
        Button(
            onClick = {
                val shareText = "\"${quote.text}\"\n\n— ${quote.author}"
                val sendIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, shareText)
                    type = "text/plain"
                }
                context.startActivity(Intent.createChooser(sendIntent, "Paylaş"))
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = DarkCard
            )
        ) {
            Icon(
                imageVector = Icons.Default.Share,
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Paylaş", fontSize = 16.sp, color = Color.White)
        }
    }
    
    // Name edit dialog
    if (showNameDialog) {
        var tempName by remember { mutableStateOf(userName) }
        
        Dialog(onDismissRequest = { showNameDialog = false }) {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = DarkCard)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "İsminizi Girin",
                        style = MaterialTheme.typography.titleLarge,
                        color = TextPrimary
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    OutlinedTextField(
                        value = tempName,
                        onValueChange = { tempName = it },
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = AccentBlue,
                            unfocusedBorderColor = TextSecondary,
                            focusedTextColor = TextPrimary,
                            unfocusedTextColor = TextPrimary
                        )
                    )
                    
                    Spacer(modifier = Modifier.height(24.dp))
                    
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        TextButton(onClick = { showNameDialog = false }) {
                            Text("İptal", color = TextSecondary)
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Button(onClick = {
                            userName = tempName
                            // SharedPreferences'a kaydet
                            sharedPrefs.edit().putString("user_name", tempName).apply()
                            showNameDialog = false
                        }) {
                            Text("Kaydet")
                        }
                    }
                }
            }
        }
    }
}
