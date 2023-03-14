package com.xavijimenezmulet.cart.view

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.xavijimenezmulet.cart.CartViewModel
import com.xavijimenezmulet.constants.Constants.PRODUCT_IMAGE_URL
import com.xavijimenezmulet.entity.cart.Cart
import com.xavijimenezmulet.theme.MobileChallengeColors
import com.xavijimenezmulet.theme.MobileChallengeTheme
import com.xavijimenezmulet.theme.MobileChallengeTypography
import com.xavijimenezmulet.theme.Red
import com.xavijimenezmulet.utils.extension.toCurrency

@Composable
fun CartRow(
    viewModel: CartViewModel = hiltViewModel(),
    dto: Cart,
    onDetailClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .clickable {
                onDetailClick()
            }
            .fillMaxWidth()
            .height(100.dp)
            .padding(
                vertical = 4.dp,
                horizontal = 8.dp
            ),
        elevation = CardDefaults.elevatedCardElevation(),
        colors = CardDefaults.cardColors(
            containerColor = MobileChallengeColors.surface
        )
    ) {
        Row {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(PRODUCT_IMAGE_URL)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .clip(RoundedCornerShape(size = 8.dp))
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 12.dp, start = 4.dp, bottom = 4.dp)
            ) {
                Text(
                    text = dto.name,
                    modifier = Modifier
                        .fillMaxWidth(),
                    style = MobileChallengeTypography.titleMedium
                )
                Text(
                    text = dto.code,
                    modifier = Modifier
                        .fillMaxWidth(),
                    style = MobileChallengeTypography.titleMedium
                )
                Text(
                    text = dto.price?.toCurrency().orEmpty(),
                    modifier = Modifier
                        .fillMaxWidth(),
                    style = MobileChallengeTypography.titleLarge
                )
            }

            Row(
                modifier = Modifier.fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                    }
                ) {
                    Icon(
                        Icons.Outlined.Delete,
                        contentDescription = "Delete",
                        tint = Red
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    name = "Light Mode"
)
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode"
)
@Composable
fun CartRowPreview() {
    MobileChallengeTheme {
        //CartRow(dto = Cart.init())
    }
}