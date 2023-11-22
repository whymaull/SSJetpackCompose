package com.whymaull.ssjetpackcompose.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dataPhone")
data class PhoneEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val description: String,
    val location: String,
    val photoUrl: String,
    val rating: Double,
    val totalReview: Int,
    var isFavorite: Boolean = false,

)
