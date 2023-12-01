package com.anythink.expressad.foundation.h;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/h/t.class */
public final class t extends g {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7976a = "SameTools";
    static List<String> b;

    /* renamed from: c  reason: collision with root package name */
    private static char[] f7977c = {'A', 'p', 'p', 'l', 'i', 'c', 'a', 't', 'i', 'o', 'n', 'I', 'n', 'f', 'o'};
    private static char[] d = {'.', 'X'};
    private static int e = 0;
    private static int f = 1;
    private static int g = 2;
    private static int h = 3;
    private static int i = 0;
    private static int j = 7;
    private static int k = 14;
    private static int l = 19;
    private static int m = 16;
    private static int n = 26;
    private static int o = 1;

    public static double a(Double d2) {
        try {
            String format = new DecimalFormat("0.00", DecimalFormatSymbols.getInstance(Locale.US)).format(d2);
            if (w.b(format)) {
                return Double.parseDouble(format);
            }
            return 0.0d;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0.0d;
        }
    }

    public static int a() {
        int i2 = o;
        o = i2 + 1;
        return i2;
    }

    public static int a(int i2) {
        if ((i2 <= 100 || i2 >= 199) && i2 != 2) {
            if ((i2 <= 200 || i2 >= 299) && i2 != 4) {
                return (i2 <= 500 || i2 >= 599) ? -1 : 5;
            }
            return 2;
        }
        return 1;
    }

    public static int a(Context context, float f2) {
        float f3 = 2.5f;
        if (context != null) {
            try {
                f3 = context.getResources().getDisplayMetrics().density;
                if (f3 == 0.0f) {
                    f3 = 2.5f;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                f3 = 2.5f;
            }
        }
        return (int) ((f2 / f3) + 0.5f);
    }

    public static int a(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof String) {
                    return Integer.parseInt((String) obj);
                }
                return 0;
            } catch (Throwable th) {
                o.b(f7976a, th.getMessage(), th);
                return 0;
            }
        }
        return 0;
    }

    public static String a(Context context, String str, String str2) {
        String sb;
        synchronized (t.class) {
            try {
                StringBuilder sb2 = new StringBuilder(str2);
                try {
                    sb2.append(a(str2, context, str));
                } catch (Exception e2) {
                }
                sb = sb2.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
        return sb;
    }

    private static String a(String str, Context context, String str2) {
        StringBuilder sb;
        String sb2;
        synchronized (t.class) {
            try {
                try {
                    Set<String> queryParameterNames = Uri.parse(str).getQueryParameterNames();
                    sb = (queryParameterNames == null || queryParameterNames.size() <= 0) ? new StringBuilder("?rtins_type=") : new StringBuilder("&rtins_type=");
                } catch (Exception e2) {
                    sb = new StringBuilder("&rtins_type=");
                }
                try {
                    if (b(str2, context) != null) {
                        sb.append(1);
                    } else {
                        sb.append(2);
                    }
                } catch (Exception e3) {
                    sb.append(0);
                }
                sb2 = sb.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
        return sb2;
    }

    public static List<String> a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            if (jSONArray.length() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= jSONArray.length()) {
                    return arrayList;
                }
                String optString = jSONArray.optString(i3);
                if (w.b(optString)) {
                    arrayList.add(optString);
                }
                i2 = i3 + 1;
            }
        } catch (Throwable th) {
            o.b(f7976a, th.getMessage(), th);
            return null;
        }
    }

    public static void a(View view) {
        if (view == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                view.setSystemUiVisibility(4102);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean a(Context context, String str) {
        boolean z;
        synchronized (t.class) {
            z = false;
            if (context != null) {
                try {
                    z = false;
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            z = false;
                            if (b(str, context) != null) {
                                z = true;
                            }
                        } catch (Exception e2) {
                            z = false;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return z;
    }

    public static boolean a(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar != null) {
            try {
                return cVar.N() == 1;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static <T extends String> boolean a(T t) {
        return t == null || t.length() == 0;
    }

    public static boolean a(String str, Context context) {
        boolean z = false;
        try {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                z = true;
            }
            return z;
        } catch (Exception e2) {
            return false;
        }
    }

    private static boolean a(List list) {
        return list == null || list.isEmpty();
    }

    private static <T> boolean a(T[] tArr) {
        return tArr == null || tArr.length == 0;
    }

    public static double b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0.0d;
            }
            return Double.parseDouble(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0.0d;
        }
    }

    public static int b(Context context, float f2) {
        Resources resources;
        if (context == null || (resources = context.getResources()) == null) {
            return 0;
        }
        return (int) ((f2 * resources.getDisplayMetrics().density) + 0.5f);
    }

    private static Object b(String str, Context context) {
        try {
            return Class.forName(String.valueOf(b(e))).getMethod(String.valueOf(b(g)), String.class, Integer.TYPE).invoke(Class.forName(String.valueOf(b(f))).getMethod(String.valueOf(b(h)), new Class[0]).invoke(context, new Object[0]), str, 8192);
        } catch (Throwable th) {
            return null;
        }
    }

    public static boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static boolean b(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private static boolean b(List list) {
        return !(list == null || list.isEmpty());
    }

    private static <T> boolean b(T[] tArr) {
        return !(tArr == null || tArr.length == 0);
    }

    private static final char[] b(int i2) {
        StringBuilder sb;
        if (i2 == 0) {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOf(s.b, j)));
            sb.append(d[i]);
            sb.append(String.valueOf(Arrays.copyOfRange(s.b, j, k)));
            sb.append(d[i]);
            sb.append(String.valueOf(Arrays.copyOfRange(s.b, k, m)));
            sb.append(d[i]);
            sb.append(String.valueOf(r.f7971c));
        } else if (i2 == 1) {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOf(s.b, j)));
            sb.append(d[i]);
            sb.append(String.valueOf(Arrays.copyOfRange(s.b, j, k)));
            sb.append(d[i]);
            sb.append(String.valueOf(Arrays.copyOfRange(s.b, l, n)));
        } else if (i2 == 2) {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOfRange(s.b, m, l)));
            sb.append(String.valueOf(f7977c));
        } else if (i2 != 3) {
            sb = null;
        } else {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOfRange(s.b, m, l)));
            sb.append(String.valueOf(r.f7971c));
        }
        return sb.toString().toCharArray();
    }

    public static float c(Context context) {
        if (context != null) {
            try {
                float f2 = context.getResources().getDisplayMetrics().density;
                if (f2 == 0.0f) {
                    return 2.5f;
                }
                return f2;
            } catch (Exception e2) {
                e2.printStackTrace();
                return 2.5f;
            }
        }
        return 2.5f;
    }

    public static String c(String str) {
        try {
            return w.b(str) ? URLEncoder.encode(str, "utf-8") : "";
        } catch (Throwable th) {
            o.b(f7976a, th.getMessage(), th);
            return "";
        }
    }

    public static int d(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String queryParameter = parse.getQueryParameter(com.anythink.expressad.a.z);
                if (TextUtils.isEmpty(queryParameter)) {
                    return false;
                }
                return queryParameter.equals("1");
            }
            return false;
        } catch (Exception e2) {
            o.d(f7976a, e2.getMessage());
            return false;
        }
    }

    public static int e(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return k(context).heightPixels;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0066 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean e(java.lang.String r3) {
        /*
            r0 = r3
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L9
            r0 = 0
            return r0
        L9:
            r0 = r3
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L84
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L6e
            r0 = r10
            java.lang.String r1 = "dyview"
            java.lang.String r0 = r0.getQueryParameter(r1)     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L84
            r9 = r0
            r0 = r9
            r3 = r0
            r0 = r9
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L84
            if (r0 == 0) goto L32
            r0 = r10
            java.lang.String r1 = "view"
            java.lang.String r0 = r0.getQueryParameter(r1)     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L84
            r3 = r0
        L32:
            r0 = r3
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L84
            r6 = r0
            r0 = r6
            if (r0 != 0) goto L4f
            r0 = -1
            r4 = r0
            r0 = r3
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L84 java.lang.Exception -> L87
            r5 = r0
            r0 = r5
            r4 = r0
        L44:
            r0 = r4
            r1 = 2
            int r0 = r0 % r1
            if (r0 != 0) goto L4f
            r0 = 1
            r6 = r0
            goto L51
        L4f:
            r0 = 0
            r6 = r0
        L51:
            r0 = r6
            r7 = r0
            r0 = r10
            java.lang.String r1 = "natmp"
            java.lang.String r0 = r0.getQueryParameter(r1)     // Catch: java.lang.Exception -> L6a java.lang.Throwable -> L8b
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L6a java.lang.Throwable -> L8b
            r8 = r0
            r0 = r8
            if (r0 != 0) goto L68
            r0 = 1
            return r0
        L68:
            r0 = r6
            return r0
        L6a:
            r3 = move-exception
            goto L73
        L6e:
            r0 = 0
            return r0
        L70:
            r3 = move-exception
            r0 = 0
            r6 = r0
        L73:
            r0 = r6
            r7 = r0
            java.lang.String r0 = "SameTools"
            r1 = r3
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L8b
            com.anythink.expressad.foundation.h.o.d(r0, r1)     // Catch: java.lang.Throwable -> L8b
            r0 = 0
            return r0
        L81:
            r0 = r7
            return r0
        L84:
            r3 = move-exception
            r0 = 0
            return r0
        L87:
            r3 = move-exception
            goto L44
        L8b:
            r3 = move-exception
            goto L81
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.foundation.h.t.e(java.lang.String):boolean");
    }

    public static int f(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return k(context).widthPixels;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String queryParameter = parse.getQueryParameter(com.anythink.expressad.a.Z);
                if (TextUtils.isEmpty(queryParameter)) {
                    return false;
                }
                return queryParameter.equals("0");
            }
            return false;
        } catch (Exception e2) {
            o.d(f7976a, e2.getMessage());
            return false;
        }
    }

    public static int g(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getResources().getDisplayMetrics().widthPixels;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int g(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            Uri parse = Uri.parse(str);
            int i2 = -1;
            if (parse != null) {
                String queryParameter = parse.getQueryParameter(com.anythink.expressad.a.C);
                String str2 = queryParameter;
                if (TextUtils.isEmpty(queryParameter)) {
                    str2 = parse.getQueryParameter(com.anythink.expressad.a.B);
                }
                i2 = -1;
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        i2 = Integer.parseInt(str2);
                    } catch (Exception e2) {
                        return -1;
                    }
                }
            }
            return i2;
        } catch (Exception e3) {
            o.d(f7976a, e3.getMessage());
            return -1;
        }
    }

    public static int h(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getResources().getDisplayMetrics().heightPixels;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    private static <T extends String> boolean h(T t) {
        return t != null && t.length() > 0;
    }

    public static int i(Context context) {
        if (context != null) {
            return 0;
        }
        try {
            if (context.getResources().getIdentifier("config_showNavigationBar", "bool", "android") != 0) {
                return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier(Settings.System.NAVIGATION_BAR_HEIGHT, "dimen", "android"));
            }
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    private static boolean i(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            try {
                Uri parse = Uri.parse(str);
                boolean z = false;
                if (parse != null) {
                    z = false;
                    if (!TextUtils.isEmpty(parse.getQueryParameter(com.anythink.expressad.a.C))) {
                        z = true;
                    }
                }
                return z;
            } catch (Exception e2) {
                o.d(f7976a, e2.getMessage());
                return false;
            }
        } catch (Throwable th) {
            return false;
        }
    }

    public static int j(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            PackageInfo currentWebViewPackage = Build.VERSION.SDK_INT >= 26 ? WebView.getCurrentWebViewPackage() : context.getPackageManager().getPackageInfo("com.google.android.webview", 1);
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.foundation.b.a.b().e();
            com.anythink.expressad.d.a b2 = com.anythink.expressad.d.b.b();
            com.anythink.expressad.d.a aVar = b2;
            if (b2 == null) {
                com.anythink.expressad.d.b.a();
                aVar = com.anythink.expressad.d.b.c();
            }
            if (currentWebViewPackage == null || TextUtils.isEmpty(currentWebViewPackage.versionName) || !currentWebViewPackage.versionName.equals("77.0.3865.92")) {
                return aVar.P();
            }
            return 5;
        } catch (Exception e2) {
            return 0;
        }
    }

    private static DisplayMetrics k(Context context) {
        if (context == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealMetrics(displayMetrics);
                return displayMetrics;
            }
            defaultDisplay.getMetrics(displayMetrics);
            return displayMetrics;
        } catch (Throwable th) {
            th.printStackTrace();
            return context.getResources().getDisplayMetrics();
        }
    }
}
