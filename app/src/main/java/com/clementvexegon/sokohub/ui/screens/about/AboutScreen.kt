package com.clementvexegon.sokohub.ui.screens.about

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.clementvexegon.sokohub.navigation.ROUT_HOME
import com.clementvexegon.sokohub.navigation.ROUT_INTENT
import com.clementvexegon.sokohub.ui.theme.Blueberry

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(navController: NavController){

    var selectedIndex by remember { mutableStateOf(0) }
    val mContext = LocalContext.current

    Scaffold(

        // TOP BAR
        topBar = {
            TopAppBar(
                title = { Text("Business Cards") },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Blueberry,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        },

        // BOTTOM BAR
        bottomBar = {
            NavigationBar(containerColor = Blueberry){

                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.White) },
                    label = { Text("Home") },
                    selected = selectedIndex == 0,
                    onClick = {
                        selectedIndex = 0
                        navController.navigate(ROUT_HOME)
                    }
                )

                NavigationBarItem(
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Intent", tint = Color.White) },
                    label = { Text("Intent") },
                    selected = selectedIndex == 1,
                    onClick = {
                        selectedIndex = 1
                        navController.navigate(ROUT_INTENT)
                    }
                )

                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile", tint = Color.White) },
                    label = { Text("Profile") },
                    selected = selectedIndex == 2,
                    onClick = {
                        selectedIndex = 2
                    }
                )
            }
        },

        // FLOATING BUTTON
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    Toast.makeText(mContext, "Add New Card", Toast.LENGTH_SHORT).show()
                },
                containerColor = Blueberry
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }

    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            // ================= CARD 1 =================
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .background(Color(0xFF2196F3), RoundedCornerShape(16.dp))
                    .padding(16.dp)
            ) {

                // TOP ROW (NAME + ICONS)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text("John Smith", color = Color.White, fontWeight = FontWeight.Bold)
                        Text("Business Consultant", color = Color.White)
                    }

                    Row {
                        Icon(
                            Icons.Default.Edit,
                            contentDescription = "Edit",
                            tint = Color.White,
                            modifier = Modifier.clickable {
                                Toast.makeText(mContext, "Edit John Smith", Toast.LENGTH_SHORT).show()
                            }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(
                            Icons.Default.Info,
                            contentDescription = "Info",
                            tint = Color.White,
                            modifier = Modifier.clickable {
                                Toast.makeText(mContext, "John Smith - Business Consultant", Toast.LENGTH_SHORT).show()
                            }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // PHONE ROW
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable {
                        val callIntent = Intent(Intent.ACTION_DIAL)
                        callIntent.data = Uri.parse("tel:0758307360")
                        mContext.startActivity(callIntent)
                    }
                ) {
                    Icon(Icons.Default.Call, contentDescription = "", tint = Color.White)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("0758307360", color = Color.White)
                }

                Spacer(modifier = Modifier.height(6.dp))

                // EMAIL ROW
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable {
                        val emailIntent = Intent(Intent.ACTION_SENDTO)
                        emailIntent.data = Uri.parse("mailto:johnsmith@gmail.com")
                        mContext.startActivity(emailIntent)
                    }
                ) {
                    Icon(Icons.Default.Email, contentDescription = "", tint = Color.White)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("johnsmith@gmail.com", color = Color.White)
                }
            }

            // ================= CARD 2 =================
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .background(Color.Red, RoundedCornerShape(16.dp))
                    .padding(16.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text("Amanda Black", color = Color.White, fontWeight = FontWeight.Bold)
                        Text("Dentist", color = Color.White)
                    }

                    Row {
                        Icon(
                            Icons.Default.Edit,
                            contentDescription = "",
                            tint = Color.White,
                            modifier = Modifier.clickable {
                                Toast.makeText(mContext, "Edit Amanda Black", Toast.LENGTH_SHORT).show()
                            }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(
                            Icons.Default.Info,
                            contentDescription = "",
                            tint = Color.White,
                            modifier = Modifier.clickable {
                                Toast.makeText(mContext, "Amanda Black - Dentist", Toast.LENGTH_SHORT).show()
                            }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable {
                        val callIntent = Intent(Intent.ACTION_DIAL)
                        callIntent.data = Uri.parse("tel:0712345678")
                        mContext.startActivity(callIntent)
                    }
                ) {
                    Icon(Icons.Default.Call, contentDescription = "", tint = Color.White)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("0712345678", color = Color.White)
                }

                Spacer(modifier = Modifier.height(6.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable {
                        val emailIntent = Intent(Intent.ACTION_SENDTO)
                        emailIntent.data = Uri.parse("mailto:amanda@gmail.com")
                        mContext.startActivity(emailIntent)
                    }
                ) {
                    Icon(Icons.Default.Email, contentDescription = "", tint = Color.White)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("amandablack@gmail.com", color = Color.White)
                }
            }

            // ================= CARD 3 =================
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .background(Color(0xFFFF9800), RoundedCornerShape(16.dp))
                    .padding(16.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text("David Hill", color = Color.White, fontWeight = FontWeight.Bold)
                        Text("Designer", color = Color.White)
                    }

                    Row {
                        Icon(
                            Icons.Default.Edit,
                            contentDescription = "",
                            tint = Color.White,
                            modifier = Modifier.clickable {
                                Toast.makeText(mContext, "Edit David Hill", Toast.LENGTH_SHORT).show()
                            }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(
                            Icons.Default.Info,
                            contentDescription = "",
                            tint = Color.White,
                            modifier = Modifier.clickable {
                                Toast.makeText(mContext, "David Hill - Designer", Toast.LENGTH_SHORT).show()
                            }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable {
                        val callIntent = Intent(Intent.ACTION_DIAL)
                        callIntent.data = Uri.parse("tel:0798765432")
                        mContext.startActivity(callIntent)
                    }
                ) {
                    Icon(Icons.Default.Call, contentDescription = "", tint = Color.White)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("0798765432", color = Color.White)
                }

                Spacer(modifier = Modifier.height(6.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable {
                        val emailIntent = Intent(Intent.ACTION_SENDTO)
                        emailIntent.data = Uri.parse("mailto:davidhill@gmail.com")
                        mContext.startActivity(emailIntent)
                    }
                ) {
                    Icon(Icons.Default.Email, contentDescription = "", tint = Color.White)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("davidhill@gmail.com", color = Color.White)
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun AboutScreenPreview(){
    AboutScreen(rememberNavController())
}