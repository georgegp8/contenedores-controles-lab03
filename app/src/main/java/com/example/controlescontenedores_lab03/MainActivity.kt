package com.example.controlescontenedores_lab03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.controlescontenedores_lab03.ui.theme.ControlesContenedoreslab03Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ControlesContenedoreslab03Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        LazyColumnDemo()
                        LazyRowDemo()
                    }
                }

            }
        }
    }
}

@Composable
fun LazyColumnDemo() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(8.dp)
    ) {
        items(10) { index ->
            Text(
                text = "Elemento $index",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun LazyRowDemo() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(8.dp)
    ) {
        items(3) { index ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .width(100.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFB3E5FC))
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text("Item $index", modifier = Modifier.padding(8.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLazyRowDemo() {
    LazyRowDemo()
}



@Preview(showBackground = true)
@Composable
fun PreviewLazyColumnDemo() {
    LazyColumnDemo()
}

