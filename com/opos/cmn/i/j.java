package com.opos.cmn.i;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.PowerManager;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/i/j.class */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final String f11290a = j.class.getSimpleName();

    private static final RectF a(View view) {
        RectF rectF;
        try {
            int[] iArr = new int[2];
            iArr[0] = -1;
            iArr[1] = -1;
            view.getLocationOnScreen(iArr);
            rectF = new RectF(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a(f11290a, "", (Throwable) e);
            rectF = null;
        }
        String str = f11290a;
        StringBuilder sb = new StringBuilder();
        sb.append("getViewScreenLocation=");
        sb.append(rectF != null ? rectF.toString() : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b(str, sb.toString());
        return rectF;
    }

    public static final boolean a(Context context) {
        boolean z = true;
        if (context != null) {
            try {
                PowerManager powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
                z = true;
                if (powerManager != null) {
                    z = Build.VERSION.SDK_INT >= 20 ? powerManager.isInteractive() : powerManager.isScreenOn();
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a(f11290a, "", (Throwable) e);
                z = true;
            }
        }
        com.opos.cmn.an.f.a.b(f11290a, "is screenOn = " + z);
        return z;
    }

    public static final boolean a(Context context, View view) {
        boolean z = false;
        if (context != null) {
            z = false;
            if (view != null) {
                if (!view.isInTouchMode()) {
                    return false;
                }
                if (!view.isShown()) {
                    com.opos.cmn.an.f.a.b(f11290a, "view not shown");
                    return false;
                } else if (Build.VERSION.SDK_INT >= 28) {
                    return b(view);
                } else {
                    if (!com.opos.cmn.an.h.d.a.a(context, view)) {
                        return false;
                    }
                    int j = com.opos.cmn.an.h.f.a.j(context);
                    z = false;
                    if (a(j != 0 ? j != 90 ? j != 180 ? j != 270 ? null : new RectF(com.opos.cmn.an.h.f.a.c(context) - 79.0f, 0.0f, com.opos.cmn.an.h.f.a.c(context), com.opos.cmn.an.h.f.a.b(context)) : new RectF(0.0f, com.opos.cmn.an.h.f.a.c(context) - 79.0f, com.opos.cmn.an.h.f.a.b(context), com.opos.cmn.an.h.f.a.c(context)) : new RectF(0.0f, 0.0f, 79.0f, com.opos.cmn.an.h.f.a.b(context)) : new RectF(0.0f, 0.0f, com.opos.cmn.an.h.f.a.b(context), 79.0f), view)) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public static final boolean a(RectF rectF, View view) {
        boolean z;
        RectF a2;
        if (view != null && rectF != null) {
            try {
                a2 = a(view);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a(f11290a, "", (Throwable) e);
            }
            if (a2 != null) {
                if (RectF.intersects(rectF, a2)) {
                    z = true;
                    com.opos.cmn.an.f.a.b(f11290a, "isCoodinateInRect rect=" + rectF + ",view =" + view);
                    return z;
                }
            }
        }
        z = false;
        com.opos.cmn.an.f.a.b(f11290a, "isCoodinateInRect rect=" + rectF + ",view =" + view);
        return z;
    }

    private static final boolean b(View view) {
        DisplayCutout displayCutout;
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null || (displayCutout = rootWindowInsets.getDisplayCutout()) == null) {
            return false;
        }
        List<Rect> boundingRects = displayCutout.getBoundingRects();
        boolean z = false;
        if (boundingRects != null) {
            if (boundingRects.size() > 0) {
                Iterator<Rect> it = boundingRects.iterator();
                while (true) {
                    z = false;
                    if (!it.hasNext()) {
                        break;
                    } else if (a(new RectF(it.next()), view)) {
                        z = true;
                        break;
                    }
                }
            } else {
                return false;
            }
        }
        return z;
    }
}
