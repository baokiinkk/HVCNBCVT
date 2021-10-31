package com.baokiiin.hvcnbcvt.di

import com.baokiiin.hvcnbcvt.data.respository.Repository
import com.baokiiin.hvcnbcvt.data.respository.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun repository(repository: RepositoryImpl): Repository
}