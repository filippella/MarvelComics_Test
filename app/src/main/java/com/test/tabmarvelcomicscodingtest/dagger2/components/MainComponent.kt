package com.test.tabmarvelcomicscodingtest.dagger2.components

import com.test.tabmarvelcomicscodingtest.dagger2.modules.MainModule
import com.test.tabmarvelcomicscodingtest.home.MainActivity

import dagger.Component

/**
 * @author Filippo Engidashet [filippo.eng@gmail.com]
 * @version 1.0.0
 * @since Sunday, 11/03/2018 at 21:46.
 */

@Component(modules = arrayOf(MainModule::class))
interface MainComponent {

    fun inject(activity: MainActivity)
}
