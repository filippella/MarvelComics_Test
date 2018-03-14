package com.test.tabmarvelcomicscodingtest.mvp.presenter

import com.test.tabmarvelcomicscodingtest.mvp.model.api.MarvelApi
import com.test.tabmarvelcomicscodingtest.mvp.model.manager.DatabaseManager
import com.test.tabmarvelcomicscodingtest.mvp.model.manager.RestApiManager
import com.test.tabmarvelcomicscodingtest.mvp.model.pojo.request.ComicsRequest
import com.test.tabmarvelcomicscodingtest.mvp.model.pojo.response.ComicsResponse
import com.test.tabmarvelcomicscodingtest.mvp.view.MarvelView
import io.reactivex.Observable
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner


/**
 * @author Filippo Engidashet [filippo.eng@gmail.com]
 * @version 1.0.0
 * @since Sunday, 11/03/2018 at 21:55.
 */

@RunWith(MockitoJUnitRunner::class)
class MarvelPresenterTest {

    @InjectMocks lateinit var mPresenter : MarvelPresenter
    @Mock lateinit var mView : MarvelView
    @Mock lateinit var mApiManager : RestApiManager
    @Mock lateinit var mDBManager : DatabaseManager

    @Before
    fun setUp() {

        RxAndroidPlugins.reset()
        RxAndroidPlugins.setMainThreadSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }

        //Set Schedulers to trampoline
        RxJavaPlugins.reset()
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }

        mPresenter.construct()
    }

    @Test
    fun getComics_Success() {

        val apiObservable : Observable<ComicsResponse> = Observable.just(ComicsResponse())
        val marvelApi = mock(MarvelApi::class.java)
        `when`(marvelApi.getComics(anyInt(), anyInt(), anyString(), anyString(), anyLong())).thenReturn(apiObservable)

        val request = ComicsRequest(0, 10, "hash", "apiKey", 1234)
        `when`(mApiManager.getComicsRequest(anyInt(), ArgumentMatchers.anyInt())).thenReturn(request)
        `when`(mApiManager.getMarvelApi()).thenReturn(marvelApi)
        `when`(mDBManager.mDBObservable).thenReturn(apiObservable)

        mPresenter.getComics(0, 10)

        verify(mView, atLeastOnce()).onLoadComics(anyList())
    }

    @After
    fun tearDown() {
        mPresenter.destruct()

        RxAndroidPlugins.reset()
        RxJavaPlugins.reset()
    }
}