package com.example.farmlease

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavController
import com.example.farmlease.schemas.LeaseItem

@Composable
fun LeaseItemsList(
    leaseItemsList: MutableList<LeaseItem>,
    contentPadding: PaddingValues,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    LazyColumn(contentPadding = contentPadding) {
        items(leaseItemsList) {
            LeaseItemCard(
                leaseItem = it,
                modifier = modifier
                    .padding(dimensionResource(R.dimen.padding_small)),
                onItemClick = { navController.navigate(ScreenRoute.ItemDetail.route + "/${it.id}") }
            )
        }
    }
}