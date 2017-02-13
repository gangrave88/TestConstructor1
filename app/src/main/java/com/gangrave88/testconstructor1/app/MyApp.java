package com.gangrave88.testconstructor1.app;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().
                name(Realm.DEFAULT_REALM_NAME).
                schemaVersion(0).
                deleteRealmIfMigrationNeeded().
                build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
