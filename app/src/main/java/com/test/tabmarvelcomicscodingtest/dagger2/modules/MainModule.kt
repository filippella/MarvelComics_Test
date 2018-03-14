package com.test.tabmarvelcomicscodingtest.dagger2.modules

import com.test.tabmarvelcomicscodingtest.mvp.view.MarvelView

import dagger.Module
import dagger.Provides

/**
 * @author Filippo Engidashet [filippo.eng@gmail.com]
 * @version 1.0.0
 * @since Sunday, 11/03/2018 at 21:46.
 */

@Module
class MainModule(private val mView: MarvelView) {

    @Provides
    internal fun provideView(): MarvelView {
        return mView
    }
}
