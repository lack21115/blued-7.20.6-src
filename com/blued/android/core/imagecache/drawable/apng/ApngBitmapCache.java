package com.blued.android.core.imagecache.drawable.apng;

import android.graphics.Bitmap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/drawable/apng/ApngBitmapCache.class */
public class ApngBitmapCache {

    /* renamed from: a  reason: collision with root package name */
    private int f9624a = 2;
    private Map<Integer, Bitmap> b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private Set<Bitmap> f9625c = new HashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap a(int i, int i2) {
        Iterator<Bitmap> it = this.f9625c.iterator();
        Bitmap bitmap = null;
        while (it.hasNext()) {
            bitmap = it.next();
            if (bitmap != null && bitmap.getAllocationByteCount() >= i * i2 * 4) {
                it.remove();
                if (bitmap.getWidth() != i || bitmap.getHeight() != i2) {
                    bitmap.reconfigure(i, i2, Bitmap.Config.ARGB_8888);
                }
                bitmap.eraseColor(0);
                return bitmap;
            }
        }
        try {
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return bitmap;
        }
    }

    public void a() {
        this.b.clear();
        this.f9625c.clear();
    }

    public void a(int i) {
        this.f9624a = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        if (i == 0) {
            this.b.clear();
        } else if (this.b.size() >= this.f9624a) {
            Iterator<Map.Entry<Integer, Bitmap>> it = this.b.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, Bitmap> next = it.next();
                int intValue = next.getKey().intValue();
                if (intValue > i || i >= intValue + this.f9624a) {
                    it.remove();
                    b(next.getValue());
                }
            }
        }
        this.b.put(Integer.valueOf(i), bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Bitmap bitmap) {
        return this.b.containsValue(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap b(int i) {
        return this.b.get(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Bitmap bitmap) {
        if (bitmap == null || a(bitmap)) {
            return;
        }
        this.f9625c.add(bitmap);
    }
}
