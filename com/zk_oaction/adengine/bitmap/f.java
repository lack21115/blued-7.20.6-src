package com.zk_oaction.adengine.bitmap;

import android.graphics.Bitmap;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/bitmap/f.class */
public class f implements h, com.zk_oaction.adengine.lk_interfaces.b {

    /* renamed from: a  reason: collision with root package name */
    String f41879a;
    float b;

    /* renamed from: c  reason: collision with root package name */
    i f41880c;

    public f(i iVar, String str, float f) {
        this.f41880c = iVar;
        this.f41879a = str;
        this.b = f;
        iVar.a(str, f, 1);
        this.f41880c.a(str, f, this);
    }

    @Override // com.zk_oaction.adengine.bitmap.h
    public void a(String str, float f, boolean z) {
        this.f41880c.a(str, f, z);
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.b
    public Bitmap b() {
        return this.f41880c.a(this.f41879a, this.b, 0);
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.b
    public int c() {
        return this.f41880c.c(this.f41879a, this.b);
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.b
    public int d() {
        return this.f41880c.d(this.f41879a, this.b);
    }
}
