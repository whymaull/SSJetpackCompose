package com.whymaull.ssjetpackcompose.ui.page.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.whymaull.ssjetpackcompose.R

@Composable
fun Profile() {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Image(painter = painterResource(R.drawable.profile), contentDescription = null, modifier = Modifier
                .size(200.dp)
                .clip(
                    CircleShape
                ))

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = " Wahyu Maulana Aditya " )
            Text(text = " first.wahyumaul21@gmail.com " , color = Color.Gray)
        }
    }

}