package com.test.tabmarvelcomicscodingtest.mvp.model.api

import com.test.tabmarvelcomicscodingtest.mvp.model.Constants
import com.test.tabmarvelcomicscodingtest.mvp.model.pojo.response.ComicsResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Filippo Engidashet [filippo.eng@gmail.com]
 * @version 1.0.0
 * @since Sunday, 11/03/2018 at 13:19.
 */

interface MarvelApi {

    @GET(Constants.COMICS_END_POINT)
    fun getComics(@Query("offset") offset: Int,
                  @Query("limit") limit: Int,
                  @Query("hash") hash: String,
                  @Query("apikey") apiKey: String,
                  @Query("ts") timestamp: Long) : Observable<ComicsResponse>
}
