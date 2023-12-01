package com.blued.android.module.live_china.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.live_china.same.LiveBitmapUtils;
import com.blued.android.share.Util;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/LiveMemoryBitmapCache.class */
public class LiveMemoryBitmapCache {

    /* renamed from: a  reason: collision with root package name */
    public static final String f14180a = LiveMemoryBitmapCache.class.getSimpleName();
    private static volatile LiveMemoryBitmapCache b;

    /* renamed from: c  reason: collision with root package name */
    private LruCache<String, BitmapWrapper> f14181c;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/LiveMemoryBitmapCache$BitmapCallback.class */
    public interface BitmapCallback {
        void onBitmapCreate(String str, Bitmap bitmap);
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/LiveMemoryBitmapCache$BitmapWrapper.class */
    public static class BitmapWrapper {

        /* renamed from: a  reason: collision with root package name */
        public Bitmap f14185a;
        public int b;
    }

    private LiveMemoryBitmapCache() {
        int maxMemory = ((int) Runtime.getRuntime().maxMemory()) / 20;
        String str = f14180a;
        Log.i(str, "cacheSize：" + maxMemory);
        this.f14181c = new LruCache<String, BitmapWrapper>(maxMemory) { // from class: com.blued.android.module.live_china.utils.LiveMemoryBitmapCache.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            /* renamed from: a */
            public int sizeOf(String str2, BitmapWrapper bitmapWrapper) {
                return bitmapWrapper.b;
            }
        };
    }

    private int a(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return Build.VERSION.SDK_INT >= 19 ? bitmap.getAllocationByteCount() : bitmap.getByteCount();
    }

    private Bitmap a(Context context, int i, int i2) {
        int i3 = i;
        if (i == 0) {
            i3 = DensityUtils.a(context, 30.0f);
        }
        if (i2 == 0) {
            return null;
        }
        Bitmap a2 = a(String.valueOf(i2));
        Bitmap bitmap = a2;
        if (a2 == null) {
            Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), i2);
            float f = i3;
            bitmap = a(decodeResource, f, f);
            if (decodeResource != bitmap) {
                decodeResource.recycle();
            }
            a(String.valueOf(i2), bitmap);
        }
        return bitmap;
    }

    public static Bitmap a(Bitmap bitmap, float f, float f2) {
        if (bitmap == null) {
            return bitmap;
        }
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        Bitmap bitmap2 = bitmap;
        if (width != 0.0f) {
            if (height == 0.0f) {
                return bitmap;
            }
            if (width <= f && height <= f2) {
                return bitmap;
            }
            Matrix matrix = new Matrix();
            float f3 = 1.0f;
            float f4 = f < width ? f / width : 1.0f;
            if (f2 < height) {
                f3 = f2 / height;
            }
            float min = Math.min(f4, f3);
            matrix.postScale(min, min);
            bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, (int) width, (int) height, matrix, true);
        }
        return bitmap2;
    }

    public static LiveMemoryBitmapCache a() {
        if (b == null) {
            synchronized (LiveMemoryBitmapCache.class) {
                try {
                    if (b == null) {
                        b = new LiveMemoryBitmapCache();
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

    private String b(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            return String.valueOf(str.hashCode());
        }
    }

    public Bitmap a(String str) {
        BitmapWrapper bitmapWrapper = this.f14181c.get(b(str));
        if (bitmapWrapper == null) {
            return null;
        }
        return bitmapWrapper.f14185a;
    }

    public void a(Context context, final String str, int i, int i2, final BitmapCallback bitmapCallback) {
        int i3 = i;
        if (i == 0) {
            i3 = DensityUtils.a(context, 30.0f);
        }
        if (TextUtils.isEmpty(str)) {
            Log.i("==xpp", "cacheBitmapFromGlide but url is empty");
            Bitmap a2 = a(context, i3, i2);
            if (bitmapCallback != null) {
                bitmapCallback.onBitmapCreate(str, a2);
                return;
            }
            return;
        }
        Bitmap a3 = a(str);
        if (a3 != null) {
            if (bitmapCallback != null) {
                Log.i("==xpp", "has :" + str);
                bitmapCallback.onBitmapCreate(str, a3);
                return;
            }
            return;
        }
        Bitmap a4 = a(context, i3, i2);
        if (bitmapCallback != null) {
            Log.i("==xpp", "set defaultRes:" + i2);
            bitmapCallback.onBitmapCreate(str, a4);
        }
        final int i4 = i3;
        ImageFileLoader.a((IRequestHost) null).a(str).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.android.module.live_china.utils.LiveMemoryBitmapCache.2
            @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
            public void onUIFinish(File file, Exception exc) {
                if (file == null || !file.exists()) {
                    return;
                }
                try {
                    Bitmap imageZoomToSize = Util.imageZoomToSize(LiveBitmapUtils.a(file.getPath(), i4), 200);
                    LiveMemoryBitmapCache.this.a(str, imageZoomToSize);
                    if (bitmapCallback != null) {
                        Log.i("==xpp", "cacheBitmapFromGlide new :" + str);
                        bitmapCallback.onBitmapCreate(str, imageZoomToSize);
                    }
                } catch (Exception | OutOfMemoryError e) {
                }
            }
        }).a();
    }

    public void a(String str, Bitmap bitmap) {
        String str2 = f14180a;
        Logger.c(str2, "put : " + str);
        if (a(str) == null) {
            BitmapWrapper bitmapWrapper = new BitmapWrapper();
            bitmapWrapper.b = a(bitmap);
            bitmapWrapper.f14185a = bitmap;
            this.f14181c.put(b(str), bitmapWrapper);
        }
        String str3 = f14180a;
        Logger.c(str3, "currentSize : " + this.f14181c.size() + "   maxSize : " + this.f14181c.maxSize());
    }
}
