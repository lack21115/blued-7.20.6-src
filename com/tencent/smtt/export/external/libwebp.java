package com.tencent.smtt.export.external;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import com.igexin.assist.util.AssistUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/export/external/libwebp.class */
public class libwebp {
    private static final int BITMAP_ALPHA_8 = 1;
    private static final int BITMAP_ARGB_4444 = 3;
    private static final int BITMAP_ARGB_8888 = 4;
    private static final int BITMAP_RGB_565 = 2;
    private static final String LOGTAG = "[image]";
    private static boolean isMultiCore = false;
    private static libwebp mInstance;
    private static boolean mIsLoadLibSuccess = false;
    private int mBitmapType = 4;

    /* renamed from: com.tencent.smtt.export.external.libwebp$1  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/export/external/libwebp$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0020 -> B:11:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = iArr;
            try {
                iArr[Bitmap.Config.ARGB_4444.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static int checkIsHuaModel() {
        String lowerCase = Build.BRAND.trim().toLowerCase();
        String lowerCase2 = Build.MODEL.trim().toLowerCase();
        int i = (lowerCase == null || lowerCase.length() <= 0 || !lowerCase.contains(AssistUtils.BRAND_HW)) ? 0 : 1;
        if (lowerCase2 == null || lowerCase2.length() <= 0 || !lowerCase2.contains(AssistUtils.BRAND_HW)) {
            return i;
        }
        return 1;
    }

    private String getCPUinfo() {
        String str = "";
        String str2 = str;
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/proc/cpuinfo").start().getInputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                String str3 = str;
                if (inputStream.read(bArr) == -1) {
                    str2 = str;
                    inputStream.close();
                    return str;
                }
                String str4 = str;
                StringBuilder sb = new StringBuilder();
                String str5 = str;
                sb.append(str);
                String str6 = str;
                sb.append(new String(bArr));
                String str7 = str;
                str = sb.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static libwebp getInstance(Context context) {
        if (mInstance == null) {
            loadWepLibraryIfNeed(context);
            mInstance = new libwebp();
        }
        return mInstance;
    }

    private boolean isMultiCore() {
        return getCPUinfo().contains("processor");
    }

    public static void loadWepLibraryIfNeed(Context context) {
        if (mIsLoadLibSuccess) {
            return;
        }
        try {
            LibraryLoader.loadLibrary(context, "webp_base");
            mIsLoadLibSuccess = true;
        } catch (UnsatisfiedLinkError e) {
            Log.e(LOGTAG, "Load WebP Library Error...: libwebp.java - loadWepLibraryIfNeed()");
        }
    }

    public static void loadWepLibraryIfNeed(Context context, String str) {
        if (mIsLoadLibSuccess) {
            return;
        }
        try {
            System.load(str + File.separator + "libwebp_base.so");
            mIsLoadLibSuccess = true;
        } catch (UnsatisfiedLinkError e) {
            Log.e(LOGTAG, "Load WebP Library Error...: libwebp.java - loadWepLibraryIfNeed()");
        }
    }

    public int[] decodeBase(byte[] bArr, int[] iArr, int[] iArr2) {
        if (mIsLoadLibSuccess) {
            return nativeDecode(bArr, isMultiCore, iArr, iArr2);
        }
        Log.e(LOGTAG, "Load WebP Library Error...");
        return null;
    }

    public int[] decodeBase_16bit(byte[] bArr, Bitmap.Config config) {
        if (!mIsLoadLibSuccess) {
            Log.e(LOGTAG, "Load WebP Library Error...");
            return null;
        }
        if (AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()] != 1) {
            this.mBitmapType = 2;
        } else {
            this.mBitmapType = 3;
        }
        return nativeDecode_16bit(bArr, isMultiCore, this.mBitmapType);
    }

    public int[] decodeInto(byte[] bArr, int[] iArr, int[] iArr2) {
        if (mIsLoadLibSuccess) {
            return nativeDecodeInto(bArr, isMultiCore, iArr, iArr2);
        }
        Log.e(LOGTAG, "Load WebP Library Error...");
        return null;
    }

    public int getInfo(byte[] bArr, int[] iArr, int[] iArr2) {
        if (mIsLoadLibSuccess) {
            return nativeGetInfo(bArr, iArr, iArr2);
        }
        return 0;
    }

    public int[] incDecode(byte[] bArr, int[] iArr, int[] iArr2) {
        if (mIsLoadLibSuccess) {
            return nativeIDecode(bArr, isMultiCore, iArr, iArr2);
        }
        Log.e(LOGTAG, "Load WebP Library Error...");
        return null;
    }

    public native int[] nativeDecode(byte[] bArr, boolean z, int[] iArr, int[] iArr2);

    public native int[] nativeDecodeInto(byte[] bArr, boolean z, int[] iArr, int[] iArr2);

    public native int[] nativeDecode_16bit(byte[] bArr, boolean z, int i);

    public native int nativeGetInfo(byte[] bArr, int[] iArr, int[] iArr2);

    public native int[] nativeIDecode(byte[] bArr, boolean z, int[] iArr, int[] iArr2);
}
