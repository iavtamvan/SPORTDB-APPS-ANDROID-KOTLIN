package com.iav.sportdbapps.model

import com.google.gson.annotations.SerializedName

data class ItemsSport(

	@field:SerializedName("teams")
	val teams: List<TeamsItem?>? = null
)