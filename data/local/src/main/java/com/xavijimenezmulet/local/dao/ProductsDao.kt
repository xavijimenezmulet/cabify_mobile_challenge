package com.xavijimenezmulet.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.xavijimenezmulet.framework.base.room.dao.BaseDao
import com.xavijimenezmulet.model.local.products.ProductEntity

@Dao
interface ProductsDao : BaseDao<ProductEntity> {
    @Query("SELECT * FROM ${ProductEntity.TABLE_NAME}")
    suspend fun getProductList(): List<ProductEntity>

    @Query("SELECT * FROM ${ProductEntity.TABLE_NAME} WHERE id = :id")
    suspend fun getProduct(id: Int): ProductEntity?
}