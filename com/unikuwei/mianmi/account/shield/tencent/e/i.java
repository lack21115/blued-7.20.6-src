package com.unikuwei.mianmi.account.shield.tencent.e;

import android.content.Context;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/* loaded from: source-8829756-dex2jar.jar:com/unikuwei/mianmi/account/shield/tencent/e/i.class */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static final String f41010a = File.separator + new String(m.b("LnVuaWFjY291bnQ=")) + File.separator;
    private static final String b = new String(m.b("dW5pYWNjb3VudC5qYXI="));

    /* renamed from: c  reason: collision with root package name */
    private static final String f41011c = new String(m.b("dW5pY29tX3VwZGF0ZQ==")) + File.separator + new String(m.b("dW5pYWNjb3VudF9jb3JlLmRhdA=="));
    private static final String d = new String(m.b("dW5pYWNjb3VudF9jb3JlLmRhdA=="));
    private static DexClassLoader e = null;

    public static DexClassLoader a() {
        return e;
    }

    public static DexClassLoader a(Context context, String str) {
        try {
            String str2 = e(context) + "optdex";
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            DexClassLoader dexClassLoader = new DexClassLoader(str, str2, null, context.getClassLoader());
            e = dexClassLoader;
            return dexClassLoader;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String a(Context context) {
        return e(context) + b;
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            byte[] bArr2 = new byte[15];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 15) {
                    return new String(bArr2);
                }
                bArr2[i2] = bArr[i2];
                i = i2 + 1;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static boolean a(Context context, byte[] bArr) {
        try {
            int length = bArr.length - 16;
            int i = (length >> 2) << 2;
            byte[] bArr2 = new byte[i];
            byte[] bArr3 = new byte[length];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    break;
                }
                bArr2[i3] = bArr[i3 + 16];
                i2 = i3 + 1;
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= length) {
                    break;
                }
                bArr3[i5] = bArr[i5 + 16];
                i4 = i5 + 1;
            }
            byte[] a2 = m.a(bArr2);
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= i) {
                    break;
                }
                bArr3[i7] = a2[i7];
                i6 = i7 + 1;
            }
            File file = new File(e(context));
            if (!file.exists()) {
                file.mkdirs();
            }
            String a3 = a(context);
            File file2 = new File(a3);
            if (file2.exists()) {
                file2.delete();
            }
            file2.createNewFile();
            b.a(bArr3, a3);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static byte[] a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            return b.a(inputStream);
        } catch (Exception e2) {
            return null;
        }
    }

    public static InputStream b(Context context) {
        try {
            String str = e(context) + f41011c;
            File file = new File(str);
            if (file.exists()) {
                g.a("find:" + str);
                return new FileInputStream(file);
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void b(Context context, byte[] bArr) {
        try {
            File file = new File(e(context));
            if (!file.exists()) {
                file.mkdirs();
            }
            String a2 = a(context);
            File file2 = new File(a2);
            if (file2.exists()) {
                file2.delete();
            }
            file2.createNewFile();
            b.a(bArr, a2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void c(Context context) {
        try {
            b.a(new File(a(context)));
        } catch (Exception e2) {
        }
    }

    public static void d(Context context) {
        try {
            String str = e(context) + f41011c;
            File file = new File(str);
            if (file.exists()) {
                g.a("delete " + str + " result:" + file.delete());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static String e(Context context) {
        return context.getFilesDir().getParent() + f41010a;
    }
}
