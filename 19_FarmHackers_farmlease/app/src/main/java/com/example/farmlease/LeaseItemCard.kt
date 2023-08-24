package com.example.farmlease

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.farmlease.data.leaseItemsList
import com.example.farmlease.schemas.LeaseItem
import com.example.farmlease.schemas.LeaseItemType
import com.example.farmlease.ui.theme.Shapes
import java.text.NumberFormat

@Composable
fun LeaseItemCard(
    leaseItem: LeaseItem,
    modifier: Modifier = Modifier,
    onItemClick: () -> Unit,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onItemClick),
        shape = Shapes.large
    ) {
        Column {
            Row(modifier = Modifier.padding(6.dp)) {
                Image(
                    painter = painterResource(id = leaseItem.img ?: R.drawable.farm_lease_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(108.dp)
                        .padding(end = 15.dp)
                        .clip(Shapes.large)
                        .align(Alignment.Top),
                    contentScale = ContentScale.Crop,
                )

                Column(modifier = modifier.fillMaxWidth()) {
                    Text(
                        text = leaseItem.itemName,
                        style = MaterialTheme.typography.displayLarge,
                        modifier = modifier
                            .padding(bottom = 6.dp)
                    )
                    Text(
                        text = leaseItem.address,
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = modifier.padding(start = 1.dp)
                    )
                }
            }
            // Price and area fields
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                if (leaseItem.type == LeaseItemType.LAND)
                    Text(
                        text = leaseItem.landArea.toString() + " Acres",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onPrimary,
                        modifier = modifier
                            .padding(start = 3.dp)
                            .clip(RoundedCornerShape(9.dp))
                            .background(MaterialTheme.colorScheme.surfaceTint)
                            .padding(6.dp)
                    )
                Spacer(Modifier.weight(1f))
                Text(
                    text = NumberFormat.getCurrencyInstance().format(leaseItem.price),
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = modifier
                       // .padding(9.dp)
                        .clip(RoundedCornerShape(9.dp))
                        .background(MaterialTheme.colorScheme.surfaceTint)
                        .padding(6.dp),
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LeaseItemCardPreview() {
    LeaseItemCard(
        leaseItemsList[0],
        onItemClick = {},
    )
}
