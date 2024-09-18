package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtworkPreview()
                }
                }
        }
    }
}

@Composable
fun ArtworkWall(artwork: Int, modifier: Modifier = Modifier) {
    val image = painterResource(artwork)

    Image(
        painter = image,
        contentDescription = "My image description",
        modifier = Modifier
            .padding(4.dp)
            .size(320.dp)

    )
}

@Composable
fun ArtworkDescription(artTitle: String, artist: String, modifier: Modifier = Modifier) {
    Column(modifier = Modifier
        .border(width = 1.dp, color = Color.Black)
        .background(color = Color(0xFFCED7E1)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = artTitle,
            modifier = modifier
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = artist,
            modifier = modifier
        )
    }
}

@Composable
fun DisplayController(modifier: Modifier = Modifier) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.Center) {
        Button(onClick = { /* Do something! */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF376BA1), contentColor = Color(0xFF376BA1)),
            border = BorderStroke(1.dp, color = Color(0xFF22355B)),
            ) {
            Text("Previous", color = Color.White)
        }

        Spacer(modifier = Modifier.width(20.dp))

        Button(onClick = { /* Do something! */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF376BA1), contentColor = Color(0xFF376BA1)),
            border = BorderStroke(1.dp, color = Color(0xFF22355B)),
            ) {
            Text("Next", color = Color.White)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ArtworkPreview(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally,) {
        ArtworkWall(R.drawable.fallen_angel)
        ArtworkDescription(artTitle = "Artwork Title", artist = "Artwork Artist (Year)")
        DisplayController()
    }
}