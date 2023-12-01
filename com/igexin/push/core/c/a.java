package com.igexin.push.core.c;

import android.content.ContentValues;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.igexin.assist.util.AssistUtils;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.b;
import com.igexin.push.core.b.t;
import com.igexin.push.core.d;
import com.igexin.push.core.e;
import com.igexin.push.core.e.f;
import com.igexin.push.f.c;
import com.igexin.push.f.n;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/c/a.class */
public final class a implements com.igexin.push.core.e.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9859a = "BIDataManager";
    private static a b;

    public static a a() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x012a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 413
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.c.a.a(java.lang.String):void");
    }

    private static void a(ArrayList<String> arrayList) {
        d.a.f9866a.i.a(b.ab, new String[]{"id"}, (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    private static long b(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", (Integer) 10);
        contentValues.put("data", str);
        contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
        return d.a.f9866a.i.a(b.ab, contentValues);
    }

    public static void b() {
        StringBuilder sb;
        String sb2;
        if (c.e()) {
            if (com.igexin.push.config.d.V) {
                long currentTimeMillis = System.currentTimeMillis();
                if ((currentTimeMillis - e.ay) - (com.igexin.push.config.d.W * 1000) >= 0) {
                    try {
                        String[] b2 = com.igexin.assist.sdk.a.a().b();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()));
                        sb3.append("|");
                        sb3.append(e.A);
                        sb3.append("|");
                        sb3.append(e.f9887a);
                        sb3.append("|");
                        sb3.append(e.C);
                        sb3.append("|");
                        sb3.append(com.igexin.push.config.d.T ? n.r() : "");
                        sb3.append("|");
                        sb3.append(n.d());
                        sb3.append("|");
                        sb3.append(AssistUtils.getDeviceBrand().toLowerCase());
                        sb3.append("|");
                        sb3.append(b2[0]);
                        sb3.append("|");
                        sb3.append(b2[1]);
                        sb3.append("|");
                        sb3.append(n.o());
                        sb3.append("|");
                        sb3.append(n.p());
                        f.a().e(currentTimeMillis);
                        com.igexin.c.a.c.a.b("UploadBITask", "upload type144 data = " + sb3.toString());
                        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.e.a.a(new com.igexin.push.core.h.e(SDKUrlConfig.getBiUploadServiceUrl(), sb3.toString().getBytes(), 144)), false, true);
                        return;
                    } catch (Throwable th) {
                        com.igexin.c.a.c.a.a(th);
                        return;
                    }
                }
                sb = new StringBuilder("type144 in Interval = ");
                sb.append(com.igexin.push.config.d.W);
            } else {
                sb = new StringBuilder(" isUpload type144 Enable ");
                sb.append(com.igexin.push.config.d.V);
            }
            sb2 = sb.toString();
        } else {
            sb2 = " upload type144 network false";
        }
        com.igexin.c.a.c.a.b(f9859a, sb2);
    }

    private static void b(ArrayList<String> arrayList) {
        d.a.f9866a.i.a(b.ab, new String[]{"rowid"}, (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0077, code lost:
        if (r9 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<com.igexin.push.core.b.c> c() {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = r0
            r1.<init>()
            r11 = r0
            r0 = 0
            r9 = r0
            com.igexin.push.core.d r0 = com.igexin.push.core.d.a.a()     // Catch: java.lang.Throwable -> L71
            com.igexin.push.a.b r0 = r0.i     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = "bidata"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L71
            r3 = r2
            r4 = 0
            java.lang.String r5 = "type"
            r3[r4] = r5     // Catch: java.lang.Throwable -> L71
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L71
            r4 = r3
            r5 = 0
            java.lang.String r6 = "10"
            r4[r5] = r6     // Catch: java.lang.Throwable -> L71
            r4 = 0
            java.lang.String r5 = ""
            android.database.Cursor r0 = r0.a(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L71
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L68
        L30:
            r0 = r10
            r9 = r0
            r0 = r10
            boolean r0 = r0.moveToNext()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L68
            r0 = r10
            r9 = r0
            r0 = r11
            com.igexin.push.core.b.c r1 = new com.igexin.push.core.b.c     // Catch: java.lang.Throwable -> L71
            r2 = r1
            r3 = r10
            r4 = 0
            int r3 = r3.getInt(r4)     // Catch: java.lang.Throwable -> L71
            r4 = r10
            r5 = 1
            java.lang.String r4 = r4.getString(r5)     // Catch: java.lang.Throwable -> L71
            r5 = r10
            r6 = 2
            int r5 = r5.getInt(r6)     // Catch: java.lang.Throwable -> L71
            r6 = r10
            r7 = 3
            long r6 = r6.getLong(r7)     // Catch: java.lang.Throwable -> L71
            r2.<init>(r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.add(r1)     // Catch: java.lang.Throwable -> L71
            goto L30
        L68:
            r0 = r10
            if (r0 == 0) goto L80
            r0 = r10
            r9 = r0
            goto L7a
        L71:
            r10 = move-exception
            r0 = r10
            com.igexin.c.a.c.a.a(r0)     // Catch: java.lang.Throwable -> L82
            r0 = r9
            if (r0 == 0) goto L80
        L7a:
            r0 = r9
            r0.close()
        L80:
            r0 = r11
            return r0
        L82:
            r10 = move-exception
            r0 = r9
            if (r0 == 0) goto L8d
            r0 = r9
            r0.close()
        L8d:
            r0 = r10
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.c.a.c():java.util.List");
    }

    private void d() {
        ArrayList arrayList = new ArrayList();
        a((List<t>) arrayList);
        if (arrayList.isEmpty()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", "reportapplist");
            jSONObject.put("session_last", e.z);
            JSONArray jSONArray = new JSONArray();
            int size = arrayList.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("appid", arrayList.get(i2).f9854c);
                jSONObject2.put("name", arrayList.get(i2).f9853a);
                jSONObject2.put("version", arrayList.get(i2).b);
                jSONObject2.put("versionName", arrayList.get(i2).d);
                jSONArray.put(jSONObject2);
                i = i2 + 1;
            }
            jSONObject.put("applist", jSONArray);
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.e.a.a(new com.igexin.push.core.h.a(SDKUrlConfig.getBiUploadServiceUrl(), jSONObject.toString().getBytes())), false, true);
        com.igexin.c.a.c.a.a("reportAL", new Object[0]);
    }

    private static void e() {
        Cursor cursor = null;
        try {
            Cursor a2 = d.a.f9866a.i.a(b.ab, null, null, new String[]{"COUNT(*)"}, null);
            if (a2 == null) {
                if (a2 != null) {
                    a2.close();
                    return;
                }
                return;
            }
            a2.moveToNext();
            long j = a2.getLong(0);
            a2.close();
            long j2 = j - 200;
            if (j2 > 0) {
                com.igexin.push.a.b bVar = d.a.f9866a.i;
                StringBuilder sb = new StringBuilder("id IN(SELECT id FROM bidata ORDER BY time ASC LIMIT ");
                sb.append(j2);
                sb.append(")");
                bVar.a(b.ab, sb.toString());
                StringBuilder sb2 = new StringBuilder("delete bidata ");
                sb2.append(j2);
                sb2.append(" old expired data");
                cursor = a2;
                com.igexin.c.a.c.a.b(f9859a, sb2.toString());
            }
            if (a2 != null) {
                a2.close();
            }
        } catch (Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th2) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th2;
            }
        }
    }

    @Override // com.igexin.push.core.e.a
    public final void a(SQLiteDatabase sQLiteDatabase) {
    }

    public final void a(List<t> list) {
        Comparator<t> comparator = new Comparator<t>() { // from class: com.igexin.push.core.c.a.1
            private static int a(t tVar, t tVar2) {
                if (tVar.f9854c.equals(tVar2.f9854c)) {
                    return 0;
                }
                return tVar.f9854c.compareTo(tVar2.f9854c);
            }

            @Override // java.util.Comparator
            public final /* synthetic */ int compare(t tVar, t tVar2) {
                t tVar3 = tVar;
                t tVar4 = tVar2;
                if (tVar3.f9854c.equals(tVar4.f9854c)) {
                    return 0;
                }
                return tVar3.f9854c.compareTo(tVar4.f9854c);
            }
        };
        PackageManager packageManager = e.l.getPackageManager();
        List<PackageInfo> a2 = n.a();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= a2.size()) {
                Collections.sort(list, comparator);
                return;
            }
            try {
                PackageInfo packageInfo = a2.get(i2);
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if ((applicationInfo.flags & 1) <= 0) {
                    t tVar = new t();
                    tVar.f9853a = applicationInfo.loadLabel(packageManager).toString();
                    tVar.f9854c = applicationInfo.packageName;
                    tVar.b = String.valueOf(packageInfo.versionCode);
                    tVar.d = packageInfo.versionName;
                    list.add(tVar);
                }
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
            i = i2 + 1;
        }
    }

    @Override // com.igexin.push.core.e.a
    public final void b(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // com.igexin.push.core.e.a
    public final void c(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            Cursor a2 = d.a.f9866a.i.a(b.ab, null, null, new String[]{"COUNT(*)"}, null);
            if (a2 == null) {
                if (a2 != null) {
                    a2.close();
                    return;
                }
                return;
            }
            a2.moveToNext();
            long j = a2.getLong(0);
            a2.close();
            long j2 = j - 200;
            if (j2 > 0) {
                com.igexin.push.a.b bVar = d.a.f9866a.i;
                StringBuilder sb = new StringBuilder("id IN(SELECT id FROM bidata ORDER BY time ASC LIMIT ");
                sb.append(j2);
                sb.append(")");
                bVar.a(b.ab, sb.toString());
                StringBuilder sb2 = new StringBuilder("delete bidata ");
                sb2.append(j2);
                sb2.append(" old expired data");
                cursor = a2;
                com.igexin.c.a.c.a.b(f9859a, sb2.toString());
            }
            if (a2 != null) {
                a2.close();
            }
        } catch (Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th2) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th2;
            }
        }
    }
}
