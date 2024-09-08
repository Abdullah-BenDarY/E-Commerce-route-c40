package com.route.data.dataSourceImpl

import com.route.data.dataSourcesContract.BrandsOnlineDataSource
import com.route.data.dataSourcesContract.CategoriesOnlineDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class DataSourceBinder{

    @Binds
    abstract fun bindOnlineDataSource(
        categoriesOnlineDataSourceImpl: CategoriesOnlineDataSourceImpl
    ): CategoriesOnlineDataSource

    @Binds
    abstract fun bindOnlineBrandsDataSource(
        brandsOnlineDataSource: BrandsOnlineDataSourceImpl
    ): BrandsOnlineDataSource
}