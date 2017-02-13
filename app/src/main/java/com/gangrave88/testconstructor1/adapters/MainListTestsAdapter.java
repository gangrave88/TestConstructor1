package com.gangrave88.testconstructor1.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import io.realm.OrderedRealmCollection;
import io.realm.RealmBaseAdapter;

public class MainListTestsAdapter extends RealmBaseAdapter{
    public MainListTestsAdapter(@NonNull Context context, @Nullable OrderedRealmCollection data) {
        super(context, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
