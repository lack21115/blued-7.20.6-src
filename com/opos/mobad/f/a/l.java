package com.opos.mobad.f.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/l.class */
public class l {
    public static int a(Context context) {
        if (context != null) {
            return (int) ((com.opos.cmn.an.h.f.a.b(context) * 0.3778f) + 0.5f);
        }
        return 504;
    }

    public static boolean a(ViewGroup viewGroup, View view) {
        if (viewGroup == null || view == null) {
            return false;
        }
        try {
            if (view.getParent() == null) {
                viewGroup.addView(view);
                return true;
            }
            com.opos.cmn.an.f.a.b("InterSplash$SplashViewUtils", String.format("addView failed:The %s already has a parent.", view));
            return false;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("InterSplash$SplashViewUtils", "", e);
            return false;
        }
    }

    public static boolean a(ViewGroup viewGroup, View view, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup == null || view == null) {
            return false;
        }
        try {
            if (view.getParent() == null) {
                viewGroup.addView(view, layoutParams);
                return true;
            }
            com.opos.cmn.an.f.a.b("InterSplash$SplashViewUtils", String.format("addView failed:The %s already has a parent.", view));
            return false;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("InterSplash$SplashViewUtils", "", e);
            return false;
        }
    }
}
