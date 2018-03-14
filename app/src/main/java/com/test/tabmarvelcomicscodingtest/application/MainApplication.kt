package com.test.tabmarvelcomicscodingtest.application

import android.app.Application

import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since Sunday, 11/03/2018 at 13:16.
 */

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)

        val realmConfiguration = RealmConfiguration.Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build()

        Realm.setDefaultConfiguration(realmConfiguration)
    }
}
