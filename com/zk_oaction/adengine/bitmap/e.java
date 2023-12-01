package com.zk_oaction.adengine.bitmap;

import android.graphics.Bitmap;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/bitmap/e.class */
public class e implements com.zk_oaction.adengine.lk_interfaces.b {

    /* renamed from: a  reason: collision with root package name */
    public int f28186a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public Bitmap.Config f28187c;
    public Bitmap d;

    public e(int i, int i2, Bitmap.Config config) {
        this.f28186a = i;
        this.b = i2;
        this.f28187c = config;
        a();
    }

    public void a() {
        synchronized (this) {
            if (this.d == null) {
                this.d = Bitmap.createBitmap(this.f28186a, this.b, this.f28187c);
            }
        }
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.b
    public Bitmap b() {
        Bitmap bitmap;
        synchronized (this) {
            bitmap = this.d;
        }
        return bitmap;
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.b
    public int c() {
        int i;
        synchronized (this) {
            i = this.f28186a;
        }
        return i;
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.b
    public int d() {
        int i;
        synchronized (this) {
            i = this.b;
        }
        return i;
    }

    public void e() {
        synchronized (this) {
            Bitmap bitmap = this.d;
            if (bitmap != null) {
                bitmap.recycle();
                this.d = null;
            }
        }
    }
}
