package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    mainScreen()
                }
            }
        }
    }
}

data class Cuadro(
    val imageResource: Int,
    val title: String,
    val artist: String,
    val year: String
)

@Composable
fun mainScreen() {
    val imageResources = listOf(
        Cuadro(
            imageResource = R.drawable.jardindelicias,
            title = stringResource(R.string.title_jardindelicias),
            artist = stringResource(R.string.artist_jardindelicias),
            year = stringResource(R.string.year_jardindelicias)
        ),
        Cuadro(
            imageResource = R.drawable.balsamedusa,
            title = stringResource(R.string.title_balsamedusa),
            artist = stringResource(R.string.artist_balsamedusa),
            year = stringResource(R.string.year_balsamedusa)
        ),
        Cuadro(
            imageResource = R.drawable.entierroornans,
            title = stringResource(R.string.title_entierroornans),
            artist = stringResource(R.string.artist_entierroornans),
            year = stringResource(R.string.year_entierroornans)
        ),
        Cuadro(
            imageResource = R.drawable.nocheestrellada,
            title = stringResource(R.string.title_nocheestrellada),
            artist = stringResource(R.string.artist_nocheestrellada),
            year = stringResource(R.string.year_nocheestrellada)
        ),
        Cuadro(
            imageResource = R.drawable.jugadorescartas,
            title = stringResource(R.string.title_jugadorescartas),
            artist = stringResource(R.string.artist_jugadorescartas),
            year = stringResource(R.string.year_jugadorescartas)
        ),
        Cuadro(
            imageResource = R.drawable.nighthawks,
            title = stringResource(R.string.title_nighthawks),
            artist = stringResource(R.string.artist_nighthawks),
            year = stringResource(R.string.year_nighthawks)
        ),
    )

    var currentIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageResources[currentIndex].imageResource),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
        )
        Text(
            text = imageResources[currentIndex].title,
            color = Color.White,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        Text(
            text = imageResources[currentIndex].artist + " - " + imageResources[currentIndex].year,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    if (currentIndex > 0) {
                        currentIndex--
                    } else {
                        currentIndex = imageResources.size - 1
                    }
                },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.btn1),
                    fontSize = 20.sp
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    if (currentIndex < imageResources.size - 1) {
                        currentIndex++
                    } else {
                        currentIndex = 0
                    }
                },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.btn2),
                    fontSize = 20.sp
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        mainScreen()
    }
}