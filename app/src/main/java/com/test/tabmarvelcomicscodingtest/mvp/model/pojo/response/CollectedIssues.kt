package com.test.tabmarvelcomicscodingtest.mvp.model.pojo.response

import io.realm.RealmModel
import io.realm.annotations.RealmClass

/**
 * @author Filippo Engidashet [filippo.eng@gmail.com]
 * @version 1.0.0
 * @since Sunday, 11/03/2018 at 14:24.
 */

@RealmClass
open class CollectedIssues : RealmModel {

    private var resourceURI: String? = null
    private var name: String? = null

    override fun toString(): String {
        return "CollectedIssues [resourceURI = $resourceURI, name = $name]"
    }
}
