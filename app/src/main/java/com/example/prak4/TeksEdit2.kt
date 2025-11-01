package com.example.prak4

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormPendaftaran(modifier: Modifier = Modifier) {

    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textStatus by remember { mutableStateOf("") }

    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    val genderList = listOf("Laki-laki", "Perempuan")
    val statusList = listOf("Janda", "Lajang", "Duda")

    val backgroundLavender = Color(0xFFF3E5F5)
    val purpleButton = Color(0xFF7C3AED)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundLavender)
    ){
        Box (
            modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFFD1B3FF), Color(0xFFB388FF))
                )
            ),
            contentAlignment = Alignment.CenterStart
        ){
            Text(
                text = "Formulir Pendaftaran",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                modifier = Modifier
                    .padding(start = 20.dp, top = 16.dp)
            )
        }
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = MaterialTheme.shapes.large,
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ){
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ){
                    Text(
                        text = "NAMA LENGKAP",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    OutlinedTextField(
                        value = textNama,
                        onValueChange = { textNama = it },
                        placeholder = { Text("Isikan nama lengkap") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = "JENIS KELAMIN",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    genderList.forEach { item ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .selectable(
                                    selected = (textJK == item),
                                    onClick = { textJK = item }
                                )
                                .padding(vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = (textJK == item),
                                onClick = { textJK = item }
                            )
                            Text(text = item)
                        }
                    }
                    Text(
                        text = "STATUS PERKAWINAN",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    statusList.forEach { item ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .selectable(
                                    selected = (textStatus == item),
                                    onClick = { textStatus = item }
                                )
                                .padding(vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = (textStatus == item),
                                onClick = { textStatus = item }
                            )
                            Text(text = item)
                        }
                    }
                    Text(
                        text = "ALAMAT",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    OutlinedTextField(
                        value = textAlamat,
                        onValueChange = { textAlamat = it },
                        placeholder = { Text("Alamat lengkap") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                    )
                    Spacer(modifier= Modifier.height(16.dp))


                }
            }
        }
    }




}
