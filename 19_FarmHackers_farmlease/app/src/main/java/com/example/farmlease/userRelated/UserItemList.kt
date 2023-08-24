package com.example.farmlease.userRelated

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Key
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.farmlease.AddLeaseItem
import com.example.farmlease.LeaseItemCard
import com.example.farmlease.ScreenRoute
import com.example.farmlease.data.leaseItemsList
import com.example.farmlease.data.userLeasedItems
import com.example.farmlease.data.userOwnedItems
import com.example.farmlease.schemas.LeaseItemType

enum class NavPaths { OWNED, LEASED }


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserItemList(leaseItemTypeStr: String, navController: NavController) {
    val leaseItemType = LeaseItemType.valueOf(leaseItemTypeStr)

    var selectedItemIndex by remember { mutableStateOf(NavPaths.OWNED) }

    Scaffold(
        floatingActionButton = {
            if (selectedItemIndex == NavPaths.OWNED)
                FloatingActionButton(onClick = { navController.navigate(ScreenRoute.AddItem.route + "/${leaseItemTypeStr}") }) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add",
                        modifier = Modifier.padding(12.dp)
                    )
                }
        },
        bottomBar = {
            data class navBarEntry(val icon: ImageVector, val label: String, val index: NavPaths)

            val navBarEnties = arrayOf(
                navBarEntry(Icons.Default.AccountCircle, "Owned", NavPaths.OWNED),
                navBarEntry(Icons.Default.Key, "Leased", NavPaths.LEASED),
            )
            NavigationBar {
                navBarEnties.forEach {
                    NavigationBarItem(
                        icon = { Icon(imageVector = it.icon, contentDescription = null) },
                        label = { Text(it.label) },
                        onClick = {
                            selectedItemIndex = if (selectedItemIndex == NavPaths.OWNED) NavPaths.LEASED else NavPaths.OWNED

                        },
                        selected = (selectedItemIndex == it.index)
                    )

                }
            }
        }
    ) { paddingValue ->
        LazyColumn(contentPadding = paddingValue) {
            val listToShow = if (selectedItemIndex == NavPaths.LEASED) userLeasedItems else userOwnedItems
            items(listToShow) { id ->
                val leaseItem = leaseItemsList.find { it.id == id }
                if (leaseItem != null && leaseItem.type == leaseItemType)
                    LeaseItemCard(leaseItem,
                        onItemClick = {
                            navController.navigate(ScreenRoute.ItemDetail.route + "/${id}")
                        },
                        modifier = Modifier.padding(6.dp)
                    )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun UserLandListPreview() {
    UserItemList(LeaseItemType.LAND.name, rememberNavController())
}