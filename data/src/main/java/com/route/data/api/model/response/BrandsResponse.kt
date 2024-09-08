package com.route.data.api.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.route.domain.model.Brand
import kotlinx.parcelize.Parcelize

@Parcelize
data class BrandsResponse(

    @field:SerializedName("metadata")
    val metadata: Metadata? = null,

    @field:SerializedName("data")
    val data: List<DataItem?>? = null,

    @field:SerializedName("results")
    val results: Int? = null
) : Parcelable

@Parcelize
data class Metadata(

    @field:SerializedName("numberOfPages")
    val numberOfPages: Int? = null,

    @field:SerializedName("nextPage")
    val nextPage: Int? = null,

    @field:SerializedName("limit")
    val limit: Int? = null,

    @field:SerializedName("currentPage")
    val currentPage: Int? = null
) : Parcelable

@Parcelize
data class DataItem(

    @field:SerializedName("image")
    val image: String? = null,

    @field:SerializedName("createdAt")
    val createdAt: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("_id")
    val id: String? = null,

    @field:SerializedName("slug")
    val slug: String? = null,

    @field:SerializedName("updatedAt")
    val updatedAt: String? = null
) : Parcelable {    // convert

	fun toBrands(): Brand {
		return Brand(
			id = id,
			image = image,
			name = name,
			slug = slug
		)
	}
}

