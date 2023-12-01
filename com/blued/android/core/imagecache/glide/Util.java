package com.blued.android.core.imagecache.glide;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.StrictMode;
import com.blued.android.core.imagecache.ImageLoaderUtils;
import com.blued.android.core.utils.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.regex.Pattern;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/glide/Util.class */
public final class Util {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f9654a = "0123456789abcdef".toCharArray();
    private static final char[] b = new char[64];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.core.imagecache.glide.Util$2  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/glide/Util$2.class */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9656a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f9656a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f9656a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f9656a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f9656a[Bitmap.Config.ARGB_8888.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private Util() {
    }

    public static int a() {
        File[] fileArr;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            File file = new File("/sys/devices/system/cpu/");
            final Pattern compile = Pattern.compile("cpu[0-9]+");
            fileArr = file.listFiles(new FilenameFilter() { // from class: com.blued.android.core.imagecache.glide.Util.1
                @Override // java.io.FilenameFilter
                public boolean accept(File file2, String str) {
                    return Pattern.this.matcher(str).matches();
                }
            });
        } catch (Throwable th) {
            try {
                if (ImageLoaderUtils.f9582a) {
                    Log.a("IMAGE_LOADER", "Failed to calculate accurate cpu count", th);
                }
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                fileArr = null;
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        }
        return Math.min(6, Math.max(Math.max(1, Runtime.getRuntime().availableProcessors()), fileArr != null ? fileArr.length : 0));
    }

    public static int a(int i, int i2, Bitmap.Config config) {
        return i * i2 * a(config);
    }

    private static int a(Bitmap.Config config) {
        int i;
        Bitmap.Config config2 = config;
        if (config == null) {
            config2 = Bitmap.Config.ARGB_8888;
        }
        int i2 = AnonymousClass2.f9656a[config2.ordinal()];
        if (i2 != 1) {
            i = 2;
            if (i2 != 2) {
                i = 2;
                if (i2 != 3) {
                    return 4;
                }
            }
        } else {
            i = 1;
        }
        return i;
    }

    public static int a(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            if (Build.VERSION.SDK_INT >= 19) {
                try {
                    return bitmap.getAllocationByteCount();
                } catch (NullPointerException e) {
                }
            }
            return bitmap.getHeight() * bitmap.getRowBytes();
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    public static <T> Queue<T> a(int i) {
        return new ArrayDeque(i);
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }
}
