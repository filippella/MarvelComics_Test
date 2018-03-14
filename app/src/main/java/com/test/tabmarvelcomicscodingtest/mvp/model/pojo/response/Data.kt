package com.test.tabmarvelcomicscodingtest.mvp.model.pojo.response

import io.realm.RealmList
import io.realm.RealmModel
import io.realm.annotations.RealmClass

/**
 * @author Filippo Engidashet [filippo.eng@gmail.com]
 * @version 1.0.0
 * @since Sunday, 11/03/2018 at 13:26.
 */

@RealmClass
open class Data : RealmModel {

    var total: Int? = null
    var limit: Int? = null
    var results: RealmList<Results>? = null
    var count: Int? = null
    var offset: Int? = null

    override fun toString(): String {
        return "Data [total = $total, limit = $limit, results = $results, count = $count, offset = $offset]"
    }
}
