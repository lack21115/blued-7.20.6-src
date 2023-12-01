package com.yxcorp.kuaishou.addfp.android.b;

import android.content.Context;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

/* loaded from: source-8829756-dex2jar.jar:com/yxcorp/kuaishou/addfp/android/b/b.class */
public class b {
    public static File a(Context context, boolean z) {
        StorageManager storageManager = (StorageManager) context.getSystemService(Context.STORAGE_SERVICE);
        try {
            Class<?> cls = Class.forName("android.os.storage.StorageVolume");
            Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
            Method method2 = cls.getMethod("getPath", new Class[0]);
            Method method3 = cls.getMethod("isRemovable", new Class[0]);
            Object invoke = method.invoke(storageManager, new Object[0]);
            int length = Array.getLength(invoke);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                Object obj = Array.get(invoke, i2);
                String str = (String) method2.invoke(obj, new Object[0]);
                if (z == ((Boolean) method3.invoke(obj, new Object[0])).booleanValue() && !TextUtils.isEmpty(str)) {
                    return new File(str);
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return Environment.getExternalStorageDirectory();
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3;
        byte[] bArr4 = new byte[256];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 256) {
                break;
            }
            bArr4[i2] = (byte) i2;
            i = i2 + 1;
        }
        if (bArr2.length != 0) {
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                bArr3 = bArr4;
                if (i3 >= 256) {
                    break;
                }
                i5 = ((bArr2[i4] & 255) + (bArr4[i3] & 255) + i5) & 255;
                byte b = bArr4[i3];
                bArr4[i3] = bArr4[i5];
                bArr4[i5] = b;
                i4 = (i4 + 1) % bArr2.length;
                i3++;
            }
        } else {
            bArr3 = null;
        }
        byte[] bArr5 = new byte[bArr.length];
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int i9 = i8;
            if (i9 >= bArr.length) {
                return bArr5;
            }
            i6 = (i6 + 1) & 255;
            i7 = ((bArr3[i6] & 255) + i7) & 255;
            byte b2 = bArr3[i6];
            bArr3[i6] = bArr3[i7];
            bArr3[i7] = b2;
            bArr5[i9] = (byte) (bArr3[((bArr3[i6] & 255) + (bArr3[i7] & 255)) & 255] ^ bArr[i9]);
            bArr5[i9] = (byte) (bArr5[i9] ^ 42);
            i8 = i9 + 1;
        }
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length <= 0 || bArr == null || bArr.length <= 0) {
                    return null;
                }
                byte[] a2 = a(bArr, bArr2);
                if (a2 != null) {
                    if (a2.length > 0) {
                    }
                }
                return a2;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length <= 0 || bArr == null || bArr.length <= 0) {
                    return null;
                }
                byte[] a2 = a(bArr, bArr2);
                if (a2 != null) {
                    if (a2.length > 0) {
                    }
                }
                return a2;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
