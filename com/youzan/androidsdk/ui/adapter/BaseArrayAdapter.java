package com.youzan.androidsdk.ui.adapter;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/ui/adapter/BaseArrayAdapter.class */
public abstract class BaseArrayAdapter<T> extends ArrayAdapter<T> {
    public BaseArrayAdapter(Context context) {
        this(context, 0, new ArrayList());
    }

    public BaseArrayAdapter(Context context, int i, List<T> list) {
        super(context, i, list);
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public BaseArrayAdapter(Context context, List<T> list) {
        this(context, 0, list);
    }

    @Override // android.widget.ArrayAdapter
    public void addAll(Collection<? extends T> collection) {
        if (Build.VERSION.SDK_INT >= 11) {
            super.addAll(collection);
            return;
        }
        for (T t : collection) {
            super.add(t);
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = view;
        if (view == null) {
            view2 = null;
        }
        getItem(i);
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }
}
