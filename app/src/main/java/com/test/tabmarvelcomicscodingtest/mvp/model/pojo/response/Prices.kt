package com.test.tabmarvelcomicscodingtest.mvp.model.pojo.response

import io.realm.RealmModel
import io.realm.annotations.RealmClass

/**
 * @author Filippo Engidashet [filippo.eng@gmail.com]
 * @version 1.0.0
 * @since Sunday, 11/03/2018 at 13:31.
 */

@RealmClass
open class Prices : RealmModel {

    var price: String? = null
    var type: String? = null

    override fun toString(): String {
        return "Prices [price = $price, type = $type]"
    }
}
