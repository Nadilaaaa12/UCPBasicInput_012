package com.example.ucp1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun Input(modifier: Modifier = Modifier) {
    var nama by remember { mutableStateOf("") }
    var noTelpon by remember { mutableStateOf("") }
    var memilihJK by remember { mutableStateOf("") }

    var namasv by remember { mutableStateOf("") }
    var noTelponsv by remember { mutableStateOf("") }
    var memilihJKsv by remember { mutableStateOf("") }

    var listJK = listOf("laki-laki","Perempuan")
    Column (modifier = modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally


    ){
        Text("Halo",
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold)


        Text("Nadila",
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold)

        Spacer(Modifier . padding(16.dp))
        TextField(
            modifier = Modifier .fillMaxWidth() .padding(5.dp),
            value = nama,
            onValueChange = {nama = it},
            label = { Text("nama")},
            placeholder = { Text("Masukan Nama") }
        )
        TextField(
            modifier = Modifier .fillMaxWidth() .padding(5.dp),
            value = noTelpon,
            onValueChange = {noTelpon = it},
            label = { Text("noTelpon")},
            placeholder = { Text("Masukan noTelpon") }
        )

        Row {
            listJK.forEach{item ->
                Row(verticalAlignment = Alignment.CenterVertically) { RadioButton(
                    selected = memilihJK == item,
                    onClick = {
                        memilihJK = item
                    }
                )
                    Text(item)
                }
            }
        }


        TextField(
            modifier = Modifier .fillMaxWidth() .padding(5.dp),
            value = memilihJK,
            onValueChange = {memilihJK = it},
            label = { Text("memilihJK")},
            placeholder = { Text("Masukan memilihJK") }
        )

        Button(onClick = {
            namasv = nama
            noTelponsv = noTelpon
            memilihJKsv = memilihJK
        }) {
            Text("Simpan")
        }
        ElevatedCard(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            DetailSurat(judul = "nama",isinya = namasv)
            DetailSurat(judul = "noTelpon",isinya = noTelponsv)
            DetailSurat(judul = "memilihJK",isinya = memilihJKsv)
        }
        Image(
            painter = painterResource(id = R.drawable.orang), contentDescription = null,
            Modifier.size(250.dp)
        )

    }
}

@Composable
fun DetailSurat(
    judul: String, isinya: String
){
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(text = judul,
            modifier = Modifier.weight(0.8f))
        Text(text = ":",
            modifier = Modifier.weight(0.2f))
        Text(text = isinya,
            modifier = Modifier.weight(2f))
    }
}




