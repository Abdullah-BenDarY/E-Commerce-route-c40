package com.route.domain.usecase

import com.route.domain.model.Brand
import com.route.domain.model.Category
import com.route.domain.repositories.BrandsRepository
import com.route.domain.repositories.CategoriesRepository
import javax.inject.Inject

class GetBrandsUseCase @Inject constructor(
    private val brandsRepository: BrandsRepository
) {
    suspend fun invoke():List<Brand>? {
        return brandsRepository.getBrands()
    }
}