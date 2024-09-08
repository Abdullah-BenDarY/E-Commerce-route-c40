package com.route.data.repositories

import com.route.data.dataSourcesContract.BrandsOnlineDataSource
import com.route.domain.model.Brand
import com.route.domain.repositories.BrandsRepository
import javax.inject.Inject

class BrandsRepoImpl @Inject constructor(
    private val onlineDataSource: BrandsOnlineDataSource
):BrandsRepository {

    override suspend fun getBrands(): List<Brand>? {
        return onlineDataSource.getBrands()
    }

}