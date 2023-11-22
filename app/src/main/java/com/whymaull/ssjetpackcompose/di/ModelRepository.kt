package com.whymaull.ssjetpackcompose.di

import com.whymaull.ssjetpackcompose.data.local.PhoneDao
import com.whymaull.ssjetpackcompose.data.repository.Repository

object ModelRepository {

    fun provideRepository(phoneDao: PhoneDao) = Repository(phoneDao)

}