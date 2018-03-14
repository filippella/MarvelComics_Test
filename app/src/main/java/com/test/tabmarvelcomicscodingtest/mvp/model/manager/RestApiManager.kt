package com.test.tabmarvelcomicscodingtest.mvp.model.manager

import com.test.tabmarvelcomicscodingtest.mvp.model.Constants
import com.test.tabmarvelcomicscodingtest.mvp.model.api.MarvelApi
import com.test.tabmarvelcomicscodingtest.mvp.model.pojo.request.ComicsRequest
import com.test.tabmarvelcomicscodingtest.utilities.CryptoUtils

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

/**
 * @author Filippo Engidashet [filippo.eng@gmail.com]
 * @version 1.0.0
 * @since Sunday, 11/03/2018 at 13:55.
 */

class RestApiManager @Inject constructor() {

    private val api: MarvelApi

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        api = retrofit.create(MarvelApi::class.java)
    }

    fun getMarvelApi(): MarvelApi {
        return api
    }

    /**
     * This function takes offset and limit needed for the comi
     */
    fun getComicsRequest(offset: Int, limit: Int): ComicsRequest {
        val timestamp = System.currentTimeMillis()
        val apiKey = Constants.PUBLIC_KEY
        val md5Digest = CryptoUtils.md5Digest(timestamp.toString() + Constants.PRIVATE_KEY + apiKey)
        return ComicsRequest(offset, limit, md5Digest, apiKey, timestamp)
    }
}
