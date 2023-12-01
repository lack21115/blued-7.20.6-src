package com.blued.android.framework.view.wheel.widget.adapters;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/wheel/widget/adapters/AbstractWheelAdapter.class */
public abstract class AbstractWheelAdapter implements WheelViewAdapter {

    /* renamed from: a  reason: collision with root package name */
    private List<DataSetObserver> f10361a;

    @Override // com.blued.android.framework.view.wheel.widget.adapters.WheelViewAdapter
    public View a(View view, ViewGroup viewGroup) {
        return null;
    }

    @Override // com.blued.android.framework.view.wheel.widget.adapters.WheelViewAdapter
    public void a(DataSetObserver dataSetObserver) {
        if (this.f10361a == null) {
            this.f10361a = new LinkedList();
        }
        this.f10361a.add(dataSetObserver);
    }

    @Override // com.blued.android.framework.view.wheel.widget.adapters.WheelViewAdapter
    public void b(DataSetObserver dataSetObserver) {
        List<DataSetObserver> list = this.f10361a;
        if (list != null) {
            list.remove(dataSetObserver);
        }
    }
}
