package com.bun.miitmdid.c.j.b;

import android.database.ContentObserver;

/* loaded from: source-7206380-dex2jar.jar:com/bun/miitmdid/c/j/b/c.class */
public class c extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private String f7549a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private b f7550c;

    public c(b bVar, int i, String str) {
        super(null);
        this.f7550c = bVar;
        this.b = i;
        this.f7549a = str;
    }

    @Override // android.database.ContentObserver
    public native void onChange(boolean z);
}
