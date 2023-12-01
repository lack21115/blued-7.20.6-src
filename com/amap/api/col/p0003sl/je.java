package com.amap.api.col.p0003sl;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.amap.api.col.3sl.je  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/je.class */
public final class je {
    private ia a;
    private volatile int b = -1;

    /* renamed from: com.amap.api.col.3sl.je$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/je$a.class */
    static final class a {
        public static Map<String, je> a = new HashMap();
    }

    private je(ia iaVar) {
        this.a = iaVar;
    }

    public static je a(ia iaVar) {
        if (a.a.get(iaVar.a()) == null) {
            a.a.put(iaVar.a(), new je(iaVar));
        }
        return a.a.get(iaVar.a());
    }

    public final void a(Context context, boolean z, boolean z2) {
        ji.a(context, this.a, "sckey", String.valueOf(z));
        if (z) {
            ji.a(context, this.a, "scisf", String.valueOf(z2));
        }
    }

    public final boolean a(Context context) {
        try {
            return Boolean.parseBoolean(ji.a(context, this.a, "sckey"));
        } catch (Throwable th) {
            return false;
        }
    }

    public final boolean b(Context context) {
        try {
            return Boolean.parseBoolean(ji.a(context, this.a, "scisf"));
        } catch (Throwable th) {
            return true;
        }
    }
}
