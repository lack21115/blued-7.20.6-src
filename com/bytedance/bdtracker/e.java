package com.bytedance.bdtracker;

import android.app.Application;
import android.content.SharedPreferences;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/e.class */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f21210a;

    public e(Application applicationContext, String spName) {
        Intrinsics.d(applicationContext, "applicationContext");
        Intrinsics.d(spName, "spName");
        this.f21210a = e2.a(applicationContext, spName, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005b A[Catch: all -> 0x008d, TRY_ENTER, TryCatch #0 {all -> 0x008d, blocks: (B:3:0x000c, B:5:0x0017, B:7:0x0027, B:12:0x004b, B:17:0x005b, B:20:0x0066, B:22:0x006e, B:24:0x0079, B:26:0x0085), top: B:34:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <T extends com.bytedance.bdtracker.l> T a(java.lang.String r6, java.lang.Class<T> r7) {
        /*
            r5 = this;
            r0 = r6
            java.lang.String r1 = "key"
            kotlin.jvm.internal.Intrinsics.d(r0, r1)
            r0 = r7
            java.lang.String r1 = "clazz"
            kotlin.jvm.internal.Intrinsics.d(r0, r1)
            r0 = r5
            android.content.SharedPreferences r0 = r0.f21210a     // Catch: java.lang.Throwable -> L8d
            r11 = r0
            r0 = r11
            if (r0 == 0) goto L8b
            r0 = r11
            r1 = r6
            r2 = 0
            java.lang.String r0 = r0.getString(r1, r2)     // Catch: java.lang.Throwable -> L8d
            r11 = r0
            r0 = r11
            if (r0 == 0) goto L8b
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L8d
            r1 = r0
            r2 = r11
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L8d
            r11 = r0
            r0 = r11
            java.lang.String r1 = "expire_ts"
            long r0 = r0.optLong(r1)     // Catch: java.lang.Throwable -> L8d
            r9 = r0
            r0 = r9
            r1 = -1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L95
            r0 = r9
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L90
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L8d
            r1 = r9
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L90
            goto L95
        L57:
            r0 = r8
            if (r0 == 0) goto L65
            com.bytedance.bdtracker.l$a r0 = com.bytedance.bdtracker.l.f21245a     // Catch: java.lang.Throwable -> L8d
            r1 = r11
            r2 = r7
            com.bytedance.bdtracker.l r0 = r0.a(r1, r2)     // Catch: java.lang.Throwable -> L8d
            return r0
        L65:
            r0 = r5
            android.content.SharedPreferences r0 = r0.f21210a     // Catch: java.lang.Throwable -> L8d
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L8b
            r0 = r7
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch: java.lang.Throwable -> L8d
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L8b
            r0 = r7
            r1 = r6
            android.content.SharedPreferences$Editor r0 = r0.remove(r1)     // Catch: java.lang.Throwable -> L8d
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L8b
            r0 = r6
            r0.apply()     // Catch: java.lang.Throwable -> L8d
        L8b:
            r0 = 0
            return r0
        L8d:
            r6 = move-exception
            r0 = 0
            return r0
        L90:
            r0 = 0
            r8 = r0
            goto L57
        L95:
            r0 = 1
            r8 = r0
            goto L57
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.e.a(java.lang.String, java.lang.Class):com.bytedance.bdtracker.l");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0051 A[Catch: all -> 0x0087, TRY_ENTER, TryCatch #0 {all -> 0x0087, blocks: (B:3:0x0006, B:5:0x0011, B:7:0x0021, B:12:0x0042, B:17:0x0051, B:20:0x005a, B:22:0x0064, B:24:0x0072, B:26:0x007f), top: B:34:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String a(java.lang.String r6) {
        /*
            r5 = this;
            r0 = r6
            java.lang.String r1 = "key"
            kotlin.jvm.internal.Intrinsics.d(r0, r1)
            r0 = r5
            android.content.SharedPreferences r0 = r0.f21210a     // Catch: java.lang.Throwable -> L87
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L85
            r0 = r10
            r1 = r6
            r2 = 0
            java.lang.String r0 = r0.getString(r1, r2)     // Catch: java.lang.Throwable -> L87
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L85
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L87
            r1 = r0
            r2 = r10
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L87
            r10 = r0
            r0 = r10
            java.lang.String r1 = "expire_ts"
            long r0 = r0.optLong(r1)     // Catch: java.lang.Throwable -> L87
            r8 = r0
            r0 = r8
            r1 = -1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L8f
            r0 = r8
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L8a
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L87
            r1 = r8
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L8a
            goto L8f
        L4d:
            r0 = r7
            if (r0 == 0) goto L59
            r0 = r10
            java.lang.String r1 = "data"
            java.lang.String r0 = r0.optString(r1)     // Catch: java.lang.Throwable -> L87
            return r0
        L59:
            r0 = r5
            android.content.SharedPreferences r0 = r0.f21210a     // Catch: java.lang.Throwable -> L87
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L85
            r0 = r10
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch: java.lang.Throwable -> L87
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L85
            r0 = r10
            r1 = r6
            android.content.SharedPreferences$Editor r0 = r0.remove(r1)     // Catch: java.lang.Throwable -> L87
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L85
            r0 = r6
            r0.apply()     // Catch: java.lang.Throwable -> L87
        L85:
            r0 = 0
            return r0
        L87:
            r6 = move-exception
            r0 = 0
            return r0
        L8a:
            r0 = 0
            r7 = r0
            goto L4d
        L8f:
            r0 = 1
            r7 = r0
            goto L4d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.e.a(java.lang.String):java.lang.String");
    }

    public final void a(String key, l data, long j) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putString;
        Intrinsics.d(key, "key");
        Intrinsics.d(data, "data");
        JSONObject a2 = data.a();
        a2.put("expire_ts", j == -1 ? -1L : System.currentTimeMillis() + j);
        SharedPreferences sharedPreferences = this.f21210a;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null || (putString = edit.putString(key, a2.toString())) == null) {
            return;
        }
        putString.apply();
    }

    public final void a(String key, String str, long j) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putString;
        Intrinsics.d(key, "key");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", str);
        jSONObject.put("expire_ts", j == -1 ? -1L : System.currentTimeMillis() + j);
        SharedPreferences sharedPreferences = this.f21210a;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null || (putString = edit.putString(key, jSONObject.toString())) == null) {
            return;
        }
        putString.apply();
    }
}
