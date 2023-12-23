package com.yusuf.phonedirectory.di

import com.yusuf.phonedirectory.data.repository.ContactRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideContactRepository() : ContactRepository{
        return ContactRepository()
    }
}