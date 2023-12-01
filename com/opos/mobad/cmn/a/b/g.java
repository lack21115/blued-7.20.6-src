package com.opos.mobad.cmn.a.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/a/b/g.class */
public class g {

    /* renamed from: com.opos.mobad.cmn.a.b.g$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/a/b/g$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25895a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x004d -> B:37:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0051 -> B:33:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0055 -> B:31:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0059 -> B:27:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005d -> B:35:0x0040). Please submit an issue!!! */
        static {
            int[] iArr = new int[a.values().length];
            f25895a = iArr;
            try {
                iArr[a.NonClickBt.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f25895a[a.ClickBt.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f25895a[a.Video.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f25895a[a.FloatLayerClickBt.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f25895a[a.FloatLayerNonClickBt.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f25895a[a.Pendant.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public static int a() {
        return View.generateViewId();
    }

    public static Bitmap a(int i, Bitmap bitmap) {
        Bitmap bitmap2 = bitmap;
        if (bitmap != null) {
            if (i > 0) {
                bitmap2 = Bitmap.createBitmap(bitmap.getWidth() * i, bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap2);
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= i) {
                        break;
                    }
                    canvas.drawBitmap(bitmap, bitmap.getWidth() * i3, 0.0f, (Paint) null);
                    i2 = i3 + 1;
                }
            } else {
                return bitmap;
            }
        }
        return bitmap2;
    }

    public static Bitmap a(String str) {
        if (com.opos.cmn.an.c.a.a(str)) {
            return null;
        }
        try {
            return BitmapFactory.decodeFile(str);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.a("ViewUtils", "", th);
            return null;
        }
    }

    public static Bitmap a(String str, int i, int i2) {
        if (com.opos.cmn.an.c.a.a(str)) {
            return null;
        }
        try {
            return com.opos.cmn.an.d.c.a.a(str, i, i2);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.a("ViewUtils", "", th);
            return null;
        }
    }

    public static BitmapDrawable a(Context context, Bitmap bitmap) {
        if (bitmap != null) {
            return (Build.VERSION.SDK_INT < 15 || context == null) ? new BitmapDrawable(bitmap) : new BitmapDrawable(context.getResources(), bitmap);
        }
        return null;
    }

    public static Drawable a(Context context, String str) {
        Bitmap a2 = a(str);
        if (a2 != null) {
            return a(context, a2);
        }
        return null;
    }

    public static Drawable a(Context context, String str, int i, int i2) {
        Bitmap a2 = a(str, i, i2);
        if (a2 != null) {
            return a(context, a2);
        }
        return null;
    }

    public static Drawable a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(637534208);
        gradientDrawable.setCornerRadius(9.0f);
        return new LayerDrawable(new Drawable[]{gradientDrawable, drawable});
    }

    public static String a(Context context, AdItemData adItemData, boolean z) {
        String str;
        MaterialData materialData;
        if (adItemData != null && (materialData = adItemData.i().get(0)) != null) {
            if (!z) {
                if (TextUtils.isEmpty(materialData.Y())) {
                    str = "立刻打开";
                    switch (materialData.e()) {
                        case 1:
                            str = "点击查看";
                            break;
                        case 2:
                            if (!com.opos.cmn.an.c.a.a(materialData.k()) && com.opos.cmn.an.h.d.a.d(context, materialData.k())) {
                                str = "立刻打开";
                                break;
                            } else {
                                str = "点击安装";
                                break;
                            }
                            break;
                        case 3:
                            if (!com.opos.cmn.an.c.a.a(materialData.k()) && com.opos.cmn.an.h.d.a.d(context, materialData.k())) {
                                str = "立刻打开";
                                break;
                            } else {
                                str = "立即下载";
                                break;
                            }
                            break;
                        case 5:
                            str = "查看详情";
                            break;
                        case 6:
                            str = "秒开";
                            break;
                        case 7:
                            str = "打开";
                            break;
                    }
                } else {
                    str = materialData.Y();
                }
            } else {
                str = "立刻打开";
            }
            com.opos.cmn.an.f.a.b("ViewUtils", "getClickBnText=" + str);
            return str;
        }
        str = "";
        com.opos.cmn.an.f.a.b("ViewUtils", "getClickBnText=" + str);
        return str;
    }

    public static void a(Activity activity) {
        if (activity != null) {
            activity.requestWindowFeature(1);
        }
    }

    public static void a(Activity activity, String str) {
        if (activity != null) {
            try {
                Window window = activity.getWindow();
                if (Build.VERSION.SDK_INT >= 23) {
                    window.getDecorView().setSystemUiVisibility(1280);
                    window.addFlags(Integer.MIN_VALUE);
                    window.setStatusBarColor(Color.parseColor(str));
                }
                a(activity, true);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("ViewUtils", "setWhiteStatusBar", (Throwable) e);
            }
        }
    }

    private static void a(Activity activity, boolean z) {
        if (activity != null) {
            try {
                Window window = activity.getWindow();
                window.addFlags(Integer.MIN_VALUE);
                int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
                int i = systemUiVisibility;
                if (Build.VERSION.SDK_INT >= 23) {
                    i = z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193);
                }
                window.getDecorView().setSystemUiVisibility(i);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("ViewUtils", "", (Throwable) e);
            }
        }
    }

    public static void a(View view, Drawable drawable) {
        if (view == null || drawable == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0063, code lost:
        if (r0.ab().b() != 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x006f, code lost:
        if (r0.W() != 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x007b, code lost:
        if (r0.V() != 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0087, code lost:
        if (r0.K() != 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0093, code lost:
        if (r0.e() != 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009f, code lost:
        if (r0.J() != 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a2, code lost:
        r5 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(com.opos.mobad.model.data.AdItemData r3, com.opos.mobad.cmn.a.b.a r4) {
        /*
            r0 = 0
            r6 = r0
            r0 = r6
            r5 = r0
            r0 = r3
            if (r0 == 0) goto La4
            r0 = r3
            java.util.List r0 = r0.i()
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.opos.mobad.model.data.MaterialData r0 = (com.opos.mobad.model.data.MaterialData) r0
            r3 = r0
            r0 = r6
            r5 = r0
            r0 = r3
            if (r0 == 0) goto La4
            int[] r0 = com.opos.mobad.cmn.a.b.g.AnonymousClass1.f25895a
            r1 = r4
            int r1 = r1.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L99;
                case 2: goto L8d;
                case 3: goto L81;
                case 4: goto L75;
                case 5: goto L69;
                case 6: goto L51;
                default: goto L4c;
            }
        L4c:
            r0 = r6
            r5 = r0
            goto La4
        L51:
            r0 = r6
            r5 = r0
            r0 = r3
            com.opos.mobad.model.data.PendantData r0 = r0.ab()
            if (r0 == 0) goto La4
            r0 = r6
            r5 = r0
            r0 = r3
            com.opos.mobad.model.data.PendantData r0 = r0.ab()
            int r0 = r0.b()
            if (r0 == 0) goto La4
            goto La2
        L69:
            r0 = r6
            r5 = r0
            r0 = r3
            int r0 = r0.W()
            if (r0 == 0) goto La4
            goto La2
        L75:
            r0 = r6
            r5 = r0
            r0 = r3
            int r0 = r0.V()
            if (r0 == 0) goto La4
            goto La2
        L81:
            r0 = r6
            r5 = r0
            r0 = r3
            int r0 = r0.K()
            if (r0 == 0) goto La4
            goto La2
        L8d:
            r0 = r6
            r5 = r0
            r0 = r3
            int r0 = r0.e()
            if (r0 == 0) goto La4
            goto La2
        L99:
            r0 = r6
            r5 = r0
            r0 = r3
            int r0 = r0.J()
            if (r0 == 0) goto La4
        La2:
            r0 = 1
            r5 = r0
        La4:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r3 = r0
            r0 = r3
            java.lang.String r1 = "isValidClickWithInteraction result ="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r3
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "ViewUtils"
            r1 = r3
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.cmn.a.b.g.a(com.opos.mobad.model.data.AdItemData, com.opos.mobad.cmn.a.b.a):boolean");
    }

    public static Drawable b(Context context, String str) {
        Drawable a2 = a(context, str);
        Drawable drawable = a2;
        if (a2 != null) {
            drawable = a(a2);
        }
        return drawable;
    }
}
