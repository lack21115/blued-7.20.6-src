package com.bytedance.bdtracker;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Method;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/k2.class */
public class k2 {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f7636a = false;
    public static Class b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f7637c;
    public static boolean d = a("com.tencent.smtt.sdk.WebView");
    public static boolean e = a("androidx.recyclerview.widget.RecyclerView");
    public static boolean f = a("androidx.viewpager.widget.ViewPager");
    public static boolean g = a("androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
    public static boolean h;
    public static boolean i;
    public static boolean j;
    public static boolean k;
    public static boolean l;
    public static boolean m;
    public static boolean n;

    static {
        a("androidx.fragment.app.Fragment");
        a("androidx.fragment.app.FragmentActivity");
        h = a("androidx.appcompat.app.AlertDialog");
        i = a("androidx.appcompat.view.menu.ListMenuItemView");
        j = a("androidx.recyclerview.widget.RecyclerView");
        k = a("androidx.viewpager.widget.ViewPager");
        l = a("androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
        a("androidx.fragment.app.Fragment");
        a("androidx.fragment.app.FragmentActivity");
        m = a("androidx.appcompat.app.AlertDialog");
        n = a("androidx.appcompat.view.menu.ListMenuItemView");
    }

    public static Class<?> a(Class<?> cls) {
        while (cls != null && !cls.equals(ViewGroup.class)) {
            try {
                f7637c = cls.getDeclaredMethod("getChildAdapterPosition", View.class);
            } catch (NoSuchMethodException e2) {
            }
            if (f7637c == null) {
                try {
                    f7637c = cls.getDeclaredMethod("getChildPosition", View.class);
                } catch (NoSuchMethodException e3) {
                }
            }
            if (f7637c != null) {
                return cls;
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    public static boolean a(View view) {
        return (view instanceof WebView) || b(view);
    }

    public static boolean a(Object obj) {
        return j && (obj instanceof RecyclerView);
    }

    public static boolean a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean b(View view) {
        return d && (view instanceof com.tencent.smtt.sdk.WebView);
    }

    public static boolean b(Object obj) {
        return e && (obj instanceof RecyclerView);
    }
}
