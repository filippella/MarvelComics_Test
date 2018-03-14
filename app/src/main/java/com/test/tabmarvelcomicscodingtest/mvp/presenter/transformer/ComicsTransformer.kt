package com.test.tabmarvelcomicscodingtest.mvp.presenter.transformer

import com.test.tabmarvelcomicscodingtest.mvp.model.pojo.response.ComicsResponse
import com.test.tabmarvelcomicscodingtest.mvp.model.pojo.vo.ComicVO
import com.test.tabmarvelcomicscodingtest.mvp.model.pojo.vo.Comics
import java.util.*

/**
 * @author Filippo Engidashet [filippo.eng@gmail.com]
 * @version 1.0.0
 * @since Sunday, 11/03/2018 at 14:57.
 */

class ComicsTransformer : Transformer<ComicsResponse, Comics> {

    override fun transform(input: ComicsResponse): Comics {
        val comics = Comics()
        val comicVOS = LinkedList<ComicVO>()

        val inputData = input.data
        if (inputData != null) {
            val results = inputData.results
            if (results != null) {
                for (result in results) {
                    val comicVO = ComicVO()

                    comicVO.id = result.id
                    comicVO.title = result.title
                    comicVO.modifiedDate = result.modified

                    val thumbnail = result.thumbnail
                    if (thumbnail != null) {
                        comicVO.avatarURL = thumbnail.path + "." + thumbnail.extension
                    }

                    comicVOS.add(comicVO)
                }
            }
        }
        comics.setComicVOList(comicVOS)
        return comics
    }
}
