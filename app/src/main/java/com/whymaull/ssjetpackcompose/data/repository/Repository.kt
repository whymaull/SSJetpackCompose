package com.whymaull.ssjetpackcompose.data.repository

import com.whymaull.ssjetpackcompose.data.local.PhoneDao
import com.whymaull.ssjetpackcompose.data.local.PhoneEntity


class Repository ( private val phoneDao: PhoneDao) {

    fun getAllPhone() = phoneDao.getAllPhone()
    fun getAllFavPhone() = phoneDao.getAllFavPhone()
    fun getPhone(id: Int) = phoneDao.getPhone(id)
    fun searchPhone(query: String) = phoneDao.searchPhone(query)
    suspend fun insertAllPhone(tourism: List<PhoneEntity>) = phoneDao.insertAllPhone(tourism)
    suspend fun updateFavPhone(id: Int, isFavorite: Boolean) = phoneDao.updateFavPhone(id, isFavorite)

}