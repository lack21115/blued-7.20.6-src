package com.tencent.tmsqmsp.sdk.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/base/e.class */
public class e implements IVendorCallback {

    /* renamed from: c  reason: collision with root package name */
    private static boolean f26008c = false;
    private static String d = com.tencent.tmsqmsp.sdk.c.b.f26014a + "b2FpZA";
    private static String e = com.tencent.tmsqmsp.sdk.c.b.f26014a + "b2FpZA";
    private static Context f = null;

    /* renamed from: a  reason: collision with root package name */
    private b f26009a = null;
    private IVendorCallback b = null;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/base/e$a.class */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f26010a;

        static {
            d.values();
            int[] iArr = new int[17];
            f26010a = iArr;
            try {
                d dVar = d.XIAOMI;
                iArr[2] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                int[] iArr2 = f26010a;
                d dVar2 = d.BLACKSHARK;
                iArr2[14] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                int[] iArr3 = f26010a;
                d dVar3 = d.VIVO;
                iArr3[3] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                int[] iArr4 = f26010a;
                d dVar4 = d.HUA_WEI;
                iArr4[1] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                int[] iArr5 = f26010a;
                d dVar5 = d.OPPO;
                iArr5[4] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                int[] iArr6 = f26010a;
                d dVar6 = d.ONEPLUS;
                iArr6[13] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                int[] iArr7 = f26010a;
                d dVar7 = d.MOTO;
                iArr7[5] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                int[] iArr8 = f26010a;
                d dVar8 = d.LENOVO;
                iArr8[6] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                int[] iArr9 = f26010a;
                d dVar9 = d.ASUS;
                iArr9[7] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                int[] iArr10 = f26010a;
                d dVar10 = d.SAMSUNG;
                iArr10[8] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                int[] iArr11 = f26010a;
                d dVar11 = d.MEIZU;
                iArr11[9] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                int[] iArr12 = f26010a;
                d dVar12 = d.ALPS;
                iArr12[10] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                int[] iArr13 = f26010a;
                d dVar13 = d.NUBIA;
                iArr13[11] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                int[] iArr14 = f26010a;
                d dVar14 = d.ZTE;
                iArr14[12] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                int[] iArr15 = f26010a;
                d dVar15 = d.FREEMEOS;
                iArr15[15] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                int[] iArr16 = f26010a;
                d dVar16 = d.SSUIOS;
                iArr16[16] = 16;
            } catch (NoSuchFieldError e16) {
            }
        }
    }

    public static String a(Context context, String str, int i) {
        String str2;
        String str3 = null;
        if (context != null) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences(d, 0);
                String string = sharedPreferences.getString(e, null);
                str2 = !TextUtils.isEmpty(string) ? new String(Base64.decode(string.getBytes("UTF-8"), 0)) : null;
                if (i == 1) {
                    try {
                        if (f26008c) {
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            String str4 = null;
                            if (!TextUtils.isEmpty(str)) {
                                str4 = Base64.encodeToString(str.getBytes("UTF-8"), 0);
                            }
                            edit.putString(e, str4);
                            edit.commit();
                        }
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        str3 = str2;
                        return str3;
                    }
                }
                return str2;
            } catch (Exception e3) {
                e = e3;
                str2 = null;
            }
        }
        return str3;
    }

    public static void a(Context context) {
        if (context != null) {
            try {
                context.getSharedPreferences(d, 0).edit().clear().commit();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(Context context, boolean z, boolean z2) {
        f26008c = z;
        f = context;
        c.a(z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(com.tencent.tmsqmsp.sdk.base.IVendorCallback r6) {
        /*
            Method dump skipped, instructions count: 376
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmsqmsp.sdk.base.e.a(com.tencent.tmsqmsp.sdk.base.IVendorCallback):int");
    }

    @Override // com.tencent.tmsqmsp.sdk.base.IVendorCallback
    public void onResult(boolean z, String str, String str2) {
        c.c("vm onResult " + z);
        if (TextUtils.isEmpty(str2)) {
            str2 = a(f, (String) null, 0);
        } else {
            a(f, str2, 1);
        }
        IVendorCallback iVendorCallback = this.b;
        if (iVendorCallback != null) {
            iVendorCallback.onResult(z, str, str2);
        }
        b bVar = this.f26009a;
        if (bVar != null) {
            bVar.f();
        }
    }
}
