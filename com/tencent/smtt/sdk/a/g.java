package com.tencent.smtt.sdk.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/a/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static g f38835a;
    private static f b;

    private g() {
    }

    public static g a() {
        g gVar;
        synchronized (g.class) {
            try {
                if (f38835a == null) {
                    f38835a = new g();
                }
                gVar = f38835a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }

    public static String a(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        if (strArr != null && strArr.length > 0) {
            if (strArr.length > 1) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= strArr.length - 1) {
                        break;
                    }
                    sb.append(strArr[i2]);
                    sb.append(",");
                    i = i2 + 1;
                }
            }
            sb.append(strArr[strArr.length - 1]);
        }
        return sb.toString();
    }

    public static String[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split(",");
    }

    private SharedPreferences b(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (this) {
            sharedPreferences = context.getSharedPreferences("tbs_emergence", 4);
        }
        return sharedPreferences;
    }

    public List<String> a(Context context, String str) {
        String string = b(context).getString(str, "");
        ArrayList arrayList = new ArrayList();
        String[] split = string.split(";");
        if (split.length > 0) {
            arrayList.addAll(Arrays.asList(split));
        }
        return arrayList;
    }

    public void a(Context context) {
        b = f.a(new File(context.getFilesDir(), "prefs.lock"));
    }

    public void a(Context context, String str, long j) {
        SharedPreferences.Editor edit = b(context).edit();
        edit.putLong(str, j);
        edit.apply();
        edit.commit();
    }

    public void a(Context context, String str, String str2) {
        List<String> a2 = a(context, str);
        a2.add(str2);
        a(context, str, a2);
    }

    public void a(Context context, String str, List<String> list) {
        SharedPreferences.Editor edit = b(context).edit();
        StringBuilder sb = new StringBuilder();
        if (list != null && !list.isEmpty()) {
            if (list.size() > 1) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list.size() - 1) {
                        break;
                    }
                    sb.append(list.get(i2));
                    sb.append(";");
                    i = i2 + 1;
                }
            }
            sb.append(list.get(list.size() - 1));
        }
        edit.putString(str, sb.toString());
        edit.apply();
        edit.commit();
    }

    public long b(Context context, String str) {
        return b(context).getLong(str, -1L);
    }

    public boolean b() {
        return b != null;
    }

    public void c() {
        f fVar = b;
        if (fVar != null) {
            fVar.b();
            b = null;
        }
    }
}
