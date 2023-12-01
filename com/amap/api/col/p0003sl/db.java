package com.amap.api.col.p0003sl;

import android.content.Context;

/* renamed from: com.amap.api.col.3sl.db  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/db.class */
public final class db {
    static db b;
    Context a;

    private db(Context context) {
        this.a = context;
    }

    public static void a(Context context) {
        b = new db(context);
    }
}
