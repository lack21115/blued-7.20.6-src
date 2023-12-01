package android.emoji;

import android.graphics.Bitmap;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: source-9557208-dex2jar.jar:android/emoji/EmojiFactory.class */
public final class EmojiFactory {
    private String mName;
    private long mNativeEmojiFactory;
    private int sCacheSize = 100;
    private Map<Integer, WeakReference<Bitmap>> mCache = new CustomLinkedHashMap();

    /* loaded from: source-9557208-dex2jar.jar:android/emoji/EmojiFactory$CustomLinkedHashMap.class */
    private class CustomLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        public CustomLinkedHashMap() {
            super(16, 0.75f, true);
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
            return size() > EmojiFactory.this.sCacheSize;
        }
    }

    private EmojiFactory(long j, String str) {
        this.mNativeEmojiFactory = j;
        this.mName = str;
    }

    private native void nativeDestructor(long j);

    private native int nativeGetAndroidPuaFromVendorSpecificPua(long j, int i);

    private native int nativeGetAndroidPuaFromVendorSpecificSjis(long j, char c2);

    private native Bitmap nativeGetBitmapFromAndroidPua(long j, int i);

    private native int nativeGetMaximumAndroidPua(long j);

    private native int nativeGetMaximumVendorSpecificPua(long j);

    private native int nativeGetMinimumAndroidPua(long j);

    private native int nativeGetMinimumVendorSpecificPua(long j);

    private native int nativeGetVendorSpecificPuaFromAndroidPua(long j, int i);

    private native int nativeGetVendorSpecificSjisFromAndroidPua(long j, int i);

    public static native EmojiFactory newAvailableInstance();

    public static native EmojiFactory newInstance(String str);

    protected void finalize() throws Throwable {
        try {
            nativeDestructor(this.mNativeEmojiFactory);
        } finally {
            super.finalize();
        }
    }

    public int getAndroidPuaFromVendorSpecificPua(int i) {
        return nativeGetAndroidPuaFromVendorSpecificPua(this.mNativeEmojiFactory, i);
    }

    public String getAndroidPuaFromVendorSpecificPua(String str) {
        int androidPuaFromVendorSpecificPua;
        if (str == null) {
            return null;
        }
        int nativeGetMinimumVendorSpecificPua = nativeGetMinimumVendorSpecificPua(this.mNativeEmojiFactory);
        int nativeGetMaximumVendorSpecificPua = nativeGetMaximumVendorSpecificPua(this.mNativeEmojiFactory);
        int length = str.length();
        int[] iArr = new int[str.codePointCount(0, length)];
        int i = 0;
        int i2 = 0;
        while (i2 < length) {
            int codePointAt = str.codePointAt(i2);
            if (nativeGetMinimumVendorSpecificPua > codePointAt || codePointAt > nativeGetMaximumVendorSpecificPua || (androidPuaFromVendorSpecificPua = getAndroidPuaFromVendorSpecificPua(codePointAt)) <= 0) {
                iArr[i] = codePointAt;
            } else {
                iArr[i] = androidPuaFromVendorSpecificPua;
            }
            i2 = str.offsetByCodePoints(i2, 1);
            i++;
        }
        return new String(iArr, 0, i);
    }

    public int getAndroidPuaFromVendorSpecificSjis(char c2) {
        return nativeGetAndroidPuaFromVendorSpecificSjis(this.mNativeEmojiFactory, c2);
    }

    public Bitmap getBitmapFromAndroidPua(int i) {
        Bitmap bitmap;
        synchronized (this) {
            WeakReference<Bitmap> weakReference = this.mCache.get(Integer.valueOf(i));
            if (weakReference == null) {
                Bitmap nativeGetBitmapFromAndroidPua = nativeGetBitmapFromAndroidPua(this.mNativeEmojiFactory, i);
                bitmap = nativeGetBitmapFromAndroidPua;
                if (nativeGetBitmapFromAndroidPua != null) {
                    this.mCache.put(Integer.valueOf(i), new WeakReference<>(nativeGetBitmapFromAndroidPua));
                    bitmap = nativeGetBitmapFromAndroidPua;
                }
            } else {
                bitmap = weakReference.get();
                if (bitmap == null) {
                    bitmap = nativeGetBitmapFromAndroidPua(this.mNativeEmojiFactory, i);
                    this.mCache.put(Integer.valueOf(i), new WeakReference<>(bitmap));
                }
            }
        }
        return bitmap;
    }

    public Bitmap getBitmapFromVendorSpecificPua(int i) {
        Bitmap bitmapFromAndroidPua;
        synchronized (this) {
            bitmapFromAndroidPua = getBitmapFromAndroidPua(getAndroidPuaFromVendorSpecificPua(i));
        }
        return bitmapFromAndroidPua;
    }

    public Bitmap getBitmapFromVendorSpecificSjis(char c2) {
        Bitmap bitmapFromAndroidPua;
        synchronized (this) {
            bitmapFromAndroidPua = getBitmapFromAndroidPua(getAndroidPuaFromVendorSpecificSjis(c2));
        }
        return bitmapFromAndroidPua;
    }

    public int getMaximumAndroidPua() {
        return nativeGetMaximumAndroidPua(this.mNativeEmojiFactory);
    }

    public int getMinimumAndroidPua() {
        return nativeGetMinimumAndroidPua(this.mNativeEmojiFactory);
    }

    public int getVendorSpecificPuaFromAndroidPua(int i) {
        return nativeGetVendorSpecificPuaFromAndroidPua(this.mNativeEmojiFactory, i);
    }

    public String getVendorSpecificPuaFromAndroidPua(String str) {
        int vendorSpecificPuaFromAndroidPua;
        if (str == null) {
            return null;
        }
        int nativeGetMinimumAndroidPua = nativeGetMinimumAndroidPua(this.mNativeEmojiFactory);
        int nativeGetMaximumAndroidPua = nativeGetMaximumAndroidPua(this.mNativeEmojiFactory);
        int length = str.length();
        int[] iArr = new int[str.codePointCount(0, length)];
        int i = 0;
        int i2 = 0;
        while (i2 < length) {
            int codePointAt = str.codePointAt(i2);
            if (nativeGetMinimumAndroidPua > codePointAt || codePointAt > nativeGetMaximumAndroidPua || (vendorSpecificPuaFromAndroidPua = getVendorSpecificPuaFromAndroidPua(codePointAt)) <= 0) {
                iArr[i] = codePointAt;
            } else {
                iArr[i] = vendorSpecificPuaFromAndroidPua;
            }
            i2 = str.offsetByCodePoints(i2, 1);
            i++;
        }
        return new String(iArr, 0, i);
    }

    public int getVendorSpecificSjisFromAndroidPua(int i) {
        return nativeGetVendorSpecificSjisFromAndroidPua(this.mNativeEmojiFactory, i);
    }

    public String name() {
        return this.mName;
    }
}
