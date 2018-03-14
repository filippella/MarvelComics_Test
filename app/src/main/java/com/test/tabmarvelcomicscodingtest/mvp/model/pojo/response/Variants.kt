package com.test.tabmarvelcomicscodingtest.mvp.model.pojo.response

import io.realm.RealmModel
import io.realm.annotations.RealmClass

/**
 * @author Filippo Engidashet [filippo.eng@gmail.com]
 * @version 1.0.0
 * @since Sunday, 11/03/2018 at 14:28.
 */

@RealmClass
open class Variants : RealmModel {

    internal var resourceURI: String? = null
    internal var name: String? = null

    override fun toString(): String {
        return "Variants [resourceURI = $resourceURI, name = $name]"
    }
}
