package com.github.mikephil.charting.data;

import android.util.Log;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/data/PieEntry.class */
public class PieEntry extends Entry {

    /* renamed from: a  reason: collision with root package name */
    private String f8531a;

    public String a() {
        return this.f8531a;
    }

    @Override // com.github.mikephil.charting.data.Entry
    @Deprecated
    public float i() {
        Log.i("DEPRECATED", "Pie entries do not have x values");
        return super.i();
    }
}
