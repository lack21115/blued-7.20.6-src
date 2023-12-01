package com.blued.android.framework.view.wheel.widget.adapters;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/wheel/widget/adapters/WheelViewAdapter.class */
public interface WheelViewAdapter {
    int a();

    View a(int i, View view, ViewGroup viewGroup);

    View a(View view, ViewGroup viewGroup);

    void a(DataSetObserver dataSetObserver);

    void b(DataSetObserver dataSetObserver);
}
