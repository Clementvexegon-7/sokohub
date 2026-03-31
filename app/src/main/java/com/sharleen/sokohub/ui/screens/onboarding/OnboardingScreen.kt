package com.sharleen.sokohub.ui.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sharleen.sokohub.R
import com.sharleen.sokohub.ui.screens.home.HomeScreen
@Composable
fun OnboardingScreen(){
    Column(
        modifier = Modifier.fillMaxSize()
    ){

        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = "img",
            modifier = Modifier.size(100.dp)







        )










    }




}
@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview(){
    OnboardingScreen()
}
