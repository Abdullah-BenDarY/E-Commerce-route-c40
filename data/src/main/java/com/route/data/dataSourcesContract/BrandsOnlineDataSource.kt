package com.route.data.dataSourcesContract

import com.route.domain.model.Brand

interface BrandsOnlineDataSource {
    suspend fun getBrands():List<Brand>?
}