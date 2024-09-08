package com.example.e_commerce_route_c40.ui.fragments.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.e_commerce_route_c40.base.BaseViewModel
import com.route.domain.model.Brand
import com.route.domain.model.Category
import com.route.domain.usecase.GetBrandsUseCase
import com.route.domain.usecase.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getBrandsUseCase: GetBrandsUseCase
) : BaseViewModel() {
    val categoriesLiveData = MutableLiveData<List<Category>?>()
    val brandsLiveData = MutableLiveData<List<Brand>?>()

    fun getCategoryList() {
        try {
            viewModelScope.launch (Dispatchers.IO){
                val categories = getCategoriesUseCase.invoke()
                categoriesLiveData.postValue(categories)
            }
        }catch (e:Exception){
            handleError(e)
        }

    }

    fun getBrandsList() {
        try {
            viewModelScope.launch (Dispatchers.IO){
                val brands = getBrandsUseCase.invoke()
                brandsLiveData.postValue(brands)
            }
        }catch (e:Exception){
            handleError(e)

        }

    }

}