package com.opos.cmn.an.h.f;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/h/f/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static int[] f24564a;
    private static float b;

    /* renamed from: c  reason: collision with root package name */
    private static float f24565c;
    private static float d;
    private static float e;
    private static float f;
    private static int g;
    private static WindowManager h;
    private static float i;
    private static float j;
    private static final String k = "com." + com.opos.cmn.an.a.a.e + ".inner.view.WindowManagerWrapper";

    public static int a(Context context, float f2) {
        int i2 = (int) f2;
        if (context != null) {
            i2 = (int) ((m(context) * f2) + 0.5f);
        }
        return i2;
    }

    public static WindowManager a(Context context) {
        if (h == null && context != null) {
            h = (WindowManager) context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        }
        return h;
    }

    public static void a(Context context, View view) {
        if (context == null || view == null) {
            return;
        }
        try {
            WindowManager a2 = a(context);
            if (a2 != null) {
                a2.removeView(view);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("WinMgrTool", "", e2);
        }
    }

    public static void a(Context context, View view, WindowManager.LayoutParams layoutParams) {
        if (context == null || view == null || layoutParams == null) {
            return;
        }
        try {
            WindowManager a2 = a(context);
            if (a2 != null) {
                a2.addView(view, layoutParams);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("WinMgrTool", "", e2);
        }
    }

    public static boolean a() {
        boolean a2 = a(com.opos.cmn.an.a.a.f24483a);
        com.opos.cmn.an.f.a.b("WinMgrTool", "isOPMobile=" + a2);
        return a2;
    }

    public static boolean a(Activity activity) {
        boolean z;
        if (activity != null) {
            try {
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("WinMgrTool", "", e2);
            }
            if ((activity.getWindow().getAttributes().flags & 1024) == 1024) {
                z = true;
                com.opos.cmn.an.f.a.b("WinMgrTool", "isActivityFullScreen=" + z);
                return z;
            }
        }
        z = false;
        com.opos.cmn.an.f.a.b("WinMgrTool", "isActivityFullScreen=" + z);
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0093, code lost:
        if (r8.toLowerCase().contains(r4) != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.lang.String r4) {
        /*
            r0 = r4
            boolean r0 = com.opos.cmn.an.c.a.a(r0)     // Catch: java.lang.Exception -> L9b
            if (r0 != 0) goto La4
            java.lang.String r0 = android.os.Build.BRAND     // Catch: java.lang.Exception -> L9b
            if (r0 == 0) goto Lc6
            java.lang.String r0 = android.os.Build.BRAND     // Catch: java.lang.Exception -> L9b
            r6 = r0
            goto L14
        L14:
            java.lang.String r0 = android.os.Build.MANUFACTURER     // Catch: java.lang.Exception -> L9b
            if (r0 == 0) goto Lcc
            java.lang.String r0 = android.os.Build.MANUFACTURER     // Catch: java.lang.Exception -> L9b
            r7 = r0
            goto L21
        L21:
            java.lang.String r0 = android.os.Build.MODEL     // Catch: java.lang.Exception -> L9b
            if (r0 == 0) goto Ld2
            java.lang.String r0 = android.os.Build.MODEL     // Catch: java.lang.Exception -> L9b
            r8 = r0
            goto L2f
        L2f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L9b
            r1 = r0
            r1.<init>()     // Catch: java.lang.Exception -> L9b
            r9 = r0
            r0 = r9
            java.lang.String r1 = "brand="
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> L9b
            r0 = r9
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> L9b
            r0 = r9
            java.lang.String r1 = ",manufacturer="
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> L9b
            r0 = r9
            r1 = r7
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> L9b
            r0 = r9
            java.lang.String r1 = ",model="
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> L9b
            r0 = r9
            r1 = r8
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> L9b
            java.lang.String r0 = "WinMgrTool"
            r1 = r9
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L9b
            com.opos.cmn.an.f.a.b(r0, r1)     // Catch: java.lang.Exception -> L9b
            r0 = r4
            r1 = r6
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch: java.lang.Exception -> L9b
            if (r0 != 0) goto L96
            r0 = r4
            r1 = r7
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch: java.lang.Exception -> L9b
            if (r0 != 0) goto L96
            r0 = r8
            boolean r0 = com.opos.cmn.an.c.a.a(r0)     // Catch: java.lang.Exception -> L9b
            if (r0 != 0) goto La4
            r0 = r8
            java.lang.String r0 = r0.toLowerCase()     // Catch: java.lang.Exception -> L9b
            r1 = r4
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Exception -> L9b
            r5 = r0
            r0 = r5
            if (r0 == 0) goto La4
        L96:
            r0 = 1
            r5 = r0
            goto La6
        L9b:
            r4 = move-exception
            java.lang.String r0 = "WinMgrTool"
            java.lang.String r1 = ""
            r2 = r4
            com.opos.cmn.an.f.a.c(r0, r1, r2)
        La4:
            r0 = 0
            r5 = r0
        La6:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r4 = r0
            r0 = r4
            java.lang.String r1 = "isLimitedBrandMobile ="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "WinMgrTool"
            r1 = r4
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r5
            return r0
        Lc6:
            java.lang.String r0 = ""
            r6 = r0
            goto L14
        Lcc:
            java.lang.String r0 = ""
            r7 = r0
            goto L21
        Ld2:
            java.lang.String r0 = ""
            r8 = r0
            goto L2f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.h.f.a.a(java.lang.String):boolean");
    }

    private static int[] a(Context context, boolean z) {
        try {
            if (f24564a == null && context != null) {
                DisplayMetrics p = p(context);
                f24564a = new int[]{p.widthPixels > p.heightPixels ? p.heightPixels : p.widthPixels, p.widthPixels > p.heightPixels ? p.widthPixels : p.heightPixels};
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("WinMgrTool", "", e2);
        }
        if (f24564a != null) {
            if (z || d(context)) {
                int[] iArr = f24564a;
                return new int[]{iArr[0], iArr[1]};
            }
            int[] iArr2 = f24564a;
            return new int[]{iArr2[1], iArr2[0]};
        }
        return new int[]{-1, -1};
    }

    public static int b(Context context) {
        int i2 = a(context, true)[0];
        com.opos.cmn.an.f.a.b("WinMgrTool", "getScreenWidth=" + i2);
        return i2;
    }

    public static int b(Context context, float f2) {
        int i2 = (int) f2;
        if (context != null) {
            i2 = (int) ((f2 / m(context)) + 0.5f);
        }
        return i2;
    }

    public static int c(Context context) {
        int i2 = a(context, true)[1];
        com.opos.cmn.an.f.a.b("WinMgrTool", "getScreenHeight=" + i2);
        return i2;
    }

    public static int c(Context context, float f2) {
        int i2 = (int) f2;
        if (context != null) {
            i2 = (int) ((n(context) * f2) + 0.5f);
        }
        return i2;
    }

    public static boolean d(Context context) {
        boolean z = false;
        boolean z2 = false;
        try {
            Configuration configuration = context.getResources().getConfiguration();
            if (configuration != null) {
                if (configuration.orientation == 1) {
                }
                StringBuilder sb = new StringBuilder();
                boolean z3 = z;
                sb.append("isPortrait=");
                boolean z4 = z;
                sb.append(z);
                z2 = z;
                com.opos.cmn.an.f.a.b("WinMgrTool", sb.toString());
                return z;
            }
            z = true;
            StringBuilder sb2 = new StringBuilder();
            boolean z32 = z;
            sb2.append("isPortrait=");
            boolean z42 = z;
            sb2.append(z);
            z2 = z;
            com.opos.cmn.an.f.a.b("WinMgrTool", sb2.toString());
            return z;
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("WinMgrTool", "", e2);
            return z2;
        }
    }

    public static float e(Context context) {
        float f2 = d;
        if (0.0f != f2) {
            return f2;
        }
        if (context != null) {
            d = o(context).density;
        }
        com.opos.cmn.an.f.a.b("WinMgrTool", "getAppDensity=" + d);
        return d;
    }

    public static float f(Context context) {
        float f2 = b;
        if (0.0f != f2) {
            return f2;
        }
        if (context != null) {
            b = p(context).density;
        }
        com.opos.cmn.an.f.a.b("WinMgrTool", "getDensity=" + b);
        return b;
    }

    public static float g(Context context) {
        float f2 = e;
        if (0.0f != f2) {
            return f2;
        }
        if (context != null) {
            e = o(context).scaledDensity;
        }
        com.opos.cmn.an.f.a.b("WinMgrTool", "getAppScaledDensity=" + e);
        return e;
    }

    public static float h(Context context) {
        float f2 = f24565c;
        if (0.0f != f2) {
            return f2;
        }
        if (context != null) {
            f24565c = p(context).scaledDensity;
        }
        com.opos.cmn.an.f.a.b("WinMgrTool", "getScaledDensity=" + f24565c);
        return f24565c;
    }

    public static int i(Context context) {
        int i2 = 270;
        if (context != null) {
            try {
                int j2 = j(context);
                if (j2 != 90) {
                    if (j2 == 180) {
                        return 180;
                    }
                    if (j2 == 270) {
                        return 90;
                    }
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("WinMgrTool", "", e2);
            }
            return i2;
        }
        i2 = 0;
        return i2;
    }

    public static int j(Context context) {
        if (context != null) {
            try {
                WindowManager a2 = a(context);
                if (a2 != null) {
                    try {
                        int rotation = a2.getDefaultDisplay().getRotation();
                        if (rotation == 1) {
                            return 90;
                        }
                        if (rotation == 2) {
                            return 180;
                        }
                        if (rotation == 3) {
                            return 270;
                        }
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.c("WinMgrTool", "", e2);
                    }
                }
                return 0;
            } catch (Exception e3) {
                com.opos.cmn.an.f.a.c("WinMgrTool", "", e3);
                return 0;
            }
        }
        return 0;
    }

    public static int k(Context context) {
        int dimensionPixelSize;
        if (g == 0) {
            try {
                if (Build.VERSION.SDK_INT >= 30) {
                    int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
                    if (identifier > 0) {
                        dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                    }
                } else {
                    Class<?> cls = Class.forName("com.android.internal.R$dimen");
                    dimensionPixelSize = context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
                }
                g = dimensionPixelSize;
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("WinMgrTool", "getStatusBarHeight", e2);
            }
        }
        com.opos.cmn.an.f.a.b("WinMgrTool", "getStatusBarHeight=" + g);
        return g;
    }

    public static float l(Context context) {
        try {
            return c(context) / b(context);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("WinMgrTool", "", e2);
            return 0.0f;
        }
    }

    public static float m(Context context) {
        float f2 = i;
        if (0.0f != f2) {
            return f2;
        }
        if (context != null) {
            if (a() && e(context) == f(context) && b(context) == 1080) {
                float f3 = 3.0f;
                if (e(context) == 3.0f) {
                    f3 = e(context);
                }
                i = f3;
            } else {
                i = e(context);
            }
        }
        com.opos.cmn.an.f.a.b("WinMgrTool", "getAppValidDensity=" + i);
        return i;
    }

    public static float n(Context context) {
        float f2 = j;
        if (0.0f != f2) {
            return f2;
        }
        if (context != null) {
            if (a() && g(context) == h(context) && b(context) == 1080) {
                float f3 = 3.0f;
                if (g(context) == 3.0f) {
                    f3 = g(context);
                }
                j = f3;
            } else {
                j = g(context);
            }
        }
        com.opos.cmn.an.f.a.b("WinMgrTool", "getAppValidScaledDensity=" + j);
        return j;
    }

    private static DisplayMetrics o(Context context) {
        if (context != null) {
            try {
                return context.getResources().getDisplayMetrics();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("WinMgrTool", "getAppDisplayMetrics", e2);
                return null;
            }
        }
        return null;
    }

    private static DisplayMetrics p(Context context) {
        if (context != null) {
            try {
                Display defaultDisplay = a(context).getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                try {
                    Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
                    return displayMetrics;
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b("WinMgrTool", "getDisplayMetrics", e2);
                    return context.getResources().getDisplayMetrics();
                }
            } catch (Exception e3) {
                com.opos.cmn.an.f.a.c("WinMgrTool", "", e3);
                return null;
            }
        }
        return null;
    }
}
