package com.anythink.core.common.k;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/k/h.class */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6811a = "CommonUtils";
    public static char[] b = {'a', 'n', 'd', 'r', 'o', 'i', 'd', 'c', 'o', 'n', 't', 'e', 'n', 't', 'p', 'm', 'g', 'e', 't', 'C', 'o', 'n', 't', 'e', 'x', 't'};
    private static char[] d = {'A', 'p', 'p', 'l', 'i', 'c', 'a', 't', 'i', 'o', 'n', 'I', 'n', 'f', 'o'};
    private static char[] e = {'.', 'X'};
    private static int f = 0;
    private static int g = 1;
    private static int h = 2;
    private static int i = 3;
    private static int j = 0;
    private static int k = 7;
    private static int l = 14;
    private static int m = 19;
    private static int n = 16;
    private static int o = 26;

    /* renamed from: c  reason: collision with root package name */
    public static char[] f6812c = {'P', 'a', 'c', 'k', 'a', 'g', 'e', 'M', 'a', 'n', 'a', 'g', 'e', 'r'};

    /* renamed from: com.anythink.core.common.k.h$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/k/h$1.class */
    final class AnonymousClass1 implements View.OnSystemUiVisibilityChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f6813a;

        AnonymousClass1(View view) {
            this.f6813a = view;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public final void onSystemUiVisibilityChange(int i) {
            if ((i & 2) == 0) {
                h.a(this.f6813a);
            }
        }
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(Context context, String str, String str2) {
        if (context != null) {
            return context.getResources().getIdentifier("anythink_".concat(String.valueOf(str)), str2, context.getPackageName());
        }
        return -1;
    }

    public static String a(Object[] objArr) {
        int length;
        if (objArr == null || (length = objArr.length - 1) == -1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            sb.append(String.valueOf(objArr[i3]));
            if (i3 == length) {
                return sb.toString();
            }
            sb.append(",");
            i2 = i3 + 1;
        }
    }

    private static void a(Activity activity) {
        Window window = activity.getWindow();
        if (window != null) {
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(4870);
            decorView.setOnSystemUiVisibilityChangeListener(new AnonymousClass1(decorView));
        }
    }

    static void a(View view) {
        view.setSystemUiVisibility(4870);
    }

    public static boolean a() {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted("http://www.toponad.com");
            }
            if (Build.VERSION.SDK_INT >= 23) {
                return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isAvailable();
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean a(Context context, String str) {
        boolean z;
        synchronized (h.class) {
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

    public static <T extends String> boolean a(T t) {
        return t == null || t.length() == 0;
    }

    public static boolean a(String str, Context context) {
        try {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                StringBuilder sb = new StringBuilder("Permission ");
                sb.append(str);
                sb.append(" is granted");
                return true;
            }
            StringBuilder sb2 = new StringBuilder("Permission ");
            sb2.append(str);
            sb2.append(" is NOT granted");
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    private static final char[] a(int i2) {
        StringBuilder sb;
        if (i2 == 0) {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOf(b, k)));
            sb.append(e[j]);
            sb.append(String.valueOf(Arrays.copyOfRange(b, k, l)));
            sb.append(e[j]);
            sb.append(String.valueOf(Arrays.copyOfRange(b, l, n)));
            sb.append(e[j]);
            sb.append(String.valueOf(f6812c));
        } else if (i2 == 1) {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOf(b, k)));
            sb.append(e[j]);
            sb.append(String.valueOf(Arrays.copyOfRange(b, k, l)));
            sb.append(e[j]);
            sb.append(String.valueOf(Arrays.copyOfRange(b, m, o)));
        } else if (i2 == 2) {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOfRange(b, n, m)));
            sb.append(String.valueOf(d));
        } else if (i2 != 3) {
            sb = null;
        } else {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOfRange(b, n, m)));
            sb.append(String.valueOf(f6812c));
        }
        return sb.toString().toCharArray();
    }

    public static String[] a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            String[] strArr = new String[jSONArray.length()];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= jSONArray.length()) {
                    return strArr;
                }
                strArr[i3] = jSONArray.optString(i3);
                i2 = i3 + 1;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    public static int b(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a7, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int b(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r10 = r0
            r0 = r10
            r1 = r3
            java.lang.String r1 = r1.getPackageName()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            java.lang.String r1 = ".R"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            java.lang.String r0 = r0.toString()
            r10 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r3 = r0
            r0 = r3
            r1 = r4
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r3
            java.lang.String r1 = "_"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r3
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r3
            java.lang.String r0 = r0.toString()
            r3 = r0
            r0 = r10
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Throwable -> Lae
            java.lang.Class[] r0 = r0.getClasses()     // Catch: java.lang.Throwable -> Lae
            r4 = r0
            r0 = r4
            int r0 = r0.length     // Catch: java.lang.Throwable -> Lae
            r8 = r0
            r0 = 0
            r6 = r0
        L53:
            r0 = r6
            r1 = r8
            if (r0 >= r1) goto Lb3
            r0 = r4
            r1 = r6
            r0 = r0[r1]
            r5 = r0
            r0 = r5
            java.lang.String r0 = r0.getSimpleName()     // Catch: java.lang.Throwable -> Lae
            java.lang.String r1 = "styleable"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> Lae
            if (r0 == 0) goto La7
            r0 = r5
            java.lang.reflect.Field[] r0 = r0.getFields()     // Catch: java.lang.Throwable -> Lae
            r5 = r0
            r0 = r5
            int r0 = r0.length     // Catch: java.lang.Throwable -> Lae
            r9 = r0
            r0 = 0
            r7 = r0
        L76:
            r0 = r7
            r1 = r9
            if (r0 >= r1) goto La7
            r0 = r5
            r1 = r7
            r0 = r0[r1]
            r10 = r0
            r0 = r10
            java.lang.String r0 = r0.getName()     // Catch: java.lang.Throwable -> Lae
            r1 = r3
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> Lae
            if (r0 == 0) goto L9e
            r0 = r10
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> Lae
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.Throwable -> Lae
            int r0 = r0.intValue()     // Catch: java.lang.Throwable -> Lae
            r6 = r0
            r0 = r6
            return r0
        L9e:
            r0 = r7
            r1 = 1
            int r0 = r0 + r1
            r7 = r0
            goto L76
        La7:
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L53
        Lae:
            r3 = move-exception
            r0 = r3
            r0.printStackTrace()
        Lb3:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.k.h.b(android.content.Context, java.lang.String, java.lang.String):int");
    }

    private static View.OnSystemUiVisibilityChangeListener b(View view) {
        return new AnonymousClass1(view);
    }

    private static Object b(String str, Context context) {
        try {
            return Class.forName(String.valueOf(a(f))).getMethod(String.valueOf(a(h)), String.class, Integer.TYPE).invoke(Class.forName(String.valueOf(a(g))).getMethod(String.valueOf(a(i)), new Class[0]).invoke(context, new Object[0]), str, 8192);
        } catch (Throwable th) {
            return null;
        }
    }

    public static <T extends String> boolean b(T t) {
        return t != null && t.length() > 0;
    }

    private static int[] b(Context context, String str) {
        try {
            Field[] fields = Class.forName(context.getPackageName() + ".R$styleable").getFields();
            int length = fields.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return null;
                }
                Field field = fields[i3];
                if (field.getName().equals(str)) {
                    return (int[]) field.get(null);
                }
                i2 = i3 + 1;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static Map<String, Object> c(String str) {
        HashMap hashMap = new HashMap();
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.opt(next));
                }
            }
            return hashMap;
        } catch (Exception e2) {
            return hashMap;
        }
    }
}
