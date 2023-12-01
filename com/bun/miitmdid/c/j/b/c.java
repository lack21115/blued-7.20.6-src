package com.bun.miitmdid.c.j.b;

import android.database.ContentObserver;

/* loaded from: source-7206380-dex2jar.jar:com/bun/miitmdid/c/j/b/c.class */
public class c extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private String f21155a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private b f21156c;

    public c(b bVar, int i, String str) {
        super(null);
        this.f21156c = bVar;
        this.b = i;
        this.f21155a = str;
    }

    @Override // android.database.ContentObserver
    public native void onChange(boolean z);
}
