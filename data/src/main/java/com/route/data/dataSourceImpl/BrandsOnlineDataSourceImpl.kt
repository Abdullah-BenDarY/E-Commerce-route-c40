package com.route.data.dataSourceImpl

import com.route.data.api.WebServices
import com.route.data.dataSourcesContract.BrandsOnlineDataSource
import com.route.domain.model.Brand
import javax.inject.Inject

class BrandsOnlineDataSourceImpl @Inject constructor(
    private val webServices: WebServices
) :BrandsOnlineDataSource {

    override suspend fun getBrands(): List<Brand>? {
        val response = webServices.getAllBrands()
        return response.data?.map { dataItem ->
            dataItem?.toBrands() ?: Brand()

        }
    }
}