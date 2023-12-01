package com.tencent.qmsp.oaid2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/oaid2/x.class */
public class x {
    public static volatile x g;
    public Boolean e;
    public BroadcastReceiver f;

    /* renamed from: a  reason: collision with root package name */
    public w f24818a = new w("udid");
    public w b = new w("oaid");
    public w d = new w("vaid");

    /* renamed from: c  reason: collision with root package name */
    public w f24819c = new w("aaid");

    public static final x a() {
        if (g == null) {
            synchronized (x.class) {
                try {
                    g = new x();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return g;
    }

    public static z a(Cursor cursor) {
        z zVar = new z(null, 0);
        if (cursor == null) {
            b("parseValue fail, cursor is null.");
            return zVar;
        } else if (cursor.isClosed()) {
            b("parseValue fail, cursor is closed.");
            return zVar;
        } else {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex("value");
            if (columnIndex >= 0) {
                zVar.f24821c = cursor.getString(columnIndex);
            } else {
                b("parseValue fail, index < 0.");
            }
            int columnIndex2 = cursor.getColumnIndex("code");
            if (columnIndex2 >= 0) {
                zVar.f24820a = cursor.getInt(columnIndex2);
            } else {
                b("parseCode fail, index < 0.");
            }
            int columnIndex3 = cursor.getColumnIndex("expired");
            if (columnIndex3 >= 0) {
                zVar.b = cursor.getLong(columnIndex3);
                return zVar;
            }
            b("parseExpired fail, index < 0.");
            return zVar;
        }
    }

    public static void b(String str) {
        c.a("MzOpenIdManager " + str);
    }

    public w a(String str) {
        if ("oaid".equals(str)) {
            return this.b;
        }
        if ("vaid".equals(str)) {
            return this.d;
        }
        if ("aaid".equals(str)) {
            return this.f24819c;
        }
        if ("udid".equals(str)) {
            return this.f24818a;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0161, code lost:
        if (r14 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0194, code lost:
        if (r14 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0197, code lost:
        r14.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x019f, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String a(android.content.Context r10, com.tencent.qmsp.oaid2.w r11) {
        /*
            Method dump skipped, instructions count: 439
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qmsp.oaid2.x.a(android.content.Context, com.tencent.qmsp.oaid2.w):java.lang.String");
    }

    public final void a(Context context) {
        synchronized (this) {
            if (this.f == null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
                v vVar = new v();
                this.f = vVar;
                context.registerReceiver(vVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
        if (r0.resolveContentProvider("com.meizu.flyme.openidsdk", 0) == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(android.content.Context r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qmsp.oaid2.x.a(android.content.Context, boolean):boolean");
    }
}
