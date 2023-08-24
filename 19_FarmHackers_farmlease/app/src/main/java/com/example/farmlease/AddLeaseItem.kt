package com.example.farmlease


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.farmlease.common.BackButton
import com.example.farmlease.data.leaseItemsList
import com.example.farmlease.data.userOwnedItems
import com.example.farmlease.schemas.LeaseItem
import com.example.farmlease.schemas.LeaseItemType
import com.example.farmlease.schemas.Owner
import com.example.farmlease.viewmodel.FirebaseRepository
import com.example.farmlease.viewmodel.User


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddLeaseItem(leaseItemTypeStr: String, navController: NavController) {
    var name by remember { mutableStateOf("") }
    var desc by remember { mutableStateOf("") }
    var owner by remember { mutableStateOf("") }
    var contact by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        BackButton(navController = navController)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.farm_lease_logo
                ),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Crop
            )
            OutlinedTextField(
                value = name,
                label = { Text(text = "Item Name") },
                onValueChange = {
                    name = it
                },
                textStyle = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = desc,
                label = { Text(text = "Description") },
                onValueChange = {
                    desc = it
                },
                textStyle = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.fillMaxWidth()
            )
            // Owner Info
            OutlinedTextField(
                value = owner,
                label = { Text(text = "Owner Name") },
                onValueChange = {
                    owner = it
                },
                textStyle = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.fillMaxWidth()
            )
            // Contact
            OutlinedTextField(
                value = contact,
                label = { Text(text = "Contact Number") },
                onValueChange = {
                    contact = it
                },
                textStyle = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = address,
                label = { Text(text = "Address") },
                onValueChange = {
                    address = it
                },
                textStyle = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.fillMaxWidth()
            )
            // Price
            OutlinedTextField(
                value = price,
                label = { Text(text = "Price") },
                onValueChange = {
                    price = it
                },
                textStyle = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = {
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> 90e25a315058137b846e999cbc0bd1a26e53c714
                     val leaseItem = LeaseItem(
=======
                    val leaseItem = LeaseItem(
>>>>>>> 025814b (UI updates)
                        itemName = name,
                        price = price.toInt(),
                        address = address,
                        owner = Owner(
                            name = owner,
                            contact = contact
                        ),
                        type = LeaseItemType.valueOf(leaseItemTypeStr)
                    )
                    leaseItemsList.add(leaseItem)
                    userOwnedItems.add(leaseItem.id)
                    navController.popBackStack()
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 16.dp)
            ) {
                Text(
                    text = "Add",
                    fontSize = 30.sp,
                    style = MaterialTheme.typography.displaySmall
                )
            }
        }
    }
}


@Preview
@Composable
fun AddLeaseItemPreview() {
    AddLeaseItem(LeaseItemType.LAND.name, rememberNavController())
}
