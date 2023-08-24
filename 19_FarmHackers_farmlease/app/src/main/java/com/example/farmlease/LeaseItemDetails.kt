package com.example.farmlease

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.farmlease.data.leaseItemsList
import com.example.farmlease.schemas.LeaseItemType
import java.text.NumberFormat

@Composable
fun LeaseItemDetails(
    leaseItemId: Int,
    onLeaseButtonClick: () -> Unit,
    navController: NavController,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        IconButton(
            onClick = { navController.popBackStack() }
        ) {
            Icon(
                imageVector = Icons.Outlined.ArrowBack,
                tint = MaterialTheme.colorScheme.primary,
                contentDescription = "back_button",
                modifier = Modifier
                    .padding(start = 6.dp, top = 9.dp)
                    .fillMaxSize()
            )
        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            val leaseItem = leaseItemsList.find { it.id == leaseItemId } ?: leaseItemsList[0]
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

            Text(
                text = leaseItem.itemName,
                style = MaterialTheme.typography.displayLarge,
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 8.dp)
            )

            if (leaseItem.type == LeaseItemType.LAND)
                FormattedTextField(label = "Area: ", value = leaseItem.landArea.toString() + " Acres")

            LongTextField("Address: ", leaseItem.address)

            leaseItem.desc?.let {
                LongTextField(label = "Description: ", content = leaseItem.desc.toString())
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Owner Info
            FormattedTextField(label = "Owner: ", value = leaseItem.owner.name)
            Spacer(modifier = Modifier.height(8.dp))
            // Contact
            FormattedTextField(label = "Contact: ", value = leaseItem.owner.contact)
            Spacer(modifier = Modifier.height(16.dp))
            // Price
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .padding(9.dp)
            ) {
                Text(
                    text = "Price: " + NumberFormat.getCurrencyInstance().format(leaseItem.price),
                    style = MaterialTheme.typography.displaySmall,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                )
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = onLeaseButtonClick,
                ) {
                    Text(
                        text = "Lease",
                        style = MaterialTheme.typography.displaySmall,
                    )
                }

            }
        }
    }
}

@Composable
fun FormattedTextField(
    label: String,
    value: String = "",
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelLarge,
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 6.dp)
        )
    }
}

@Composable
fun LongTextField(
    label: String,
    content: String
) {
    FormattedTextField(label)
    Column(
        modifier = Modifier
            .border(1.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(9.dp))
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .heightIn(max = 120.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = content,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            modifier = Modifier.fillMaxWidth()
                .padding(3.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun LeaseItemDetailsPreview() {
    LeaseItemDetails(leaseItemsList[0].id, {}, rememberNavController())
}
