package com.example.farmlease

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Agriculture
import com.example.farmlease.schemas.LeaseItem
import androidx.compose.material.icons.filled.Factory
import androidx.compose.material.icons.filled.Grass
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.farmlease.data.leaseItemsList
import com.example.farmlease.schemas.LeaseItemType
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FarmLeaseApp(
    navController: NavController,
) {
    data class DrawerEntry(val icon: ImageVector, val label: String, val type: LeaseItemType)
    val drawerEntries = arrayOf(
        DrawerEntry(Icons.Default.Grass,"My Lands", LeaseItemType.LAND),
        DrawerEntry(Icons.Default.Agriculture,"Equipment", LeaseItemType.EQUIPMENT),
        DrawerEntry(Icons.Default.AccountCircle,"Labour", LeaseItemType.LABOUR),
        DrawerEntry(Icons.Default.LocalShipping,"Transportation", LeaseItemType.TRANSPORT),
        DrawerEntry(Icons.Default.Factory,"Cold Storages", LeaseItemType.STORAGE)
    )

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    var selectedItem = remember { mutableStateOf(drawerEntries[0]) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {
                Image(
                    painter = painterResource(
                        id = R.drawable.farm_lease_logo
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 18.dp)
                        .size(150.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary)
                        .align(Alignment.CenterHorizontally),

                    contentScale = ContentScale.Crop
                )
                Text(
                    text = stringResource(R.string.app_name),
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.displayLarge,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 9.dp, bottom = 18.dp)
                )
                drawerEntries.forEach { drawerEntry ->
                    NavigationDrawerItem(
                        icon = { Icon(drawerEntry.icon, contentDescription = null) },
                        label = { Text(drawerEntry.label) },
                        selected = drawerEntry == selectedItem.value,
                        onClick = {
                            selectedItem.value = drawerEntry
                            navController.navigate(ScreenRoute.UserItem.route + "/${drawerEntry.type.name}")
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                }
            }
        },
        content = {FarmLeaseScaffold(navController, drawerState)},
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FarmLeaseScaffold(
    navController: NavController,
    drawerState: DrawerState
) {
    val scope = rememberCoroutineScope()

    var selectedItemIndex by remember { mutableStateOf(LeaseItemType.LAND) }
    var listToShow: List<LeaseItem> = leaseItemsList.filter { it.type == selectedItemIndex }


    Scaffold(
        topBar = {
            TopAppBar(
                onMenuClick = {
                    scope.launch {
                        drawerState.open()
                    }
                }
            )
        },
        bottomBar = {
            data class navBarEntry(val icon: ImageVector, val label: String, val type: LeaseItemType)

            val navBarEntries = arrayOf(
                navBarEntry(Icons.Default.Grass, "Lands", LeaseItemType.LAND),
                navBarEntry(Icons.Default.Agriculture, "Equipment", LeaseItemType.EQUIPMENT),
                navBarEntry(Icons.Default.AccountCircle, "Labour", LeaseItemType.LABOUR),
                navBarEntry(Icons.Default.LocalShipping, "Transport", LeaseItemType.TRANSPORT),
                navBarEntry(Icons.Default.Factory, "Cold Storages", LeaseItemType.STORAGE),
            )
            NavigationBar {
                navBarEntries.forEach {
                    NavigationBarItem(
                        icon = { Icon(imageVector = it.icon, contentDescription = null) },
                        onClick = {
                            selectedItemIndex = it.type
                        },
                        selected = (selectedItemIndex == it.type)
                    )

                }
            }
        }
    ) {
        paddingValue ->
            LazyColumn(contentPadding = paddingValue) {
                items(listToShow) { id ->
                        LeaseItemCard(id,
                            onItemClick = {
                                navController.navigate(ScreenRoute.ItemDetail.route + "/${id.id}")
                            },
                            modifier = Modifier.padding(6.dp)
                        )
                }
            }
        }
    }


@Preview
@Composable
fun PreviewFarmLeaseApp() {
    FarmLeaseApp(navController = rememberNavController())
}