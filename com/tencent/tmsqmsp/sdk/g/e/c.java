package com.tencent.tmsqmsp.sdk.g.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/g/e/c.class */
public class c {
    public static volatile c g;
    public Boolean e;
    public BroadcastReceiver f;

    /* renamed from: a  reason: collision with root package name */
    public b f26093a = new b("udid");
    public b b = new b("oaid");
    public b d = new b("vaid");

    /* renamed from: c  reason: collision with root package name */
    public b f26094c = new b("aaid");

    public static final c a() {
        if (g == null) {
            synchronized (c.class) {
                try {
                    g = new c();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return g;
    }

    public static e a(Cursor cursor) {
        String str;
        e eVar = new e(null, 0);
        if (cursor == null) {
            str = "parseValue fail, cursor is null.";
        } else if (cursor.isClosed()) {
            str = "parseValue fail, cursor is closed.";
        } else {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex("value");
            if (columnIndex >= 0) {
                eVar.f26096c = cursor.getString(columnIndex);
            } else {
                b("parseValue fail, index < 0.");
            }
            int columnIndex2 = cursor.getColumnIndex("code");
            if (columnIndex2 >= 0) {
                eVar.f26095a = cursor.getInt(columnIndex2);
            } else {
                b("parseCode fail, index < 0.");
            }
            int columnIndex3 = cursor.getColumnIndex("expired");
            if (columnIndex3 >= 0) {
                eVar.b = cursor.getLong(columnIndex3);
                return eVar;
            }
            str = "parseExpired fail, index < 0.";
        }
        b(str);
        return eVar;
    }

    public static void b(String str) {
        com.tencent.tmsqmsp.sdk.base.c.a("MzOpenIdManager " + str);
    }

    public b a(String str) {
        if ("oaid".equals(str)) {
            return this.b;
        }
        if ("vaid".equals(str)) {
            return this.d;
        }
        if ("aaid".equals(str)) {
            return this.f26094c;
        }
        if ("udid".equals(str)) {
            return this.f26093a;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0172, code lost:
        if (r14 == null) goto L52;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String a(android.content.Context r10, com.tencent.tmsqmsp.sdk.g.e.b r11) {
        /*
            Method dump skipped, instructions count: 405
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmsqmsp.sdk.g.e.c.a(android.content.Context, com.tencent.tmsqmsp.sdk.g.e.b):java.lang.String");
    }

    public final void a(Context context) {
        synchronized (this) {
            if (this.f == null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
                a aVar = new a();
                this.f = aVar;
                context.registerReceiver(aVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
        if (r0.resolveContentProvider("com.meizu.flyme.openidsdk", 0) == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(android.content.Context r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmsqmsp.sdk.g.e.c.a(android.content.Context, boolean):boolean");
    }
}
