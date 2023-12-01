package com.bytedance.bdtracker;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.LruCache;
import android.util.SparseArray;
import android.view.Display;
import android.view.View;
import android.widget.AbsSeekBar;
import android.widget.AdapterView;
import com.bytedance.applog.R;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/c3.class */
public class c3 {

    /* renamed from: a  reason: collision with root package name */
    public static SparseArray<String> f7597a;
    public static Set<Integer> b;

    /* renamed from: c  reason: collision with root package name */
    public static LruCache<Class, String> f7598c = new LruCache<>(100);

    public static int a(View view) {
        if (view == null) {
            return 0;
        }
        int i = 0;
        if (Build.VERSION.SDK_INT >= 17) {
            Display display = view.getDisplay();
            i = 0;
            if (display != null) {
                i = display.getDisplayId();
            }
        }
        return i;
    }

    public static String a(View view, boolean z) {
        Object tag = view.getTag(84159242);
        if (tag == null || !(tag instanceof String)) {
            if (z) {
                return null;
            }
            if (f7597a == null) {
                f7597a = new SparseArray<>();
            }
            if (b == null) {
                b = new HashSet();
            }
            int id = view.getId();
            if (id <= 2130706432 || b.contains(Integer.valueOf(id))) {
                return null;
            }
            String str = f7597a.get(id);
            if (str != null) {
                return str;
            }
            try {
                String resourceEntryName = view.getResources().getResourceEntryName(id);
                f7597a.put(id, resourceEntryName);
                return resourceEntryName;
            } catch (Exception e) {
                b.add(Integer.valueOf(id));
                return null;
            }
        }
        return (String) tag;
    }

    public static String a(Class cls) {
        String str = f7598c.get(cls);
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            String simpleName = cls.getSimpleName();
            String str3 = simpleName;
            if (TextUtils.isEmpty(simpleName)) {
                str3 = "Anonymous";
            }
            f7598c.put(cls, str3);
            str2 = str3;
            if (!k2.j) {
                str2 = str3;
                if (!k2.e) {
                    str2 = str3;
                    if (!k2.f7636a) {
                        str2 = str3;
                        if (str3.contains("RecyclerView")) {
                            str2 = str3;
                            try {
                                if (k2.a((Class<?>) cls) != null) {
                                    str2 = str3;
                                    if (k2.f7637c != null) {
                                        k2.b = cls;
                                        k2.f7636a = true;
                                        return str3;
                                    }
                                }
                            } catch (Exception e) {
                                z2.c("U SHALL NOT PASS!", e);
                                str2 = str3;
                            }
                        }
                    }
                }
            }
        }
        return str2;
    }

    public static String a(String str) {
        if (str == null) {
            return "";
        }
        String str2 = str;
        if (!TextUtils.isEmpty(str)) {
            str2 = str;
            if (str.length() > 20) {
                str2 = str.substring(0, 20);
            }
        }
        return str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b0, code lost:
        if (r0 == 145) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0156, code lost:
        if (r10.getText() != null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01c7, code lost:
        if (r10.getText() != null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01ca, code lost:
        r11 = r10.getText();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<java.lang.String> a(android.view.View r4, java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 670
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.c3.a(android.view.View, java.lang.String):java.util.ArrayList");
    }

    public static boolean a(Context context, int i) {
        boolean z = true;
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                if (((DisplayManager) context.getSystemService("display")).getDisplays()[0].getDisplayId() == i) {
                    return true;
                }
                z = false;
            }
            return z;
        } catch (Exception e) {
            return true;
        }
    }

    public static boolean b(View view) {
        return view == null || view.getTag(R.id.applog_tag_ignore) != null;
    }

    public static boolean c(View view) {
        boolean z = false;
        boolean z2 = view.isClickable() || (view instanceof AbsSeekBar);
        boolean z3 = z2;
        if (view.getParent() instanceof AdapterView) {
            AdapterView adapterView = (AdapterView) view.getParent();
            if (adapterView.isClickable() || adapterView.getOnItemClickListener() != null || adapterView.getOnItemSelectedListener() != null) {
                z = true;
            }
            z3 = z2 | z;
        }
        return z3;
    }
}
