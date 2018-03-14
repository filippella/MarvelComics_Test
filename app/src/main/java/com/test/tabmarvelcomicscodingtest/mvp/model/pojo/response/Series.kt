package com.test.tabmarvelcomicscodingtest.mvp.model.pojo.response

import io.realm.RealmModel
import io.realm.annotations.RealmClass

/**
 * @author Filippo Engidashet [filippo.eng@gmail.com]
 * @version 1.0.0
 * @since Sunday, 11/03/2018 at 13:33.
 */

@RealmClass
open class Series : RealmModel {

    var resourceURI: String? = null
    var name: String? = null

    override fun toString(): String {
        return "Series [resourceURI = $resourceURI, name = $name]"
    }
}
