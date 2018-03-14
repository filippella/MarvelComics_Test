package com.test.tabmarvelcomicscodingtest.mvp.model.pojo.vo

import java.util.*

/**
 * @author Filippo Engidashet [filippo.eng@gmail.com]
 * @version 1.0.0
 * @since Sunday, 11/03/2018 at 15:00.
 */

class Comics {

    private val mComicVOList = LinkedList<ComicVO>()

    fun setComicVOList(comicVOList: List<ComicVO>) {
        mComicVOList.addAll(comicVOList)
    }

    fun getComicVOList(): List<ComicVO> {
        return mComicVOList
    }
}
