package com.zk_oaction.adengine.bitmap;

import android.graphics.Bitmap;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/bitmap/f.class */
public class f implements h, com.zk_oaction.adengine.lk_interfaces.b {

    /* renamed from: a  reason: collision with root package name */
    String f28188a;
    float b;

    /* renamed from: c  reason: collision with root package name */
    i f28189c;

    public f(i iVar, String str, float f) {
        this.f28189c = iVar;
        this.f28188a = str;
        this.b = f;
        iVar.a(str, f, 1);
        this.f28189c.a(str, f, this);
    }

    @Override // com.zk_oaction.adengine.bitmap.h
    public void a(String str, float f, boolean z) {
        this.f28189c.a(str, f, z);
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.b
    public Bitmap b() {
        return this.f28189c.a(this.f28188a, this.b, 0);
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.b
    public int c() {
        return this.f28189c.c(this.f28188a, this.b);
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.b
    public int d() {
        return this.f28189c.d(this.f28188a, this.b);
    }
}
