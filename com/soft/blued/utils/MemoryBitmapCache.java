package com.soft.blued.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Build;
import android.util.LruCache;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.GlideApp;
import com.blued.android.core.image.GlideRequest;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/MemoryBitmapCache.class */
public class MemoryBitmapCache {

    /* renamed from: a  reason: collision with root package name */
    public static final String f34758a = MemoryBitmapCache.class.getSimpleName();
    private static volatile MemoryBitmapCache b;

    /* renamed from: c  reason: collision with root package name */
    private LruCache<String, BitmapWrapper> f34759c = new LruCache<String, BitmapWrapper>(((int) Runtime.getRuntime().maxMemory()) / 10) { // from class: com.soft.blued.utils.MemoryBitmapCache.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a */
        public int sizeOf(String str, BitmapWrapper bitmapWrapper) {
            return bitmapWrapper.b;
        }
    };

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/MemoryBitmapCache$BitmapWrapper.class */
    public static class BitmapWrapper {

        /* renamed from: a  reason: collision with root package name */
        public Bitmap f34762a;
        public int b;
    }

    private MemoryBitmapCache() {
    }

    private int a(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return Build.VERSION.SDK_INT >= 19 ? bitmap.getAllocationByteCount() : bitmap.getByteCount();
    }

    public static Bitmap a(Bitmap bitmap, float f, float f2) {
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        if (width > f || height > f2) {
            Matrix matrix = new Matrix();
            float f3 = 1.0f;
            float f4 = f < width ? f / width : 1.0f;
            if (f2 < height) {
                f3 = f2 / height;
            }
            float min = Math.min(f4, f3);
            matrix.postScale(min, min);
            return Bitmap.createBitmap(bitmap, 0, 0, (int) width, (int) height, matrix, true);
        }
        return bitmap;
    }

    public static MemoryBitmapCache a() {
        if (b == null) {
            synchronized (MemoryBitmapCache.class) {
                try {
                    if (b == null) {
                        b = new MemoryBitmapCache();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    private String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return sb.toString();
            }
            String hexString = Integer.toHexString(bArr[i2] & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
            i = i2 + 1;
        }
    }

    private String c(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            return String.valueOf(str.hashCode());
        }
    }

    public Bitmap a(String str) {
        BitmapWrapper bitmapWrapper = this.f34759c.get(c(str));
        if (bitmapWrapper == null) {
            return null;
        }
        return bitmapWrapper.f34762a;
    }

    public void a(Context context, final String str) {
        if (a(str) != null) {
            return;
        }
        GlideApp.b(context).f().b(DiskCacheStrategy.b).e(-1).b(str).a((GlideRequest<Bitmap>) new SimpleTarget<Bitmap>() { // from class: com.soft.blued.utils.MemoryBitmapCache.2
            @Override // com.bumptech.glide.request.target.Target
            /* renamed from: a */
            public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                try {
                    MemoryBitmapCache.this.a(str, MemoryBitmapCache.a(bitmap, AppInfo.l, AppInfo.m));
                } catch (Throwable th) {
                }
            }
        });
    }

    public void a(String str, Bitmap bitmap) {
        String str2 = f34758a;
        com.blued.android.framework.utils.Logger.c(str2, "put : " + str);
        if (a(str) == null) {
            BitmapWrapper bitmapWrapper = new BitmapWrapper();
            bitmapWrapper.b = a(bitmap);
            bitmapWrapper.f34762a = bitmap;
            this.f34759c.put(c(str), bitmapWrapper);
        }
        String str3 = f34758a;
        com.blued.android.framework.utils.Logger.c(str3, "currentSize : " + this.f34759c.size() + "   maxSize : " + this.f34759c.maxSize());
    }

    public BitmapWrapper b(String str) {
        String str2 = f34758a;
        com.blued.android.framework.utils.Logger.c(str2, "remove : " + str);
        return this.f34759c.remove(c(str));
    }
}
