package com.bytedance.bdtracker;

import android.app.ActionBar;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.applog.IPageMeta;
import com.bytedance.applog.annotation.PageMeta;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/t2.class */
public class t2 {

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f21310a = Collections.singletonList("android.app.Activity");
    public static final List<String> b = Arrays.asList("android.app.Fragment", "androidx.fragment.app.Fragment", "androidx.fragment.app.Fragment");

    /* renamed from: c  reason: collision with root package name */
    public static final List<Class<?>> f21311c = new ArrayList();
    public static final List<Class<?>> d = new ArrayList();

    static {
        for (String str : f21310a) {
            Class<?> b2 = j1.b(str);
            if (b2 != null) {
                f21311c.add(b2);
            }
        }
        for (String str2 : b) {
            Class<?> b3 = j1.b(str2);
            if (b3 != null) {
                d.add(b3);
            }
        }
    }

    public static String a(Object obj) {
        PageMeta pageMeta;
        if (obj == null) {
            return "";
        }
        if (obj instanceof IPageMeta) {
            try {
                return ((IPageMeta) obj).path();
            } catch (Throwable th) {
                z2.a("Cannot get path from IPageMeta.", th);
            }
        }
        return (!obj.getClass().isAnnotationPresent(PageMeta.class) || (pageMeta = (PageMeta) obj.getClass().getAnnotation(PageMeta.class)) == null || TextUtils.isEmpty(pageMeta.path())) ? obj.getClass().getCanonicalName() : pageMeta.path();
    }

    public static String b(Object obj) {
        Object invoke;
        CharSequence charSequence;
        String charSequence2;
        PageMeta pageMeta;
        if (obj == null) {
            return "";
        }
        if (obj instanceof IPageMeta) {
            try {
                return ((IPageMeta) obj).title();
            } catch (Throwable th) {
                z2.a("Cannot get title from IPageMeta.", th);
            }
        }
        if (!obj.getClass().isAnnotationPresent(PageMeta.class) || (pageMeta = (PageMeta) obj.getClass().getAnnotation(PageMeta.class)) == null || TextUtils.isEmpty(pageMeta.title())) {
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (!TextUtils.isEmpty(activity.getTitle())) {
                    return activity.getTitle().toString();
                }
                if (Build.VERSION.SDK_INT >= 11) {
                    ActionBar actionBar = activity.getActionBar();
                    if (actionBar != null) {
                        if (!TextUtils.isEmpty(actionBar.getTitle())) {
                            charSequence2 = actionBar.getTitle().toString();
                        }
                        charSequence2 = null;
                    } else {
                        try {
                            Class<?> a2 = j1.a("androidx.appcompat.app.AppCompatActivity", "androidx.appcompat.app.AppCompatActivity");
                            if (a2 != null && a2.isInstance(activity) && (invoke = activity.getClass().getMethod("getSupportActionBar", new Class[0]).invoke(activity, new Object[0])) != null && (charSequence = (CharSequence) invoke.getClass().getMethod("getTitle", new Class[0]).invoke(invoke, new Object[0])) != null) {
                                charSequence2 = charSequence.toString();
                            }
                        } catch (Exception e) {
                        }
                        charSequence2 = null;
                    }
                    if (!TextUtils.isEmpty(charSequence2)) {
                        return charSequence2;
                    }
                }
                try {
                    PackageManager packageManager = ((Activity) obj).getPackageManager();
                    if (packageManager != null) {
                        CharSequence loadLabel = packageManager.getActivityInfo(((Activity) obj).getComponentName(), 0).loadLabel(packageManager);
                        if (!TextUtils.isEmpty(loadLabel)) {
                            return loadLabel.toString();
                        }
                    }
                } catch (Exception e2) {
                    z2.a("Cannot get title from activity label.", e2);
                }
            }
            return obj.getClass().getName();
        }
        return pageMeta.title();
    }

    public static JSONObject c(Object obj) {
        if (obj instanceof IPageMeta) {
            try {
                return ((IPageMeta) obj).pageProperties();
            } catch (Throwable th) {
                z2.a("Cannot get track properties from activity.", th);
                return null;
            }
        }
        return null;
    }

    public static boolean d(Object obj) {
        for (Class<?> cls : d) {
            if (cls.isInstance(obj)) {
                return true;
            }
        }
        return false;
    }
}
