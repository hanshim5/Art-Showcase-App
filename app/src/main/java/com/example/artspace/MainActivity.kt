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
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.artworks.Artwork
import com.example.artspace.ui.theme.ArtSpaceTheme
import com.example.artspace.data.Data
import androidx.compose.material3.Surface


/*
Group Members: Hannah Sim, Justine Cruz, Evan Haut
*I have confirmed that all three of us have completed the lab.*
 */

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
                    DisplayController()
                }
            }
        }
    }
}

@Composable
fun ArtworkWall(current: Artwork, modifier: Modifier = Modifier) {
    // Surrounded with box in order to center image
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = Modifier,
            shadowElevation = 12.dp // Adds elevation for a shadow effect
        ) {
            Image(
                painter = painterResource(id = current.imageResourceId),
                contentDescription = null,
                modifier = Modifier
                    .size(320.dp)
                    .padding(28.dp)
            )
        }
    }
}


@Composable
fun ArtworkDescription(current: Artwork, modifier: Modifier = Modifier) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(24.dp)
        .height(76.dp)
        .background(color = Color(0xFFCED7E1)),
        verticalArrangement = Arrangement.Center) {
        Text(
            text = stringResource(current.artTitleResourceId),
            modifier = modifier
                .padding(start = 16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Light
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(current.artistNameResourceId) ,
            modifier = modifier
                .padding(start = 16.dp),
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DisplayController(modifier: Modifier = Modifier) {
    val artworks = Data().loadArtworks()
    var currentIndex by remember { mutableStateOf(0) }
    val currentArtwork = artworks[currentIndex]

    // Displays artwork
    ArtworkWall(currentArtwork)

    // Displays description + Buttons
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,

    ) {
        ArtworkDescription(currentArtwork)

        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center) {
            Button(
                onClick = {
                    currentIndex = if (currentIndex == 0) artworks.size - 1 else currentIndex - 1
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF376BA1),
                    contentColor = Color(0xFF376BA1)
                ),
                border = BorderStroke(1.dp, color = Color(0xFF22355B)),
                modifier = Modifier.width(128.dp).height(36.dp)

                ) {
                ProvideTextStyle(value = MaterialTheme.typography.labelLarge) { }
                Text("Previous", fontSize = 13.sp, color = Color.White)
            }

            Spacer(modifier = Modifier.width(84.dp))

            Button(
                onClick = {
                    currentIndex = (currentIndex + 1) % artworks.size
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF376BA1),
                    contentColor = Color(0xFF376BA1)
                ),
                border = BorderStroke(1.dp, color = Color(0xFF22355B)),
                modifier = Modifier.width(128.dp).height(36.dp)
            ) {
                Text("Next", fontSize = 13.sp, color = Color.White)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}