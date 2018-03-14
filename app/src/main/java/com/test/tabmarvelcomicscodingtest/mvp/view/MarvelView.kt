package com.test.tabmarvelcomicscodingtest.mvp.view

import com.test.tabmarvelcomicscodingtest.mvp.model.pojo.vo.ComicVO

/**
 * @author Filippo Engidashet [filippo.eng@gmail.com]
 * @version 1.0.0
 * @since Sunday, 11/03/2018 at 13:44.
 */

interface MarvelView {

    fun onLoadComics(comicList: List<ComicVO>)

    fun onError(message: String?) : Unit
}