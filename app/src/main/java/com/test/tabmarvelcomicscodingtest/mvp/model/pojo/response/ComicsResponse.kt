package com.test.tabmarvelcomicscodingtest.mvp.model.pojo.response

import io.realm.RealmModel
import io.realm.annotations.RealmClass

/**
 * @author Filippo Engidashet [filippo.eng@gmail.com]
 * @version 1.0.0
 * @since Sunday, 11/03/2018 at 13:26.
 */

@RealmClass
open class ComicsResponse : RealmModel {

    var attributionText: String? = null
    var etag: String? = null
    var status: String? = null
    var data: Data? = null
    var copyright: String? = null
    var code: Int? = null
    var attributionHTML: String? = null

    override fun toString(): String {
        return "ComicsResponse [attributionText = $attributionText, etag = $etag, status = $status, data = $data, copyright = $copyright, code = $code, attributionHTML = $attributionHTML]"
    }
}
