package com.whymaull.ssjetpackcompose.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PhoneDao {

    @Query("SELECT * FROM dataPhone")
    fun getAllPhone(): Flow<List<PhoneEntity>>

    @Query("SELECT * FROM dataPhone WHERE isFavorite = 1")
    fun getAllFavPhone(): Flow<List<PhoneEntity>>

    @Query("SELECT * FROM dataPhone WHERE id = :id")
    fun getPhone(id: Int): Flow<PhoneEntity>

    @Query("SELECT * FROM dataPhone WHERE name LIKE '%' || :query || '%'")
    fun searchPhone(query: String): Flow<List<PhoneEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPhone(tourismList: List<PhoneEntity>)

    @Query("UPDATE dataPhone SET isFavorite = :isFavorite WHERE id = :id")
    suspend fun updateFavPhone(id: Int, isFavorite: Boolean)

}