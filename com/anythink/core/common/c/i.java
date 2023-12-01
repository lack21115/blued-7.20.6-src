package com.anythink.core.common.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.anythink.core.common.e.w;
import java.util.List;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/c/i.class */
public class i extends com.anythink.core.common.c.a<i> {
    private static final String b = i.class.getName();
    private static i c;

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/c/i$a.class */
    public static final class a {
        public List<w> a;
        public Map<String, w> b;
    }

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/c/i$b.class */
    public static final class b {
        public static final String a = "notice_url_fail_info";
        public static final String b = "id";
        public static final String c = "req_type";
        public static final String d = "req_url";
        public static final String e = "req_head";
        public static final String f = "first_fail_time";
        public static final String g = "offer_out_date_time";
        public static final String h = "retry_count";
        public static final String i = "CREATE TABLE IF NOT EXISTS notice_url_fail_info(id TEXT, req_type INTEGER, req_url TEXT, req_head TEXT, first_fail_time INTEGER, offer_out_date_time INTEGER, retry_count INTEGER )";
    }

    private i(com.anythink.core.common.c.b bVar) {
        super(bVar);
    }

    public static i a(com.anythink.core.common.c.b bVar) {
        if (c == null) {
            synchronized (i.class) {
                try {
                    if (c == null) {
                        c = new i(bVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return c;
    }

    private boolean a(String str) {
        Cursor query = a().query(b.a, new String[]{"id"}, "id=?", new String[]{str}, "id", null, null);
        if (query != null && query.getCount() > 0) {
            query.close();
            return true;
        } else if (query != null) {
            query.close();
            return false;
        } else {
            return false;
        }
    }

    private void d() {
        synchronized (this) {
            try {
                if (b() == null) {
                    return;
                }
                b().delete(b.a, null, null);
            } catch (Exception e) {
            }
        }
    }

    public final long a(w wVar) {
        boolean z;
        synchronized (this) {
            if (b() == null || wVar == null) {
                return -1L;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", wVar.a);
                contentValues.put("req_type", Integer.valueOf(wVar.b));
                contentValues.put("req_url", wVar.d);
                contentValues.put("req_head", wVar.c);
                contentValues.put(b.f, Long.valueOf(wVar.e));
                contentValues.put(b.g, Long.valueOf(wVar.f));
                contentValues.put(b.h, Integer.valueOf(wVar.g));
                Cursor query = a().query(b.a, new String[]{"id"}, "id=?", new String[]{wVar.a}, "id", null, null);
                if (query == null || query.getCount() <= 0) {
                    if (query != null) {
                        query.close();
                    }
                    z = false;
                } else {
                    query.close();
                    z = true;
                }
                if (z) {
                    return b().update(b.a, contentValues, "id = ? ", new String[]{wVar.a});
                }
                return b().insert(b.a, null, contentValues);
            } catch (Exception e) {
                return -1L;
            }
        }
    }

    public final int b(w wVar) {
        synchronized (this) {
            if (b() == null || wVar == null) {
                return -1;
            }
            try {
                return b().delete(b.a, "id=?", new String[]{wVar.a});
            } catch (Throwable th) {
                return -1;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x0228, code lost:
        if (r10 != null) goto L83;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.anythink.core.common.c.i.a c() {
        /*
            Method dump skipped, instructions count: 631
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.c.i.c():com.anythink.core.common.c.i$a");
    }
}
