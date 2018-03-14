package com.test.tabmarvelcomicscodingtest.mvp.model.pojo.response

import io.realm.RealmModel
import io.realm.annotations.RealmClass

/**
 * @author Filippo Engidashet [filippo.eng@gmail.com]
 * @version 1.0.0
 * @since Sunday, 11/03/2018 at 14:24.
 */

@RealmClass
open class TextObjects : RealmModel {

    private var text: String? = null
    private var language: String? = null
    private var type: String? = null

    override fun toString(): String {
        return "TextObjects [text = $text, language = $language, type = $type]"
    }
}
