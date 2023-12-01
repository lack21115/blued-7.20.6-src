package com.umeng.commonsdk.config;

import android.content.Context;
import android.util.Pair;
import com.umeng.commonsdk.config.d;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/config/FieldManager.class */
public class FieldManager {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40839a = "cfgfd";
    private static b b = b.b();

    /* renamed from: c  reason: collision with root package name */
    private static boolean f40840c = false;
    private static Object d = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/config/FieldManager$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final FieldManager f40841a = new FieldManager();

        private a() {
        }
    }

    private FieldManager() {
    }

    private static Pair<Long, String> a(String str) {
        Pair<Long, String> pair = new Pair<>(-1L, null);
        if (str != null && str.length() >= 2) {
            String[] split = str.split("@");
            if (split.length < 2) {
                return pair;
            }
            try {
                return new Pair<>(Long.valueOf(Long.parseLong(split[0])), split[1]);
            } catch (Throwable th) {
                return pair;
            }
        }
        return pair;
    }

    public static FieldManager a() {
        return a.f40841a;
    }

    public static boolean allow(String str) {
        synchronized (d) {
            if (f40840c) {
                return b.a(str);
            }
            return false;
        }
    }

    public static boolean b() {
        boolean z;
        synchronized (d) {
            z = f40840c;
        }
        return z;
    }

    public void a(Context context) {
        String name = d.a.class.getName();
        String name2 = d.b.class.getName();
        String name3 = d.c.class.getName();
        String name4 = d.EnumC1080d.class.getName();
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "cfgfd", "1001@3749699455,2130669566,262139,1983");
        synchronized (d) {
            Pair<Long, String> a2 = a(imprintProperty);
            String str = "1001@3749699455,2130669566,262139,1983";
            if (a2.first.longValue() > 1000) {
                String str2 = a2.second;
                str = "1001@3749699455,2130669566,262139,1983";
                if (str2 != null) {
                    str = "1001@3749699455,2130669566,262139,1983";
                    if (str2.length() > 0) {
                        str = str2;
                    }
                }
            }
            String[] split = str.split(",");
            int length = split.length;
            if (length > 0) {
                ArrayList arrayList = new ArrayList();
                g gVar = new g();
                for (int i = 0; i < length; i++) {
                    arrayList.add(gVar);
                    ((e) arrayList.get(i)).a(split[i], b, d.b(new String[]{name, name2, name3, name4}[i]));
                }
            }
            f40840c = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x005a, code lost:
        if (r9.length() > 0) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.content.Context r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.config.FieldManager.a(android.content.Context, java.lang.String):void");
    }
}
