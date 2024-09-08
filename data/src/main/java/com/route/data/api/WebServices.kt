package com.route.data.api

import com.route.data.api.model.response.BrandsResponse
import com.route.data.api.model.response.CategoriesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface WebServices {

    @GET("api/v1/categories")
    suspend fun getCategories():CategoriesResponse

    @GET("api/v1/categories/{catId}/subcategories")
    suspend fun getSubCategories(
        @Path("catId")categoryId:String
    ):CategoriesResponse

    @GET("api/v1/products")
    suspend fun getProducts(
        @Query("catId")categoryId:String? =null,
    ):CategoriesResponse

    @GET("api/v1/brands")
    suspend fun getAllBrands():BrandsResponse


}