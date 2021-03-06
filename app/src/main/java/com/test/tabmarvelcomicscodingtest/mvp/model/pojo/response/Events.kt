package com.test.tabmarvelcomicscodingtest.mvp.model.pojo.response

import io.realm.RealmList
import io.realm.RealmModel
import io.realm.annotations.RealmClass

/**
 * @author Filippo Engidashet [filippo.eng@gmail.com]
 * @version 1.0.0
 * @since Sunday, 11/03/2018 at 13:28.
 */

@RealmClass
open class Events : RealmModel {

    var items: RealmList<Items>? = null
    var collectionURI: String? = null
    var available: String? = null
    var returned: String? = null

    override fun toString(): String {
        return "Events [items = $items, collectionURI = $collectionURI, available = $available, returned = $returned]"
    }
}
