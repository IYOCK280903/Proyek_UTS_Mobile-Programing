package com.example.uts1_kartunama

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uts1_kartunama.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF001F54)
                ) {
                    BusinessCardScreen()
                }
            }
        }
    }
}

@Composable
fun BusinessCardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF001F54))
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Foto profil (taruh di res/drawable/profile_pic.png)
        Image(
            painter = painterResource(id = R.drawable.profile_pic),
            contentDescription = "Foto Profil",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Philipus Benediktus Mario Djuang",
            fontSize = 22.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Text(
            text = "Mahasiswa Universitas Sanata Dharma",
            fontSize = 14.sp,
            color = Color(0xFFB3C7E6)
        )

        Text(
            text = "\"Ingin menjadi orang sukses\"",
            fontSize = 12.sp,
            color = Color.LightGray,
            modifier = Modifier.padding(top = 8.dp, bottom = 16.dp)
        )

        Divider(color = Color.LightGray, thickness = 1.dp, modifier = Modifier.padding(8.dp))

        // Bagian kontak
        ContactInfo(icon = R.drawable.ic_phone, text = "+62 821 4495 4323")
        ContactInfo(icon = R.drawable.ic_email, text = "iyock28@gmail.com")
        ContactInfo(icon = R.drawable.ic_location, text = "Yogyakarta, Indonesia")

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "MEDIA SOSIAL",
            fontWeight = FontWeight.SemiBold,
            color = Color.LightGray,
            fontSize = 13.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Ikon media sosial
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            SocialIcon(R.drawable.ic_instagram, "Instagram: riodjuang__")
            SocialIcon(R.drawable.ic_tiktok, "TikTok: goriorio28")
            SocialIcon(R.drawable.ic_github, "GitHub: IYOCK280903")
        }
    }
}

@Composable
fun ContactInfo(icon: Int, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 6.dp)
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = Color(0xFFB3C7E6),
            modifier = Modifier.size(22.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = text, color = Color.White, fontSize = 14.sp)
    }
}

@Composable
fun SocialIcon(icon: Int, desc: String) {
    Icon(
        painter = painterResource(id = icon),
        contentDescription = desc,
        tint = Color.White,
        modifier = Modifier
            .size(32.dp)
            .clip(CircleShape)
            .background(Color(0xFF203864))
            .padding(5.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCardScreen()
    }
}
