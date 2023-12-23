package com.yusuf.phonedirectory.di

import com.yusuf.phonedirectory.data.api.ContactsApi
import com.yusuf.phonedirectory.data.repository.ContactRepository
import com.yusuf.phonedirectory.utils.Utils.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideContactRepository(api:ContactsApi) : ContactRepository{
        return ContactRepository(api)
    }

    @Provides
    @Singleton
    fun provideContactsAPi() : ContactsApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ContactsApi::class.java)
    }
}