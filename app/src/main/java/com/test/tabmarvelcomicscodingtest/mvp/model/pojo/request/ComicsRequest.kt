package com.test.tabmarvelcomicscodingtest.mvp.model.pojo.request

/**
 * @author Filippo Engidashet [filippo.eng@gmail.com]
 * @version 1.0.0
 * @since Sunday, 11/03/2018 at 14:04.
 */

data class ComicsRequest(val offset: Int, val limit: Int, val hash: String, val apiKey: String, val timestamp: Long)
