package com.soft.blued.ui.find.fragment;

import android.view.View;
import android.widget.AdapterView;
import java.util.List;

/* renamed from: com.soft.blued.ui.find.fragment.-$$Lambda$FilterNewFragment$D1VooYx9j8uk-p-qY4jZPcyqJb4  reason: invalid class name */
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/-$$Lambda$FilterNewFragment$D1VooYx9j8uk-p-qY4jZPcyqJb4.class */
public final /* synthetic */ class $$Lambda$FilterNewFragment$D1VooYx9j8ukpqY4jZPcyqJb4 implements AdapterView.OnItemClickListener {
    private final /* synthetic */ List f$0;
    private final /* synthetic */ FilterNewFragment f$1;

    public /* synthetic */ $$Lambda$FilterNewFragment$D1VooYx9j8ukpqY4jZPcyqJb4(List list, FilterNewFragment filterNewFragment) {
        this.f$0 = list;
        this.f$1 = filterNewFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        FilterNewFragment.a(this.f$0, this.f$1, adapterView, view, i, j);
    }
}
