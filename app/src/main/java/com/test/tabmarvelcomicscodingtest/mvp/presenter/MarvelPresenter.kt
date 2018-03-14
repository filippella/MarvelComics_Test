package com.test.tabmarvelcomicscodingtest.mvp.presenter

import com.test.tabmarvelcomicscodingtest.mvp.model.api.MarvelApi
import com.test.tabmarvelcomicscodingtest.mvp.model.manager.DatabaseManager
import com.test.tabmarvelcomicscodingtest.mvp.model.manager.RestApiManager
import com.test.tabmarvelcomicscodingtest.mvp.model.pojo.vo.Comics
import com.test.tabmarvelcomicscodingtest.mvp.presenter.transformer.ComicsTransformer
import com.test.tabmarvelcomicscodingtest.mvp.view.MarvelView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * @author Filippo Engidashet [filippo.eng@gmail.com]
 * @version 1.0.0
 * @since Sunday, 11/03/2018 at 13:42.
 */

class MarvelPresenter @Inject constructor(private var mView: MarvelView?, private var mRestManager: RestApiManager?, private var mDBManager: DatabaseManager?) {

    private var mCompositeDisposable: CompositeDisposable? = null

    fun construct() {
        mCompositeDisposable = CompositeDisposable()
    }

    private fun clearSubscriptions() {
        if (mCompositeDisposable != null && !mCompositeDisposable!!.isDisposed) {
            mCompositeDisposable!!.dispose()
        }
    }

    fun getComics(offset: Int, limit: Int) {

        val apiObservable: MarvelApi = mRestManager!!.getMarvelApi()
        val request = mRestManager!!.getComicsRequest(offset, limit)

        mCompositeDisposable!!.add(
                apiObservable.getComics(request.offset, request.limit, request.hash, request.apiKey, request.timestamp)
                        .publish { remote ->
                            Observable.mergeDelayError(
                                    remote.subscribeOn(Schedulers.io())
                                            .observeOn(AndroidSchedulers.mainThread())
                                            .doOnNext {
                                                println("Saving to database")
                                                //save to database here
                                                mDBManager!!.saveComics(it)
                                                mView!!.onLoadComics(ComicsTransformer().transform(it).getComicVOList())
                                            }
                                    , mDBManager!!.mDBObservable.takeUntil(remote)
                            )
                        }
                        .map { comicsResponse -> ComicsTransformer().transform(comicsResponse) }
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .unsubscribeOn(Schedulers.computation())
                        .subscribeWith(object : DisposableObserver<Comics>() {

                            override fun onNext(comics: Comics) {
                                mView!!.onLoadComics(comics.getComicVOList())
                            }

                            override fun onError(e: Throwable) {
                                mView!!.onError(e.message)
                            }

                            override fun onComplete() {
                                println("Comics completed")
                            }
                        })
        )
    }

    fun destruct() {
        clearSubscriptions()
        mCompositeDisposable = null;
        mView = null
        mRestManager = null
    }
}
