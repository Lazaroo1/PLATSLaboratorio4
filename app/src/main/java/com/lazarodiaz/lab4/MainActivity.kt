package com.lazarodiaz.lab4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MascotaList(sampleMascotas())
                }
            }
        }
    }
}

fun sampleMascotas(): List<Mascota> {
    return listOf(
        Mascota(1, "Yeisi", "Labrador Retriever", R.drawable.dog1),
        Mascota(2, "Tonito", "Golden Retriever", R.drawable.dog2),
        Mascota(3, "Wilson", "Poodle", R.drawable.cat1),
        Mascota(4, "Juanfri", "Beagle", R.drawable.cat2),
        Mascota(5, "Charlie", "Bulldog Francés", R.drawable.dog3),
        Mascota(6, "CHepe", "Cane Corso", R.drawable.dog4),
        Mascota(7, "Pereira", "Presa Canario", R.drawable.dog5),
        Mascota(8, "Pepe", "Dogo Argentino", R.drawable.dog6),
        Mascota(9, "Caldito", "Hamster Dorado", R.drawable.ham1),
        Mascota(10, "Pipol Polka", "American Staffordshire Terrier", R.drawable.pipol),
        Mascota(11, "Leia Nicole", "Salchicha", R.drawable.leia),
        Mascota(12, "Toyaqui", "Pastor Maya", R.drawable.toy)
    )
}

@Composable
fun MascotaList(mascotas: List<Mascota>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(mascotas, key = { it.id }) { mascota ->
            MascotaCard(mascota)
        }
    }
}

@Composable
fun MascotaCard(mascota: Mascota) {
    var adoptado by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = mascota.imagenResId),
                contentDescription = mascota.nombre,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(72.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(text = mascota.nombre, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(
                    text = mascota.raza,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }

            Button(onClick = { adoptado = !adoptado }) {
                Text(text = if (adoptado) "¡Adoptado! ❤" else "Adoptar")
            }
        }
    }
}
