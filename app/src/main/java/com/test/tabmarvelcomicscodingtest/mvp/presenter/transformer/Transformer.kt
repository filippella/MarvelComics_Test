package com.test.tabmarvelcomicscodingtest.mvp.presenter.transformer

/**
 * @author Filippo Engidashet [filippo.eng@gmail.com]
 * @version 1.0.0
 * @since Sunday, 11/03/2018 at 14:57.
 */

interface Transformer<in I, out O> {

    fun transform(input : I) : O
}