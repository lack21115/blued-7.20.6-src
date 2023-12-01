package com.tencent.qmsp.sdk.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/base/e.class */
public class e implements IVendorCallback {

    /* renamed from: c  reason: collision with root package name */
    private static boolean f38541c = false;
    private static String d = com.tencent.qmsp.sdk.c.b.f38547a + "b2FpZA";
    private static String e = com.tencent.qmsp.sdk.c.b.f38547a + "b2FpZA";
    private static Context f = null;

    /* renamed from: a  reason: collision with root package name */
    private b f38542a = null;
    private IVendorCallback b = null;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/base/e$a.class */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f38543a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00c5 -> B:73:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00c9 -> B:69:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00cd -> B:81:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00d1 -> B:77:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00d5 -> B:89:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00d9 -> B:85:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00dd -> B:97:0x0058). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00e1 -> B:91:0x0064). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00e5 -> B:71:0x0070). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x00e9 -> B:67:0x007c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00ed -> B:79:0x0088). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x00f1 -> B:75:0x0094). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x00f5 -> B:87:0x00a0). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x00f9 -> B:83:0x00ac). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x00fd -> B:95:0x00b8). Please submit an issue!!! */
        static {
            int[] iArr = new int[d.values().length];
            f38543a = iArr;
            try {
                iArr[d.XIAOMI.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f38543a[d.BLACKSHARK.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f38543a[d.VIVO.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f38543a[d.HUA_WEI.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f38543a[d.OPPO.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f38543a[d.ONEPLUS.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f38543a[d.MOTO.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f38543a[d.LENOVO.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f38543a[d.ASUS.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f38543a[d.SAMSUNG.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f38543a[d.MEIZU.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f38543a[d.ALPS.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f38543a[d.NUBIA.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f38543a[d.ZTE.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f38543a[d.FREEMEOS.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                f38543a[d.SSUIOS.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
        }
    }

    public static String a(Context context, String str, int i) {
        String str2;
        String str3 = null;
        if (context != null) {
            str3 = null;
            try {
                if (context instanceof Context) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences(d, 0);
                    String string = sharedPreferences.getString(e, null);
                    str2 = !TextUtils.isEmpty(string) ? new String(Base64.decode(string.getBytes("UTF-8"), 0)) : null;
                    if (i == 1) {
                        try {
                            if (f38541c) {
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
                }
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
                if (context instanceof Context) {
                    context.getSharedPreferences(d, 0).edit().clear().commit();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(Context context, boolean z, boolean z2) {
        f38541c = z;
        f = context;
        c.a(z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(com.tencent.qmsp.sdk.base.IVendorCallback r6) {
        /*
            Method dump skipped, instructions count: 376
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qmsp.sdk.base.e.a(com.tencent.qmsp.sdk.base.IVendorCallback):int");
    }

    @Override // com.tencent.qmsp.sdk.base.IVendorCallback
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
        b bVar = this.f38542a;
        if (bVar != null) {
            bVar.f();
        }
    }
}
