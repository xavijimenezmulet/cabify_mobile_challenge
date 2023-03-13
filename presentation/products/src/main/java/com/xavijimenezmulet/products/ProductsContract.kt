package com.xavijimenezmulet.products

import androidx.paging.PagingData
import com.xavijimenezmulet.entity.products.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

/**
 *   @author xavierjimenez
 *   @since 13/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
data class CharactersViewState(
    val pagedData: Flow<PagingData<Product>> = emptyFlow()
)

sealed class ProductsEvent {
    object LoadProducts : ProductsEvent()
}