package com.autonavi.aps.amapapi.storage;

import android.content.ContentResolver;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.ht;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.restruct.d;
import com.autonavi.aps.amapapi.utils.i;
import com.baidu.mobads.sdk.internal.bj;
import java.util.ArrayList;
import java.util.Hashtable;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/storage/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    Hashtable<String, ArrayList<C0191a>> f9261a = new Hashtable<>();
    private long i = 0;
    private boolean j = false;
    private String k = "2.0.201501131131".replace(".", "");
    private String l = null;
    boolean b = true;

    /* renamed from: c  reason: collision with root package name */
    long f9262c = 0;
    String d = null;
    d e = null;
    private String m = null;
    private long n = 0;
    boolean f = true;
    boolean g = true;
    String h = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.autonavi.aps.amapapi.storage.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/storage/a$a.class */
    public static final class C0191a {

        /* renamed from: a  reason: collision with root package name */
        private com.autonavi.aps.amapapi.model.a f9263a = null;
        private String b = null;

        protected C0191a() {
        }

        public final com.autonavi.aps.amapapi.model.a a() {
            return this.f9263a;
        }

        public final void a(com.autonavi.aps.amapapi.model.a aVar) {
            this.f9263a = aVar;
        }

        public final void a(String str) {
            if (TextUtils.isEmpty(str)) {
                this.b = null;
            } else {
                this.b = str.replace("##", "#");
            }
        }

        public final String b() {
            return this.b;
        }
    }

    private com.autonavi.aps.amapapi.model.a a(String str, StringBuilder sb, boolean z) {
        C0191a a2;
        try {
            if (!str.contains("cgiwifi") && !str.contains("wifi")) {
                a2 = (str.contains("cgi") && this.f9261a.containsKey(str) && this.f9261a.get(str).size() > 0) ? this.f9261a.get(str).get(0) : null;
                if (a2 == null && i.a(a2.a())) {
                    com.autonavi.aps.amapapi.model.a a3 = a2.a();
                    a3.e("mem");
                    a3.h(a2.b());
                    if (!z && !com.autonavi.aps.amapapi.utils.a.a(a3.getTime())) {
                        if (this.f9261a == null || !this.f9261a.containsKey(str)) {
                            return null;
                        }
                        this.f9261a.get(str).remove(a2);
                        return null;
                    }
                    if (i.a(a3)) {
                        this.f9262c = 0L;
                    }
                    a3.setLocationType(4);
                    return a3;
                }
            }
            a2 = a(sb, str);
            return a2 == null ? null : null;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Cache", "get1");
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x01c9, code lost:
        r8 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.autonavi.aps.amapapi.storage.a.C0191a a(java.lang.StringBuilder r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 492
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.storage.a.a(java.lang.StringBuilder, java.lang.String):com.autonavi.aps.amapapi.storage.a$a");
    }

    private String a(String str, StringBuilder sb, Context context) {
        if (context == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            this.l = i.l(context);
            String str2 = str;
            if (str.contains("&")) {
                str2 = str.substring(0, str.indexOf("&"));
            }
            String substring = str2.substring(str2.lastIndexOf("#") + 1);
            if (substring.equals("cgi")) {
                jSONObject.put("cgi", str2.substring(0, str2.length() - 12));
            } else if (!TextUtils.isEmpty(sb) && sb.indexOf(",access") != -1) {
                jSONObject.put("cgi", str2.substring(0, str2.length() - (substring.length() + 9)));
                String[] split = sb.toString().split(",access");
                jSONObject.put("mmac", split[0].contains("#") ? split[0].substring(split[0].lastIndexOf("#") + 1) : split[0]);
            }
            return ht.b(com.autonavi.aps.amapapi.security.a.a(jSONObject.toString().getBytes("UTF-8"), this.l));
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:197:0x0542 A[LOOP:0: B:49:0x0186->B:197:0x0542, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:218:0x059d  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0523 A[EDGE_INSN: B:250:0x0523->B:195:0x0523 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.content.Context r11, java.lang.String r12, boolean r13) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 1496
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.storage.a.a(android.content.Context, java.lang.String, boolean):void");
    }

    private void a(String str, AMapLocation aMapLocation, StringBuilder sb, Context context) throws Exception {
        if (context == null) {
            return;
        }
        if (this.l == null) {
            this.l = i.l(context);
        }
        String a2 = a(str, sb, context);
        StringBuilder sb2 = new StringBuilder();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase openOrCreateDatabase = context.openOrCreateDatabase("hmdb", 0, null);
            sb2.append("CREATE TABLE IF NOT EXISTS hist");
            sb2.append(this.k);
            sb2.append(" (feature VARCHAR PRIMARY KEY, nb VARCHAR, loc VARCHAR, time VARCHAR);");
            openOrCreateDatabase.execSQL(sb2.toString());
            sb2.delete(0, sb2.length());
            sb2.append("REPLACE INTO ");
            sb2.append("hist");
            sb2.append(this.k);
            sb2.append(" VALUES (?, ?, ?, ?)");
            Object[] objArr = new Object[4];
            objArr[0] = a2;
            objArr[1] = com.autonavi.aps.amapapi.security.a.a(sb.toString().getBytes("UTF-8"), this.l);
            objArr[2] = com.autonavi.aps.amapapi.security.a.a(aMapLocation.toStr().getBytes("UTF-8"), this.l);
            objArr[3] = Long.valueOf(aMapLocation.getTime());
            for (int i = 1; i < 3; i++) {
                objArr[i] = ht.b((byte[]) objArr[i]);
            }
            openOrCreateDatabase.execSQL(sb2.toString(), objArr);
            sQLiteDatabase = openOrCreateDatabase;
            sb2.delete(0, sb2.length());
            sb2.delete(0, sb2.length());
            if (openOrCreateDatabase == null || !openOrCreateDatabase.isOpen()) {
                return;
            }
            openOrCreateDatabase.close();
        } catch (Throwable th) {
            try {
                com.autonavi.aps.amapapi.utils.b.a(th, "DB", "updateHist");
            } finally {
                sb2.delete(0, sb2.length());
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
            }
        }
    }

    private static void a(String str, Hashtable<String, String> hashtable) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        hashtable.clear();
        String[] split = str.split("#");
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            String str2 = split[i2];
            if (!TextUtils.isEmpty(str2) && !str2.contains("|")) {
                hashtable.put(str2, "");
            }
            i = i2 + 1;
        }
    }

    private boolean a(com.autonavi.aps.amapapi.model.a aVar, boolean z) {
        if (a(z)) {
            return aVar == null || com.autonavi.aps.amapapi.utils.a.a(aVar.getTime()) || z;
        }
        return false;
    }

    private static boolean a(String str, com.autonavi.aps.amapapi.model.a aVar) {
        if (TextUtils.isEmpty(str) || !i.a(aVar) || str.startsWith("#")) {
            return false;
        }
        return str.contains("network");
    }

    private static boolean a(String str, StringBuilder sb) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(sb) || !str.contains(",access") || sb.indexOf(",access") == -1) {
            return false;
        }
        String[] split = str.split(",access");
        String substring = split[0].contains("#") ? split[0].substring(split[0].lastIndexOf("#") + 1) : split[0];
        if (TextUtils.isEmpty(substring)) {
            return false;
        }
        String sb2 = sb.toString();
        return sb2.contains(substring + ",access");
    }

    private boolean a(boolean z) {
        if (com.autonavi.aps.amapapi.utils.a.e() || z) {
            return this.b || com.autonavi.aps.amapapi.utils.a.f() || z;
        }
        return false;
    }

    private static double[] a(double[] dArr, double[] dArr2) {
        int i;
        double[] dArr3 = new double[3];
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i = i4;
            if (i2 >= dArr.length) {
                break;
            }
            d2 += dArr[i2] * dArr[i2];
            d3 += dArr2[i2] * dArr2[i2];
            d += dArr[i2] * dArr2[i2];
            int i5 = i3;
            int i6 = i;
            if (dArr2[i2] == 1.0d) {
                int i7 = i + 1;
                i5 = i3;
                i6 = i7;
                if (dArr[i2] == 1.0d) {
                    i5 = i3 + 1;
                    i6 = i7;
                }
            }
            i2++;
            i3 = i5;
            i4 = i6;
        }
        dArr3[0] = d / (Math.sqrt(d2) * Math.sqrt(d3));
        double d4 = i3;
        dArr3[1] = (d4 * 1.0d) / i;
        dArr3[2] = d4;
        int i8 = 0;
        while (true) {
            int i9 = i8;
            if (i9 >= 2) {
                return dArr3;
            }
            if (dArr3[i9] > 1.0d) {
                dArr3[i9] = 1.0d;
            }
            i8 = i9 + 1;
        }
    }

    private boolean b() {
        long b = i.b();
        long j = this.i;
        boolean z = false;
        if (j == 0) {
            return false;
        }
        if (this.f9261a.size() > 360 || b - j > bj.e) {
            z = true;
        }
        return z;
    }

    private void c() {
        this.i = 0L;
        if (!this.f9261a.isEmpty()) {
            this.f9261a.clear();
        }
        this.j = false;
    }

    private void c(Context context) throws Exception {
        if (context == null) {
            return;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase openOrCreateDatabase = context.openOrCreateDatabase("hmdb", 0, null);
            if (!i.a(openOrCreateDatabase, "hist")) {
                if (openOrCreateDatabase == null || !openOrCreateDatabase.isOpen()) {
                    return;
                }
                openOrCreateDatabase.close();
                return;
            }
            long a2 = i.a();
            openOrCreateDatabase.delete("hist" + this.k, "time<?", new String[]{String.valueOf(a2 - bj.e)});
            if (openOrCreateDatabase == null || !openOrCreateDatabase.isOpen()) {
                return;
            }
            openOrCreateDatabase.close();
        } catch (Throwable th) {
            try {
                com.autonavi.aps.amapapi.utils.b.a(th, "DB", "clearHist p2");
                if (0 == 0 || !sQLiteDatabase.isOpen()) {
                    return;
                }
                sQLiteDatabase.close();
            } catch (Throwable th2) {
                if (0 != 0 && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
                throw th2;
            }
        }
    }

    public final com.autonavi.aps.amapapi.model.a a(Context context, String str, StringBuilder sb, boolean z, boolean z2) {
        if (!TextUtils.isEmpty(str) && com.autonavi.aps.amapapi.utils.a.e()) {
            String str2 = str + "&" + this.f + "&" + this.g + "&" + this.h;
            if (str2.contains("gps") || !com.autonavi.aps.amapapi.utils.a.e() || sb == null) {
                return null;
            }
            if (b()) {
                c();
                return null;
            }
            if (z && !this.j) {
                try {
                    String a2 = a(str2, sb, context);
                    c();
                    a(context, a2, z2);
                } catch (Throwable th) {
                }
            }
            if (this.f9261a.isEmpty()) {
                return null;
            }
            return a(str2, sb, z2);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x017e, code lost:
        if (r17 != false) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0035 A[Catch: all -> 0x0155, TRY_ENTER, TryCatch #0 {all -> 0x0155, blocks: (B:6:0x000c, B:8:0x0015, B:18:0x0035, B:26:0x005a, B:32:0x006b, B:34:0x0082, B:39:0x009b, B:41:0x00a2, B:45:0x00b4, B:48:0x00c4, B:50:0x00ca, B:52:0x00d6, B:54:0x00e5, B:64:0x0127, B:67:0x013a, B:71:0x0147, B:55:0x00ed, B:56:0x00fd, B:58:0x0104, B:59:0x0114, B:46:0x00be, B:11:0x001d, B:13:0x0023), top: B:103:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b4 A[Catch: all -> 0x0155, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0155, blocks: (B:6:0x000c, B:8:0x0015, B:18:0x0035, B:26:0x005a, B:32:0x006b, B:34:0x0082, B:39:0x009b, B:41:0x00a2, B:45:0x00b4, B:48:0x00c4, B:50:0x00ca, B:52:0x00d6, B:54:0x00e5, B:64:0x0127, B:67:0x013a, B:71:0x0147, B:55:0x00ed, B:56:0x00fd, B:58:0x0104, B:59:0x0114, B:46:0x00be, B:11:0x001d, B:13:0x0023), top: B:103:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00be A[Catch: all -> 0x0155, TRY_ENTER, TryCatch #0 {all -> 0x0155, blocks: (B:6:0x000c, B:8:0x0015, B:18:0x0035, B:26:0x005a, B:32:0x006b, B:34:0x0082, B:39:0x009b, B:41:0x00a2, B:45:0x00b4, B:48:0x00c4, B:50:0x00ca, B:52:0x00d6, B:54:0x00e5, B:64:0x0127, B:67:0x013a, B:71:0x0147, B:55:0x00ed, B:56:0x00fd, B:58:0x0104, B:59:0x0114, B:46:0x00be, B:11:0x001d, B:13:0x0023), top: B:103:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0104 A[Catch: all -> 0x0155, TRY_LEAVE, TryCatch #0 {all -> 0x0155, blocks: (B:6:0x000c, B:8:0x0015, B:18:0x0035, B:26:0x005a, B:32:0x006b, B:34:0x0082, B:39:0x009b, B:41:0x00a2, B:45:0x00b4, B:48:0x00c4, B:50:0x00ca, B:52:0x00d6, B:54:0x00e5, B:64:0x0127, B:67:0x013a, B:71:0x0147, B:55:0x00ed, B:56:0x00fd, B:58:0x0104, B:59:0x0114, B:46:0x00be, B:11:0x001d, B:13:0x0023), top: B:103:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0114 A[Catch: all -> 0x0155, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0155, blocks: (B:6:0x000c, B:8:0x0015, B:18:0x0035, B:26:0x005a, B:32:0x006b, B:34:0x0082, B:39:0x009b, B:41:0x00a2, B:45:0x00b4, B:48:0x00c4, B:50:0x00ca, B:52:0x00d6, B:54:0x00e5, B:64:0x0127, B:67:0x013a, B:71:0x0147, B:55:0x00ed, B:56:0x00fd, B:58:0x0104, B:59:0x0114, B:46:0x00be, B:11:0x001d, B:13:0x0023), top: B:103:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x013a A[Catch: all -> 0x0155, TRY_ENTER, TryCatch #0 {all -> 0x0155, blocks: (B:6:0x000c, B:8:0x0015, B:18:0x0035, B:26:0x005a, B:32:0x006b, B:34:0x0082, B:39:0x009b, B:41:0x00a2, B:45:0x00b4, B:48:0x00c4, B:50:0x00ca, B:52:0x00d6, B:54:0x00e5, B:64:0x0127, B:67:0x013a, B:71:0x0147, B:55:0x00ed, B:56:0x00fd, B:58:0x0104, B:59:0x0114, B:46:0x00be, B:11:0x001d, B:13:0x0023), top: B:103:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0153 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x019d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.autonavi.aps.amapapi.model.a a(com.autonavi.aps.amapapi.restruct.e r8, boolean r9, com.autonavi.aps.amapapi.model.a r10, com.autonavi.aps.amapapi.restruct.i r11, java.lang.StringBuilder r12, java.lang.String r13, android.content.Context r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.storage.a.a(com.autonavi.aps.amapapi.restruct.e, boolean, com.autonavi.aps.amapapi.model.a, com.autonavi.aps.amapapi.restruct.i, java.lang.StringBuilder, java.lang.String, android.content.Context, boolean):com.autonavi.aps.amapapi.model.a");
    }

    public final void a() {
        this.f9262c = 0L;
        this.d = null;
    }

    public final void a(Context context) {
        if (this.j) {
            return;
        }
        try {
            c();
            a(context, (String) null, false);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Cache", "loadDB");
        }
        this.j = true;
    }

    public final void a(AMapLocationClientOption aMapLocationClientOption) {
        this.g = aMapLocationClientOption.isNeedAddress();
        this.f = aMapLocationClientOption.isOffset();
        this.b = aMapLocationClientOption.isLocationCacheEnable();
        this.h = String.valueOf(aMapLocationClientOption.getGeoLanguage());
    }

    public final void a(d dVar) {
        this.e = dVar;
    }

    public final void a(String str) {
        this.d = str;
    }

    public final void a(String str, StringBuilder sb, com.autonavi.aps.amapapi.model.a aVar, Context context, boolean z) {
        int i;
        try {
            if (i.a(aVar)) {
                String str2 = str + "&" + aVar.isOffset() + "&" + aVar.i() + "&" + aVar.j();
                if (!a(str2, aVar) || aVar.e().equals("mem") || aVar.e().equals(ContentResolver.SCHEME_FILE) || aVar.e().equals("wifioff") || "-3".equals(aVar.d())) {
                    return;
                }
                if (b()) {
                    c();
                }
                JSONObject f = aVar.f();
                if (i.a(f, "offpct")) {
                    f.remove("offpct");
                    aVar.a(f);
                }
                if (str2.contains("wifi")) {
                    if (TextUtils.isEmpty(sb)) {
                        return;
                    }
                    if (aVar.getAccuracy() >= 300.0f) {
                        String[] split = sb.toString().split("#");
                        int length = split.length;
                        int i2 = 0;
                        int i3 = 0;
                        while (true) {
                            i = i3;
                            if (i2 >= length) {
                                break;
                            }
                            int i4 = i;
                            if (split[i2].contains(",")) {
                                i4 = i + 1;
                            }
                            i2++;
                            i3 = i4;
                        }
                        if (i >= 8) {
                            return;
                        }
                    } else if (aVar.getAccuracy() <= 3.0f) {
                        return;
                    }
                    if (str2.contains("cgiwifi") && !TextUtils.isEmpty(aVar.g())) {
                        String replace = str2.replace("cgiwifi", "cgi");
                        com.autonavi.aps.amapapi.model.a h = aVar.h();
                        if (i.a(h)) {
                            a(replace, new StringBuilder(), h, context, true);
                        }
                    }
                } else if (str2.contains("cgi") && ((sb != null && sb.indexOf(",") != -1) || "4".equals(aVar.d()))) {
                    return;
                }
                com.autonavi.aps.amapapi.model.a a2 = a(str2, sb, false);
                if (i.a(a2) && a2.toStr().equals(aVar.toStr(3))) {
                    return;
                }
                this.i = i.b();
                C0191a c0191a = new C0191a();
                c0191a.a(aVar);
                c0191a.a(TextUtils.isEmpty(sb) ? null : sb.toString());
                if (this.f9261a.containsKey(str2)) {
                    this.f9261a.get(str2).add(c0191a);
                } else {
                    ArrayList<C0191a> arrayList = new ArrayList<>();
                    arrayList.add(c0191a);
                    this.f9261a.put(str2, arrayList);
                }
                if (z) {
                    a(str2, aVar, sb, context);
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Cache", "add");
        }
    }

    public final void b(Context context) {
        try {
            c();
            c(context);
            this.j = false;
            this.d = null;
            this.n = 0L;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Cache", "destroy part");
        }
    }
}
