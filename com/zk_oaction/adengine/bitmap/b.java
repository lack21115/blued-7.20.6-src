package com.zk_oaction.adengine.bitmap;

import android.graphics.Bitmap;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/bitmap/b.class */
class b {

    /* renamed from: a  reason: collision with root package name */
    String f41866a;
    float b;
    private Bitmap e;

    /* renamed from: c  reason: collision with root package name */
    private int f41867c = -1;
    private int d = -1;
    private HashSet<WeakReference<h>> f = new HashSet<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, float f) {
        this.f41866a = str;
        this.b = f;
    }

    public int a() {
        int size;
        synchronized (this.f) {
            HashSet hashSet = new HashSet();
            Iterator<WeakReference<h>> it = this.f.iterator();
            while (it.hasNext()) {
                WeakReference<h> next = it.next();
                if (next.get() != null) {
                    hashSet.add(next);
                }
            }
            this.f.clear();
            this.f.addAll(hashSet);
            size = this.f.size();
        }
        return size;
    }

    public void a(int i, int i2) {
        synchronized (this) {
            this.f41867c = i;
            this.d = i2;
        }
    }

    public void a(Bitmap bitmap) {
        synchronized (this) {
            this.e = bitmap;
            if (bitmap != null) {
                this.f41867c = bitmap.getWidth();
                this.d = bitmap.getHeight();
            }
        }
    }

    public void a(h hVar) {
        synchronized (this.f) {
            Iterator<WeakReference<h>> it = this.f.iterator();
            while (true) {
                if (!it.hasNext()) {
                    this.f.add(new WeakReference<>(hVar));
                    break;
                } else if (it.next().get() == hVar) {
                    break;
                }
            }
        }
    }

    public void a(boolean z) {
        synchronized (this.f) {
            Iterator<WeakReference<h>> it = this.f.iterator();
            while (it.hasNext()) {
                h hVar = it.next().get();
                if (hVar != null) {
                    hVar.a(this.f41866a, this.b, z);
                }
            }
        }
    }

    public void b() {
        synchronized (this) {
            Bitmap bitmap = this.e;
            if (bitmap != null) {
                bitmap.recycle();
                this.e = null;
            }
        }
    }

    public int c() {
        int i;
        synchronized (this) {
            i = this.f41867c;
        }
        return i;
    }

    public int d() {
        int i;
        synchronized (this) {
            i = this.d;
        }
        return i;
    }

    public Bitmap e() {
        Bitmap bitmap;
        synchronized (this) {
            bitmap = this.e;
        }
        return bitmap;
    }

    public boolean f() {
        boolean z;
        synchronized (this) {
            if (this.f41867c != -1) {
                if (this.d != -1) {
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }
}
