package com.huawei.openalliance.ad.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.LruCache;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.ge;
import java.lang.ref.WeakReference;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/x.class */
public class x {
    private static final int I = 31457280;
    private static x Z;
    LruCache<String, WeakReference<Drawable>> Code;
    private static final String V = x.class.getSimpleName();
    private static final byte[] B = new byte[0];

    private x() {
        V();
    }

    public static x Code() {
        x xVar;
        synchronized (B) {
            if (Z == null) {
                Z = new x();
            }
            xVar = Z;
        }
        return xVar;
    }

    private void V() {
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        this.Code = new LruCache<String, WeakReference<Drawable>>(Math.min((int) I, maxMemory > 0 ? maxMemory / 4 : I)) { // from class: com.huawei.openalliance.ad.utils.x.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            /* renamed from: Code */
            public int sizeOf(String str, WeakReference<Drawable> weakReference) {
                Drawable drawable;
                if (weakReference == null || (drawable = weakReference.get()) == null) {
                    return 1;
                }
                if (!(drawable instanceof BitmapDrawable)) {
                    if (drawable instanceof fb) {
                        return ((fb) drawable).I();
                    }
                    return 1;
                }
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                if (bitmap != null) {
                    return bitmap.getByteCount();
                }
                return 1;
            }
        };
    }

    public Drawable Code(String str) {
        try {
            WeakReference<Drawable> weakReference = this.Code.get(str);
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        } catch (Throwable th) {
            String str2 = V;
            ge.I(str2, "get cache encounter: " + th.getClass().getSimpleName());
            return null;
        }
    }

    public void Code(String str, Drawable drawable) {
        try {
            this.Code.put(str, new WeakReference<>(drawable));
        } catch (Throwable th) {
            String str2 = V;
            ge.I(str2, "put cache encounter: " + th.getClass().getSimpleName());
        }
    }
}
