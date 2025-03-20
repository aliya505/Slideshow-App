package com.example.slideshowapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImageSlideshowApp()
        }
    }
}

@Composable
fun ImageSlideshowApp() {
    val images = listOf(
        R.drawable.blueflower2,
        R.drawable.orangeflower,
        R.drawable.pinkflower,
        R.drawable.redflower
    )

    val captions = listOf(
        "Image 1: A blue flower",
        "Image 2: An orange flower",
        "Image 3: A pink flower",
        "Image 4: A red flower"
    )

    var currentIndex by remember { mutableStateOf(0) }
    var inputText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = images[currentIndex]),
            contentDescription = "Displayed Image",
            modifier = Modifier
                .size(300.dp)
                .padding(8.dp)
        )

        Text(
            text = captions[currentIndex],
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp)
        )

        TextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("Enter image number") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Button(
            onClick = {
                val number = inputText.toIntOrNull()
                if (number != null && number in 1..images.size) {
                    currentIndex = number - 1
                }
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Go")
        }

        Row(
            modifier = Modifier.padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                currentIndex = if (currentIndex == 0) images.size - 1 else currentIndex - 1
            }) {
                Text("Back")
            }

            Button(onClick = {
                currentIndex = (currentIndex + 1) % images.size
            }) {
                Text("Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewImageSlideshowApp() {
    ImageSlideshowApp()
}

