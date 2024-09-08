package com.example.e_commerce_route_c40.ui.fragments.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.e_commerce_route_c40.R
import com.example.e_commerce_route_c40.adapters.HomeBrandsAdapter
import com.example.e_commerce_route_c40.adapters.HomeCategoriesAdapter
import com.example.e_commerce_route_c40.base.BaseFragment
import com.example.e_commerce_route_c40.databinding.FragmentHomeBinding
import com.example.e_commerce_route_c40.util.showToast
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
//  //  private lateinit var offersAdapter: OffersAdapter
    private lateinit var adapterCategories: HomeCategoriesAdapter
    private lateinit var adapterBrands: HomeBrandsAdapter
//    private lateinit var adapterHomeAppliance: AdapterHomeAppliance

    private val _viewModel :HomeViewModel by viewModels()

    override fun initViewModel(): HomeViewModel {
        return _viewModel
    }

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeLiveData()
        viewModel.getCategoryList()
        viewModel.getBrandsList()
    }

    private fun observeLiveData() {
        viewModel.categoriesLiveData.observe(viewLifecycleOwner){categories->
            adapterCategories.changeData(categories)
        }

        viewModel.brandsLiveData.observe(viewLifecycleOwner) { brands ->
            adapterBrands.changeData(brands)
        }
    }

    private fun initViews() {
        adapterCategories = HomeCategoriesAdapter()
        adapterBrands = HomeBrandsAdapter()

//        adapterHomeAppliance.setOncCartClick {
//            // action add to cart
//        }
//        adapterHomeAppliance.setOnFavClick {
//            //action add to favoriets
//        }
//        adapterHomeAppliance.setOnProductClick {
//            // action to specific product fragment
//        }
//
//        adapterCategories.setOnClick {
//            // action to specific category fragment
//        }
        binding.apply {
            rvCategories.adapter = adapterCategories
            rvBrands.adapter = adapterBrands

            etSearch.setOnClickListener {
                // Handle search button click
            }
            btnCart.setOnClickListener {
                // action to cart fragment
            }
            rvOffers.setOnClickListener {
                // action to specific fragment
            }
            tvViewAllCategories.setOnClickListener {
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToCategoryFragment())
            }
            rvCategories.setOnClickListener {
                // action to specific category fragment
            }
            rvHomeAppliance.setOnClickListener {
                // action to specific appliance fragment
            }

        }

    }
}