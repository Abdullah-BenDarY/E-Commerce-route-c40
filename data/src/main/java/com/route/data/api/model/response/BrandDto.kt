package com.route.data.api.model.response

import com.google.gson.annotations.SerializedName
import com.route.domain.model.Brand

data class BrandDto(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("slug")
	val slug: String? = null
)

