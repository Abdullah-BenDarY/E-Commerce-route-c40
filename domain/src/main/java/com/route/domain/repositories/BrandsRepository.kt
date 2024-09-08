package com.route.domain.repositories

import com.route.domain.model.Brand
import com.route.domain.model.Category
import com.route.domain.model.SubCategory

interface BrandsRepository {
    suspend fun getBrands():List<Brand>?
}