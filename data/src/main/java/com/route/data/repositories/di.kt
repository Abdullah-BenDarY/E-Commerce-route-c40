package com.route.data.repositories

import com.route.domain.model.Brand
import com.route.domain.repositories.BrandsRepository
import com.route.domain.repositories.CategoriesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoriesBinder{

    @Binds
    abstract fun bindCategoriesRepo(
        categoriesRepoImpl: CategoriesRepoImpl
    ):CategoriesRepository

    @Binds
    abstract fun bindBrandsRepo(
        brandsRepoImpl: BrandsRepoImpl
    ):BrandsRepository


}