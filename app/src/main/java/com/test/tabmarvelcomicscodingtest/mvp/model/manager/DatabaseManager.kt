package com.test.tabmarvelcomicscodingtest.mvp.model.manager

import com.test.tabmarvelcomicscodingtest.mvp.model.pojo.response.ComicsResponse
import io.reactivex.Observable
import io.realm.Realm
import javax.inject.Inject

/**
 * @author Filippo Engidashet [filippo.eng@gmail.com]
 * @version 1.0.0
 * @since Sunday, 11/03/2018 at 16:47.
 */

class DatabaseManager @Inject constructor() {

    val mDBObservable: Observable<ComicsResponse> = Observable.create { emitter ->
        val realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        val comics: ComicsResponse? = realm.where(ComicsResponse::class.java).findFirst()
        realm.commitTransaction()
        comics?.let {
            emitter.onNext(it)
        } ?: run {
            emitter.onError(Throwable("Comics was not found"))
        }
    }

    fun saveComics(comicsResponse: ComicsResponse) {
        try {
            val realm = Realm.getDefaultInstance()
            realm.beginTransaction()
            realm.delete(ComicsResponse::class.java)
            realm.copyToRealm(comicsResponse)
            realm.commitTransaction()
        } catch (e : Exception) {
            println(e.message)
        }

    }
}
