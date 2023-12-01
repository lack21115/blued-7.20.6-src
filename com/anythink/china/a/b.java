package com.anythink.china.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.android.internal.telephony.SmsConstants;
import com.anythink.china.a.a.d;
import com.anythink.china.a.a.e;
import com.anythink.china.a.a.f;
import com.anythink.china.a.a.g;
import com.anythink.china.a.a.j;
import com.anythink.china.a.a.k;
import com.anythink.china.a.a.m;
import com.anythink.china.api.ATChinaSDKHandler;
import com.anythink.china.api.OaidSDKCallbackListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import java.lang.reflect.Method;
import java.util.Arrays;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/a/b.class */
public final class b {

    /* renamed from: com.anythink.china.a.b$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/china/a/b$1.class */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ com.anythink.china.a.a a;
        final /* synthetic */ Context b;
        final /* synthetic */ String c;

        AnonymousClass1(com.anythink.china.a.a aVar, Context context, String str) {
            this.a = aVar;
            this.b = context;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.china.a.a aVar = new com.anythink.china.a.a() { // from class: com.anythink.china.a.b.1.1
                @Override // com.anythink.china.a.a
                public final void a() {
                    b.c(AnonymousClass1.this.b, AnonymousClass1.this.a);
                }

                @Override // com.anythink.china.a.a
                public final void a(String str, boolean z) {
                    if (AnonymousClass1.this.a != null) {
                        AnonymousClass1.this.a.a(str, z);
                    }
                }
            };
            try {
                String str = this.c;
                boolean z = true;
                switch (str.hashCode()) {
                    case -2053026509:
                        if (str.equals("LENOVO")) {
                            z = true;
                            break;
                        }
                        break;
                    case -1712043046:
                        if (str.equals("SAMSUNG")) {
                            z = true;
                            break;
                        }
                        break;
                    case -602397472:
                        if (str.equals("ONEPLUS")) {
                            z = true;
                            break;
                        }
                        break;
                    case 89163:
                        if (str.equals("ZTE")) {
                            z = true;
                            break;
                        }
                        break;
                    case 2018896:
                        if (str.equals("ASUS")) {
                            z = false;
                            break;
                        }
                        break;
                    case 2432928:
                        if (str.equals("OPPO")) {
                            z = true;
                            break;
                        }
                        break;
                    case 2555124:
                        if (str.equals("SSUI")) {
                            z = true;
                            break;
                        }
                        break;
                    case 73239724:
                        if (str.equals("MEIZU")) {
                            z = true;
                            break;
                        }
                        break;
                    case 630905871:
                        if (str.equals("MOTOLORA")) {
                            z = true;
                            break;
                        }
                        break;
                    case 976565563:
                        if (str.equals("FERRMEOS")) {
                            z = true;
                            break;
                        }
                        break;
                    case 2141820391:
                        if (str.equals("HUAWEI")) {
                            z = true;
                            break;
                        }
                        break;
                }
                switch (z) {
                    case false:
                        new com.anythink.china.a.a.b(this.b).a(aVar);
                        return;
                    case true:
                    case true:
                        new g(this.b).a(aVar);
                        return;
                    case true:
                    case true:
                    case true:
                        b.c(this.b, this.a);
                        return;
                    case true:
                        new d(this.b).a(aVar);
                        return;
                    case true:
                        new j(this.b).a(aVar);
                        return;
                    case true:
                    case true:
                        new m(this.b).a(aVar);
                        return;
                    case true:
                        new e(this.b).a(aVar);
                        return;
                    default:
                        b.c(this.b, this.a);
                        return;
                }
            } catch (Throwable th) {
                com.anythink.china.a.a aVar2 = this.a;
                if (aVar2 != null) {
                    th.getMessage();
                    aVar2.a();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/china/a/b$a.class */
    public static final class a {
        private static Object e;
        private static Class<?> f;
        private static Method g;
        private static Method h;
        private static Method i;
        private static Method j;
        final String a;
        final String b;
        final String c;
        final String d;

        static {
            try {
                Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
                f = cls;
                e = cls.newInstance();
                g = f.getMethod("getUDID", Context.class);
                h = f.getMethod("getOAID", Context.class);
                i = f.getMethod("getVAID", Context.class);
                j = f.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
            }
        }

        a(Context context) {
            this.a = a(context, g);
            this.b = a(context, h);
            this.c = a(context, i);
            this.d = a(context, j);
        }

        private static String a(Context context, Method method) {
            Object obj = e;
            if (obj == null || method == null) {
                return null;
            }
            try {
                Object invoke = method.invoke(obj, context);
                if (invoke != null) {
                    return (String) invoke;
                }
                return null;
            } catch (Throwable th) {
                return null;
            }
        }

        private static boolean a() {
            return (f == null || e == null) ? false : true;
        }
    }

    private static String a(Context context) {
        try {
            return new a(context).b;
        } catch (Throwable th) {
            return "";
        }
    }

    private static String a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, SmsConstants.FORMAT_UNKNOWN);
        } catch (Exception e) {
            return null;
        }
    }

    public static void a(Context context, com.anythink.china.a.a aVar) {
        String str;
        String a2;
        try {
            a2 = a(context);
            try {
            } catch (Throwable th) {
                str = a2;
            }
        } catch (Throwable th2) {
            str = "";
        }
        if (!TextUtils.isEmpty(a2)) {
            aVar.a(a2, false);
            return;
        }
        String str2 = Build.MANUFACTURER;
        String a3 = a("ro.build.freeme.label");
        if (!TextUtils.isEmpty(a3) && a3.equalsIgnoreCase("FREEMEOS")) {
            str2 = "FERRMEOS";
        } else {
            String a4 = a("ro.ssui.product");
            if ((TextUtils.isEmpty(a4) || a4.equalsIgnoreCase(SmsConstants.FORMAT_UNKNOWN)) ? false : true) {
                str2 = "SSUI";
            }
        }
        str = a2;
        if (!TextUtils.isEmpty(str2)) {
            String upperCase = str2.toUpperCase();
            if (Arrays.asList("ASUS", "HUAWEI", "OPPO", "ONEPLUS", "ZTE", "FERRMEOS", "SSUI", "SAMSUNG", "MEIZU", "MOTOLORA", "LENOVO").contains(upperCase)) {
                com.anythink.core.common.k.b.a.a().a(new AnonymousClass1(aVar, context, upperCase));
                str = a2;
            } else if ("VIVO".equals(upperCase)) {
                str = new k(context).a();
            } else if ("NUBIA".equals(upperCase)) {
                str = new f(context).a();
            } else {
                c(context, aVar);
                str = a2;
            }
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        aVar.a(str, false);
    }

    private static void a(Context context, String str, com.anythink.china.a.a aVar) {
        com.anythink.core.common.k.b.a.a().a(new AnonymousClass1(aVar, context, str));
    }

    static /* synthetic */ void a(IdSupplier idSupplier, com.anythink.china.a.a aVar) {
        String oaid = idSupplier != null ? idSupplier.getOAID() : "";
        if (TextUtils.isEmpty(oaid)) {
            if (aVar != null) {
                aVar.a();
            }
        } else if (aVar != null) {
            aVar.a(oaid, false);
        }
    }

    private static boolean a() {
        String a2 = a("ro.build.freeme.label");
        return !TextUtils.isEmpty(a2) && a2.equalsIgnoreCase("FREEMEOS");
    }

    private static void b(IdSupplier idSupplier, com.anythink.china.a.a aVar) {
        String oaid = idSupplier != null ? idSupplier.getOAID() : "";
        if (TextUtils.isEmpty(oaid)) {
            if (aVar != null) {
                aVar.a();
            }
        } else if (aVar != null) {
            aVar.a(oaid, false);
        }
    }

    private static boolean b() {
        String a2 = a("ro.ssui.product");
        return (TextUtils.isEmpty(a2) || a2.equalsIgnoreCase(SmsConstants.FORMAT_UNKNOWN)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(final Context context, final com.anythink.china.a.a aVar) {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.china.a.b.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    ATChinaSDKHandler.handleInitOaidSDK(context.getApplicationContext(), new OaidSDKCallbackListener() { // from class: com.anythink.china.a.b.2.1
                        @Override // com.anythink.china.api.OaidSDKCallbackListener
                        public final void OnSupport(boolean z, IdSupplier idSupplier) {
                            b.a(idSupplier, aVar);
                        }

                        @Override // com.anythink.china.api.OaidSDKCallbackListener
                        public final void onSupport(IdSupplier idSupplier) {
                            b.a(idSupplier, aVar);
                        }
                    });
                } catch (Throwable th) {
                }
            }
        });
    }
}
