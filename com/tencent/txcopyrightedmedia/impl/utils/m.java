package com.tencent.txcopyrightedmedia.impl.utils;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/m.class */
public class m {
    public final v e;
    public final l f;
    public final h g;
    public b h;
    public o i;
    public ai j;
    private HashMap<String, String> l;
    private static String k = m.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public static String f26418a = "STORAGE_SERVICE";
    public static String b = "THREAD_POOL";

    /* renamed from: c  reason: collision with root package name */
    public static String f26419c = "DATA_BUFFER_SERVER";
    public static String d = "CALLBACK_SERVICE";

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/m$a.class */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final m f26420a = new m((byte) 0);
    }

    private m() {
        ArrayList arrayList = new ArrayList();
        this.f = new l();
        this.g = new h();
        arrayList.add(this.f);
        arrayList.add(this.g);
        v vVar = new v(arrayList);
        this.e = vVar;
        vVar.h();
        this.l = new HashMap<>();
    }

    /* synthetic */ m(byte b2) {
        this();
    }

    public static m a() {
        return a.f26420a;
    }

    public final String a(String str) {
        synchronized (this) {
            if (this.l == null || !this.l.containsKey(str)) {
                return "";
            }
            if (TextUtils.isEmpty(this.l.get(str))) {
                return "";
            }
            return this.l.get(str);
        }
    }

    public final void a(String str, String str2) {
        synchronized (this) {
            if (this.l != null && !TextUtils.isEmpty(str)) {
                this.l.put(str, str2);
            }
        }
    }

    public final Object b(String str) {
        synchronized (m.class) {
            try {
                if (TextUtils.equals(f26418a, str)) {
                    return this.h;
                } else if (TextUtils.equals(b, str)) {
                    return this.i;
                } else if (TextUtils.equals(f26419c, str)) {
                    return this.g;
                } else if (TextUtils.equals(d, str)) {
                    return this.j;
                } else {
                    return null;
                }
            } finally {
            }
        }
    }
}
