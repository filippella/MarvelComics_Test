package com.test.tabmarvelcomicscodingtest.mvp.model.pojo.response

import io.realm.RealmList
import io.realm.RealmModel
import io.realm.annotations.RealmClass

/**
 * @author Filippo Engidashet [filippo.eng@gmail.com]
 * @version 1.0.0
 * @since Sunday, 11/03/2018 at 13:27.
 */

@RealmClass
open class Results : RealmModel {

    var series: Series? = null
    var issn: String? = null
    var events: Events? = null
    var id: String? = null
    var title: String? = null
    var dates: RealmList<Dates>? = null
    var description: String? = null
    var isbn: String? = null
    var variants: RealmList<Variants>? = null
    var digitalId: String? = null
    var collections: RealmList<Variants>? = null
    var pageCount: String? = null
    var textObjects: RealmList<TextObjects>? = null
    var urls: RealmList<Urls>? = null
    var format: String? = null
    var upc: String? = null
    var modified: String? = null
    var variantDescription: String? = null
    var creators: Creators? = null
    var ean: String? = null
    var issueNumber: String? = null
    var stories: Stories? = null
    var thumbnail: Thumbnail? = null
    var resourceURI: String? = null
    var images: RealmList<Images>? = null
    var collectedIssues: RealmList<CollectedIssues>? = null
    var prices: RealmList<Prices>? = null
    var characters: Characters? = null
    var diamondCode: String? = null

    override fun toString(): String {
        return "Results [series = $series, issn = $issn, events = $events, id = $id, title = $title, dates = $dates, description = $description, isbn = $isbn, variants = $variants, digitalId = $digitalId, collections = $collections, pageCount = $pageCount, textObjects = $textObjects, urls = $urls, format = $format, upc = $upc, modified = $modified, variantDescription = $variantDescription, creators = $creators, ean = $ean, issueNumber = $issueNumber, stories = $stories, thumbnail = $thumbnail, resourceURI = $resourceURI, images = $images, collectedIssues = $collectedIssues, prices = $prices, characters = $characters, diamondCode = $diamondCode]"
    }
}
