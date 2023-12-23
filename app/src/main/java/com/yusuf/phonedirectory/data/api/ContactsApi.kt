package com.yusuf.phonedirectory.data.api


import com.yusuf.phonedirectory.data.entity.CRUDResult
import com.yusuf.phonedirectory.data.entity.ResultKisiler
import com.yusuf.phonedirectory.utils.Utils.Companion.DELETE_URL
import com.yusuf.phonedirectory.utils.Utils.Companion.GET_URL
import com.yusuf.phonedirectory.utils.Utils.Companion.INSERT_URL
import com.yusuf.phonedirectory.utils.Utils.Companion.SEARCH_URL
import com.yusuf.phonedirectory.utils.Utils.Companion.UPDATE_URL
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ContactsApi {

    @GET(GET_URL)
    suspend fun getAllContacts() : ResultKisiler

    @POST(SEARCH_URL)
    @FormUrlEncoded
    suspend fun searchContact(@Field("kisi_ad") kisi_ad:String) : ResultKisiler

    @POST(DELETE_URL)
    @FormUrlEncoded
    suspend fun deleteContact(@Field("kisi_id") kisi_id:Int) : CRUDResult

    @POST(INSERT_URL)
    @FormUrlEncoded
    suspend fun insertContact(@Field("kisi_ad") kisi_ad:String,@Field("kisi_tel") kisi_tel:String) : CRUDResult

    @POST(UPDATE_URL)
    @FormUrlEncoded
    suspend fun updateContact(@Field("kisi_id") kisi_id: Int,@Field("kisi_ad") kisi_ad:String,@Field("kisi_tel") kisi_tel:String) : CRUDResult
}